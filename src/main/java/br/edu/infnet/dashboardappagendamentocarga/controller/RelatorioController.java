package br.edu.infnet.dashboardappagendamentocarga.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboardappagendamentocarga.model.domain.Agendamento;
import br.edu.infnet.dashboardappagendamentocarga.model.domain.Carga;
import br.edu.infnet.dashboardappagendamentocarga.model.domain.Log;
import br.edu.infnet.dashboardappagendamentocarga.service.AgendamentoService;
import br.edu.infnet.dashboardappagendamentocarga.service.LogService;

@Controller
public class RelatorioController {
	
	@Autowired
	private AgendamentoService agendamentoService;
	@Autowired
	private LogService logService;

	@GetMapping(value = "/generate")
	public String emissaoRelatorio(Model model) {
		
		Workbook workbook = new XSSFWorkbook();
		
		Sheet abaCargas = workbook.createSheet("Cargas");
				
		String[] columns = {"Data", "Transportador", "Tipo", 
							"Nome do Cliente", "E-mail do Cliente", "CNPJ do solicitante", "UF solicitante",
							"Documento da Carga", "Porto da Carga"};

		Row headerRow = abaCargas.createRow(0);
		
		for(int i = 0; i < columns.length; i++) {
			headerRow.createCell(i).setCellValue(columns[i]);
		}
		
		List<Agendamento> agendamentos = agendamentoService.obterLista();
		
		int rowNum = 0;
		
		for(Agendamento agendamento: agendamentos) {
			
			for(Carga carga : agendamento.getCargas()) {
				Row row = abaCargas.createRow(++rowNum);
				
				row.createCell(0).setCellValue(
						agendamento.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
					);
				row.createCell(1).setCellValue(agendamento.getTransportador());
				row.createCell(2).setCellValue(agendamento.getTipo());  //isWeb() ? "web" : "loja");
				row.createCell(3).setCellValue(agendamento.getCliente().getNome());
				row.createCell(4).setCellValue(agendamento.getCliente().getEmail());
				row.createCell(5).setCellValue(agendamento.getCliente().getCnpj());
				row.createCell(6).setCellValue(
						agendamento.getCliente().getEndereco() != null ? 
								agendamento.getCliente().getEndereco().getUf() : ""
							);
				row.createCell(7).setCellValue(carga.getDocumento());
				row.createCell(8).setCellValue(carga.getPorto());
			}
		}
		
		LocalDateTime hoje = LocalDateTime.now(); 
		
		String arquivo = "cargas"+hoje.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))+".xlsx";		

		String mensagem = null;
		try {
			workbook.write(new FileOutputStream(arquivo));

			workbook.close();

			mensagem = "A planilha gerada está disponível no diretório padrão!!!"; 
			
		} catch (IOException e) {
			mensagem = "Problemas na geração da planilha!!!";
			
			e.printStackTrace();
		}
		
		Log log = new Log();
		log.setData(hoje);
		log.setNome(mensagem);
		
		logService.incluir(log);
		
		return "redirect:/";
	}
}
