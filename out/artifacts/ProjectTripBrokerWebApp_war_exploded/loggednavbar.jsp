<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="newpackage.TipoOfferta"%>

<nav>
    <div class="nav-wrapper">
        <a href="Catalogo.jsp" class="brand-logo">Catalogo</a>
        <ul class="right hide-on-med-and-down">
            <li><a href="FindEvento.jsp"><%=TipoOfferta.OffertaEvento%></a></li>
            <li><a href="FindPernotto.jsp"><%=TipoOfferta.OffertaPernotto%></a></li>
            <li><a href="FindTrasporto.jsp"><%=TipoOfferta.OffertaTrasporto%></a></li>
            <li><a href="GestioneUtente.jsp">Gestione utente</a></li>
            <li><a href="Pagamento.jsp">Carrello</a></li>
            <li><a href="logout.jsp">Logout</a></li>
        </ul>
    </div>
</nav>

