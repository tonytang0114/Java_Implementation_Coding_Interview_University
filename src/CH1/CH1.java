/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CH1;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;



/**
 *
 * @author CITDBS
 */
public class CH1 {
    //Q1
    public boolean isUnique(String s){
        HashSet<Character> hs = new HashSet<Character>();
        for(int i=0;i<s.length();i++){
            if(hs.contains(s.charAt(i)))
            {
                return false;
            }else{
                hs.add(s.charAt(i));
            }
        }
        return true;
    }
    
    //Q1 without DTO
    public boolean isUnique_2(String s){
        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<s.length();j++)
            {
                if(s.charAt(i) == s.charAt(j))
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    //Q2 Check Permutation
    //Given two strings, write a method to decide if one is a permutation of the other
    public boolean CheckPermutation(String s1, String s2)
    {
        //Brute force
        if(s1.length()!=s2.length()) return false;
        Arrays.sort(s1.toCharArray());
        Arrays.sort(s2.toCharArray());
        
        if(s1.length()>=s2.length()){
           for(int i=0;i<s2.length();i++){
               if(s2.charAt(i)!=s1.charAt(i)){
                   return false;
               }
            }
        }else{
            for(int i=0;i<s1.length();i++){
               if(s1.charAt(i)!=s2.charAt(i)){
                   return false;
               }
            }
        }
        return true;
    }
    
    public boolean CheckPermutation_1(String s1, String s2)
    {
        //By HashMap<Character, Integer>
        if(s1.length()!=s2.length()) return false;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i=0;i<s2.length();i++)
        {
            if(!hm.containsKey(s2.charAt(i))){
                hm.put(s2.charAt(i), 1);
            }else{
                hm.put(s2.charAt(i), hm.get(s2.charAt(i))+1);
            }
        }

        for(int i=0;i<s1.length();i++)
        {
            if(!hm.containsKey(s1.charAt(i))){
                return false;
            }else{
                hm.put(s2.charAt(i), hm.get(s2.charAt(i))-1);
                if(hm.get(s2.charAt(i))==-1)
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    //Q3 URLify
    public void URLify(String s, int n)
    {
        char[] charArr = s.toCharArray();
        int last = n-1;
        for(int i=charArr.length-1;i>=0;i--)
        {
            if(charArr[last]!=' '){
                charArr[i] = charArr[last];
            }else{
                charArr[i] = '0';
                charArr[--i] = '2';
                charArr[--i] = '%';
            }
        }
        System.out.print(s);
    }
    
    //Q4 Palindrome Permutation
    public boolean PalindromePermutation(String s1)
    {
        //HashMap --> easy
        //Time complexity(O(n))
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        for(int i=0;i<s1.length();i++)
        {
            if(!hm.containsKey(s1.charAt(i))){
                hm.put(s1.charAt(i), 1);
            }else{
                hm.put(s1.charAt(i), hm.get(s1.charAt(i))+1);
            }
        }
        
        boolean hasOdd = false;
        for(int i=0;i<s1.length();i++){
            if(hm.get(s1.charAt(i))%2==1){
                if(hasOdd){
                    return false;
                }
                hasOdd=true;
            }
        }
        return true;       
    }
    
    //Q5 One-Away
    public boolean OneAway(String s1, String s2, int m, int n)
    {
        //HashMap
        //two-pointer
        return true;
    }
    
    //Q6
    public String StringCompression(String s1)
    {
        //Time Complexity (O(n^2))
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s1.length();i++)
        {
            sb.append(s1.charAt(i));
            int count=0;
            for(int j=i;j<s1.length();j++)
            {
                if(s1.charAt(i)==s1.charAt(j))
                {
                    count++;
                    i=j;
                }else{
                    break;
                }
            }
            sb.append(count);         
        }
        if(sb.toString().length() >= s1.length())
        {
            return s1;
        }else{
            return sb.toString();
        }
    }
    
    //Q6
    public String StringCompression_1(String s1)
    {
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        
        for(char i='a';i<='z';i++){
            hm.put(i,0);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s1.length();i++)
        {
            if(hm.containsKey(s1.charAt(i))){
                hm.put(s1.charAt(i), hm.get(s1.charAt(i))+1);

                if(i<s1.length()-1 && s1.charAt(i)!=s1.charAt(i+1)){
                    sb.append(s1.charAt(i));
                    sb.append(hm.get(s1.charAt(i)));
                    hm.put(s1.charAt(i), 0);
                }
            }
        }
        sb.append(s1.charAt(s1.length()-1));
        sb.append(hm.get(s1.charAt(s1.length()-1)));
        
        if(sb.toString().length() >= s1.length())
        {
            return s1;
        }else{
            return sb.toString();
        }
    }
    
    //Q7
    public int[][] rotate_matrix(int[][] matrix){
        //edge case
        if(matrix.length ==0 || matrix[0].length !=matrix.length){return matrix;}
        int n = matrix.length;
        
        for(int layer=0;layer<n/2;layer++){
            int first = layer;
            int last = n-layer-1;
            for(int i=first;i<last;i++){
                int offset = i-first;
                
                int top = matrix[first][i];
                //left->top
                matrix[first][i] = matrix[last-offset][first];
                
                //bottom->left
                matrix[last-offset][first] = matrix[last][last-offset];
                
                //right->bottom
                matrix[last][last-offset] = matrix[i][last];
                
                //top->right
                matrix[i][last] = top;
            }
        }
        return matrix;
    }
    
    //Q9-Zero Matrix
    public int[][] Zero_Matrix(int[][] matrix){
        Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
        //Check which element is zero;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    hm.put(i,j);
                }
            }
        }
        
        for(Integer key: hm.keySet()){
            for(int i=0;i<matrix.length;i++){
                matrix[key][i] =0;
            }
        }
        
        for(Integer value: hm.values()){
            for(int j=0;j<matrix[0].length;j++){
                matrix[j][value]=0;
            }
        }
        
        return matrix;
    }

  
    //Extra
    public void perm1(String prefix, String s) {
        int n = s.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
               perm1(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, n));
        }
    }
    
    
    public boolean StringRotation(String s1, String s2)
    {
        if(s1.length() == s2.length() && s1.length()>0){
            String s1s1 = s1+s1;
            return isSubString(s1s1,s2);
        }
        return false;
    }
    
    public boolean isSubString(String s1, String s2)
    {
        return s1.contains(s2);
    }
    
}
