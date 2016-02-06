<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 04/02/2016
  Time: 15.05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="utenteBean" scope="session"
             class="newpackage.UtenteBean"/>
<jsp:setProperty name="utenteBean" property="*"/>

<script>
    function Change(){

        t=document.getElementById("tableModSurname");
        if(t.style.display = "block")
            t.style.display = "none";
        else
            t.style.display = "block";

    }
</script>

<form class="col s12" name="frm" method="post" action="GestioneUtente.jsp">
    <ul>
        <li>
            <table>
                <tr>
                    <td width="80%">
                        <div class="card-panel blue-grey white-text">Cognome <%=utenteBean.getSurname()%></div>
                    </td>
                    <td width="20%">
                        <button class="btn-flat waves-effect waves-light" id="changeSurname" onclick="Change();">Modifica</button>
                    </td>
                </tr>
            </table>
        </li>
        <li>
            <table style="display:none" id="tableModSurname">
                <tr>
                    <td width="80%">
                        <div class="input-field col s12">
                            <input placeholder="es. cognome" id="modSurname" name="modSurname" type="text" class="validate">
                            <label for="modSurname">Nuovo Cognome</label>
                        </div>
                    </td>
                    <td width="20%">
                        <button class="btn-flat waves-effect waves-light" id="confirmModSurname" type = "submit" name="confirmModSurname">Conferma Modifica</button>
                    </td>
                </tr>
            </table>
        </li>
    </ul>
</form>