package design;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 4）实现生产者、消费者场景。假设现在有一个任务调度系统负责处理数据，A线程负责从DB里拉待处理的任务放到队列，
 *   B线程组负责从队列中处理任务；由于任务处理量较大，B线程组会将任务进行并行处理。当所有子线程处理完成后，由B线程汇总结果并统一入库
 * 要求：
 * A线程组负责生产数据data，B线程组负责消费data数据，A、B线程组要实现阻塞；尽量考虑异常场景的处理；
 * B线程组的一个处理线程在获取到一个数后，需要再拆分5个子线程并行处理是数据，当5个子线程全部处理完成，B的处理线程将结果合并；请尽量考虑异常场景的处理；
 * 考核点：多线程、锁、异常设计；
 * 考核标准：可运行并且满足所有题干要求。
 *
 */
public class ProducerCustomerMain {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> dataQueue = new ArrayBlockingQueue<>(20);
        ExecutorService threadPool = Executors.newCachedThreadPool();

        System.out.println("生产线程启动");

        for (int i=0;i<7;i++){
            threadPool.submit(new Product(dataQueue));
        }

        System.out.println("消费线程启动");

        for (int i=0;i<3;i++){
            threadPool.submit(new Customer(dataQueue));
        }
    }

    static class Product implements Callable<Integer>{
        ArrayBlockingQueue<Integer> dataQueue;

        Product(ArrayBlockingQueue<Integer> dataQueue) {
            this.dataQueue = dataQueue;
        }


        @Override
        public Integer call() throws Exception {
            int data = (int)(Math.random()*10);
            dataQueue.put(data);
            System.out.println("生产线程-"+Thread.currentThread().getName()+"生产数据"+data);
            return data;
        }
    }


    static class Customer implements Callable<Integer>{

        private ArrayBlockingQueue<Integer> dataQueue;

        public Customer(ArrayBlockingQueue<Integer> dataQueue) {
            this.dataQueue = dataQueue;
        }

        @Override
        public Integer call() throws Exception {
            int data = dataQueue.take();
            System.out.println("消费线程-"+Thread.currentThread().getName()+"获得待处理数据"+data);
            int result = 0;
            try {
                result = dispiseData(data);
                System.out.println("消费线程-"+Thread.currentThread().getName()+"处理数据"+data +"的结果为:"+result);  //正常处理结果
            }catch (Exception e){
                System.out.println("消费线程-"+Thread.currentThread().getName()+"处理数据"+data +"出错,原因为:"+e); //异常处理
            }
            return result;
        }
    }

    static Integer dispiseData(Integer data) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(5);
        List<Callable<Integer>> cdCallList = new ArrayList<>();
        for (int i=0;i<5;i++){
            cdCallList.add(new CustomerDispose(data));
        }

        List<Future<Integer>> resultFutures = es.invokeAll(cdCallList);

        int rsult = 0;
        for (Future<Integer> t:resultFutures){
            rsult+=t.get();
        }
        es.shutdown();
        return rsult;

    }

    static class CustomerDispose implements Callable<Integer>{
        private int data;

        public CustomerDispose(int data) {
            this.data = data;
        }


        @Override
        public Integer call() throws Exception {
            return doDisposeDate(data);
        }

        private Integer doDisposeDate(int data) {
            return data+1;
        }
    }
}