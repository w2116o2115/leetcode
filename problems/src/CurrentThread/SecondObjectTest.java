package CurrentThread;

/**
 * @author Carlose wei
 * @version 1.0
 * @date 2021/1/17 13:22
 */
public class SecondObjectTest {

    private static class SecondObject{
        private static boolean flag = true;
        private int count = 0;

        public synchronized void print1(){
            for (int i = 1; i <= 50; i++) {
                if(!flag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(++count);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = !flag;

                this.notifyAll();
            }
        }

        public synchronized void print2(){
            for (int i = 1; i <= 50; i++) {
                if(flag){
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(++count);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = !flag;

                this.notifyAll();
            }
        }
    }


    public static void main(String[] args) {


        // 2.两个线程轮流打印数字，一直到100
        SecondObject so = new SecondObject();
        new Thread(new Runnable() {

            @Override
            public void run() {
                so.print1();
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                so.print2();
            }
        }).start();
    }

}