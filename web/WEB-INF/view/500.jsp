<%-- 
    Document   : 500
    Created on : Mar 26, 2020, 9:27:38 PM
    Author     : jaimin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body> <style>
        *{
            margin:0px;
            box-sizing:border-box;
        }
    </style>
          <%@include file="../view/header.jsp" %>
          <br>
          <br>
          <div class="container" style="text-align:center">
              <h2> Server Error Currently Service is not Avaliable</h2>
              <br>
              <a href="javascript:history.go(-1);" class="btn btn-info">Go Back</a>
          </div>
          <%@include file="../view/footer.jsp" %>
    </body>
</html>
