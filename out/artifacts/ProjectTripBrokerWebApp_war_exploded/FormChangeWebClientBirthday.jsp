<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 04/02/2016
  Time: 15.09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="utenteBean" scope="session"
             class="newpackage.Beans.UtenteBean"/>
<jsp:setProperty name="utenteBean" property="*"/>

<form class="col s12" name="frm" method="post" action="GestioneUtente.jsp">
    <ul>
        <li>
            <table>
                <tr>
                    <td width="80%">
                        <div class="card-panel blue-grey white-text">Data di nascita <%=utenteBean.getBirthday()%></div>
                    </td>

                </tr>
            </table>
        </li>
    </ul>
</form>
