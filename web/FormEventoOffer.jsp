<%@ page import="newpackage.Enumerations.TipoOffertaEvento" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 12/01/2016
  Time: 12.48
  To change this template use File | Settings | File Templates.
--%>

<html>
    <head>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>
        <link href="/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<div class="row">
    <form class="col s12" name="frm" method="post" action="FindEvento.jsp">
        <ul>
            <li>
                <div class="row">
                    <div class="input-field col s12">
                        <input placeholder="es. Concerto a Roma" id="ofname" name="ofname" type="text">
                        <label for="ofname">Nome Offerta</label>
                    </div>
                </div>
            </li>
            <li>
                <div class="row">
                    <div class="input-field col s12">
                        <input placeholder="es. Roma" id="ofcity" name="ofcity" type="text">
                        <label for="ofcity">Citta preferita</label>
                    </div>
                </div>
            </li>
            <li>
                <div class="input-field col s12">
                    <select name="oftype">
                        <option value="" disabled selected>Opzione</option>
                        <option value="<%=TipoOffertaEvento.Museo.getNome()%>"><%=TipoOffertaEvento.Museo.getNome()%></option>
                        <option value="<%=TipoOffertaEvento.Concerto.getNome()%>"><%=TipoOffertaEvento.Concerto.getNome()%></option>
                        <option value="<%=TipoOffertaEvento.VisitaGuidata.getNome()%>"><%=TipoOffertaEvento.VisitaGuidata.getNome()%></option>
                        <option value="<%=TipoOffertaEvento.Cinema.getNome()%>"><%=TipoOffertaEvento.Cinema.getNome()%></option>
                        <option value="<%=TipoOffertaEvento.Teatro.getNome()%>"><%=TipoOffertaEvento.Teatro.getNome()%></option>
                    </select>
                    <label>Seleziona la tua tipologia</label>
                </div>
            </li>
            <li>
                <div class="input-field col s12">
                    <select  name="ofprice">
                        <option value="" disabled selected>Opzione</option>
                        <option value="1">Prezzo < 100</option>
                        <option value="2">Prezzo compreso tra 100 e 500</option>
                        <option value="3">Prezzo > 500</option>
                    </select>
                    <label>Seleziona la tua fascia di prezzo</label>
                </div>
            </li>
            <li>
                <div class="input-field col s12" id="datepick">
                    <input type="date" class="datepicker" name="ofdateexpired">
                    <label>Seleziona giorno specifico</label>
                </div>
            </li>
            <li>
                <button class="btn-flat waves-effect waves-light" type="submit" name="findMyEvent" id="findMyEvent">Cerca
                    <i class="material-icons right">send</i>
                </button>
            </li>
        </ul>
    </form>
</div>

<!--
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <script src="/js/init.js"></script>
    </body>
</html>-->
