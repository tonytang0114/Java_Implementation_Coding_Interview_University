/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingthecodinginterview;

import CH1.CH1;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CITDBS
 */
public class CH1Test {
    
    public CH1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of isUnique method, of class CH1.
     */
    @org.junit.Test
    public void testIsUnique() {
        System.out.println("isUnique");
        String s = "abcde";
        CH1 instance = new CH1();
        boolean expResult = true;
        boolean result = instance.isUnique(s);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testIsUnique_1() {
        System.out.println("isUnique");
        String s = "aabbcc";
        CH1 instance = new CH1();
        boolean expResult = false;
        boolean result = instance.isUnique(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of isUnique_2 method, of class CH1.
     */
    @org.junit.Test
    public void testIsUnique_2() {
        System.out.println("isUnique_2");
        String s = "abcde";
        CH1 instance = new CH1();
        boolean expResult = false;
        boolean result = instance.isUnique_2(s);
        assertEquals(expResult, result);
    }
    
    @org.junit.Test
    public void testIsUnique_2_1() {
        System.out.println("isUnique_2");
        String s = "aabbcc";
        CH1 instance = new CH1();
        boolean expResult = false;
        boolean result = instance.isUnique_2(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of CheckPermutation method, of class CH1.
     */
    
    @org.junit.Test
    public void testCheckPermutation() {
        System.out.println("CheckPermutation");
        String s1 = "abc";
        String s2 = "cba";
        CH1 instance = new CH1();
        boolean expResult = false;
        boolean result = instance.CheckPermutation(s1, s2);
        assertEquals(expResult, result);
    }

    /**
     * Test of CheckPermutation_1 method, of class CH1.
     */
    @org.junit.Test
    public void testCheckPermutation_1() {
        System.out.println("CheckPermutation_1");
        String s1 = "abcde";
        String s2 = "bcdea";
        CH1 instance = new CH1();
        boolean expResult = true;
        boolean result = instance.CheckPermutation_1(s1, s2);
        assertEquals(expResult, result);
    }

    /**
     * Test of URLify method, of class CH1.
     */
    @org.junit.Test
    public void testURLify() {
        System.out.println("URLify");
        String s = "Mr John Smith    ";
        int n = 13;
        CH1 instance = new CH1();
        instance.URLify(s, n);
    }

    /**
     * Test of PalindromePermutation method, of class CH1.
     */
    @org.junit.Test
    public void testPalindromePermutation() {
        System.out.println("PalindromePermutation");
        String s1 = "aabbc";
        CH1 instance = new CH1();
        boolean expResult = true;
        boolean result = instance.PalindromePermutation(s1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
        public void testPalindromePermutation_1() {
        System.out.println("PalindromePermutation");
        String s1 = "abccee";
        CH1 instance = new CH1();
        boolean expResult = false;
        boolean result = instance.PalindromePermutation(s1);
        assertEquals(expResult, result);
    }

    /**
     * Test of OneAway method, of class CH1.
     */
        /*
    @org.junit.Test
    public void testOneAway() {
        System.out.println("OneAway");
        String s1 = "";
        String s2 = "";
        int m = 0;
        int n = 0;
        CH1 instance = new CH1();
        boolean expResult = false;
        boolean result = instance.OneAway(s1, s2, m, n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
     */

    /**
     * Test of StringCompression method, of class CH1.
     */
    @org.junit.Test
    public void testStringCompression() {
        System.out.println("StringCompression");
        String s1 = "aaaaaabbcc";
        CH1 instance = new CH1();
        String expResult = "a6b2c2";
        String result = instance.StringCompression(s1);
        assertEquals(expResult, result);
    }

    /**
     * Test of StringCompression_1 method, of class CH1.
     */
    @org.junit.Test
    public void testStringCompression_1() {
        System.out.println("StringCompression_1");
        String s1 = "aaaaaabbcc";
        CH1 instance = new CH1();
        String expResult = "a6b2c2";
        String result = instance.StringCompression_1(s1);
        assertEquals(expResult, result);
    }

    /**
     * Test of rotate_matrix method, of class CH1.
     */
    @org.junit.Test
    public void testRotate_matrix() {
        System.out.println("rotate_matrix");
        int[][] matrix = {{1,2,3,},{4,5,6},{7,8,9}};
        CH1 instance = new CH1();
        int[][] expResult = {{7,4,1,},{8,5,2},{9,6,3}};
        int[][] result = instance.rotate_matrix(matrix);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of Zero_Matrix method, of class CH1.
     */
    @org.junit.Test
    public void testZero_Matrix() {
        System.out.println("Zero_Matrix");
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        CH1 instance = new CH1();
        int[][] expResult = {{1,0,1,},{0,0,0},{1,0,1}};
        int[][] result = instance.Zero_Matrix(matrix);
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of StringRotation method, of class CH1.
     */
    @org.junit.Test
    public void testStringRotation() {
        System.out.println("StringRotation");
        String s1 = "erbottlewat";
        String s2 = "waterbottle";
        CH1 instance = new CH1();
        boolean expResult = true;
        boolean result = instance.StringRotation(s1, s2);
        assertEquals(expResult, result);

    }

    /**
     * Test of isSubString method, of class CH1.
     */
    @org.junit.Test
    public void testIsSubString() {
        System.out.println("isSubString");
        String s1 = "erbottlewaterbottle";
        String s2 = "waterbottle";
        CH1 instance = new CH1();
        boolean expResult = true;
        boolean result = instance.isSubString(s1, s2);
        assertEquals(expResult, result);

    }
    
}
