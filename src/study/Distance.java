package study;

public class Distance {
    // 메서드 구현
    static double getDistance(int x, int y, int x1, int y1) {
        double calcX = (x1 - x);
        double calcY = (y1 - y);
        double xDistance = Math.pow(calcX, 2);
        double yDistance = Math.pow(calcY, 2);
        double distance = Math.sqrt(xDistance + yDistance);

        return distance;
    }


    public static void main(String[] args) {
        System.out.println(getDistance(1, 1, 2, 2));
    }
}
