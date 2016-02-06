<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 04/02/2016
  Time: 15.16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="utenteBean" scope="session"
             class="newpackage.UtenteBean"/>
<jsp:setProperty name="utenteBean" property="*"/>

<script>
    function Change(){

        t=document.getElementById("tableModNickname");
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
                        <div class="card-panel blue-grey white-text">Nickname <%=utenteBean.getNickname()%></div>
                    </td>
                    <td width="20%">
                        <button class="btn-flat waves-effect waves-light" id="changeNickname" onclick="Change();">Modifica</button>
                    </td>
                </tr>
            </table>
        </li>
        <li>
            <table style="display:none" id="tableModNickname">
                <tr>
                    <td width="80%">
                        <div class="input-field col s12">
                            <input placeholder="mynickname" id="modNickname" name="modNickname" type="text" class="validate">
                            <label for="modNickname">Nuovo Nickname</label>
                        </div>
                    </td>
                    <td width="20%">
                        <button class="btn-flat waves-effect waves-light" id="confirmModNickname" type = "submit" name="confirmModNickname">Conferma Modifica</button>
                    </td>
                </tr>
            </table>
        </li>
    </ul>
</form>

