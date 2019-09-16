package others.ProductConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yuyang
 * @create 2019-09-15 18:11
 */
public class producterConsumer2 {
    private int queueSize = 10;
    private Queue<Integer> queue = new LinkedList<>();
    ReentrantLock lock = new ReentrantLock();
    Condition pCon = lock.newCondition();
    Condition cCon = lock.newCondition();
    class Producter implements Runnable{
        @Override
        public void run() {
            while (true){
                lock.lock();

            }

        }
    }
}
