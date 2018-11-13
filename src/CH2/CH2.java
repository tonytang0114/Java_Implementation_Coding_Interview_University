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
public class CH2 {

    //Q1 Remove Dups With DTO
    public void RemoveDups_withDTO(Node n) {
        //Hashset
        HashSet<Integer> hs = new HashSet<Integer>();
        Node prev = null;
        Node cur = n;
        while (n != null) {
            if (!hs.contains(n.data)) {
                hs.add(n.data);
            } else {
                prev.next = cur.next;
            }
        }

        prev = n;
        cur = n.next;

        n = n.next;
    }
    //Q1 Remove Dups Without DTO
    public void RemoveDups_WithoutDTO(Node n){
        //Runner method
        while(n!=null){
            Node prev = n;
            while(n.next != null){
                Node cur = n.next;
                if(cur.data == prev.data){
                    prev.next = cur.next;
                }
                cur = cur.next;
            }
            prev = prev.next;
        }
    }
    
    //Q2 Return Kth to Last
    public Node ReturnKthToLast(Node n, int k){
        int len = FindLengthOfLinkedList(n);
        if(k>len) {return null;}
        
        for(int i=0;i<k;i++){
                n = n.next;
        }
        return n;
    }
    
    public int FindLengthOfLinkedList(Node n){
        int count=0;
        while(n!=null){
            count++;
            n=n.next;
        }
        return count;
    }
    
    //Q3 Delete Middle Node
    public void DeleteMiddleNode(Node n){
        Node cur = n;
        Node next = cur.next;
        
        cur.data = next.data;
        cur.next = next.next;
    }
    
    //Q4 Partition
    public void Partition(int x){
        //Case 1 (x is not in the partition)
        //Case 2 (x in in the partition)
        //Brute force O(n^2)
    }
    
    //Q5 Sum List
    //You have two numbers represented by a linked list, where each node contains a single
    //digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a
    //function that adds the two numbers and returns the sum as a linked list.
    public Node SumLists(Node n1, Node n2){
        Node Sum = null;
        int len_n1 = FindLengthOfLinkedList(n1);
        int len_n2 = FindLengthOfLinkedList(n2);
        int i=0,j=0;
        boolean HasCarrier = false;
        while(i<len_n1 && j<len_n2){
            int sum = n1.data + n2.data;
            
            if(sum >= 10) {
                HasCarrier=true;
            }else{
                HasCarrier=false;
            }
            
            if(Sum == null){
                Sum = new Node(sum%10);
            }else{
                if(HasCarrier){
                    Sum.next= new Node(sum%10+1);  
                }
                else
                {
                    Sum.next = new Node(sum%10);
                }
            }
            n1 = n1.next;
            n2 = n2.next;
            i++;
            j++;
        }
        while(i<len_n1){
            Sum.next = new Node(n1.data);
            n1 = n1.next;
        }
        while(j<len_n2){
            Sum.next = new Node(n2.data);
            n2 = n2.next;
        }
        return Sum;
    }
    
    //Q5 Sum List and reverse
    public Node SumList_2(Node n1, Node n2){
        //Reverse the linkedlist
        n1 = Reverse(n1);
        n2 = Reverse(n2);
        Node sum = SumLists(n1,n2);
        return Reverse(sum);
    }
    
    public Node Reverse(Node n1){
        Node prev = null;
        Node cur = n1;
        Node next = null;
        while(cur!= null){
            next=cur.next;
            next.next = cur;
            prev=cur;
            cur=next;
        }
        n1 = prev;
        return n1;
    }
    //Q6 Palindrome
   public boolean isPalindrome(Node n1){
       //Find the length of the linked list
       int len = FindLengthOfLinkedList(n1);
       int mid = len/2;
       Node left = null;
       Node right = null; 
       Node cur=n1;
       //case 1 the list is even
       if(len %2==0){
            //Separate into two lists (left / right)
           for(int i=0;i<mid/2-1;i++){
               cur = cur.next;
           }
           right = cur.next;
           cur.next = null;
           left = n1;
           
       }else{
            //Separate into two lists (left / right) with the mid node duplicate
           for(int i=0;i<mid/2;i++){
               cur = cur.next;
           }
           right = cur;
           cur.next = null;
           left = n1;      
       }
       
       while(left!=null && right!=null){
           if(left.data != right.data){
               return false;
           }
           left = left.next;
           right = right.next;
       }
       return true;
   }  
   //Q7 Intersection O(n)
   public boolean Intersection(Node n1, Node n2)
   {
        int len_n1 = FindLengthOfLinkedList(n1);
        int len_n2 = FindLengthOfLinkedList(n2);
        int diff;

        if(len_n1 > len_n2){
            diff = len_n1 - len_n2;
            return IsGettingIntersectingNode(diff,n1,n2);
        }else{
            diff = len_n2 - len_n1;
            return IsGettingIntersectingNode(diff,n2,n1);
        }
       
   }
   
    public boolean IsGettingIntersectingNode(int diff, Node n1, Node n2){
        Node current = n1;
        Node current1 = n2;
        
        for(int i=0;i<diff;i++){
            if(current == null){
                return false;
            }
            current = current.next;
        }
        
        while(current !=null && current1!=null){
            if(current == current1){
                return true;
            }
            current=current.next;
            current1=current1.next;
        }
        
        return false;
    }
    //Q9 Loop detection of a circular linked list
    //Time complexity O(n^2)
    public int Loop_detection(Node n1){
        //foreach node -> tranverse to the right
        Node cur = n1;
        while(n1 != null){
            if(ReturnLastNodeofLinkedList(cur,n1)){
                return n1.data;
            }
            n1=n1.next;
        }
        return -1;
    }
    
    public boolean ReturnLastNodeofLinkedList(Node n1,Node n2){
        while(n1.next!=null){
            if(n1==n2){
                return true;
            }
            n1 = n1.next;
        }
        return false;
    }
    
    public int Loop_detection_1(Node n1){
        HashSet<Node> hs = new HashSet<Node>();
        while(n1!=null){
            if(!hs.contains(n1)){
                hs.add(n1);
            }else{
                return n1.data;
            }
            n1=n1.next;
        }
        return -1;
    }
    
}


