package chap_05;

public class Student {
  int studentID;
  String studentName;
  int grade;
  String address;

  public Student(int id, String name) {
    studentID = id;
    studentName = name;
  }

  public void showStudentInfo() {
    System.out.println(studentName + "," + address);
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String name) {
    studentName = name;
  }

  public static void main(String[] args) {
    Student studentLee = new Student(100, "이순신");
    studentLee.address = "서울시 영등포구 여의도동";

    Student studentKim = new Student(101,"김유신");
    studentKim.address = "미국 산호세";

    studentLee.showStudentInfo();
    studentKim.showStudentInfo();

    System.out.println(studentLee);
  }
}
