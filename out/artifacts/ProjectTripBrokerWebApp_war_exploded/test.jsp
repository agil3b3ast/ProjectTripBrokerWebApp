<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 11/01/2016
  Time: 16.30
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<% if(request.getParameter("packetitem") != null){
    System.out.println(request.getParameter("packetitem"));
}%>
<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Test</title>
    </head>
    <body>
    <form action="test.jsp" name="myform2" method="post">
        <input hidden value="ciao" name="packetitem">
        <button class="btn-flat waves-effect waves-light" type="submit">Torna al catalogo
            <i class="material-icons right">send</i>
        </button>
    </form>
    </body>

    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>

</html>
