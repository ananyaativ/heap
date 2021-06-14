package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        heap heap=new heap(10);
        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.print();
        heap.sort();
        heap.print();
       // heap.delete(0);
       // heap.print();
    }
}
