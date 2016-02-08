<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 04/02/2016
  Time: 11.15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<jsp:useBean id="utenteBean" scope="session"
             class="newpackage.Beans.UtenteBean"/>
<jsp:setProperty name="utenteBean" property="*"/>

<jsp:useBean id="carrelloBean" scope="session"
             class="newpackage.Beans.CarrelloBean"/>
<jsp:setProperty name="carrelloBean" property="*"/>

<%
    if(!utenteBean.isLogged()){
%>
    <jsp:forward page="SignUp.jsp"/>
<%}%>

<html>
    <head>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Gestione Utente</title>
    </head>
    <body>
            <jsp:include page="loggednavbar.jsp"/>
            <jsp:include page="WebClientCredentials.jsp"/>
    <!--
    <div class="row">
        <div class="col s12 center-align">
            <ul>
                <li>
                    <div class="row">
                        <div class="input-field col s12">
                            <input placeholder="mynickname" id="nickname" name="nickname" type="text" class="validate">
                            <label for="nickname">Nickname</label>
                        </div>
                    </div>
                </li>

                <li>
                    <div class="row">
                        <div class="input-field col s12">
                            <input placeholder="mypassword" id="password" name="password" type="text" class="validate">
                            <label for="password">Password</label>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="row">
                        <div class="input-field col s12">
                            <input placeholder="es. mionome" id="name" name="name" type="text" class="validate">
                            <label for="name">Nome</label>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="row">
                        <div class="input-field col s12">
                            <input placeholder="es. cognome" id="cognome" name="cognome" type="text" class="validate">
                            <label for="cognome">Cognome</label>
                        </div>
                    </div>
                </li>
                <li>
                    <div class="input-field col s12" id="datepick">
                        <input type="date" class="datepicker" name="birthday">
                        <label>Seleziona data di nascita</label>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    -->
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script src="/js/init.js"></script>
    </body>
</html>
