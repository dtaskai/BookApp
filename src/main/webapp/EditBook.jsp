<%--
  Created by IntelliJ IDEA.
  User: taska
  Date: 4/5/2021
  Time: 3:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<t:page>
    <h3>Editing... ${book.get().title}</h3>
    <form action="edit" method="post" style="margin-top: 10px">
        <table>
            <tr>
            <input type="hidden" name="id" value="${book.get().id}">
            </tr>
            <tr>
                <td>ISBN:</td>
                <td><input name="ISBN" value="${book.get().ISBN}"></td>
            </tr>
            <tr>
                <td>Title:</td>
                <td><input name="title" value="${book.get().title}"></td>
            </tr>
            <tr>
                <td>Author:</td>
                <td><input name="author" value="${book.get().author}"></td>
            </tr>
            <tr>
                <td>Publisher</td>
                <td><input name="publisher" value="${book.get().publisher}"></td>
            </tr>
            <tr>
                <td>Genre</td>
                <td>
                    <select name="genre" id="genre">
                        <option value="Fantasy" <c:if test="${book.get().genre == 'Fantasy'}">selected</c:if>>Fantasy</option>
                        <option value="Horror" <c:if test="${book.get().genre == 'Horror'}">selected</c:if>>Horror</option>
                        <option value="Adventure" <c:if test="${book.get().genre == 'Adventure'}">selected</c:if>>Adventure</option>
                        <option value="Science" <c:if test="${book.get().genre == 'Science'}">selected</c:if>>Science</option>
                        <option value="Art" <c:if test="${book.get().genre == 'Art'}">selected</c:if>>Art</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Page</td>
                <td><input name="page" value="${book.get().page}"></td>
            </tr>
            <tr>
                <td>Progress</td>
                <td><input name="progress" value="${book.get().progress}"></td>
            </tr>
            <tr>
                <td>Rating</td>
                <td>
                    <select name="rating" id="rating">
                        <option value="0" <c:if test="${book.get().rating == '0'}">selected</c:if>>0</option>
                        <option value="1" <c:if test="${book.get().rating == '1'}">selected</c:if>>1</option>
                        <option value="2" <c:if test="${book.get().rating == '2'}">selected</c:if>>2</option>
                        <option value="3" <c:if test="${book.get().rating == '3'}">selected</c:if>>3</option>
                        <option value="4" <c:if test="${book.get().rating == '4'}">selected</c:if>>4</option>
                        <option value="5" <c:if test="${book.get().rating == '5'}">selected</c:if>>5</option>
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
