package CurrentThread;

/**
 * 1.现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
 *
 * 注意：需要先调用start方法后调用join方法；p1线程调用join方法后就会先执行p1线程的方法
 */
public class ForthObject {
    private static class ForthObjectTest extends Thread {

        public ForthObjectTest(String name) {
            super(name);
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(this.getName() + ":" + i);
            }
        }
    }

    public static void main(String[] args) {
        // 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
        ForthObjectTest p1 = new ForthObjectTest("1");
        ForthObjectTest p2 = new ForthObjectTest("2");
        ForthObjectTest p3 = new ForthObjectTest("3");
        try {
            //
            p1.start();
            p1.join();
            p2.start();
            p2.join();
            p3.start();
            p3.join();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}