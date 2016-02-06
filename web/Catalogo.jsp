<%@ page import="newpackage.PacchettoBean" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!-- Si dichiara la variabile offertaBean e istanzia un oggetto newpackage.offertaBean -->
<jsp:useBean id="pacchettoBean" scope="request"
             class="newpackage.PacchettoBean" />

<!--  Setta automaticamente tutti gli attributi dell'oggetto offertaBean -->
<jsp:setProperty name="pacchettoBean" property="*" />

<jsp:useBean id="carrelloBean" scope="session"
             class="newpackage.CarrelloBean"/>
<jsp:setProperty name="carrelloBean" property="*"/>

<!-- Si dichiara la variabile utenteBean e istanzia un oggetto newpackage.utenteBean -->
<jsp:useBean id="utenteBean" scope="session"
             class="newpackage.UtenteBean" />

<!--  Setta automaticamente tutti gli attributi dell'oggetto utenteBean -->
<jsp:setProperty name="utenteBean" property="*" />

<%
    if (!pacchettoBean.selectAll()) {
        System.out.println("not null");
    }
    if(request.getParameter("offerpernottoitem") != null)
        System.out.println(request.getParameter("offerpernottoitem"));

    if(!(carrelloBean.getPacketitem().equals("")) || !(carrelloBean.getOffereventoitem().equals("")) || !(carrelloBean.getOfferpernottoitem().equals("")) || !(carrelloBean.getOffertrasportoitem().equals(""))){
        System.out.println("Qualcosa non è null");
        if(carrelloBean.addItem() || !carrelloBean.carrelloempty()) {
            System.out.println("True");%>
        <jsp:forward page="Pagamento.jsp"/>
<%      }
}
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
    <title>Catalogo</title>

    <script type="text/javascript">
        function onClick() {
            var index = arguments[0];
            var ni = document.getElementById('clicks'+index);
            if(ni.style.display == "none")
                ni.style.display = "block"
            else
                ni.style.display = "none"
            /*
            var newdiv = document.createElement('div');

            newdiv.setAttribute('class','col s7');

            newdiv.innerHTML = '\
                    <div class="card deep-purple">\
                        <div class="card-content white-text">\
                            <span class="card-title">U_Pippo Baudo 22</span>\
                            <div class="row">\
                                <div class="col s5">\
                                    <p><button id="artistbutton" style="background: url(biffyclyro.jpeg); background-size:auto; height: 256px;width: 256px;" onclick="parent.location=\'login.jsp\'"/></p>\
                                </div>\
                            <div class="col s7">\
                                <p>This is an Under Pippo Baudo description</p>\
                            </div></div>\
                            </div>\
                        </div>';
            ni.appendChild(newdiv);*/
        }
    </script>
</head>
    <body background="nirvana.jpg">
    <!-- Navbar goes here
    <nav>
        <div class="nav-wrapper">
            <a href="#" class="brand-logo">Logo</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <li><a href="sass.html">Sass</a></li>
                <li><a href="badges.html">Components</a></li>
                <li><a href="collapsible.html">JavaScript</a></li>
            </ul>
        </div>
    </nav>-->
    <%if(!utenteBean.isLogged()){%>
    <jsp:include page="navbar.jsp"/>
    <%}else{%>
    <jsp:include page="loggednavbar.jsp"/>
    <%}%>
    <div class="row">
        <div class="col s4">
            <div class="card large">
                <div class="card-image">
                    <img src="Dave-Grohl-Inside.jpg">
                    <span class="card-title">Eventi</span>
                </div>
                <div class="card-content">
                <p>Qui potrai accedere a migliaia di eventi.</p>
            </div>
                <div class="card-action">
                    <a href="OffertaEvento.jsp">Visualizza eventi</a>
                </div>
            </div>
        </div>
        <div class="col s4">
            <div class="card large">
                <div class="card-image">
                    <img src="background2.jpg">
                    <span class="card-title">Viaggi</span>
                </div>
                <div class="card-content">
                <p>Organizzare i tuoi viaggi non e' mai stato cosi facile!</p>
                </div>
                <div class="card-action">
                    <a href="OffertaTrasporto.jsp">Visualizza viaggi</a>
                </div>
            </div>
        </div>
        <div class="col s4">
            <div class="card large">
                <div class="card-image">
                    <img src="background3.jpg">
                    <span class="card-title">Pernottamenti</span>
                </div>
                <div class="card-content">
                    <p>Prenota il tuo hotel ora!</p>
                </div>
                <div class="card-action">
                    <a href="OffertaPernotto.jsp">Visualizza pernottamenti</a>
                </div>
            </div>
        </div>
    </div>
    <!-- Page Layout here -->
    <!-- Grey navigation panel -->
    <div class="card blue-grey darken-1">
        <div class="card-content white-text">


                <!--<div class="col s5">
                    <div class="card deep-purple">
                        <div class="card-content white-text">
                            <span class="card-title">U_Pippo Baudo</span>
                            <p><img src="music_artist.jpg"><br>Now you can choose you Pippo Baudo</p>
                        </div>
                    </div>
                </div>-->
                <% ArrayList<PacchettoBean> ls = pacchettoBean.getPlist();
                    if(ls != null){%>


                    <%for(int i=0;i<ls.size();i++){%>
                        <div class="row">
                            <div class="col s5">
                            <!--<button type="button" onClick="onClick();">-->
                                <div class="card deep-purple">
                                    <div class="card-content white-text">
                                         <span class="card-title">
                                             <%=ls.get(i).getPname()%>
                                         </span>
                                         <div class="row"><div class="col"><img src="http://orig15.deviantart.net/1614/f/2010/217/e/0/biffy_clyro_i_by_henrikack.jpg" style="margin-top: 10px; width: 180px; height: 150px;"></div><div class="col">
                                            <p>Prezzo <%=ls.get(i).getPprice()%></p></div>
                                        </div>
                                        <div class="card-action">
                                            <table>
                                                <tr>
                                                    <td width="50%">
                                                        <a onclick="onClick(<%=i%>);" class="waves-effect waves-light">Dettagli</a>
                                                    </td>
                                                    <td width="50%">
                                                        <form action="Catalogo.jsp" name="myform2" method="post">
                                                            <input hidden value="<%=ls.get(i).getId()%>" type="text" name="packetitem" id="packetitem">
                                                            <button class="btn-flat waves-effect waves-light" type="submit">Acquista
                                                                <i class="material-icons right">send</i>
                                                            </button>
                                                        </form>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!--</button>-->
                            <div class="col s7" id="clicks<%=i%>" style="display: none">
                                <div class="card deep-purple">
                                    <div class="card-content white-text">
                                             <span class="card-title">
                                                 <%=ls.get(i).getPname()%>
                                             </span>
                                        <div class="row">
                                            <div class="col s5">
                                                <p><button id="artistbutton" style="background: url(biffyclyro.jpeg); background-size:auto; height: 256px;width: 256px;" onclick="parent.location='login.jsp'"/></p>
                                            </div>
                                            <div class="col s7">
                                                <p>This is a packet description.
                                                    <br>Prezzo <%=ls.get(i).getPprice()%>
                                                </p>
                                                <div class="card blue-grey">
                                                    <div class="card-content white-text">
                                                        <span class="card-title">
                                                            Offerta Pernotto <%=ls.get(i).getPofpernotto().getOfname()%>
                                                        </span>
                                                        <ul>
                                                            <li><img src="http://orig15.deviantart.net/1614/f/2010/217/e/0/biffy_clyro_i_by_henrikack.jpg" style="margin-top: 10px; width: 100px; height: 70px;"></li>
                                                            <li>Data scadenza <%=ls.get(i).getPofpernotto().getOfdateexpired()%></li>
                                                            <li>Prezzo <%=ls.get(i).getPofpernotto().getOfprice()%></li>
                                                        </ul>
                                                        <div class="card-action">
                                                            <form action="Catalogo.jsp" name="myform3" method="post">
                                                                <input hidden value="<%=ls.get(i).getPofpernotto().getOfid()%>" type="text" name="offerpernottoitem" id="offerpernottoitem">
                                                                <button class="btn-flat waves-effect waves-light" type="submit">Acquista
                                                                    <i class="material-icons right">send</i>
                                                                </button>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="card blue-grey">
                                                    <div class="card-content white-text">
                                                        <span class="card-title">
                                                            Offerta Trasporto <%=ls.get(i).getPoftrasporto().getOfname()%>
                                                        </span>
                                                        <ul>
                                                            <li><img src="http://orig15.deviantart.net/1614/f/2010/217/e/0/biffy_clyro_i_by_henrikack.jpg" style="margin-top: 10px; width: 100px; height: 70px;"></li>
                                                            <li>Data scadenza <%=ls.get(i).getPoftrasporto().getOfdateexpired()%></li>
                                                            <li>Prezzo <%=ls.get(i).getPoftrasporto().getOfprice()%></li>
                                                        </ul>
                                                        <div class="card-action">
                                                            <form action="Catalogo.jsp" name="myform4" method="post">
                                                                <input hidden value="<%=ls.get(i).getPoftrasporto().getOfid()%>" type="text" name="offertrasportoitem" id="offertrasportoitem">
                                                                <button class="btn-flat waves-effect waves-light" type="submit">Acquista
                                                                    <i class="material-icons right">send</i>
                                                                </button>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                                <%for(int j = 0;j<ls.get(i).getPofevento().size();j++){%>
                                                <div class="card blue-grey">
                                                    <div class="card-content white-text">
                                                        <span class="card-title">
                                                            Offerta Evento <%=ls.get(i).getPofevento().get(j).getOfname()%>
                                                        </span>
                                                        <ul>
                                                            <li><img src="http://orig15.deviantart.net/1614/f/2010/217/e/0/biffy_clyro_i_by_henrikack.jpg" style="margin-top: 10px; width: 100px; height: 70px;"></li>
                                                            <li>Data scadenza <%=ls.get(i).getPofevento().get(j).getOfdateexpired()%></li>
                                                            <li>Prezzo <%=ls.get(i).getPofevento().get(j).getOfprice()%></li>
                                                        </ul>
                                                        <div class="card-action">
                                                            <form action="Catalogo.jsp" name="myform5" method="post">
                                                                <input hidden value="<%=ls.get(i).getPofevento().get(j).getOfid()%>" type="text" name="offereventoitem" id="offereventoitem">
                                                                <button class="btn-flat waves-effect waves-light" type="submit">Acquista
                                                                    <i class="material-icons right">send</i>
                                                                </button>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                                <%}%>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    <%}%>




                <%}else{%>
                    <div class="col s5">
                        <div class="card deep-purple">
                            <div class="card-content white-text">
                                <span class="card-title">Nessun pacchetto disponibile</span>
                            </div>
                        </div>
                    </div>
                <%}%>


                <!--
                <div class="col s7">
                    <div class="card deep-purple">
                        <div class="card-content white-text">
                            <span class="card-title">U_Pippo Baudo 22</span>
                            <div class="row">
                                <div class="col s5">
                                    <p><button id="artistbutton" style="background: url(biffyclyro.jpeg); background-size:auto; height: 256px;width: 256px;" onclick="parent.location='login.jsp'"/></p>
                                </div>
                                <div class="col s7">
                                    <p>This is an Under Pippo Baudo description</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>-->
            </div>
        </div>
    </div>



    <div class="row">
        <div class="col s9">
            <!-- Teal page content  -->
            <div class="card-panel teal lighten-2"></div>
           </div>

    </div>

    <div class="row">
        <div class="col s9">
            <!-- Teal page content  -->
            <div class="card-panel teal lighten-2"></div>
        </div>

    </div>


    <script>
        function myFunction() {
            var x, text;

            // Get the value of the input field with id="numb"
            x = document.getElementById("artistbutton").value;

            // If x is Not a Number or less than one or greater than 10
            if (isNaN(x) || x < 1 || x > 10) {
                text = "Input not valid";
            } else {
                text = "Input OK";
            }
            document.getElementById("demo").innerHTML = text;
        }
    </script>
    <!--Import jQuery before materialize.js-->
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="js/materialize.min.js"></script>
    </body>
</html>