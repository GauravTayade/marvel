<%-- 
    Document   : header
    Created on : 2-Nov-2019, 1:27:20 PM
    Author     : Gaurav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/png" sizes="32x32" href="resources/images/favicon/favicon-32x32.png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Avenger Universe</title>
         <link href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css" rel="stylesheet">
            <script src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
            <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!--            bootstrap 4 integration-->
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <link rel="stylesheet" href="resources/css/custom.css">
            <link rel="stylesheet" href="resources/plugins/fontawesome/all.css">
    </head>
    <body>
        <header class="nav-bar-position">
            <!-- Image and text -->
            <nav class="navbar navbar-light bg-light nav-background-stripe fixed-top">
                <a class="navbar-brand header-font" href="index.jsp">
                    <img src="resources/images/logo.png" width="50" height="50" class="d-inline-block align-top" alt="">
                Avengers Universe
                </a>
                <ul class="nav justify-content-end">
                    <c:choose>
                        <c:when test="${sessionScope.user.getUsername()!=null}">
                            <li class="nav-item">
                                <a class="nav-link" href="#"> Hello <c:out value="${sessionScope.user.getUsername().toUpperCase()}"></c:out> !</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="addAvenger.jsp">Add Avenger</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="displayAvengers.jsp">Display Avenger</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" href="#" data-toggle="modal" data-target="#loginModal">Hello Guest!!</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                    <li class="nav-item">
                        <c:choose>
                            <c:when test="${sessionScope.user.getUsername()!=null}">
                                <form action="userLogout.do" method="POST">
                                    <input class="nav-link btn-logout" type="submit" name="logout" value="logout"/>
                                </form>
                            </c:when>
                            <c:otherwise>
                                <a class="nav-link" href="#" data-toggle="modal" data-target="#loginModal">Login</a>
                            </c:otherwise>
                        </c:choose>
                    </li>
                </ul>
            </nav>
        </header>
     
        