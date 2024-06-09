package de.unistuttgart.dsass2024.ex06.p3;

import java.util.ArrayList;
import java.util.Iterator;

public class WeightedGraph<N, E> implements IWeightedGraph<N, E> {

    private int numEdges;
    private ArrayList<ArrayList<IEdge<E>>> adjacencyList;
 

    /**
     * Initializes an empty graph without nodes or edges.
     */
    public WeightedGraph() {
        this.numEdges = 0;
        this.adjacencyList = new ArrayList<>();
    }

    @Override
    public int numberOfNodes() {
        return this.adjacencyList.size();
    }

    @Override
    public int numberOfEdges() {
        return this.numEdges;
    }

    @Override
    public Iterator<IEdge<E>> edgeIterator() {
        ArrayList<IEdge<E>> edges = new ArrayList<>(numEdges);
        for (ArrayList<IEdge<E>> outgoingEdges : this.adjacencyList) {
            edges.addAll(outgoingEdges);
        }
        return edges.iterator();
    }

    @Override
    public Iterator<IEdge<E>> outgoingEdges(int src) {
        return this.adjacencyList.get(src).iterator();
    }

    public int addNode() {
        this.adjacencyList.add(new ArrayList<>());
        return this.adjacencyList.size() - 1;
    }

    public void addEdge(int src, int dest) {
        if (src < 0 || src >= numberOfNodes() || dest < 0 || dest >= numberOfNodes())
            throw new IllegalArgumentException();
        this.adjacencyList.get(src).add(new Edge<>(src, dest, 0));
        this.numEdges++;
    }

    public void createFromEdgeList(ArrayList<Integer> list) throws UnsupportedOperationException {
        if(list.size() > 2) {
            for(int i=0; i<list.get(0); i++) {
                this.adjacencyList.add(new ArrayList<>());
            }
            for(int i=2; i<list.size()-1; i=i+2) {
                //this.adjacencyList.get(i).add(new Edge<>(list.get(i), list.get(i+1), list.get(i+3)));
                this.adjacencyList.get(i).add(new Edge<>(list.get(i), list.get(i+1), 1));
            }
        }
    }


    public ArrayList<Integer> toEdgeList() {
        ArrayList<Integer> edgeList = new ArrayList<>();
        edgeList.add(this.adjacencyList.size());
        int amountOfEdges = 0;
        for(int i=0; i<this.adjacencyList.size(); i++) {
            amountOfEdges += this.adjacencyList.get(i).size();
        }
        edgeList.add(amountOfEdges);
        for(int i=0; i<this.adjacencyList.size(); i++) {
            for(int j=0; i<this.adjacencyList.get(i).size(); j++) {
                edgeList.add(this.adjacencyList.get(i).get(j).getSource());
                edgeList.add(this.adjacencyList.get(i).get(j).getDestination());
                //edgeList.add(Double.valueOf(this.adjacencyList.get(i).get(j).getWeight()).intValue());
            }
        }
        return edgeList;
    }

    public void createFromNodeList(ArrayList<Integer> list) throws UnsupportedOperationException {
        if(list.size() > 2) {
            for(int i=2; i<list.size(); i++) {
                for(int j=i+1; j<=i+list.get(i); j++) {
                    this.adjacencyList.get(i).add(new Edge<>(i, list.get(j), 1));
                }
                i += list.get(i);
            }
        }
    }

    public ArrayList<Integer> toNodeList(){
        ArrayList<Integer> nodeList = new ArrayList<>();
        nodeList.add(this.adjacencyList.size());
        int amountOfEdges = 0;
        for(int i=0; i<this.adjacencyList.size(); i++) {
            amountOfEdges += this.adjacencyList.get(i).size();
        }
        nodeList.add(amountOfEdges);
        for(int i=0; i<this.adjacencyList.size(); i++) {
            nodeList.add(this.adjacencyList.get(i).size());
            for(int j=0; j<this.adjacencyList.get(i).size(); j++) {
                nodeList.add(this.adjacencyList.get(i).get(j).getDestination());
            }
        }

        return nodeList;
    }


}