package additionalQuestions;

public class MultiThreadPrint implements Runnable {
    private final MultithreadPrintHolder holder;
    private int threadNumber;
    static int currentNumber=0;

    public MultiThreadPrint(MultithreadPrintHolder holder, int threadNumber) {
        this.holder = holder;
        this.threadNumber = threadNumber;
    }


    @Override
    synchronized public void run() {
        while (currentNumber < MultithreadPrintHolder.maxPrint)
        {
                if(currentNumber % 3 == threadNumber && currentNumber < MultithreadPrintHolder.maxPrint)
                {
                    System.out.println(Thread.currentThread().getName() + " "+ ++currentNumber);
                }

        }
    }
}
