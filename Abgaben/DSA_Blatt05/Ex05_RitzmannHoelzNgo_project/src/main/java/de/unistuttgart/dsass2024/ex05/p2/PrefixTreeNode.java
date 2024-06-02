package de.unistuttgart.dsass2024.ex05.p2;

import java.util.HashMap;
import java.util.Set;

public class PrefixTreeNode implements IPrefixTreeNode{

    private String prefix;
    private HashMap<Character, IPrefixTreeNode> childLabelMap = new HashMap<>();

    public PrefixTreeNode() {

    }

    @Override
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String getPrefix() {
        return this.prefix;
    }

    @Override
    public Set<Character> getLabels() {
        return this.childLabelMap.keySet();
    }

    @Override
    public void setChild(char label, IPrefixTreeNode node) {
        this.childLabelMap.put(label, node);
    }

    @Override
    public IPrefixTreeNode getChild(char label) {
        return childLabelMap.get(label);
    }

    @Override
    public void removeChildren() {
        this.childLabelMap = new HashMap<>();
    }

}