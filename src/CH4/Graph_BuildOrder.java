/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author CITDBS
 */
public class Graph_BuildOrder {
    List<Character> V;
    Map<Character, LinkedList<Character>> adjListMap;
    
    public Graph_BuildOrder(List<Character> V){
        this.V = V;
        this.adjListMap = new HashMap();
        for(int i=0;i<V.size();i++){
           adjListMap.put(V.get(i), new LinkedList<Character>());
        }
    }
    
    public void addEdge(Character src, Character dest){
        adjListMap.get(src).add(dest);
    }
}
