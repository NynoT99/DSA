package de.unistuttgart.dsass2024.ex05.p4;

import java.util.ArrayList;
import java.util.List;

public class Sorter {

    public static <T extends Comparable<T>> void heapSort(final ISimpleList<T> list) {
        MaxHeap<T> heap = new MaxHeap<>();

        for(int i=0; i<list.size(); i++) {
            heap.insert(list.get(i));
        }

        List<T> sorted = new ArrayList<>();

        while (!heap.isEmpty()) {
            sorted.add(heap.extractMax());
        }
    }

}