package de.unistuttgart.dsass2024.ex02.p5;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Random;

import org.junit.*;

public class SimpleListTest {

    @Test
    public void test() {
        ISimpleList<Integer> simpleList = new SimpleList<>();
        Random random = new Random();
        for(int i=0; i<10; i++) {
            simpleList.prepend(random.nextInt(100));
        }

        for(int i=0; i<simpleList.getSize(); i++) {
            System.out.println(simpleList.getElement(i));
        }
        
        System.out.println("---------------");

        simpleList.sort();

        for(int i=0; i<simpleList.getSize(); i++) {
            System.out.println(simpleList.getElement(i));
        }
    }
}