package de.unistuttgart.dsass2024.ex04.p2;

import java.util.Stack;

public class AVLTree<K extends Comparable<K>> implements IAVLTree<K> {
    private AVLNode<K> root = null;

    @Override
    public AVLNode<K> getRootNode() {
        return root;
    }

    @Override
    public void setRootNode(AVLNode<K> node) {
        root = node;
    }

    @Override
    public void insert(K k) {
        if (root == null)
            root = new AVLNode<>(k);
        else
            root = insertRecursive(root, k);
    }

    private AVLNode<K> insertRecursive(AVLNode<K> n, K k) {
        int cmp = n.getKey().compareTo(k);
        if (cmp == 0) {
            // Schlüssel bereits vorhanden. Es ist nichts zu tun.
        } else if (cmp < 0) {
            // Rechts einfügen
            if (n.getRight() != null) {
                // Im rechten Teilbaum einfügen (rekursiv)
                n.setRight(insertRecursive(n.getRight(), k));
            } else {
                // Neuen Blattknoten rechts erzeugen
                n.setRight(new AVLNode<>(k));
            }
            // Höhe des rechten Teilbaums könnte sich verändert haben
            n.updateHeight();
            // Ggf. rebalancieren
            n = rebalance(n);
        } else {
            // Links einfügen (symmetrisch)
            if (n.getLeft() != null) {
                // Im linken Teilbaum einfügen (rekursiv)
                n.setLeft(insertRecursive(n.getLeft(), k));
            } else {
                // Neuen Blattknoten links erzeugen
                n.setLeft(new AVLNode<>(k));
            }
            // Höhe des linken Teilbaums könnte sich verändert haben
            n.updateHeight();
            // Ggf. rebalancieren
            n = rebalance(n);
        }

        return n;
    }



    private AVLNode<K> rotateLeft(AVLNode<K> n) {
        AVLNode<K> tmp = n.getRight();
        n.setRight(tmp.getLeft());
        n.updateHeight();
        tmp.setLeft(n);
        tmp.updateHeight();
        return tmp;
    }

    private AVLNode<K> rotateRight(AVLNode<K> n) {
        AVLNode<K> tmp = n.getLeft();
        n.setLeft(tmp.getRight());
        n.updateHeight();
        tmp.setRight(n);
        tmp.updateHeight();
        return tmp;
    }

    @Override
    public void remove(K k) {
        AVLNode<K> currentNode = this.root;
        Stack<AVLNode<K>> stack = new Stack<>();
        Boolean foundValue = false;
        while(currentNode != null) {
            stack.add(currentNode);
            if(currentNode.getKey().compareTo(k) < 0) {
                currentNode = currentNode.getRight();
            }
            if(currentNode.getKey().compareTo(k) > 0) {
                currentNode = currentNode.getLeft();
            }
            if(currentNode.getKey().compareTo(k) == 0) {
                foundValue = true;
                currentNode = null;
            }
        }
        if(foundValue == true) {
            stack.peek().updateHeight();
            rebalance(stack.pop());
        }
    }

    @Override
    public AVLNode<K> rebalance(AVLNode<K> n) {
        if(n.getBalance() == 2) {
            // case 1: AVL-balance == 2, left child AVL-balance >= 0
            if(n.getLeft().getBalance() >= 0) {
                return rotateRight(n);
            }
            // case 2: AVL-balance == 2, left child AVL-balance == -1
            else {
                n.setLeft(rotateLeft(n.getLeft()));
                return rotateRight(n);
            }
        }
        if(n.getBalance() == -2) {
            // case 3: AVL-balance == -2, right child AVL-balance <= 0
            if(n.getRight().getBalance() <= 0) {
                return rotateLeft(n);
            }
            // case 4: AVL-balance == -2, right child AVL-balance == 1
            else {
                n.setRight(rotateRight(n.getRight()));
                return rotateLeft(n);
            }
        }
        // case 0: AVL-balance == -1 || AVL-balance == 0 || AVL-balance ==1
        else {
            return n;
        }
    }
}