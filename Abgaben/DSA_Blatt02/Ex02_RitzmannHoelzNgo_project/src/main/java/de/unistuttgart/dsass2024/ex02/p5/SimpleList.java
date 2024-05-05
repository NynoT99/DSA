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
                ISimpleListNode<T> previousNode = this.firstListNode;
                for(int j=0; j<this.size-1; j++) {
                    if(firstNode.getElement().compareTo(secondNode.getElement()) > 0) {
                        if(previousNode == firstNode) {
                            this.firstListNode = secondNode;
                            firstNode.setNext(this.firstListNode.getNext());
                            this.firstListNode.setNext(firstNode);
                        }
                        else {
                            previousNode.setNext(secondNode);
                            firstNode.setNext(secondNode.getNext());
                            secondNode.setNext(firstNode);
                        }
                        previousNode = secondNode;
                        switchedNodes = true;
                    }
                    else {
                        previousNode = firstNode;
                    }
                    firstNode = previousNode.getNext();
                    secondNode = firstNode.getNext();
                }
                if(switchedNodes==false) {
                    break;
                }
            }
        }
    }

}