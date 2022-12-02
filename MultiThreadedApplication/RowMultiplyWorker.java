package MultiThreadedApplication;

/**
 * To optimize the performance of this program, we have to use the advantage of multi-cores. We will create a thread for each row in a matrix that does the multiplication in parellel and reduce the processing time.
 * @author Shivam Verma
 */
public class RowMultiplyWorker implements Runnable{

    private final int[][] result;
    private int[][] matrix1;
    private int[][] matrix2;
    private final int row;


    /**
     * Parameterized Constructor to initialize the variables
     * @param result
     * @param matrix1
     * @param matrix2
     * @param row
     */
    public RowMultiplyWorker(int[][] result, int[][] matrix1, int[][] matrix2, int row) {
        this.result = result;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.row = row;
    }

    /**
     * By default method of Runnable interface is implemented
     *  This method will be called when the thread is started
    */
    @Override
    public void run() {
        for(int i=0;i<matrix2[0].length;i++){
            result[row][i] = 0;

            for(int j=0;j<matrix1[row].length;j++){
                result[row][i] += matrix1[row][j] * matrix2[j][i];
            }
        }

        
    }
    
}
