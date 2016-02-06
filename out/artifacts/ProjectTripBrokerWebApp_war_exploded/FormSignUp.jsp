<%--
  Created by IntelliJ IDEA.
  User: Alessandro
  Date: 29/01/2016
  Time: 19.29
  To change this template use File | Settings | File Templates.
--%>

<div class="row">
    <form class="col s12" name="frm" method="post" action="GestioneUtente.jsp">
        <ul>
            <li>
                <div class="row">
                    <div class="input-field col s12 white-text">
                        <input placeholder="mynickname" id="nickname" name="nickname" type="text" class="validate">
                        <label for="nickname">Nickname</label>
                    </div>
                </div>
            </li>
            <li>
                <div class="row">
                    <div class="input-field col s12 white-text">
                        <input placeholder="mypassword" id="password" name="password" type="text" class="validate">
                        <label for="password">Password</label>
                    </div>
                </div>
            </li>
            <li>
                <div class="row">
                    <div class="input-field col s12 white-text">
                        <input placeholder="es. mionome" id="name" name="name" type="text" class="validate">
                        <label for="name">Nome</label>
                    </div>
                </div>
            </li>
            <li>
                <div class="row">
                    <div class="input-field col s12 white-text">
                        <input placeholder="es. cognome" id="surname" name="surname" type="text" class="validate">
                        <label for="surname">Cognome</label>
                    </div>
                </div>
            </li>
            <li>
                <div class="input-field col s12 white-text" id="datepick">
                    <input type="date" class="datepicker" name="birthday">
                    <label>Seleziona data di nascita</label>
                </div>
            </li>
            <li>
                <button class="btn-flat waves-effect waves-light" type="submit" name="signUp" id="signUp">Registrati
                    <i class="material-icons right"></i>
                </button>
            </li>
        </ul>
    </form>
</div>