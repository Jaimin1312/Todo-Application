<%-- 
    Document   : index
    Created on : Mar 26, 2020, 7:39:59 PM
    Author     : jaimin
--%>


<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.io.*,java.text.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Todo</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <!DOCTYPE html>
</head>
<body>
   
    <%@include file="../view/header.jsp" %>
     <style>
        .container{
            height:100%;
        }
    </style>
    <br>
    <div class="container">
        <div class="table-responsive">
            <div style="text-align:center"><a href="/TodoApp/add-todo" class="btn btn-primary btn-block">Create New Todo</a></div>
            <br>
            <div style="text-align:center;font-size:18px"><h2>Todo List</h2><br><h1>${msg}</h2></div>
            <%int count=1;%>
            <table class="table table-hover" style="font-size:20px">
                <tr>
                    <td>Index</td>
                    <td>Title</td>
                    <td>Description</td>
                    <td>Status</td>
                    <td>Date</td>
                    <td>Edit</td>
                    <td>Delete</td>
                </tr>
                <c:forEach var="row" items="${todos}">
                    <tr>
                        <td><%=count++%></td>
                        <td>${row.title}</td>
                        <td>${row.description}</td>
                        <td>${row.status}</td>
                        <td>${row.date}</td>
                        <td><a href="/TodoApp/edit/${row.id}" class="btn btn-info">Edit</a></td>
                        <td><a href="javascript:listdelete(${row.id},<%=count-1%>);" class="btn btn-danger" >Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <%@include file="../view/footer.jsp" %>
    <script>
        function listdelete(id,count) {
            if (confirm("Are you sure you want to delete index "+count))
            {
                window.location = "/TodoApp/delete/"+id;
            }
        }
    </script>
</body>
</html>
