package test;

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  String getLocation() {
    return "x: " + x + ", y: " + y;
  }
}

class Point3D extends Point {
  int z;

  public Point3D(int x, int y, int z) {
    super(x, y);
    this.z = z;

  }

  String getLocation() {
    return "x: " + x + ", y: " + y + ", z: " + z;
  }
}

public class OverrideTest {
  public static void main(String[] args) {
    Point3D p = new Point3D(3, 5, 7);
    System.out.println(p.getLocation());

    Point p2 = new Point(1, 2);
    System.out.println(p2.getLocation());
  }
}
