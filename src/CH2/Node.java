/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH2;

import java.util.HashSet;

/**
 *
 * @author CITDBS
 */
public class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
    
}

/*
struct node *slow_ptr, *fast_ptr;
 
while(!slow_ptr && !fast_ptr && fast_ptr->next != NULL) {
        slow_ptr = slow_ptr->next;  // moves one node ahead at a time
        fast_ptr = fast_ptr->next->next;  // moves two nodes ahead at a time
}
*/



