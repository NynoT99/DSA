package de.unistuttgart.dsass2024.ex05.p4;

import java.util.ArrayList;

public class MaxHeap<T extends Comparable<T>> {
    private ArrayList<T> Heap = new ArrayList<>();
 
    public MaxHeap() {
     
    }
 
    private int parent(int position) { 
        return (position - 1) / 2; 
    }
 
    private int leftChild(int position) {
        return (2 * position) + 1; 
    }
 
    private int rightChild(int position) {
        return (2 * position) + 2;
    }
 
    private boolean isLeaf(int posistion) {
        if (posistion > (size / 2) && posistion <= size) {
            return true;
        }
        return false;
    }
 
    private void swap(int firstPostion, int secondPostion) {
        T temporaryStorage;
        temporaryStorage = Heap.get(firstPostion);
        Heap.set(firstPostion, Heap.get(secondPostion));
        Heap.set(secondPostion, temporaryStorage);
    }
 
    private void maxHeapify(int position) {
        if (isLeaf(position)) {
            return;
        }
        if (Heap.get(position).compareTo(Heap.get(leftChild(position))) < 0 || Heap.get(position).compareTo(Heap.get(rightChild(position))) < 0) {
            if(Heap.get(leftChild(position)).compareTo(Heap.get(rightChild(position))) > 0) {
                swap(position, leftChild(position));
                maxHeapify(leftChild(position));
            }
            else {
                swap(position, rightChild(position));
                maxHeapify(rightChild(position));
            }
        }
    }
 
    public void insert(T element) {
        Heap.add(element);
 
        int current = Heap.size();
        while(Heap.get(current).compareTo(Heap.get(current)) > 0) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
 
    public T extractMax() {
        T popped = Heap.get(0);
        Heap.set(0, Heap.get(Heap.size()-1));
        Heap.remove(Heap.size()-1);
        maxHeapify(0);
        return popped;
    }

    public Boolean isEmpty() {
        if(Heap.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

}
