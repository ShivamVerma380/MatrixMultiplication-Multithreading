package MultiThreadedApplication;

import java.util.Date;
import java.util.Scanner;

/**
 * Normal way to do matrix multiplication
 * @author Shivam Verma
 */
public class MatrixMultiplication {
    
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the dimensions of  matrix");
        int rows = in.nextInt();
        int columns = in.nextInt();
        
        Date startDate = new Date();

        int[][] matrix1 = MatrixGeneratorUtil.generateRandomMatrix(rows, columns);
        int[][] matrix2 = MatrixGeneratorUtil.generateRandomMatrix(rows, columns);
        int[][] result = new int[rows][columns];
        ParallelThreadsCreator.multiply(matrix1, matrix2,result);

        System.out.print("\n***************************Matrix 1************************************\n");
        MatrixGeneratorUtil.printMatrix(matrix1);

        System.out.print("\n***************************Matrix 2************************************\n");
        MatrixGeneratorUtil.printMatrix(matrix2);

        System.out.print("\n***************************Result************************************\n");
        MatrixGeneratorUtil.printMatrix(result);

        Date endDate = new Date();

        System.out.println("\n\nTime taken in ms: " + (endDate.getTime() - startDate.getTime()));


    }
}
