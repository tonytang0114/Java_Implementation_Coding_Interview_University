/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH4;

import java.util.LinkedList;

/**
 *
 * @author CITDBS
 */
public class Graph {
    int V;
    LinkedList<Integer> adjListArray[];
    
    public Graph(int V){
        this.V = V;
        adjListArray = new LinkedList[V];
        
        for(int i=0;i<V;i++){
            adjListArray[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int src, int dest){
        adjListArray[src].add(dest);
    }
}
