package com.corndel.exercises;

public class Counter {

    private int count;

    public Counter() {
        count = 0;
    }

    // Overloading Counter where i is input
    public Counter (int i){
        count = i;
    }

    public void increment() {
        count ++;
    }

    public void reset() {
        count = 0;
    }

    public int getCount() {
        return count;
    }

    // test for extension
    public static void main(String[] args) {
        Counter counter1 = new Counter(5);
        System.out.println(counter1.count);
    }

}

