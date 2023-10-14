
package module8.two;

import java.util.concurrent.RecursiveTask;

    public class SumTask extends RecursiveTask<Double> {
    
    private final double[] list;
    private final int start;
    private final int end;
    
    public SumTask(double[] list, int start, int end) {
        this.list = list;
        this.start = start;
        this.end = end;
    } // Constructor

    @Override
    protected Double compute() {
        if (end - start <= 40000) {
            double sum = 0;
            for (int i = start; i < end; i++) {
                sum += list[i];
            }
            return sum;
            
        } else {
            
            int middle = (start + end) / 2;
            SumTask TaskOne = new SumTask(list, start, middle);
            SumTask TaskTwo = new SumTask(list, middle, end);

            
            TaskOne.fork();
            
            double rightResult = TaskTwo.compute();
            double leftResult = TaskOne.join();

            return leftResult + rightResult;
            
        }
        
    } // END of compute()
    
} // END of SumTask
