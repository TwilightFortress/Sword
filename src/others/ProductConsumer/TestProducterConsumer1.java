package others.ProductConsumer;

/**
 * synchronized实现生产者消费者
 *
 * @author yuyang
 * @create 2019-07-05 9:58
 */
public class TestProducterConsumer1 {
    private static Integer count = 0;
    private static final Integer FULL = 10;
    private static String LOCK = "lock";

    public static void main(String[] args) {
        TestProducterConsumer1 TestProducterConsumer1 = new TestProducterConsumer1();
        new Thread(TestProducterConsumer1.new Producer()).start();
        new Thread(TestProducterConsumer1.new Consumer()).start();
        new Thread(TestProducterConsumer1.new Producer()).start();
        new Thread(TestProducterConsumer1.new Consumer()).start();
        new Thread(TestProducterConsumer1.new Producer()).start();
        new Thread(TestProducterConsumer1.new Consumer()).start();
        new Thread(TestProducterConsumer1.new Producer()).start();
        new Thread(TestProducterConsumer1.new Consumer()).start();
    }

    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (LOCK) {
                    while (count == FULL) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    count++;
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                synchronized (LOCK) {
                    while (count == 0) {
                        try {
                            LOCK.wait();
                        } catch (Exception e) {
                        }
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有" + count);
                    LOCK.notifyAll();
                }
            }
        }
    }
}
