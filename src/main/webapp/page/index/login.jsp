<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>

<head>

    <!-- Basic -->
    <meta charset="UTF-8"/>

    <title>Login | Fire - Admin Template</title>

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

    <!-- Import google fonts -->
    <link href='http://fonts.useso.com/css?family=Titillium+Web' rel='stylesheet' type='text/css'>

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="page/assets/ico/favicon.ico" type="image/x-icon"/>
    <link rel="apple-touch-icon" href="page/assets/ico/apple-touch-icon.png"/>
    <link rel="apple-touch-icon" sizes="57x57" href="page/assets/ico/apple-touch-icon-57x57.png"/>
    <link rel="apple-touch-icon" sizes="72x72" href="page/assets/ico/apple-touch-icon-72x72.png"/>
    <link rel="apple-touch-icon" sizes="76x76" href="page/assets/ico/apple-touch-icon-76x76.png"/>
    <link rel="apple-touch-icon" sizes="114x114" href="page/assets/ico/apple-touch-icon-114x114.png"/>
    <link rel="apple-touch-icon" sizes="120x120" href="page/assets/ico/apple-touch-icon-120x120.png"/>
    <link rel="apple-touch-icon" sizes="144x144" href="page/assets/ico/apple-touch-icon-144x144.png"/>
    <link rel="apple-touch-icon" sizes="152x152" href="page/assets/ico/apple-touch-icon-152x152.png"/>

    <!-- start: CSS file-->

    <!-- Vendor CSS-->
    <link href="page/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="page/assets/vendor/skycons/css/skycons.css" rel="stylesheet"/>
    <link href="page/assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet"/>

    <!-- Plugins CSS-->
    <link href="page/assets/plugins/bootkit/css/bootkit.css" rel="stylesheet"/>

    <!-- Theme CSS -->
    <link href="page/assets/css/jquery.mmenu.css" rel="stylesheet"/>

    <!-- Page CSS -->
    <link href="page/assets/css/style.css" rel="stylesheet"/>
    <link href="page/assets/css/add-ons.min.css" rel="stylesheet"/>

    <style>
        footer {
            display: none;
        }
    </style>

    <!-- end: CSS file-->


    <!-- Head Libs -->
    <script src="page/assets/plugins/modernizr/js/modernizr.js"></script>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<!-- Start: Content -->
<div class="container-fluid content">
    <div class="row">
        <!-- Main Page -->
        <div id="content" class="col-sm-12 full">
            <div class="row">
                <div class="login-box">
                    <div class="panel">
                        <div class="panel-body">
                            <div class="header bk-margin-bottom-20 text-center">
                                <img src="page/assets/img/logo.png" class="img-responsive" alt=""/>
                                <h4>登录</h4>
                            </div>
                            <form class="form-horizontal login" action="Login/login_submit.api" method="post">
                                <div class="bk-padding-left-20 bk-padding-right-20">
                                    <div class="form-group">
                                        <input type="hidden" name="redirectURL" value="${redirctURL}"/>
                                        <label>用户名</label>
                                        <div class="input-group input-group-icon">
                                            <input type="text" class="form-control bk-radius" id="userName"
                                                   name="userName" placeholder="Username or E-mail"/>
                                            <span class="input-group-addon">
														<span class="icon">
															<i class="fa fa-user"></i>
														</span>
													</span>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label>密码</label>
                                        <div class="input-group input-group-icon">
                                            <input type="password" class="form-control bk-radius" id="password"
                                                   name="password" placeholder="Password"/>
                                            <span class="input-group-addon">
														<span class="icon">
															<i class="fa fa-key"></i>
														</span>
													</span>
                                        </div>
                                    </div>
                                    <div class="row bk-margin-top-20 bk-margin-bottom-10">
                                        <div class="col-sm-8">
                                            <div class="checkbox-custom checkbox-default">
                                                <input id="RememberMe" name="rememberme" type="checkbox"/>
                                                <label for="RememberMe">记住用户名</label>
                                            </div>
                                        </div>
                                        <div class="col-sm-4 text-right">
                                            <button type="submit" class="btn btn-primary hidden-xs">登录</button>
                                            <button type="submit"
                                                    class="btn btn-primary btn-block btn-lg visible-xs bk-margin-top-20">
                                                登录
                                            </button>
                                        </div>
                                    </div>
                                    <div class="text-with-hr">
                                        <span>or</span>
                                    </div>
                                    <div class="text-center bk-margin-top-10 bk-margin-bottom-30">
                                        <a class="btn btn-facebook bk-margin-bottom-15 bk-margin-5">Connect with <i
                                                class="fa fa-facebook"></i></a>
                                        <a class="btn btn-twitter bk-margin-bottom-15 bk-margin-5">Connect with <i
                                                class="fa fa-twitter"></i></a>
                                    </div>
                                    <p class="text-center">Don't have an account yet? <a href="page-register.html">Register!</a>
                                    </p>
                                </div>
                            </form>
                        </div>
                    </div>
                    <p class="text-center text-muted">Fire <i class="fa fa-coffee"></i> Collect from <a
                            href="http://www.fovoy.com/" title="FOVOY" target="_blank">fovoy</a> - Home Page <a
                            href="http://www.fovoy.com/" target="_blank" title="FOVOY">FOVOY</a></p>
                </div>
            </div>
        </div>
        <!-- End Main Page -->
    </div>
</div><!--/container-->


<!-- start: JavaScript-->

<!-- Vendor JS-->
<script src="page/assets/vendor/js/jquery.min.js"></script>
<script src="page/assets/vendor/js/jquery-2.1.1.min.js"></script>
<script src="page/assets/vendor/js/jquery-migrate-1.2.1.min.js"></script>
<script src="page/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="page/assets/vendor/skycons/js/skycons.js"></script>

<!-- Plugins JS-->
<script src="page/assets/plugins/bootkit/js/bootkit.js"></script>

<!-- Theme JS -->
<script src="page/assets/js/jquery.mmenu.min.js"></script>
<script src="page/assets/js/core.min.js"></script>

<!-- Pages JS -->
<script src="page/assets/jspagespage-login.js"></script>

<!-- end: JavaScript-->

</body>

</html>