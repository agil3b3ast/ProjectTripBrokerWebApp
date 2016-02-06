<%@ page import="newpackage.TipoOffertaEvento" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 12/01/2016
  Time: 12.48
  To change this template use File | Settings | File Templates.
--%>

<!--
<html>
    <head>
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>
        <link href="/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


        <script type="text/javascript">
            function Toggle() {
                if(document.getElementById("check1").checked) {
                    document.getElementById("datepick").style.display = "block"
                    document.getElementById("selectdate").style.display = "none"
                }
                else{
                    document.getElementById("datepick").style.display = "none"
                    document.getElementById("selectdate").style.display = "block"
                }
            }
        </script>
    </head>
    <body>-->
<div class="row">
    <form class="col s12" name="frm" method="post" action="FindEvento.jsp">
        <ul>
            <li>
                <div class="row">
                    <div class="input-field col s12">
                        <input placeholder="es. Concerto a Roma" id="ofname" name="ofname" type="text" class="validate">
                        <label for="ofname">Nome Offerta</label>
                    </div>
                </div>
            </li>
            <li>
                <div class="row">
                    <div class="input-field col s12">
                        <input placeholder="es. Roma" id="ofcity" name="ofcity" type="text" class="validate">
                        <label for="ofcity">Nome Offerta</label>
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
                <!-- Switch -->
                <div class="switch">
                    <label>
                        Intervallo
                        <input type="checkbox" id="check1" onclick="Toggle();" checked ="checked">
                        <span class="lever"></span>
                        Giorno specifico
                    </label>
                </div>
            </li>
            <li>
                <div class="input-field col s12" style="display: block" id="datepick">
                    <input type="date" class="datepicker" name="ofdateexpired">
                    <label>Seleziona giorno specifico</label>
                </div>
            </li>
            <li>
                <div class="input-field col s12" style="display: none" id="selectdate">
                    <select name="ofdatexpired">
                        <option value="" disabled selected>Opzione</option>
                        <option value="1">Minore di un mese</option>
                        <option value="2">Tra un mese e 5 mesi</option>
                        <option value="3">Oltre 5 mesi</option>
                    </select>
                    <label>Seleziona il periodo di scadenza</label>
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
