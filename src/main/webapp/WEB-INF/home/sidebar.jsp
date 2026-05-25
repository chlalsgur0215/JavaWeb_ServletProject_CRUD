<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="../home/index">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">최민혁<sup>202212036</sup></div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item active">
        <a class="nav-link" href="../home/index">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>Dashboard</span></a>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Interface
    </div>

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#"
           data-toggle="collapse" data-target="#collapseTwo"
           aria-expanded="true" aria-controls="collapseTwo">
            <i class="fas fa-fw fa-cog"></i>
            <span>Management</span>
        </a>
        <div id="collapseTwo" class="collapse"
             aria-labelledby="headingTwo" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Member : </h6>
                <a class="collapse-item" href="../members/login-form">로그인</a>
                <a class="collapse-item" href="../members/register-form">등록</a>
                <a class="collapse-item" href="../members/get">정보조회</a>
                <a class="collapse-item" href="../members/logout-form">로그아웃</a>
                <a class="collapse-item" href="../members/delete">탈퇴</a>
                <a class="collapse-item" href="../members/list">회원목록</a>
                <h6 class="collapse-header">Blogs : </h6>
                <a class="collapse-item" href="../blogs/list">목록</a>
                <a class="collapse-item" href="../blogs/register-form">등록</a>
            </div>
        </div>
    </li>

    <!-- Nav Item - Utilities Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseUtilities"
           aria-expanded="true" aria-controls="collapseUtilities">
            <i class="fas fa-fw fa-wrench"></i>
            <span>Utilities</span>
        </a>
        <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
             data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Custom Components:</h6>
                <a class="collapse-item" href="../home/buttons">Buttons</a>
                <a class="collapse-item" href="../home/cards">Cards</a>
                <h6 class="collapse-header">Custom Utilities:</h6>
                <a class="collapse-item" href="../home/color">Colors</a>
                <a class="collapse-item" href="../home/border">Borders</a>
                <a class="collapse-item" href="../home/animation">Animations</a>
                <a class="collapse-item" href="../home/other">Other</a>
            </div>
        </div>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider">

    <!-- Heading -->
    <div class="sidebar-heading">
        Addons
    </div>

    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
           aria-expanded="true" aria-controls="collapsePages">
            <i class="fas fa-fw fa-folder"></i>
            <span>Pages</span>
        </a>
        <div id="collapsePages" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Login Screens:</h6>
                <a class="collapse-item" href="../home/login">Login</a>
                <a class="collapse-item" href="../home/register">Register</a>
                <a class="collapse-item" href="../home/forgot-password">Forgot Password</a>
                <div class="collapse-divider"></div>
                <h6 class="collapse-header">Other Pages:</h6>
                <a class="collapse-item" href="../home/404">404 Page</a>
                <a class="collapse-item" href="../home/blank">Blank Page</a>
                <!-- Nav Item - Charts -->
                <a class="collapse-item" href="../home/charts">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Charts</span></a>
                <!-- Nav Item - Tables -->
                <a class="collapse-item" href="../home/tables">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Tables</span></a>
                <a class="collapse-item" href="../file/upload-form">
                    <i class="fas fa-fw fa-comments"></i>
                    <span>File Upload</span></a>
            </div>
        </div>
    </li>
    <!-- Nav Item - Pages Collapse Menu -->
    <li class="nav-item">
        <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseMySQL"
           aria-expanded="true" aria-controls="collapseMySQL">
            <i class="fas fa-fw fa-folder"></i>
            <span>Mysql</span>
        </a>
        <div id="collapseMySQL" class="collapse" aria-labelledby="headingPages" data-parent="#accordionSidebar">
            <div class="bg-white py-2 collapse-inner rounded">
                <h6 class="collapse-header">Sakila :</h6>
                <a class="collapse-item" href="../sakila/register-form">Register-form</a>
                <a class="collapse-item" href="../sakila/update-form">Update-form</a>
                <a class="collapse-item" href="../sakila/actors">List</a>
                <h6 class="collapse-header">World :</h6>
                <a class="collapse-item" href="../world/city">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>City</span></a>
                <!-- Nav Item - Tables -->
                <a class="collapse-item" href="../world/country">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Country</span></a>
                <!-- Nav Item - Tables -->
                <a class="collapse-item" href="../world/language">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Language</span></a>
            </div>
        </div>
    </li>

    <!-- Divider -->
    <hr class="sidebar-divider d-none d-md-block">

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

    <!-- Sidebar Message -->
    <div class="sidebar-card d-none d-lg-flex">
        <img class="sidebar-card-illustration mb-2" src="../home/img/undraw_rocket.svg" alt="...">
        <p class="text-center mb-2"><strong>SB Admin Pro</strong> is packed with premium features, components, and more!</p>
        <a class="btn btn-success btn-sm" href="https://startbootstrap.com/theme/sb-admin-pro">Upgrade to Pro!</a>
    </div>

</ul>

