<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1" />
        <title>Promotion Event</title>
    </head>
    <body>
        <a href="/">Home</a>

        <table border="1">
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Description</td>
                <td>Start Date</td>
                <td>End Date</td>
                <td>Status</td>
                <td>Admin ID</td>
                <td>Actions</td>
            </tr>
            <c:forEach var="events" items="${newEvents}">
                <tr>
                    <td>${events.getPromotionEventID()}</td>
                    <td>${events.getPromotionEventName()}</td>
                    <td>${events.getPromotionEventDescription()}</td>
                    <td>${events.getPromotionEventStartDate()}</td>
                    <td>${events.getPromotionEventEndDate()}</td>
                    <td>${events.getPromotionEventStatus()}</td>
                    <td>${events.getAdminID()}</td>
                    <td>
                        <a>Edit</a>
                        <a>Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
