package 其他;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 水分子的产生 {

    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition h_condition = lock.newCondition();
    private static final Condition o_condition = lock.newCondition();
    private volatile int h = 0;
    private volatile int o = 0;
    private Semaphore hs = new Semaphore(2);
    private Semaphore os = new Semaphore(0);
    public void hydrogen_s(Runnable releaseHydrogen) throws InterruptedException {
        hs.acquire(1);
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        os.release(1);
    }

    public void oxygen_s(Runnable releaseOxygen) throws InterruptedException {
        os.acquire(2);
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        hs.release(2);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        while (h >= 2) {
           h_condition.await();
        }
        lock.lock();
        releaseHydrogen.run();
        h++;
        if (h == 2 && o == 1) {
            h = 0;
            o = 0;
            o_condition.signal();
            h_condition.signal();
            return;
        }
        if (h == 2 && o== 0)
        o_condition.signal();
        lock.unlock();

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        while (o != 0) {
           o_condition.await();
        }
        lock.lock();
        releaseOxygen.run();
        o++;
        if (h == 2 && o == 1) {
            h = 0;
            o = 0;
            o_condition.signal();
            h_condition.signal();
            return;
        }
        h_condition.signal();
        lock.unlock();

    }

    public void hydrogen() throws InterruptedException {

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        lock.lock();
        while (h == 2) {
            h_condition.await();
            lock.wait();
        }

        System.out.print("h");
        h++;
        if (h == 2 && o == 1) {
            h = 0;
            o = 0;
            o_condition.signal();
            h_condition.signal();
            lock.unlock();
            return;
        }
        if (h == 2 && o== 0)
            o_condition.signal();
        lock.unlock();

    }

    public void oxygen() throws InterruptedException {

        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        lock.lock();
        while (o != 0) {
            o_condition.await();
            lock.wait();
        }
        System.out.print("o");
        o++;
        if (h == 2 && o == 1) {
            h = 0;
            o = 0;
            o_condition.signal();
            h_condition.signal();
            lock.unlock();
            return;
        }
        h_condition.signal();
        lock.unlock();

    }
    public static void main(String[] args) throws InterruptedException {
        水分子的产生 test = new 水分子的产生();
       /* test.oxygen();
        test.oxygen();
        test.hydrogen();
        test.hydrogen();
        test.hydrogen();
        test.hydrogen();*/

    }

}
