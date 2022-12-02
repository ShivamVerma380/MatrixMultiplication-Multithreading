import java.util.Date;
import java.util.Scanner;

/**
 *  Class which demonstrates multiplication of two matrices using Single Thread
 * @author  Shivam Verma
 * 
 */
public class MatrixMultiplication{

    /**
     * Main method to multiply two matrices
     * @param args
     */
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the dimensions of  matrix");
        int rows = in.nextInt();
        int columns = in.nextInt();


        
        Date startDate = new Date();

        int[][] matrix1 = MatrixGeneratorUtil.generateRandomMatrix(rows, columns);
        int[][] matrix2 = MatrixGeneratorUtil.generateRandomMatrix(rows, columns);

        int[][] result = multiplyMatrix(matrix1, matrix2);

        System.out.print("\n***************************Matrix 1************************************\n");
        MatrixGeneratorUtil.printMatrix(matrix1);

        System.out.print("\n***************************Matrix 2************************************\n");
        MatrixGeneratorUtil.printMatrix(matrix2);

        System.out.print("\n***************************Result************************************\n");
        MatrixGeneratorUtil.printMatrix(result);

        Date endDate = new Date();

        System.out.println("\n\nTime taken in ms: " + (endDate.getTime() - startDate.getTime()));
        
    }

    private static int[][] multiplyMatrix(int[][] matrix1, int[][] matrix2) {
        int resultRows = matrix1.length;
        int resultColumns = matrix2[0].length;
        int[][] result = new int[resultRows][resultColumns];

        int columns2 = matrix2[0].length;
        
        for(int i=0;i<resultRows;i++){
            for(int j=0;j<columns2;j++){
                result[i][j] = 0;
                for(int k=0;k<resultColumns;k++){
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

}