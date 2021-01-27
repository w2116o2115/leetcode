package CurrentThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Carlose wei
 * @version 1.0
 * @date 2021/1/17 13:38
 */
public class ThreeThread extends Thread{
    public static void main(String[] args) {
        MyObject object = new MyObject();
        new Thread(() ->{
            for (int i=0;i<10;i++){
                object.printA();
            }
        }).start();
        new Thread(() ->{
            for (int i=0;i<10;i++){
                object.printB();
            }
        }).start();
        new Thread(() ->{
            for (int i=0;i<10;i++){
                object.printC();
            }
        }).start();
    }

    private static class MyObject {
        Lock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();
        Condition c3 = lock.newCondition();
        private int flag = 1;

        private void printA(){
            lock.lock();
            try {
                while (flag != 1) {
                    c1.await();
                }
                flag = 2;
                System.out.print("A");
                c2.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        private void printB(){
            lock.lock();
            try {
                while (flag != 2) {
                    c2.await();
                }
                flag = 3;
                System.out.print("B");
                c3.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }

        private void printC(){
            lock.lock();
            try {
                while (flag != 3) {
                    c3.await();
                }
                flag = 1;
                System.out.println("C");
                c1.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}