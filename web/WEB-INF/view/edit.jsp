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
        <title>Edit Todo</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>

        <!DOCTYPE html>
</head>
<body><style>
        .container{
            height:100%;
        }

        *{
            margin:0px;
            box-sizing:border-box;
        }

        .error{
            color:red;
        }
    </style>
    <%@include file="../view/header.jsp" %>
    <br>
    <br>
    <div class="container"><h2>Edit New TODO</h2>
        <form action="/TodoApp/Edit/${row.id}" id="formid" method="post">
            <div class="form-group">
                <label>
                    Title
                </label>
                <input type="text" class="form-control" value="${row.title}" id="title" name="title" placeholder="Enter a Todo Title">
            </div>
            <div class="form-group">
                <label>
                    Description
                </label>
                <textarea type="text" rows="4" value="${row.description}" class="form-control" id="description" name="description" placeholder="Enter a Todo Description">${row.description}</textarea>
            </div>
            <div class="form-group">
                <label>
                    Status
                </label>
                <select name="status" class="form-control">
                    <c:if test="${row.status == 'Pending'}">
                        <option selected>Pending</option>
                        <option>Working</option>
                        <option>Progress</option>
                    </c:if>
                    <c:if test="${row.status == 'Working'}">
                        <option >Pending</option>
                        <option selected>Working</option>
                        <option>Progress</option>
                    </c:if>
                        <c:if test="${row.status == 'Progress'}">
                        <option >Pending</option>
                        <option>Working</option>
                        <option selected>Progress</option>
                    </c:if>

                </select>
            </div>
            <div class="row">
                <div class="col-sm-6">
                    <button type="submit" value="submit" class="btn btn-info form-control">Submit</button>
                </div>
                <div class="col-sm-6">
                    <a href="/TodoApp" class="form-control btn btn-info">Cancel</a>
                </div>
            </div>


        </form>
    </div>


    <%@include file="../view/footer.jsp" %>
    <script>
        function listdelete(id) {
            if (confirm("Are you sure you want to delete "))
            {

            }
        }

        $(document).ready(function () {
            $("#formid").validate({
                rules: {
                    title: "required",
                    description: "required",
                },

                messages: {
                    title: "*Please Enter a Title",
                    description: "*Please Enter a Description",
                },
            });
        });
    </script>
</body>
</html>
