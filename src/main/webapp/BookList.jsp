<%--
  Created by IntelliJ IDEA.
  User: taska
  Date: 4/5/2021
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<html>
<head>
    <title>Book List</title>
</head>
<t:page>
    <style type="text/css">
        td {
            border: 1px solid black;
        }

        thead > tr > td {
            font-weight: bold;
        }
    </style>
    <div style="margin-top: 10px">
        <table border="1" cellpadding="15">
            <thead>
            <tr>
                <th>ISBN</th>
                <th>Title</th>
                <th>Author</th>
                <th>Publisher</th>
                <th>Genre</th>
                <th>Page</th>
                <th>Progress</th>
                <th>Added by</th>
                <th>Completed</th>
                <th>Rating</th>
                <th>Change status</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${books}" var="book">
                <tr>
                    <td><c:out value="${book.ISBN}"/></td>
                    <td><c:out value="${book.title}"/></td>
                    <td><c:out value="${book.author}"/></td>
                    <td><c:out value="${book.publisher}"/></td>
                    <td><c:out value="${book.genre}"/></td>
                    <td><c:out value="${book.page}"/></td>
                    <td><c:out value="${book.progress}"/></td>
                    <td><c:out value="${book.addedBy}"/></td>
                    <c:choose>
                        <c:when test="${book.completed==true}">
                            <td><c:out value="Finished"/></td>
                        </c:when>
                        <c:otherwise>
                            <td><c:out value="In Progress"/></td>
                        </c:otherwise>
                    </c:choose>
                    <td><c:out value="${book.rating}"/></td>
                    <td>
                        <form method="post" action="change">
                            <input type="hidden" name="id" value="${book.id}">
                            <c:choose>
                                <c:when test="${book.completed==true}">
                                    <input type="submit" value="Mark as unfinished">
                                </c:when>
                                <c:otherwise>
                                    <input type="submit" value="Mark as finished">
                                </c:otherwise>
                            </c:choose>
                        </form>
                    </td>
                    <td>
                        <form method="get" action="edit">
                            <input type="hidden" name="id" value="${book.id}">
                            <input type="submit" value="Edit">
                        </form>
                    </td>
                    <td>
                        <form method="post" action="delete">
                            <input type="hidden" name="id" value="${book.id}">
                            <input type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</t:page>
</html>
