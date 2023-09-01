<%@ page import="javaservletapp.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    List<Student> students = new ArrayList<>();
    students.add(new Student("S1", "Student 1", "Dep 1", 35));
    students.add(new Student("S2", "Student 2", "Dep 1", 70));
    students.add(new Student("S3", "Student 3", "Dep 1", 60));
    students.add(new Student("S4", "Student 4", "Dep 1", 90));
    students.add(new Student("S5", "Student 5", "Dep 2", 30));
    students.add(new Student("S6", "Student 6", "Dep 3", 32));
    students.add(new Student("S7", "Student 7", "Dep 3", 70));
    students.add(new Student("S8", "Student 8", "Dep 3", 20));

    Map<String, Double> passPercentages = new HashMap<>();
    passPercentages.put("Dep 1", 75.0);
    passPercentages.put("Dep 2", 0.0);
    passPercentages.put("Dep 3", 33.33);
%>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>
<h2>Welcome <%= session.getAttribute("userId") %>
</h2>
<table border="1">
    <tr>
        <th>Department</th>
        <th>Student ID</th>
        <th>Marks</th>
        <th>Pass %</th>
    </tr>
    <%
        for (Student student : students) {
            String passPercentage = String.format("%.2f%%", passPercentages.getOrDefault(student.getDepartment(), 0.0));
    %>
    <tr>
        <td><%= student.getDepartment() %>
        </td>
        <td><%= student.getStudentID() %>
        </td>
        <td><%= student.getMarks() %>
        </td>
        <td><%= passPercentage %>
        </td>
    </tr>
    <%
        }
    %>
</table>
<script>
    function showStudentName(studentName) {
        alert("Student Name: " + studentName);
    }
</script>
</body>
</html>
