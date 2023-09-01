package javaservletapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String userId = request.getParameter("userId");
    String password = request.getParameter("password");

    // Validasi userID dan password dengan hardcode
    if (userId.equals("user123") && password.equals("password123")) {
      // Login berhasil, simpan userID dalam sesi
      HttpSession session = request.getSession();
      session.setAttribute("userId", userId);
      response.sendRedirect("welcome.jsp");
    } else {
      // Login gagal, kembali ke halaman login
      response.sendRedirect("login.jsp");
    }
  }
}