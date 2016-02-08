<%@ page import="newpackage.Beans.CarrelloBean" %>
<%@ page import="newpackage.Beans.UtenteBean" %>
<%@ page import="newpackage.DBResourcesManager" %>
<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 05/02/2016
  Time: 22.27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="utenteBean" class="newpackage.Beans.UtenteBean" scope="session"/>
<jsp:setProperty name="utenteBean" property="*"/>

<jsp:useBean id="carrelloBean" class="newpackage.Beans.CarrelloBean" scope="session"/>
<jsp:setProperty name="carrelloBean" property="*"/>

<%
    if (!utenteBean.isLogged()){
%>
    <jsp:forward page="Catalogo.jsp"/>
<%}
    session.setAttribute("carrelloBean",new CarrelloBean());
    session.setAttribute("utenteBean",new UtenteBean());
%>
    <jsp:forward page="Catalogo.jsp"/>
