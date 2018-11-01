/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author CITDBS
 */
public class CH4 {
    
    //Q1 Route between Nodes
    public boolean RouteBetweenNodes(Graph g, int src, int dest){
        //Use iterative DFS
        boolean[] visited = new boolean[g.V];
        visited[src] = true;
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(src);
        
        while(!stack.isEmpty()){
            int item = stack.peek();
            stack.pop();
            
            if(!visited[item]){
                visited[item] = true;
            }
            Iterator<Integer> adjListIterator = g.adjListArray[src].iterator();
            while(adjListIterator.hasNext()){
                int n = adjListIterator.next();
                if(!visited[n]){
                    stack.push(n);
                }
            }
        }
        
        return visited[dest] == true;
    }
    
    //Q2 Minimal tree (Given a sorted array with unique integer elements, write
    //an algorithm to create a binary search tree with minimal height
    //nlogn vs O(logn)
    public TreeNode CreateMinimalTree(int[] arr){
        return CrreateMinimalBST(arr, 0 ,arr.length-1);
    }
    
    TreeNode CrreateMinimalBST(int arr[], int start, int end){
        if(end<start){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode n = new TreeNode(arr[mid]);
        n.left = CrreateMinimalBST(arr, start, mid-1);
        n.right = CrreateMinimalBST(arr, mid+1, end);
        return n;
    }
    
    //Q3 List of depths: Given a binary tree, design an algorithm which
    //creates a linked list of all the nodes at each depth(e.g. if you have a tree
    //with depth D , you will have D linked lists
    public LinkedList<TreeNode>[] ListOfDepth(TreeNode tree){
        if(tree == null) { return null;}
        
        int height = findHeightOfTree(tree)-1; //start from 0 to n-1
        int depth =0;
        LinkedList<TreeNode>[] lsd = (LinkedList<TreeNode>[])new Object[height];
        lsd[0].add(tree);
        
        depth++;
        CreateLinkedListAtEachDepth(tree,depth,lsd);
        return lsd;
    }
    
    public void CreateLinkedListAtEachDepth(TreeNode tree, int depth,LinkedList<TreeNode>[] lsd){
        if(tree.left!=null){
            lsd[depth].add(tree.left);
        }
        if(tree.right!=null){
            lsd[depth].add(tree.right);
        }
        CreateLinkedListAtEachDepth(tree.left,depth+1,lsd);
        CreateLinkedListAtEachDepth(tree.right,depth+1,lsd);
    }
    
    public int findHeightOfTree(TreeNode tree){
        if(tree == null){
            return -1;
        }
        return 1+ Math.max(findHeightOfTree(tree.left), findHeightOfTree(tree.right));
    }
    
    //Q3 ArrayList version (can ignore height)
    public void createLevelLinkedList_1(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level)
    {
        if(root == null) { return;} //base case
        LinkedList<TreeNode> list = null;
        if(lists.size() == level){
            list = new LinkedList<TreeNode>();
            lists.add(list);
        }else{
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList_1(root.left,lists,level+1);
        createLevelLinkedList_1(root.right,lists,level+1);
    }
    
    //Q3 BFS implementation
    ArrayList<LinkedList<TreeNode>> createLevelLinkedList_2(TreeNode root){
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        
        //Visit the root/
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if(root != null){
            current.add(root);
        }
        while(current.size()>0){
            result.add(current); //Add previous level
            LinkedList<TreeNode> parents = current; //Go to next level
            current = new LinkedList<TreeNode>();
            for(TreeNode parent: parents){
                if(parent.left!=null){
                    current.add(parent.left);
                }
                if(parent.right!=null){
                    current.add(parent.right);
                }
            }
        }
        return result;
    }
    
    //Q4 Check Balanced: Implement a function to check if a binary tree is balanced
    public boolean Check_Balance(TreeNode tree){
        int diff = Math.abs(findHeightOfTree(tree.left)-findHeightOfTree(tree.right));
        if(diff<=1 && Check_Balance(tree.left) && Check_Balance(tree.right)){
            return true;
        }
        return false;
    }
    
    //Q5 Validate BST:
    public boolean Validate_BST(TreeNode tree){
        return Check_BST(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean Check_BST(TreeNode tree, int MIN, int MAX){
        if(tree==null){
            return true;
        }
        
        if(tree.data > MIN 
                && tree.data<MAX
                && Check_BST(tree.left, MIN, tree.data)
                && Check_BST(tree.right, tree.data, MAX))
        {
            return true;
        }
        else{
            return false;
        }       
    }
    //In-order traversal
    public boolean Validate_BST_2(TreeNode root){
        List<Integer> list = new ArrayList<Integer>();
        int max = Integer.MAX_VALUE;
        for(Integer i:list){
            if(max>i){
                max=i;
            }else{
                return false;
            }
        }
        return true;
    }
    
    public List<Integer> InOrderTraversal(TreeNode root, List<Integer> list){
        if(root!= null){
            InOrderTraversal(root.left,list);
            list.add(root.data);
            InOrderTraversal(root.right,list);
        }
        return list;
    }  
    
    //Q6 Successor (In order)
    /*
    public TreeNode FindInOrderSuccessor(TreeNode n){
        if(n == null) return null;
        if(n.right!=null){
            return leftMostChild(n.right);
        }else{
            TreeNode q =  n;
            TreeNode x = q.parent;
            
            while(x!= null && x.left!=q){
                q = x;
                x = x.parent;
            }
            return x;
        }
    }
    public TreeNode leftMostChild(TreeNode n){
        if(n==null) { return null;}
        while(n.left!=null){
            n = n.left;
        }
        return n;
    }
    */
    
    //Q7 Build order (solve using topological sort)
    public List<Character> BuildOrder(List<Character> projects, ArrayList<List<Character>> dependencies){
       //Make a Graph
       List<Character> result = new ArrayList();
       Graph_BuildOrder g = PlotGraph(projects, dependencies);
       boolean[] visited = new boolean[projects.size()];
       Stack<Character> stack = new Stack<Character>();
       for(Character ch: projects){
           if(!visited[ch]){
                Topological_Sort(g,ch,visited,stack);
           }
       }
       
       while(!stack.isEmpty()){
           result.add(stack.pop());
       }
       return result;
    }
    
    public void Topological_Sort(Graph_BuildOrder g, Character ch, boolean[] visited, Stack stack){
        visited[ch] = true;
        Iterator<Character> it = g.adjListMap.get(ch).iterator(); 
        while(it.hasNext()){
            char character = it.next();
            if(!visited[character]){
                Topological_Sort(g,character,visited,stack);
            }
        }
        stack.push(ch);
    }
    
    public Graph_BuildOrder PlotGraph(List<Character> projects, ArrayList<List<Character>> dependencies)
    {
        Graph_BuildOrder g = new Graph_BuildOrder(projects);
        Iterator<List<Character>> listIterator = dependencies.iterator();
        while(listIterator.hasNext()){
            List<Character> temp = listIterator.next();
            g.addEdge(temp.get(0), temp.get(1));
        }
        
        return g;
    }
    //Q4.8 First common ancestor
    
    //Q4.9 BST Sequences
    public void BST_Sequences(TreeNode root){
        
    }
    
    
    
}
