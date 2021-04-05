<%--
  Created by IntelliJ IDEA.
  User: taska
  Date: 4/5/2021
  Time: 2:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<html>
<head>
    <title>Add a new Book</title>
</head>
<t:page>
    <form action="add" method="post" style="margin-top: 10px">
        <table>
            <tr>
                <td>ISBN:</td>
                <td><input name="ISBN"></td>
            </tr>
            <tr>
                <td>Title:</td>
                <td><input name="title"></td>
            </tr>
            <tr>
                <td>Author:</td>
                <td><input name="author"></td>
            </tr>
            <tr>
                <td>Publisher</td>
                <td><input name="publisher"></td>
            </tr>
            <tr>
                <td>Genre</td>
                <td>
                    <select name="genre" id="genre">
                        <option value="Fantasy">Fantasy</option>
                        <option value="Horror">Horror</option>
                        <option value="Adventure">Adventure</option>
                        <option value="Science">Science</option>
                        <option value="Art">Art</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Page</td>
                <td><input name="page"></td>
            </tr>
            <tr>
                <td>Progress</td>
                <td><input name="progress"></td>
            </tr>
            <tr>
                <td>Status</td>
                <td>
                    <select name="completed" id="completed">
                        <option value="true">Finished</option>
                        <option value="false">In Progress</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Rating</td>
                <td>
                    <select name="rating" id="rating">
                        <option value="0">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Save"></td>
                <td>
                    <button type="button" onclick="window.history.back()">Back</button>
                </td>
            </tr>
        </table>
    </form>
</t:page>
</html>

