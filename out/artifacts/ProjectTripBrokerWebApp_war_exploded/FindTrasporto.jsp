<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 13/01/2016
  Time: 20.26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Si dichiara la variabile offertaBean e istanzia un oggetto newpackage.offertaBean -->
<jsp:useBean id="findtrasportoBean" scope="request"
             class="newpackage.Beans.OffertaTrasportoBean"/>

<!--  Setta automaticamente tutti gli attributi dell'oggetto offertaBean -->
<jsp:setProperty name="findtrasportoBean" property="*"/>

<jsp:useBean id="utenteBean" class="newpackage.Beans.UtenteBean" scope="session"/>
<jsp:setProperty name="utenteBean" property="*"/>

<%
    if(request.getParameter("findMyTransport")!= null){
        findtrasportoBean.fillToFind();
    }
%>

<html>
    <head>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Trova trasporto</title>
    </head>
    <body>
        <%if(!utenteBean.isLogged()){%>
            <jsp:include page="navbar.jsp"/>
        <%}else{%>
            <jsp:include page="loggednavbar.jsp"/>
        <%}%>
        <table align="center">
            <tbody>
            <tr>
                <td width="30%">
                    <jsp:include page="FormTrasportoOffer.jsp"/>
                </td>
                <td width="20%"></td>
                <td width="50%">
                    <%request.setAttribute("findtrasportoBean",findtrasportoBean);%>
                    <jsp:include page="OffertaTrasportoResponse.jsp"/>
                </td>
            </tr>
            </tbody>
        </table>

        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script src="/js/init.js"></script>
    </body>
</html>
