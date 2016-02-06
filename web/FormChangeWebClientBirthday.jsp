<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 04/02/2016
  Time: 15.09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="utenteBean" scope="session"
             class="newpackage.UtenteBean"/>
<jsp:setProperty name="utenteBean" property="*"/>

<script>
    function Change(){
        t=document.getElementById("tableModBirthday");
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
                        <div class="card-panel blue-grey white-text">Data di nascita <%=utenteBean.getBirthday()%></div>
                    </td>
                    <td width="20%">
                        <button class="btn-flat waves-effect waves-light" id="changeBirthday" onclick="Change();">Modifica</button>
                    </td>
                </tr>
            </table>
        </li>
        <li>
            <table style="display:none" id="tableModBirthday">
                <tr>
                    <td width="80%">
                        <div class="input-field col s12" id="datepick">
                            <input type="date" class="datepicker" name="modBirthday">
                            <label>Seleziona data di nascita</label>
                        </div>
                    </td>
                    <td width="20%">
                        <button class="btn-flat waves-effect waves-light" id="confirmModBirthday" type = "submit" name="confirmModBirthday">Conferma Modifica</button>
                    </td>
                </tr>
            </table>
        </li>
    </ul>
</form>
