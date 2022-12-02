package MultiThreadedApplication;

import java.util.ArrayList;
import java.util.List;

/**
 * To optimize the performance of this program, we have to use the advantage of multi-cores. We will create a thread for each row in a matrix that does the multiplication in parellel and reduce the processing time.
 * We will not create more than 10 threads as application can hang up.
 * @author Shivam Verma
 */
public class ParallelThreadsCreator {

    public static void multiply(int[][] matrix1,int[][] matrix2,int[][] result){
        List threads = new ArrayList<>();
        int rows1 = matrix1.length;

        for(int i=0;i<rows1;i++){
            RowMultiplyWorker worker = new RowMultiplyWorker(result, matrix1, matrix2, i);
            Thread thread = new Thread(worker);
            thread.start();
            threads.add(thread);
            if(threads.size()%10==0){
                waitForThreads(threads);
            }

        }
    }

    private static void waitForThreads(List threads) {
        for(int i=0;i<threads.size();i++){
            try {
                ((Thread) threads.get(i)).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }

    
}
