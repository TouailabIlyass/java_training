<%-- 
    Document   : index
    Created on : Feb 27, 2019, 1:56:53 PM
    Author     : drging
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="get" action="qcm">
        <ul>
            <li><label>Nom</label><input type="text" name="nom"></li>
            <li><label>Prenom</label><input type="text" name="prenom"></li>
            <li><label>Sexe</label>
                <ul>
                    <li><label>M</label><input type="radio" name="sexe" value="M"></li>
                    <li><label>F</label><input type="radio" name="sexe" value="F"></li>
                </ul>
            </li>
            
            <li><label>Fonction</label>
                <select name="fct">
                    <option value="Enseignant">Enseignant</option>
                    <option selected>Etudiant</option>
                    <option>Ingenieur</option>
                    <option>Retraite</option>
                    <option>Autre</option>
                </select>
            </li>
            
            <li>Loisirs
            <ul>
                    <li><label>Lecture</label><input type="checkbox" name="ls[]" value="Lecture"></li>
                    <li><label>Sport</label><input type="checkbox" name="ls[]" value="Sport"></li>
                    <li><label>Voyage</label><input type="checkbox" name="ls[]" value="Voyage"></li>
                </ul>
            
            </li>
            <li>Commentaire
                <ul>
                    <li>
                        <textarea width="100" name="cmt"></textarea>
                        
                    </li>
                </ul>
            </li>
        </ul>
        
            <input type="submit" name="submit" value="submit">
        </form>
        
        
    </body>
</html>
