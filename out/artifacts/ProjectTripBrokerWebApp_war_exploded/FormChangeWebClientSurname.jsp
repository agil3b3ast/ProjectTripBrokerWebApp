<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 04/02/2016
  Time: 15.05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="utenteBean" scope="session"
             class="newpackage.Beans.UtenteBean"/>
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
                </tr>
            </table>
        </li>
    </ul>
</form>