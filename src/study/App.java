package study;

public class App {

    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int[] shuffleResult = shuffle.shuffle(arr);
    }
}
