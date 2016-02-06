<%@ page import="newpackage.TipoOffertaEvento" %><%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 29/12/2015
  Time: 11.49
  To change this template use File | Settings | File Templates--%>

<ul class="collapsible" >

    <% for(TipoOffertaEvento of : TipoOffertaEvento.values()){%>
    <li>
        <form action="OffertaEvento.jsp" name="myform" method="post">
            <input hidden value="<%=of.getNome()%>" name="oftype">
            <button class="btn-flat waves-effect waves-light" type="submit"><%=of.getNome()%>
                <i class="material-icons right">send</i>
            </button>
        </form>
        <!--<div input id="first" name="first" type="submit" class="collapsible-header">First</div>-->
    </li>
    <%}%>
</ul>

