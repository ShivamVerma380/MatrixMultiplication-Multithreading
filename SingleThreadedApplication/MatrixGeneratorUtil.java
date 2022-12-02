import java.util.Random;

/**
 * Utility class to generate the matrix.
 * 
 * @author Shivam Verma
 *
 */

public class MatrixGeneratorUtil{

    /**
     * Utility method to generate the matrix
     * @param  int row, int column
    */
    public static int[][] generateRandomMatrix(int rows,int columns){
        int[][] matrix = new int[rows][columns];
        
        Random random = new Random();  //Generate random integer

        for(int i=0;i<rows;i++){
            for(int j=0;j<rows;j++){
                matrix[i][j] = random.nextInt(100); //Generate random integer between 0 and 100
            }
        }

        return matrix;
    
    }

    /**
     * Utility method to print the matrix
     * @param  int[][] matrix
    */ 
    public static void printMatrix(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
 