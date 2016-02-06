<%@ page import="newpackage.TipoOffertaTrasporto" %><%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 08/01/2016
  Time: 16.27
  To change this template use File | Settings | File Templates.
--%>

<ul class="collapsible" >

    <% for(TipoOffertaTrasporto of : TipoOffertaTrasporto.values()){%>
    <li>
        <form action="OffertaTrasporto.jsp" name="myform" method="post">
            <input hidden value="<%=of.getNome()%>" name="oftype">
            <button class="btn-flat waves-effect waves-light" type="submit"><%=of.getNome()%>
                <i class="material-icons right">send</i>
            </button>
        </form>
        <!--<div input id="first" name="first" type="submit" class="collapsible-header">First</div>-->
    </li>
    <%}%>
</ul>

