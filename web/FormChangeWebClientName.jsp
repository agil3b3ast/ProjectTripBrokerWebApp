<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 04/02/2016
  Time: 15.02
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<jsp:useBean id="utenteBean" scope="session"
             class="newpackage.UtenteBean"/>
<jsp:setProperty name="utenteBean" property="*"/>

<html>
    <head>
    <script>
        function Change(){
            var t = document.getElementById('tabModName');
            if(t.style.display == "none")
                t.style.display = "block";
            else
                t.style.display = 'none';
        }
    </script>
    </head>
    <body>
<form class="col s12" name="frm" method="post" action="GestioneUtente.jsp">
    <table>
        <tbody>
            <tr>
                <td width="80%">
                    <div class="card-panel blue-grey white-text">Nome <%=utenteBean.getName()%></div>
                </td>
                <td width="20%">
                    <button class="btn-flat waves-effect waves-light" id="changeName" onclick="Change();">Modifica</button>
                </td>
            </tr>
            <tr style="display: none" id="tabModName">
                <td width="80%">
                    <div class="input-field col s12">
                        <input placeholder="es. mionome" id="modName" name="modName" type="text" class="validate">
                        <label for="modName">Nuovo Nome</label>
                    </div>
                </td>
                <td width="20%">
                    <button class="btn-flat waves-effect waves-light" id="confirmModName" type = "submit" name="confirmModName">Conferma Modifica</button>
                </td>
            </tr>
        </tbody>
    </table>
</form>
    </body>
</html>