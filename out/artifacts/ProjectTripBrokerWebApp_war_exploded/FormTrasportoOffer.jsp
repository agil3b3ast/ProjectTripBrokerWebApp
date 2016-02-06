<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 12/01/2016
  Time: 17.54
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="newpackage.TipoOffertaTrasporto" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<script>
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
<script>
    function Toggle2() {
        if(document.getElementById("check2").checked) {
            document.getElementById("favourite_city_to").style.display = "none"
        }
        else{
            document.getElementById("favourite_city_to").style.display = "block"
        }
    }
</script>

<div class="row">
    <form class="col s12" name="frm" method="post" action="FindTrasporto.jsp">
    <ul>
            <li>
                <div class="row">
                    <div class="input-field col s12">
                        <input placeholder="es. Treno per Milano" id="first_name" name="ofname" type="text" class="validate">
                        <label for="first_name">Nome Offerta</label>
                    </div>
                </div>
            </li>
            <li>
                <!-- Switch -->
                <div class="switch">
                    <label>
                        Andata e ritorno
                        <input type="checkbox" id="check2" onclick="Toggle2();" checked ="checked">
                        <span class="lever"></span>
                        Solo andata
                    </label>
                </div>
            </li>
            <li>
                <div class="row">
                    <div class="input-field col s12" id="favourite_city_from">
                        <input placeholder="es. Roma" type="text" class="validate" name="cityFrom">
                        <label for="first_name">Città Partenza</label>
                    </div>
                    <div class="input-field col s12" style="display: none" id="favourite_city_to" name="ofcity">
                        <input placeholder="es. Dublino" type="text" class="validate">
                        <label for="first_name">Città Arrivo</label>
                    </div>
                </div>
            </li>
            <li>
                <div class="input-field col s12">
                    <select name="oftype">
                        <option value="<%=TipoOffertaTrasporto.Aereo.getNome()%>" disabled selected>Opzione</option>
                        <option value="<%=TipoOffertaTrasporto.Aereo.getNome()%>"><%=TipoOffertaTrasporto.Aereo.getNome()%></option>
                        <option value="<%=TipoOffertaTrasporto.Autobus.getNome()%>"><%=TipoOffertaTrasporto.Autobus.getNome()%></option>
                        <option value="<%=TipoOffertaTrasporto.Nave.getNome()%>"><%=TipoOffertaTrasporto.Nave.getNome()%></option>
                        <option value="<%=TipoOffertaTrasporto.Treno.getNome()%>"><%=TipoOffertaTrasporto.Treno.getNome()%></option>
                    </select>
                    <label>Seleziona la tua tipologia</label>
                </div>
            </li>
            <li>
                <div class="input-field col s12">
                    <select name="ofprice">
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

                <div class="input-field col s12" style="display: none" id="selectdate">
                    <select name="ofdateexpired">
                        <option value="" disabled selected>Opzione</option>
                        <option value="1">Minore di un mese</option>
                        <option value="2">Tra un mese e 5 mesi</option>
                        <option value="3">Oltre 5 mesi</option>
                    </select>
                    <label>Seleziona il periodo di scadenza</label>
                </div>
            </li>
            <li>
                <div class="row">
                    <div class="input-field col s6">
                        <input placeholder="es. 1" id="time_to" type="text" class="validate" name="duration">
                        <label for="time_to">Durata Viaggio</label>
                    </div>
                    <div class="input-field col s6">
                        <select name="duration">
                            <option value="" disabled selected>Opzione</option>
                            <option value="1">Minuti</option>
                            <option value="2">Ore</option>
                            <option value="3">Giorni</option>
                        </select>
                    </div>
                </div>
            </li>
            <li>
                <button class="btn-flat waves-effect waves-light" type="submit" name="findMyTransport" id="findMyTransport">Cerca
                    <i class="material-icons right">send</i>
                </button>
            </li>
        </ul>
    </form>
</div>

