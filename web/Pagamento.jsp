<%@ page import="newpackage.OffertaEventoBean" %>
<%@ page import="newpackage.OffertaPernottoBean" %>
<%@ page import="newpackage.OffertaTrasportoBean" %>
<%@ page import="newpackage.PacchettoBean" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!-- Si dichiara la variabile offertaBean e istanzia un oggetto newpackage.OffertaBean -->
<jsp:useBean id="carrelloBean" scope="session"
             type="newpackage.CarrelloBean" />

<jsp:setProperty name="carrelloBean" property="*"/>

<!-- Si dichiara la variabile utenteBean e istanzia un oggetto newpackage.UtenteBean -->
<jsp:useBean id="utenteBean" scope="session"
             class="newpackage.UtenteBean" />

<!--  Setta automaticamente tutti gli attributi dell'oggetto utenteBean -->
<jsp:setProperty name="utenteBean" property="*" />

<%
    if(!utenteBean.isLogged()){
%>
    <jsp:forward page="login.jsp"/>
<%  }
    if(request.getParameter("pay") != null){
        if(request.getParameter("pay").equals("pay")){
            if(!carrelloBean.Pay()){%>

    <div class="row">
        <div class="card blue-grey">
            <div class="card-content white-text">
                <span class="card-title">Pagamento non riuscito per le seguenti offerte e/o pacchetti</span>
            </div>
        </div>
        <form action="Catalogo.jsp" name="myform8" method="post">
            <button class="btn-flat waves-effect waves-light" type="submit">Torna al catalogo
                <i class="material-icons right">send</i>
            </button>
        </form>
    </div>

    <%}}}
%>
<%
    if(request.getParameter("offertrasportoitem")!=null){
    if(request.getParameter("offertrasportoitem").equals("")){
    System.out.println("RequestGetParameter");}
    if(!request.getParameter("offertrasportoitem").equals("")){
        System.out.println("RequesteGetPArameterNotNull");}
    }
    if(request.getParameter("confirmRemovePack") != null || request.getParameter("confirmRemoveEve") != null || request.getParameter("confirmRemoveTras") != null || request.getParameter("confirmRemovePer") != null){
        System.out.println("Rimuovo item");
    if(!(carrelloBean.getPacketitem().equals("")) || !(carrelloBean.getOffereventoitem().equals("")) || !(carrelloBean.getOfferpernottoitem().equals("")) || !(carrelloBean.getOffertrasportoitem().equals(""))){
        System.out.println("Item da rimuovere, qualcosa non è null");
    if(!carrelloBean.removeItem()){%>
    <div class="row">
        <div class="card blue-grey">
            <div class="card-content white-text">
                <span class="card-title">Non è stato possibile rimuovere l'elemento dal carrello</span>
            </div>
        </div>
    </div>
<%
    }}}
%>


<html>
    <head>
        <!--Import Google Icon Font-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Import materialize.css-->
        <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

        <!--Let browser know website is optimized for mobile-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Pagamento</title>
    </head>
    <body>
        <%if(!utenteBean.isLogged()){%>
        <jsp:include page="navbar.jsp"/>
        <%}else{%>
        <jsp:include page="loggednavbar.jsp"/>
        <%}%>
        <%//for(OffertaEvento ofe : carrelloBean.getOfferEventolist()){%>
        <%for(Object object : carrelloBean.getItemList()){
            if(object instanceof OffertaEventoBean){
            OffertaEventoBean ofe = (OffertaEventoBean) object;%>
            <div class="card blue-grey">
                <div class="card-content white-text">
                    <span class="card-title">
                        Offerta <%=ofe.getOfname()%>
                    </span>
                    <ul>
                        <li><img src="http://orig15.deviantart.net/1614/f/2010/217/e/0/biffy_clyro_i_by_henrikack.jpg" style="margin-top: 10px; width: 100px; height: 70px;"></li>
                        <li>Data scadenza <%=ofe.getOfdateexpired()%></li>
                        <li>Prezzo <%=ofe.getOfprice()%></li>
                        <li>Citta <%=ofe.getOfcity()%></li>
                    </ul>
                </div>
                <form action="Pagamento.jsp" name="myform8" method="post">
                    <input hidden value="<%=ofe.getOfid()%>" type="text" name="offereventoitem" id="offereventoitem">
                    <button class="btn-flat waves-effect waves-light" type="submit" id="confirmRemoveEve" name="confirmRemoveEve">Rimuovi dal carrello</button>
                </form>
            </div>
        <%}
        %>

        <%//for(Object object : carrelloBean.getItemList()){
            if(object instanceof OffertaPernottoBean){
                OffertaPernottoBean ofp = (OffertaPernottoBean) object;%>
        <div class="card blue-grey">
            <div class="card-content white-text">
                <span class="card-title">
                    Offerta <%=ofp.getOfname()%>
                </span>
                <ul>
                    <li><img src="http://orig15.deviantart.net/1614/f/2010/217/e/0/biffy_clyro_i_by_henrikack.jpg" style="margin-top: 10px; width: 100px; height: 70px;"></li>
                    <li>Data scadenza <%=ofp.getOfdateexpired()%></li>
                    <li>Prezzo <%=ofp.getOfprice()%></li>
                    <li>Citta <%=ofp.getOfcity()%></li>
                    <li>Numero notti <%=ofp.getNumberOfNights()%></li>
                    <li>Numero stelle <%=ofp.getStars()%></li>
                </ul>
            </div>
            <form action="Pagamento.jsp" name="myform7" method="post">
                <input hidden value="<%=ofp.getOfid()%>" type="text" name="offerpernottoitem" id="offerpernottoitem">
                <button class="btn-flat waves-effect waves-light" type="submit" id="confirmRemovePer" name ="confirmRemovePer" >Rimuovi dal carrello</button>
            </form>
        </div>
        <%}%>

        <%  //for(Object object : carrelloBean.getItemList()){
            if(object instanceof OffertaTrasportoBean){
                OffertaTrasportoBean oft = (OffertaTrasportoBean) object;%>
        <div class="card blue-grey">
            <div class="card-content white-text">
                <span class="card-title">
                    Offerta <%=oft.getOfname()%>
                </span>
                <ul>
                    <li><img src="http://orig15.deviantart.net/1614/f/2010/217/e/0/biffy_clyro_i_by_henrikack.jpg" style="margin-top: 10px; width: 100px; height: 70px;"></li>
                    <li>Data scadenza <%=oft.getOfdateexpired()%></li>
                    <li>Prezzo <%=oft.getOfprice()%></li>
                    <li>Citta destinazione <%=oft.getOfcity()%></li>
                    <li>Citta partenza <%=oft.getCityFrom()%></li>
                    <li>Durata <%=oft.getDuration()%></li>
                </ul>
            </div>
            <form action="Pagamento.jsp" name="myform6" method="post">
                <input hidden value="<%=oft.getOfid()%>" type="text" name="offertrasportoitem" id="offertrasportoitem">
                <button class="btn-flat waves-effect waves-light" type="submit" id="confirmRemoveTras" name="confirmRemoveTras">Rimuovi dal carrello</button>
            </form>
        </div>
        <%}
        %>

        <%//for(Object object : carrelloBean.getItemList()){
            if(object instanceof PacchettoBean){
                PacchettoBean p = (PacchettoBean) object;%>
        <div class="card blue-grey">
            <div class="card-content white-text">
                <span class="card-title">
                    Pacchetto <%=p.getPname()%>
                </span>
                <ul>
                    <li><img src="http://orig15.deviantart.net/1614/f/2010/217/e/0/biffy_clyro_i_by_henrikack.jpg" style="margin-top: 10px; width: 100px; height: 70px;"></li>
                    <li>Prezzo <%=p.getPprice()%></li>
                </ul>
            </div>
            <form action="Pagamento.jsp" name="myform5" method="post">
                <input hidden value="<%=p.getId()%>" type="text" name="packetitem" id="packetitem">
                <button class="btn-flat waves-effect waves-light" type="submit" id="confirmRemovePack" name ="confirmRemovePack">Rimuovi dal carrello</button>
            </form>
        </div>
        <%}
        }
        if(!carrelloBean.carrelloempty()){
        %>
         <form action="Pagamento.jsp" name="myform3" method="post">
            <input hidden value="pay" type="text" name="pay">
            <button class="btn-flat waves-effect waves-light" type="submit">Acquista
                <i class="material-icons right">send</i>
            </button>
        </form>
        <%}else{%>
        <div class="row">
            <div class="card blue-grey">
                <div class="card-content white-text">
                    <span class="card-title">Carrello Vuoto</span>
                </div>
            </div>
            <form action="Catalogo.jsp" name="myform2" method="post">
                <button class="btn-flat waves-effect waves-light" type="submit">Torna al catalogo
                    <i class="material-icons right">send</i>
                </button>
            </form>
        </div>
        <%}
        %>

        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <script type="text/javascript" src="js/materialize.min.js"></script>

    </body>
</html>
