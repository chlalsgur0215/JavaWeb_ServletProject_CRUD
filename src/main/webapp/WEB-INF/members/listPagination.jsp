<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>EGY Admin - Member List With Pagination </title>

    <!-- Custom fonts for this template -->
    <link href="../home/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../home/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="../home/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <%@ include file="../home/sidebar.jsp" %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <%@ include file="../home/topbar.jsp" %>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <table class="table">
                        <thead class="thead-light">
                            <tr>
                                <th>이메일</th>
                                <th>연락처</th>
                                <th>주소</th>
                                <th>역할</th>
                                <th>수정시간</th>
                            </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${requestScope.members}" var="dto">
                            <tr>
                                <td>${dto.email}</td>
                                <td>${dto.phone}</td>
                                <td>${dto.address}</td>
                                <td>${dto.role}</td>
                                <td>${dto.regDateTime}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>


                </div>
                <!-- /.container-fluid -->
                <nav aria-label="...">
                    <ul class="pagination justify-content-center">
                    <c:if test="${pagination.beginPageNo > pagination.perPagination}">
                        <li class="page-item">
                            <a class="page-link" href="../members/list?pn=${pagination.beginPageNo - 1}">Prev</a>
                        </li>
                    </c:if>
                    <c:forEach var="pageNo" begin="${pagination.beginPageNo}" end="${pagination.endPageNo}">
                    <c:choose>
                        <c:when test="${pageNo == pagination.curPageNo}">
                        <li class="page-item active">
                            <a class="page-link" href="../members/list?pn=${pageNo}">${pageNo}</a>
                        </li>
                        </c:when>
                        <c:otherwise>
                        <li class="page-item">
                            <a class="page-link" href="../members/list?pn=${pageNo}">${pageNo}</a>
                        </li>
                        </c:otherwise>
                    </c:choose>
                    </c:forEach>
                    <c:if test="${pagination.endPageNo < pagination.totalPages}">
                        <li class="page-item">
                            <a class="page-link" href="../members/list?pn=${pagination.endPageNo + 1}">Next</a>
                        </li>
                    </c:if>
                    </ul>
                </nav>
            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Egy 2025</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="../home/login.jsp">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="../home/vendor/jquery/jquery.min.js"></script>
    <script src="../home/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="../home/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="../home/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="../home/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="../home/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="../home/js/demo/datatables-demo.js"></script>

</body>

</html>