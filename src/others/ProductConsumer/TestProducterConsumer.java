package others.ProductConsumer;

/**
 * @author yuyang
 * @create 2019-07-05 9:47
 * wait()/notify()
 * 不是很好：生产者一直生产，队列满消费者才开始消费
 */

import java.util.LinkedList;
import java.util.Queue;
public class TestProducterConsumer {
    private int queueSize = 10;
    // private PriorityQueue<Integer>queue=new PriorityQueue<Integer>(queueSize);
    private Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {
        TestProducterConsumer test = new TestProducterConsumer();
        new Thread(test.new Producter()).start();
        new Thread(test.new Producter()).start();
        new Thread(test.new Producter()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Consumer()).start();
        new Thread(test.new Consumer()).start();

    }

    //生产者线程
    class Producter implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (queue) {
                    if (queue.size() < queueSize) {
                        queue.add(queue.size() + 1);
                        System.out.println(Thread.currentThread().getName() + "生产者向队列中加入产品P，队列剩余空间：" + (queueSize - queue.size()));
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        queue.notifyAll();
                    } else {
                        try {
                            System.out.println("队列已满等待消费者消费");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                    }
                }
            }
        }
    }

    //消费者线程
    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (queue) {
                    if (queue.isEmpty()) {
                        System.out.println("没有产品可以消费，进入阻塞状态等待生产者生产。");
                        try {
                            queue.wait();//队列空，消费者阻塞
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            queue.notify();
                        }
                        //System.out.println("消费者获取到队列锁准备消费");
                    } else {
                        queue.notify();//队列不为空，唤醒生产者
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        queue.poll();//消费者消费
                        System.out.println(Thread.currentThread().getName() + "消费者消费了产品P，剩余空间：" + (queueSize - queue.size()));
                    }
                }
            }
        }
    }
}