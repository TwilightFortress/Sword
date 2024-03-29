package others.ProductConsumer;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程顺序打印ABC
 * @author yuyang
 */

public class 多线程顺序打印ABC implements Runnable {

    // 打印次数
    private static  int PRINT_COUNT = 10;
    // 打印锁
    private final ReentrantLock reentrantLock;
    // 本线程打印所需的condition
    private final Condition thisCondtion;
    // 下一个线程打印所需要的condition
    private final Condition nextCondtion;
    // 打印字符
    private final char printChar;

    public 多线程顺序打印ABC(ReentrantLock reentrantLock, Condition thisCondtion, Condition nextCondition,
                      char printChar) {
        this.reentrantLock = reentrantLock;
        this.thisCondtion = thisCondtion;
        this.nextCondtion = nextCondition;
        this.printChar = printChar;
    }

    @Override
    public void run() {
        // 获取打印锁 进入临界区
        reentrantLock.lock();
        try {
            // 连续打印PRINT_COUNT次
            for (int i = 0; i < PRINT_COUNT; i++) {
                //打印字符
                System.out.print(printChar);
                    nextCondtion.signal();
                if (i < PRINT_COUNT - 1) {
                    try {
                        thisCondtion.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        } finally {
            // 释放打印锁
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 写锁
        ReentrantLock lock = new ReentrantLock();
        // 打印a线程的condition
        Condition conditionA = lock.newCondition();
        // 打印b线程的condition
        Condition conditionB = lock.newCondition();
        // 打印c线程的condition
        Condition conditionC = lock.newCondition();
        // 实例化A线程
        Thread printerA = new Thread(new 多线程顺序打印ABC(lock, conditionA, conditionB, 'A'));
        // 实例化B线程
        Thread printerB = new Thread(new 多线程顺序打印ABC(lock, conditionB, conditionC, 'B'));
        // 实例化C线程
        Thread printerC = new Thread(new 多线程顺序打印ABC(lock, conditionC, conditionA,  'C'));
        // 依次开始A B C线程
        printerA.start();
        Thread.sleep(100);
        printerB.start();
        Thread.sleep(100);
        printerC.start();
    }
}