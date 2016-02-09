<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 12/01/2016
  Time: 17.51
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="newpackage.Enumerations.TipoOffertaPernotto" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<div class="row">
    <form class="col s12" name="frm" method="post" action="FindPernotto.jsp">
        <ul>
            <li>
                <div class="row">
                    <div class="input-field col s12">
                        <input placeholder="es. Notte a Dublino" id="first_name" nome="ofname" type="text">
                        <label for="first_name">Nome Offerta</label>
                    </div>
                </div>
            </li>
           <li>
                <div class="row">
                    <div class="input-field col s12">
                        <input placeholder="es. Dublino" id="favourite_city" name="ofcity" type="text">
                        <label for="first_name">Città preferita</label>
                    </div>
                </div>
            </li>
            <li>
                <div class="input-field col s12">
                    <select name="oftype">
                        <option value="" disabled selected>Opzione</option>
                        <option value="<%=TipoOffertaPernotto.BeB.getNome()%>"><%=TipoOffertaPernotto.BeB.getNome()%></option>
                        <option value="<%=TipoOffertaPernotto.Appartamento.getNome()%>"><%=TipoOffertaPernotto.Appartamento.getNome()%></option>
                        <option value="<%=TipoOffertaPernotto.CasaVacanze.getNome()%>"><%=TipoOffertaPernotto.CasaVacanze.getNome()%></option>
                        <option value="<%=TipoOffertaPernotto.Hotel.getNome()%>"><%=TipoOffertaPernotto.Hotel.getNome()%></option>
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
                <div class="input-field col s12" style="display: block" id="datepick">
                    <input type="date" class="datepicker" name="ofdateexpired">
                    <label>Seleziona giorno specifico</label>
                </div>
            </li>
            <li>
                <div class="input-field col s12">
                    <select name="numberOfNights">
                        <option value="" disabled selected>Opzione</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="3">4</option>
                        <option value="3">5</option>
                    </select>
                    <label>Seleziona numero di notti</label>
                </div>
            </li>
            <li>
                <div class="input-field col s12">
                    <select name="stars">
                        <option value="" disabled selected>Opzione</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="3">4</option>
                        <option value="3">5</option>
                    </select>
                    <label>Seleziona numero di stelle</label>
                </div>
            </li>
            <li>
                <button class="btn-flat waves-effect waves-light" type="submit" name="findMyOverNight" id="findMyOverNight">Cerca
                    <i class="material-icons right">send</i>
                </button>
            </li>
        </ul>
    </form>

</div>