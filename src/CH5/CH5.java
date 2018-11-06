/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH5;

import java.util.regex.Pattern;

/**
 *
 * @author CITDBS
 */
public class CH5 {
    /*You are given two 32-bit numbers, N and M and two bit positions, i andj.
      Write a method to insert M into N such that M starts at bit j and ends at bit i/
      You can assume that the bits j through i have enough space to fit all of M.
    
    Input: N = 10000000000, M = 10011, i=2 , j=6
    Output: N = 10001001100
    
    Q1
    */
    public int Insertion(int N, int M, int i, int j){
        
        if(j-i+1>=countbits(M)){
            M = M<<i;
            return N+M;
        }else{
            throw new Error("No enough space to hold");
        }
    }
    
    public int countbits(int M){
        int count=0;
        while(M!=0){
            count++;
            M>>=1;
        }
        return count;
    }
    
    /*
    Q5.2 BinaryToString
    */
    public String BinaryToString(double num){
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
       
        String[] arr= String.valueOf(num).split(Pattern.quote("."));
        int input = Integer.parseInt(arr[1]);
        int count=0;
        while(input>0){
            if(input%2==0) {
                sb.append(0);
            }else{
                sb.append(1);
            }
            if(count>32){
                return "ERROR";
            }
            count++;
            input/=2;
        }    
        
        return sb.toString();    
    }
    
    //Q5.3 Flip Bit to Win
	public int longestSequence(int num) {
            if (num == -1) {
                    return Integer.BYTES;
            }
            int curLength = 0;
            int preLength = 0;
            int max = 1;
            while (num != 0) {
                    if ((num & 1) == 1) { // current bit is a 1
                            curLength++;
                    } else if ((num & 1) == 0) { // current bit is a 0
                            preLength = (num & 2) == 0 ? 0 : curLength;
                            curLength = 0;
                    }
                    max = Math.max(max, preLength + 1 + curLength);
                    num >>>= 1;
            }
            return max;
	}
      
    //Q5.4 next smallest and next largest number
    //E.g. Input: 0100010
    //     Output: next smallest: 0100001
    //     Output: next largest: 0100100
        public void nextLargestAndSmallest(int input){
            int i = FindNearestbitPosition(input, 0);
            int j = FindNearestbitPosition(input, 1);
            
            //Find nextsmallest
            Integer NextSmallest = Integer.valueOf(input);
            Integer NextLargest = Integer.valueOf(input);
            
            NextSmallest ^= (1 << i) | (1<<j);
            System.out.print("Next Smallest integer: "+ input);
            
            //Find nextLargest(find the next zero after finding 1)
            input >>>=j;
            int k = FindNearestbitPosition(input, 0)+j;
            
            //Find the next Largest
            NextLargest ^= (1 << j) | (1<<k);
            System.out.print("Next Smallest integer: "+ NextLargest);
            
        }
        
        public int FindNearestbitPosition(int input, int zeroOrOne){
            Integer cloneInput = Integer.valueOf(input);
            int count=0;
            while(cloneInput!=0){
                if((cloneInput&1) == zeroOrOne){
                    return count;
                }
                count++;
                cloneInput>>>=1;
            }
            return -1;
        }
        
    //5,5 Debugger
        /*
        If the output is 0, it means the number is a power of 2.
        Example (10000 & 01111) = 00000 (zero) where 10000 = 2^5 = 32
        Example (10001 & 10000) = 10000 (>0) where 10000 is not zero. Therefore it is not a power of 2
        */
    
    //Q5.6 Conversion
    public int Covnversion(int input, int input2){
        int result = input ^ input2;
        //Count number of set bits in result
        int count=0;
        while(result>0){
            if((result & 1)==0){
                count++;
            }
            result>>>=1;
        }
        return count;
    }
    
    //Q5.7 Pairwise swap
    public int SwapBits(int input){
        int even_bits = input & 0xAAAAAAAA;
        int odd_bits = input & 0x55555555;
        
        even_bits >>=1;
        odd_bits <<=1;
        
        return (even_bits | odd_bits);
    }
    
    public int DrawLine(){
        return 1;
    }
}
