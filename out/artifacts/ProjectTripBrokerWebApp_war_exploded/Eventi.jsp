<%@ page import="java.util.ArrayList" %>
<%@ page import="newpackage.Utente" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!-- Si dichiara la variabile loginBean e istanzia un oggetto newpackage.LoginBean -->
<jsp:useBean id="loginBean" scope="request"
             class="newpackage.LoginBean" />

<!--  Setta automaticamente tutti gli attributi dell'oggetto loginBean -->
<jsp:setProperty name="loginBean" property="*" />

<html>
<head>
    <!--Import Google Icon Font-->
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!--Import materialize.css-->
    <link type="text/css" rel="stylesheet" href="css/materialize.min.css" media="screen,projection"/>

    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
</head>

<body>
    <div class="row">
        <div class="col s12 blue-grey"><span class="flow-text white-text">Eventi</span></div>
    </div>

    <table>
        <thead>
        <tr>
            <th data-field="id">Tipo offerta</th>
            <th data-field="name">Nome offerta</th>
            <th data-field="price">Prezzo offerta</th>
        </tr>
        </thead>

        <tbody>
            <tr>
                <td>Pernotto</td>
                <td>Pernotto1</td>
                <td>$99</td>
            </tr>
            <tr>
                <td>Viaggi</td>
                <td>Viaggio1</td>
                <td>$399.76</td>
            </tr>
            <tr>
                <td>Concerto</td>
                <td>Concerto1</td>
                <td>$39.00</td>
            </tr>

            <tr>
                <td width="50%">
                    <ul class="collapsible" data-collapsible="expandable">
                        <% ArrayList<String[]> ls = loginBean.selectAll();
                            Utente u = (Utente) loginBean.selectObj();
                            for(int i=0;i<ls.size();i++){%>
                        <li>
                            <div class="collapsible-header"><%=ls.get(i)[0]%></div>
                            <div class="collapsible-body"><p>Questo id corrisponde a <%=ls.get(i)[5]%> nella tabella</p></div>
                        </li>
                        <%}%>
                    </ul>
                </td>
            </tr>
        </tbody>
    </table>

    <table align="center">
        <tbody>
            <tr>
                <td width="50%">
                    <ul class="collapsible" data-collapsible="expandable">
                        <li>
                            <div class="collapsible-header">First</div>
                            <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
                        </li>
                        <li>
                            <div class="collapsible-header">Second</div>
                            <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
                        </li>
                        <li>
                            <div class="collapsible-header">Third</div>
                            <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
                        </li>
                    </ul>
                </td>



                <td width="50%">
                    <ul class="collapsible" data-collapsible="expandable">
                        <li>
                            <div class="collapsible-header">First</div>
                            <div class="collapsible-body">
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
                            </div>
                        </li>
                        <li>
                            <div class="collapsible-header">Second</div>
                            <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
                        </li>
                        <li>
                            <div class="collapsible-header">Third</div>
                            <div class="collapsible-body"><p>Lorem ipsum dolor sit amet.</p></div>
                        </li>
                    </ul>
                </td>
            </tr>
        </tbody>
    </table>





    <footer class="page-footer" >

        <div class="row">
            <div class="col 16 s12">
                <h5 class="white-text">Footer Content</h5>
                <p class="grey-text text-lighten-5">You can use rows and columns here to organize your footer content.</p>
            </div>
            <div class="col 14 offset-l2 s12">
                <h5 class="white-text">Links</h5>
                <ul>
                    <li><a class="grey-text text-lighten-3" href="#!">Link 1</a></li>
                    <li><a class="grey-text text-lighten-3" href="#!">Link 2</a></li>
                    <li><a class="grey-text text-lighten-3" href="#!">Link 3</a></li>
                    <li><a class="grey-text text-lighten-3" href="#!">Link 4</a></li>
                </ul>
            </div>
        </div>
        <div class="footer-copyright">
            <div class="container">
                © 2014 Copyright Text
                <a class="grey-text text-lighten-4 right" href="#!">More Links</a>
            </div>
        </div>
    </footer>

<!--Import jQuery before materialize.js-->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>