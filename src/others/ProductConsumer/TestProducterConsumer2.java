package others.ProductConsumer;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrankLock实现生产者消费者
 * @author yuyang
 * @create 2019-07-05 10:47
 */
public class TestProducterConsumer2 {
    public static final int MAX_CAP = 20;
    static LinkedList<Object> list = new LinkedList<Object>();
    static ReentrantLock lock = new ReentrantLock();
    static Condition notFull = lock.newCondition();
    static Condition notEmpty = lock.newCondition();

    static class Producer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    lock.lock();
                    while (list.size() == MAX_CAP) {
                        try {
                            System.out.println("当前已有" + list.size() + "个产品，缓冲区已满，请等待消费者消费");
                            notFull.await(); //队列满，生产者线程进入阻塞状态
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add(new Object());
                    System.out.println("生产了一个产品，当前产品个数为 " + list.size());
                    notEmpty.signalAll(); //生产者生产了产品，唤醒所有的消费者
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                Thread.yield();
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                    lock.lock();
                    while (list.size() == 0) {
                        try {
                            System.out.println("当前已有" + list.size() + "个产品，缓冲区已空，请等待生产者生产");
                            notEmpty.await();//队列空了，阻塞消费者
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    list.remove();
                    try {
                        Thread.sleep(700);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("消费了一个产品，当前产品个数为 " + list.size());
                    notFull.signalAll();//消费者从队列中取出了产品，唤醒所有生产者
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            new Thread(new Producer()).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(new Consumer()).start();
        }
    }
}