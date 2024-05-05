package de.unistuttgart.dsass2024.ex02.p5;

public class SimpleList<T extends Comparable<T>> implements ISimpleList<T> {

    int size = 0;
    ISimpleListNode<T> firstListNode = null;

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void prepend(T element) {
        if(firstListNode == null) {
            this.firstListNode = new SimpleListNode<T>(element);
            this.size++;
        }
        else {
            ISimpleListNode<T> temporaryStorage = firstListNode;
            firstListNode = new SimpleListNode<T>(element);
            firstListNode.setNext(temporaryStorage);
            this.size++;
        }
    }

    @Override
    public T getElement(int index) {
        if(index == 0) {
            return this.firstListNode.getElement();
        }
        else {
            ISimpleListNode<T> node = firstListNode;
            for(int i=0; i<index; i++) {
                node = node.getNext();
            }
            return node.getElement();
        }
    }

    @Override
    public void sort() {
        if(this.size > 1) {
            for(int i=0; i<this.size; i++) {
                Boolean switchedNodes = false;
                ISimpleListNode<T> firstNode = this.firstListNode;
                ISimpleListNode<T> secondNode = this.firstListNode.getNext();
                for(int j=0; j<this.size-1; j++) {
                    if(firstNode.getElement().compareTo(secondNode.getElement()) > 0) {
                        T temporaryStorage = firstNode.getElement();
                        firstNode.setElement(secondNode.getElement());
                        secondNode.setElement(temporaryStorage);;
                        switchedNodes = true;
                    }
                    firstNode = secondNode;
                    secondNode = secondNode.getNext();
                }
                if(switchedNodes==false) {
                    break;
                }
            }
        }
    }

}