/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH3;

/**
 *
 * @author CITDBS
 */
public class StackMin{
    public class StackNode{
        int data;
        StackNode next;
        public StackNode(int data){
            this.data = data;
        }
    }
    private int min = Integer.MAX_VALUE;
    private StackNode top;
    
    public void push(int item){
        if(min>item){
            min = item;
        }
        if(top == null){
            top = new StackNode(item);
        }else{
            StackNode s = new StackNode(item);
            s.next = top;
            top=s;
        }
    }
    
    public int pop(){
        if(top==null){
            throw new Error("Empty stack exception");
        }else{
            int item = top.data;
            top = top.next;
            return item;
        }
    }
    
    public int min(){
        return min;
    }
}
