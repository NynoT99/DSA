package de.unistuttgart.dsass2024.ex05.p2;

public class PrefixTree implements IPrefixTree {

    private int size = 0;
    private IPrefixTreeNode firstTreeNode = null;

    public PrefixTree() {
    }

    @Override
    public void insert(String word) {
        if(this.firstTreeNode == null) {
            this.firstTreeNode = new PrefixTreeNode();
            this.firstTreeNode.setPrefix(word);
        }
        else {
            int prefixLength = -1;
            if(word.length() - this.firstTreeNode.getPrefix().length() > 0) {
                for(int i=0; i<this.firstTreeNode.getPrefix().length(); i++) {
                    if(this.firstTreeNode.getPrefix().charAt(i) != word.charAt(i)) {
                        break;
                    }
                    prefixLength = i;
                }
            }
            else {
                for(int i=0; i<word.length(); i++) {
                    if(this.firstTreeNode.getPrefix().charAt(i) != word.charAt(i)) {
                        break;
                    }
                    prefixLength = i;
                }
            }
            if(prefixLength == -1) {
                IPrefixTreeNode tempNode = this.firstTreeNode;
                this.firstTreeNode = new PrefixTreeNode();
                this.firstTreeNode.setPrefix("");
                this.firstTreeNode.setChild(tempNode.getPrefix().charAt(0), tempNode);
            }
            else {
                Boolean noChild = true;
                int currentPosition = prefixLength;
                IPrefixTreeNode currentTreeNode = this.firstTreeNode;
                String newWord = word.substring(prefixLength+1);
                while(!currentTreeNode.getLabels().isEmpty()) {
                    if(currentTreeNode.getChild(newWord.charAt(0)) != null) {
                        noChild = false;
                        currentTreeNode = currentTreeNode.getChild(newWord.charAt(0));
                        newWord = word.substring(currentPosition+1);
                        if(newWord.length() - this.firstTreeNode.getPrefix().length() > 0) {
                            for(int i=0; i<this.firstTreeNode.getPrefix().length(); i++) {
                                if(this.firstTreeNode.getPrefix().charAt(i) != newWord.charAt(i)) {
                                    break;
                                }
                                currentPosition = i;
                            }
                        }
                        else {
                            for(int i=0; i<newWord.length(); i++) {
                                if(this.firstTreeNode.getPrefix().charAt(i) != newWord.charAt(i)) {
                                    break;
                                }
                                currentPosition = i;
                            }
                        }
                    }
                    else {
                        break;
                    }
                }
                IPrefixTreeNode newNode = new PrefixTreeNode();
                if(noChild) {
                    newNode.setPrefix(word.substring(prefixLength+1));
                    currentTreeNode.setChild(newNode.getPrefix().charAt(0), newNode);
                }
                else {
                    newNode.setPrefix(newWord.substring(currentPosition+1));
                    currentTreeNode.setChild(newNode.getPrefix().charAt(0), newNode);
                }
            }
            
        }
        this.size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    public IPrefixTreeNode getFirsTreeNode() {
        return this.firstTreeNode;
    }

}