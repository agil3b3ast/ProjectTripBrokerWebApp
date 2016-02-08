<%@ page import="newpackage.Beans.OffertaBean" %>
<%@ page import="java.util.ArrayList "%>


<!--  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 12/01/2016
  Time: 12.47
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!-- Si dichiara la variabile offertaBean e istanzia un oggetto newpackage.offertaBean -->
<jsp:useBean id="findeventoBean" scope="request"
             class="newpackage.Beans.OffertaEventoBean"/>

<!--  Setta automaticamente tutti gli attributi dell'oggetto offertaBean -->
<jsp:setProperty name="findeventoBean" property="*"/>

<jsp:useBean id="utenteBean" class="newpackage.Beans.UtenteBean" scope="session"/>
<jsp:setProperty name="utenteBean" property="*"/>


<%
    /*
    if(!findeventoBean.getOftype().equals(""))
        System.out.println(findeventoBean.getOftype());
    if(!findeventoBean.getOfcity().equals(""))
        System.out.println(findeventoBean.getOfcity());
    if(!findeventoBean.getOfname().equals(""))
        System.out.println(findeventoBean.getOfname());
    if(findeventoBean.getOfprice()>0)
        System.out.println(findeventoBean.getOfprice());
    if(!findeventoBean.getOfdateexpired().equals(""))
        System.out.println(findeventoBean.getOfdateexpired());
    */

    if(request.getParameter("findMyEvent")!= null){
        findeventoBean.fillToFind();
    }

%>
<html>
    <head>

        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Ricerca</title>
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
                        <jsp:include page="FormEventoOffer.jsp"/>
                    </td>
                    <td width="20%"></td>
                    <td width="50%">
                        <%request.setAttribute("findeventoBean",findeventoBean);%>
                        <jsp:include page="OffertaEventoReponse.jsp"/>
                    </td>
                </tr>
            </tbody>
        </table>

        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script src="/js/init.js"></script>
    </body>
</html>
