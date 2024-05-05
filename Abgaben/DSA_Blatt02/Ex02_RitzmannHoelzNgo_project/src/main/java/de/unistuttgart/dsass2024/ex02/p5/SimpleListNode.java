package de.unistuttgart.dsass2024.ex02.p5;

public class SimpleListNode<T extends Comparable<T>> implements ISimpleListNode<T>{

    T element;
    ISimpleListNode<T> nextNode;

    public SimpleListNode(T element) {
        this.element = element;
    }

    @Override
    public T getElement() {
        return this.element;
    }

    @Override
    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public ISimpleListNode<T> getNext() {
        return this.nextNode;
    }

    @Override
    public void setNext(ISimpleListNode<T> node) {
        this.nextNode = node;
    }

}