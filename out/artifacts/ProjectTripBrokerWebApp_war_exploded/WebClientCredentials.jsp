<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 04/02/2016
  Time: 13.42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="utenteBean" scope="session"
             class="newpackage.UtenteBean"/>
<jsp:setProperty name="utenteBean" property="*"/>

<jsp:useBean id="carrelloBean" scope="session"
             class="newpackage.CarrelloBean"/>
<jsp:setProperty name="carrelloBean" property="*"/>

<div class="row">
    <div class="col s12 blue-grey">
        <ul>
            <li>
                <div class="card-title blue-grey white-text">Credenziali utente</div>
            </li>

            <li>
                <jsp:include page="FormChangeWebClientName.jsp"/>
            </li>
            <li>
                <jsp:include page="FormChangeWebClientSurname.jsp"/>
            </li>
            <li>
                <jsp:include page="FormChangeWebClientNickname.jsp"/>
            </li>
            <li>
                <jsp:include page="FormChangeWebClientBirthday.jsp"/>
            </li>
            <li>
                <table>
                    <tr>
                        <td>
                            <div class="card-panel blue-grey white-text">Data di iscrizione <%=utenteBean.getSignUpDate()%></div>
                        </td>
                    </tr>
                </table>
            </li>
            <li>
                <%if(utenteBean.getCarrelloBean().getItemList().size()==0){%>
                <table>
                    <tr>
                        <td>
                            <div class="card-panel blue-grey white-text">Carrello Vuoto</div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="card-panel blue-grey white-text">Questo carrello è di : <%=carrelloBean.getUtenteBean().getName()%> , <%=carrelloBean.getUtenteBean().getSurname()%></div>
                        </td>
                    </tr>
                </table>
                <%}%>
            </li>
        </ul>
    </div>
</div>