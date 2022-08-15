package main;

import util.Calculator;

public class Runner {

    public static void main(String[] args) {
        System.out.println("Hello");
        Calculator c = new Calculator();

        int sum= c.add(1,5);
        System.out.println("sum of 1 and 5 = " + sum);
        //AddHelper helper;  //does not compile, AddHelper not exported
    }
}
