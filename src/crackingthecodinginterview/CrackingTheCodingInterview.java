/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingthecodinginterview;

import CH1.CH1;
import CH2.CH2;
import CH2.Node;

/**
 *
 * @author CITDBS
 */
public class CrackingTheCodingInterview {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Node n = new Node(1);
        n.next = new Node(2);
        n.next.next = new Node(3);
        n.next.next.next = n;
        //n.next.next.next.next = new Node(5);
        

        //CH2 ch2 = new CH2();
        //Node c = ch2.ReturnKthToLast(n, 2);
        //printList(c);
        //System.out.print(n.next.next.next == n);
    }
    
    public static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+",");
            n=n.next;
        }
    }
    
}
