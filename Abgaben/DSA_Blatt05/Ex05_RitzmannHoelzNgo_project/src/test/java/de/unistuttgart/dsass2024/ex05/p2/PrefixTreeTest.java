package de.unistuttgart.dsass2024.ex05.p2;

import org.junit.Test;

public class PrefixTreeTest {

    @Test
    public void test() {
        PrefixTree prefixTree = new PrefixTree();
        prefixTree.insert("Baum");
        prefixTree.insert("Baumschule");
        prefixTree.insert("Baumi");
        prefixTree.insert("Baumschulen");
        System.out.println(prefixTree.getFirsTreeNode().getPrefix());
        System.out.println(prefixTree.getFirsTreeNode().getChild('s').getPrefix());
    }
}