<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 06/02/2016
  Time: 20.08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="card-action">
    <form action="Catalogo.jsp" name="myform5" method="post">
        <input hidden value="%=ls.get(i).getPofevento().get(j).getOfid()%>" type="text" name="offereventoitem" id="offereventoitem">
        <button class="btn-flat waves-effect waves-light" type="submit">Acquista
            <i class="material-icons right">send</i>
        </button>
    </form>
</div>

<div class="card-action">
    <form action="Catalogo.jsp" name="myform3" method="post">
        <input hidden value="%=ls.get(i).getPofpernotto().getOfid()%>" type="text" name="offerpernottoitem" id="offerpernottoitem">
        <button class="btn-flat waves-effect waves-light" type="submit">Acquista
            <i class="material-icons right">send</i>
        </button>
    </form>
</div>

<div class="card-action">
    <form action="Catalogo.jsp" name="myform4" method="post">
        <input hidden value="%=ls.get(i).getPoftrasporto().getOfid()%>" type="text" name="offertrasportoitem" id="offertrasportoitem">
        <button class="btn-flat waves-effect waves-light" type="submit">Acquista
            <i class="material-icons right">send</i>
        </button>
    </form>
</div>