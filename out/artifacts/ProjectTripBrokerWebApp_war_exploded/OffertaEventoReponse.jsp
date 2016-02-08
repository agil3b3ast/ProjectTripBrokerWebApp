<%@ page import="newpackage.Beans.OffertaBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="newpackage.Beans.OffertaEventoBean" %>
<%@ page import="newpackage.Enumerations.Avatars" %><%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 14/01/2016
  Time: 18.30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="findeventoBean" scope="request"
             class="newpackage.Beans.OffertaEventoBean"/>

<jsp:useBean id="utenteBean" class="newpackage.Beans.UtenteBean" scope="session"/>
<jsp:setProperty name="utenteBean" property="*"/>

<jsp:useBean id="carrelloBean" scope="session"
             class="newpackage.Beans.CarrelloBean"/>
<jsp:setProperty name="carrelloBean" property="*"/>

<%
    if(utenteBean.isLogged()){
        if(request.getParameter("offereventoitem") !=null){
            carrelloBean.setPacketitem("");
            carrelloBean.setOfferpernottoitem("");
            carrelloBean.setOffertrasportoitem("");
            if(carrelloBean.addItem() || !carrelloBean.carrelloempty()) {%>
<jsp:forward page="Pagamento.jsp"/>
<%      }}
}%>
<!--
<html>
<head>
</head>
<body>-->
<ul class="collapsible">
    <% ArrayList<OffertaBean> ls = findeventoBean.getOfferList();
        if(ls != null){
            for(int i=0;i<ls.size();i++){%>
    <li>
        <div class="collapsible-header"><%=((OffertaEventoBean)ls.get(i)).getOfname()%></div>
        <div class="collapsible-body"><div class="row"><div class="col"><img src="<%=Avatars.Evento.getPath()%>" style="margin-top: 10px; width: 180px; height: 150px;"></div><div class="col">
            <p>Prezzo <%=ls.get(i).getOfprice()%><br>Data di scadenza <%=ls.get(i).getOfdateexpired()%></br><br>Città <%=((OffertaEventoBean)ls.get(i)).getOfcity()%></br></p>
        </div></div></div>
        <%if(utenteBean.isLogged()){%>
        <div class="card-action">
            <form action="OffertaEventoReponse.jsp" name="myform5" method="post">
                <input hidden value="<%=((OffertaEventoBean)ls.get(i)).getOfid()%>" name="offereventoitem" id="offereventoitem">
                <button class="btn-flat waves-effect waves-light" type="submit">Acquista/Aggiungi
                </button>
            </form>
        </div>
        <%}%>
    </li>
    <%}}else{%>
    <li>
        <div class="collection-header">Selezionare almeno una delle opzioni</div>
    </li>
    <%}%>
</ul>
<!--</body>
</html>-->
