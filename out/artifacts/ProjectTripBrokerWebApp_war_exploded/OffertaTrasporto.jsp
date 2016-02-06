<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 08/01/2016
  Time: 13.33
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="newpackage.OffertaBean" %>
<%@ page import="newpackage.TipoOffertaTrasporto" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!-- Si dichiara la variabile offertaBean e istanzia un oggetto newpackage.offertaBean -->
<jsp:useBean id="offertaBean" scope="request"
             class="newpackage.OffertaTrasportoBean" />
<!--  Setta automaticamente tutti gli attributi dell'oggetto offertaBean -->
<jsp:setProperty name="offertaBean" property="*" />

<jsp:useBean id="utenteBean" class="newpackage.UtenteBean" scope="session"/>
<jsp:setProperty name="utenteBean" property="*"/>

<%
    if (offertaBean.getOftype() != null) {
        System.out.println("first not null");
        for(TipoOffertaTrasporto of : TipoOffertaTrasporto.values()){
            if ((offertaBean.getOftype().equals(of.getNome()))&& !offertaBean.selectAll()) {
                System.out.println("not null");
                break;
            }
        }
    }
    else{System.out.println("first null");}
%>

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
<%if(!utenteBean.isLogged()){%>
<jsp:include page="navbar.jsp"/>
<%}else{%>
<jsp:include page="loggednavbar.jsp"/>
<%}%>
<table align="center">
    <tbody>
    <tr>
        <td width="50%">
            <jsp:include page="doListaTrasporto.jsp"/>
        </td>

        <td width="50%">
            <ul class="collapsible" data-collapsible="expandable">
                <% ArrayList<OffertaBean> ls = offertaBean.getOfferList();
                    if(ls != null){
                        for(int i=0;i<ls.size();i++){%>
                <li>
                    <div class="collapsible-header"><%=ls.get(i).getOfname()%></div>
                    <div class="collapsible-body"><div class="row"><div class="col"><img src="https://upload.wikimedia.org/wikipedia/commons/c/c0/Jumaira_Beach_Hotel.jpg" style="margin-top: 10px; width: 180px; height: 150px;"></div><div class="col">
                        <p>Prezzo <%=ls.get(i).getOfprice()%><br>Data di scadenza <%=ls.get(i).getOfdateexpired()%></br></p>
                    </div></div></div>
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

<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>

</body>
</html>
