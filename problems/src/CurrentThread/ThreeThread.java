package CurrentThread;

/**
 * @author Carlose wei
 * @version 1.0
 * @date 2021/1/17 13:38
 */
public class ThreeThread extends Thread{
    public static void main(String[] args) {

        MyObject ob = new MyObject();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0 ; i<10 ; i++)
                    ob.printA();
            }

        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0 ; i<10 ; i++)
                    ob.printB();
            }

        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                for(int i = 0 ; i<10 ; i++)
                    ob.printC();
            }

        }).start();
    }

    private static class MyObject {

        private int flag = 1;

        public synchronized void printA() {
            while (flag != 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("A");
            flag = 2;
            this.notifyAll();


        }

        public synchronized void printC() {
            while (flag != 3) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C");
            flag = 1;
            this.notifyAll();


        }

        public synchronized void printB() {
            while (flag != 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print("B");
            flag = 3;
            this.notifyAll();
        }
    }
}