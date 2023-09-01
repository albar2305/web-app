package javaservletapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaservletapp.model.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Buat data mahasiswa hardcoded
    List<Student> students = new ArrayList<>();
    students.add(new Student("S1", "Student 1", "Dep 1", 35));
    students.add(new Student("S2", "Student 2", "Dep 1", 70));
    students.add(new Student("S3", "Student 3", "Dep 1", 60));
    students.add(new Student("S4", "Student 4", "Dep 1", 90));
    students.add(new Student("S5", "Student 5", "Dep 2", 30));
    students.add(new Student("S6", "Student 6", "Dep 2", 32));
    students.add(new Student("S7", "Student 7", "Dep 1", 70));
    students.add(new Student("S8", "Student 8", "Dep 1", 20));

    Map<String, Double> passPercentages = calculatePassPercentages(students);

    System.out.println("Jumlah Mahasiswa: " + students.size());
    System.out.println("Persentase Kelulusan: " + passPercentages);
    request.setAttribute("students", students);
    request.setAttribute("passPercentages", passPercentages);

    request.getRequestDispatcher("welcome.jsp").forward(request, response);
  }

  private Map<String, Double> calculatePassPercentages(List<Student> students) {
    Map<String, Double> passPercentages = new HashMap<>();
    Map<String, Integer> passCounts = new HashMap<>();
    Map<String, Integer> totalCounts = new HashMap<>();

    for (Student student : students) {
      String department = student.getDepartment();
      boolean isPass = student.getMarks() >= 40;

      passCounts.put(department, passCounts.getOrDefault(department, 0) + (isPass ? 1 : 0));
      totalCounts.put(department, totalCounts.getOrDefault(department, 0) + 1);
    }

    for (String department : totalCounts.keySet()) {
      int total = totalCounts.get(department);
      int pass = passCounts.getOrDefault(department, 0);

      double passPercentage = (total > 0) ? ((double) pass / total) * 100.0 : 0.0;
      passPercentages.put(department, passPercentage);
    }

    return passPercentages;
  }
}

