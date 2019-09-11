package others.ProductConsumer;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * @author yuyang
 */

public class 多线程ABC打印问题 implements Runnable {

    private static  int PRINT_COUNT;
    private final ReentrantLock reentrantLock;
    private final Condition thisCondtion;
    private final Condition nextCondtion;
    private final Condition nextCondtion1;
    private final char printChar;

    public 多线程ABC打印问题(ReentrantLock reentrantLock, Condition thisCondtion, Condition nextCondition, Condition nextCondtion1,
                      char printChar) {
        this.reentrantLock = reentrantLock;
        this.thisCondtion = thisCondtion;
        this.nextCondtion = nextCondition;
        this.nextCondtion1 = nextCondtion1;
        this.printChar = printChar;
    }

    boolean b = true;
    @Override
    public void run() {
        reentrantLock.lock();
        try {
            for (int i = 0; i < PRINT_COUNT;i++) {
                System.out.print(printChar);
                if(b){
                    nextCondtion.signal();
                    b = false;
                }else{
                    nextCondtion1.signal();
                    b = true;
                }
                if (i < PRINT_COUNT - 1) {
                    try {
                        thisCondtion.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PRINT_COUNT = n;
        ReentrantLock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        Thread printerA = new Thread(new 多线程ABC打印问题(lock, conditionA, conditionB,conditionC, 'A'));
        Thread printerB = new Thread(new 多线程ABC打印问题(lock, conditionB, conditionA,conditionA, 'B'));
        Thread printerC = new Thread(new 多线程ABC打印问题(lock, conditionC, conditionA, conditionA, 'C'));
        printerA.start();
        sleep(100);
        printerB.start();
        sleep(100);
        printerC.start();
    }
}