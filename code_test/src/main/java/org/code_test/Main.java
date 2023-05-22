package org.code_test;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] splitInput = input.split(" ");
        int A = Integer.parseInt(splitInput[0]);
        int B = Integer.parseInt(splitInput[1]);
        int V = Integer.parseInt(splitInput[2]);

        int result = (V - B) / (A - B);
        if ((V - B) % (A - B) != 0) {
            result++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

}