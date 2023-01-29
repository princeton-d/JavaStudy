package chap_07_Class;

public class _03_Enum {
  public static final String MALE = "mail";
  public static final String FEMALE = "femail";

  public static void main(String[] args) {
    Gender gender = Gender.MALE;
    Gender gender2 = Gender.FEMALE;

    System.out.println(gender);
  }
}
enum Gender {
  MALE, FEMALE;
}