package com.evilsoulm.keep_nice.patterns.bridge;

/**
 * Author by mazixuan
 * Data:2016-10-24 21:26
 * Project:Keep_Nice
 * Detail:
 */

public class Test {
    public static void main(String[] args) {
        Computer computer = new Laptop(new Apple());
        computer.sale();
    }
}
