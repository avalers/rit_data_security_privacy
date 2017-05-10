<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page"
    xmlns:spring="http://www.springframework.org/tags"
    xmlns:c="http://java.sun.com/jsp/jstl/core"
    xmlns:form="http://www.springframework.org/tags/form" version="2.0">
    <jsp:directive.page language="java" contentType="text/html" />
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
   <head>
      <title>RIT Faculty Courses</title>
   </head>

   <body>
     <div align="center" style="background-color:#f36e21;">
 
    <h2>My Courses List as Faculty:</h2>
    <ul>
        <c:forEach items="${courses}" var="course"> 
           <h1> ${course.name} </h1> 
        </c:forEach>
    </ul>
      </div>
   </body>
   
</html>
</jsp:root>