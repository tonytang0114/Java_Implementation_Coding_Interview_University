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
public class CH3 {
    public void ThreeInOne(){
        /*
        1) Separate an array into three parts
        2) 0--- n/3(+-/1) -----2n/3(+/-1) ----- n
        3) Push elements into array of three stacks (LIFO)
            i)   Three stacks have their own capacity and size
            ii)  pop will pop the top element from its own stack
            iii) if size==0 -> use the second stack->first stack->null pointer exception
            iv)  push -> push to the current stack
                            (if current stack is the third one and full -> raise full exception)
                            else  if current stack is first/second(create second/third stack and push)
            v) isFull(capacity is max in all three stacks)
            vi) isEmpty(the current stack is empty)                                                 
        */
    }
    
    public class StackMin{
        
    }
}
