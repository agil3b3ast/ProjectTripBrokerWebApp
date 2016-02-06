<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 29/12/2015
  Time: 12.54
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!-- Si dichiara la variabile loginBean e istanzia un oggetto newpackage.LoginBean -->
<jsp:useBean id="loginBean" scope="request"
             class="newpackage.LoginBean" />

<!--  Setta automaticamente tutti gli attributi dell'oggetto loginBean -->
<jsp:setProperty name="loginBean" property="*" />

<html>
<head>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>OK</title>
</head>
<body>
<form action="OffertaEvento.jsp" name="myform" method="POST">
    <table align="center">
        <tbody>
        <tr>
            <td width="50%">
                <ul class="collapsible" >
                    <li>
                        <button class="btn waves-effect waves-light" type="submit" id="first" name="first">Submit
                            <i class="material-icons right">send</i>
                        </button>
                        <!--<div input id="first" name="first" type="submit" class="collapsible-header">First</div>-->
                    </li>
                    <li>
                        <div class="collapsible-header">Second</div>
                        <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
                    </li>
                    <li>
                        <div class="collapsible-header">Third</div>
                        <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
                    </li>
                </ul>
            </td>



            <td width="50%">
                <ul class="collapsible" data-collapsible="expandable">
                    <% ArrayList<String[]> ls = loginBean.getofferList();
                        if(ls != null){
                            for(int i=0;i<ls.size();i++){%>
                    <li>
                        <div class="collapsible-header"><%=ls.get(i)[0]%></div>
                        <div class="collapsible-body"><p>Questo id corrisponde a <%=ls.get(i)[5]%> nella tabella</p></div>
                    </li>
                    <%}}else{%>
                    <li>
                        <div class="collection-header">Selezionare almeno una delle opzioni</div>
                    </li>
                    <%}%>
                </ul>
            </td>
        </tr>
        </tbody>
    </table>
</form>
<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>

</body>
</html>
