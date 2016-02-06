<%@ page import="newpackage.OffertaBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="newpackage.OffertaPernottoBean" %><%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 14/01/2016
  Time: 23.52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="findpernottoBean" scope="request"
             type="newpackage.OffertaPernottoBean"/>

<ul class="collapsible">
    <% ArrayList<OffertaBean> ls = findpernottoBean.getOfferList();
        if(ls != null){
            for(int i=0;i<ls.size();i++){%>
    <li>
        <div class="collapsible-header"><%=ls.get(i).getOfname()%></div>
        <div class="collapsible-body"><div class="row"><div class="col"><img src="http://orig15.deviantart.net/1614/f/2010/217/e/0/biffy_clyro_i_by_henrikack.jpg" style="margin-top: 10px; width: 180px; height: 150px;"></div><div class="col">
            <p>Prezzo <%=ls.get(i).getOfprice()%><br>Data di scadenza <%=ls.get(i).getOfdateexpired()%></br>
                <br>Numero notti <%=((OffertaPernottoBean)ls.get(i)).getNumberOfNights()%></br>
                <br>Stelle <%=((OffertaPernottoBean)ls.get(i)).getStars()%></br></p>
        </div></div></div>
    </li>
    <%}}else{%>
    <li>
        <div class="collection-header">Selezionare almeno una delle opzioni</div>
    </li>
    <%}%>
</ul>

