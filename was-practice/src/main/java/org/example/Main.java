package org.example;

import java.io.IOException;

// GET /calculate?leftHandSide=11&operator=*&rightHandSide=55
public class Main {
    public static void main(String[] args) throws IOException {
    
        new CustomWebApplicationServer(8080).start();
    }
}