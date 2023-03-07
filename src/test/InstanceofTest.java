package test;

public class InstanceofTest {

  public static void main(String[] args) {

    Car c = new Car();
    FireCar f = new FireCar();

    if (c instanceof FireCar) {
      System.out.println("gh");
    } else {
      System.out.println("돌아가!");
    }

//    c = f;
    f = (FireCar) c;
  }
}

class Car {

}

class FireCar extends Car {

}