package de.unistuttgart.dsass2024.ex02.p4;

import static org.junit.Assert.*;
import org.junit.*;

public class ComplexityTest {

    @Test
    public void test() {
        int n=20;
        
        // System.out.println(System.currentTimeMillis());
        // long startTime = System.currentTimeMillis();
        // System.out.println("Result: " + Complexity.couldBeBetter1(n));
        // long endTime = System.currentTimeMillis();
        // System.out.println(endTime - startTime);

        // startTime = System.currentTimeMillis();
        // System.out.println("Result: " + Complexity.isDoneBetter1(n));
        // endTime = System.currentTimeMillis();
        // System.out.println(endTime - startTime);


        // long startTime = System.currentTimeMillis();
        // System.out.println("Result: " + Complexity.couldBeBetter2(n));
        // long endTime = System.currentTimeMillis();
        // System.out.println(endTime - startTime);

        // startTime = System.currentTimeMillis();
        // System.out.println("Result: " + Complexity.isDoneBetter2(n));
        // endTime = System.currentTimeMillis();
        // System.out.println(endTime - startTime);


        long startTime = System.currentTimeMillis();
        System.out.println("Result: " + Complexity.couldBeBetter3(n));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        startTime = System.currentTimeMillis();
        System.out.println("Result: " + Complexity.isDoneBetter3(n));
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}