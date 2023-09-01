package javaservletapp.model;

public class Student {
  private String studentID;
  private String studentName;
  private String department;
  private int marks;

  public Student(String studentID, String studentName, String department, int marks) {
    this.studentID = studentID;
    this.studentName = studentName;
    this.department = department;
    this.marks = marks;
  }

  public String getStudentID() {
    return studentID;
  }

  public String getStudentName() {
    return studentName;
  }

  public String getDepartment() {
    return department;
  }

  public int getMarks() {
    return marks;
  }
}
