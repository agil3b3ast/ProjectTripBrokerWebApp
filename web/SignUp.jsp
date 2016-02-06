<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 04/02/2016
  Time: 11.10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="utenteBean" scope="session"
             class="newpackage.UtenteBean"/>
<jsp:setProperty name="utenteBean" property="*"/>

<%
    if(utenteBean.isLogged()){
%>
    <jsp:forward page="Catalogo.jsp"/>

<%}if(request.getParameter("signUp")!= null){
        if(utenteBean.signUp()){

            //utenteBean.setCarrelloBean(carrelloBean);
            //carrelloBean.setUtenteBean(utenteBean);
            session.setAttribute("carrelloBean",utenteBean.getCarrelloBean());
%>
    <jsp:forward page="GestioneUtente.jsp"/>
<%
        }
    }
%>

<html>
    <head>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Registrazione</title>
    </head>
    <body>
        <jsp:include page="navbar.jsp"/>
        <div class="row">
            <div class="col s12 center-align">
                <!-- Teal page content  -->
                <div class="card-panel teal blue-grey">
                    <% if(request.getParameter("signUp")!= null){%>
                        <div class="row">
                            <div class="col s12">
                                <!-- Teal page content  -->
                                <div class="card-panel teal lighten-2 white-text">La registrazione non ha avuto successo, riprovare. Le possibili soluzioni sono:<br>  Impostare un nickname differente<br>
                                Inserire correttamente tutti i campi</div>
                            </div>
                        </div>
                    <%}%>
                    <div class="row">
                        <div class="col s12">
                        <jsp:include page="FormSignUp.jsp"/>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script src="/js/init.js"></script>
    </body>
</html>
