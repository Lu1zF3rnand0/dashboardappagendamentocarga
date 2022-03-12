<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Agendamentos <br> de Cargas</sup></div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a class="nav-link" href="/">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Monitoramento
    </div>

    <!-- Nav Item - Pages Collapse Menu -->       
    <li class="nav-item">
 <!--       
 		<a class="nav-link" href='<c:url value="/agendamentos" />' style="margin-top: 15px; padding: 0px 0px 5px 15px">
            <span>Agendamentos</span>
        </a>
 --> 
        <a class="nav-link geral" href='<c:url value="/clientes" />' style="margin-top: 15px; padding: 0px 0px 5px 15px">
            <span>Clientes</span>
        </a>
        <a class="nav-link carga" href="#" data-toggle="collapse" data-target="#collapseTwo" style="margin-top: 20px; padding: 0px 20px 15px 15px"
            aria-expanded="true" aria-controls="collapseTwo">
            <i class="fas fa-fw fa-cog"></i>
            <span>Cargas</span>
        </a>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Tipos:</h6>
                <a class="collapse-item"  href='<c:url value="/cargasSolta" />'>Carga Solta</a>
                <a class="collapse-item"  href='<c:url value="/conteineres" />'>Conteiner</a>
                <a class="collapse-item"  href='<c:url value="/veiculos" />'>Veiculo</a>
            </div>
        </div>
    </li>
    
   <!-- Divider -->
   <hr class="sidebar-divider d-none d-md-block">
    
</ul>
