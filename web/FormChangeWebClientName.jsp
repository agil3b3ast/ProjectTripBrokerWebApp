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
             class="newpackage.Beans.UtenteBean"/>
<jsp:setProperty name="utenteBean" property="*"/>


<form class="col s12" name="frm" method="post" action="GestioneUtente.jsp">
    <ul>
        <li>
        <table>
            <tbody>
                <tr>
                    <td width="80%">
                        <div class="card-panel blue-grey white-text">Nome <%=utenteBean.getName()%></div>
                    </td>
                </tr>
            </tbody>
        </table>
        </li>
    </ul>
</form>
