<%@ page import="newpackage.Beans.OffertaBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="newpackage.Beans.OffertaTrasportoBean" %>
<%@ page import="newpackage.Enumerations.Avatars" %><%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 14/01/2016
  Time: 23.54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="findtrasportoBean" scope="request"
             class="newpackage.Beans.OffertaTrasportoBean"/>

<jsp:useBean id="utenteBean" class="newpackage.Beans.UtenteBean" scope="session"/>
<jsp:setProperty name="utenteBean" property="*"/>

<jsp:useBean id="carrelloBean" scope="session"
             class="newpackage.Beans.CarrelloBean"/>
<jsp:setProperty name="carrelloBean" property="*"/>

<%
    if(utenteBean.isLogged()){
        if(request.getParameter("offertrasportoitem") !=null){
            carrelloBean.setPacketitem("");
            carrelloBean.setOfferpernottoitem("");
            carrelloBean.setOffereventoitem("");
            if(carrelloBean.addItem() || !carrelloBean.carrelloempty()) {%>
<jsp:forward page="Pagamento.jsp"/>
<%      }}
}%>

<ul class="collapsible">
    <% ArrayList<OffertaBean> ls = findtrasportoBean.getOfferList();
        if(ls != null){
            for(int i=0;i<ls.size();i++){%>
    <li>
        <div class="collapsible-header"><%=((OffertaTrasportoBean)ls.get(i)).getOfname()%></div>
        <div class="collapsible-body"><div class="row"><div class="col"><img src="<%=Avatars.Trasporto.getPath()%>" style="margin-top: 10px; width: 180px; height: 150px;"></div><div class="col">
            <p>Prezzo <%=ls.get(i).getOfprice()%><br>Data di scadenza <%=ls.get(i).getOfdateexpired()%></br>
                <br>Durata <%=((OffertaTrasportoBean)ls.get(i)).getDuration()%> minuti</br>
                <br>Città partenza <%=((OffertaTrasportoBean)ls.get(i)).getCityFrom()%></br>
                <br>Città destinazione <%=((OffertaTrasportoBean)ls.get(i)).getOfcity()%></br></p>
        </div></div></div>
        <%if(utenteBean.isLogged()){%>
        <div class="card-action">
            <form action="OffertaTrasportoResponse.jsp" name="myform5" method="post">
                <input hidden value="<%=((OffertaTrasportoBean)ls.get(i)).getOfid()%>" name="offertrasportoitem" id="offertrasportoitem">
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

