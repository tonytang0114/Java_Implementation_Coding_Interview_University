/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crackingthecodinginterview;

/**
 *
 * @author CITDBS
 */
public class CrackingTheCodingInterview {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CH1 ch1 = new CH1();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        matrix = ch1.Zero_Matrix(matrix);
        
       
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+',');
            }
            System.out.println();
        }
        // TODO code application logic here
    }
    
}
