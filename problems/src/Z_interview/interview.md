## 总结

- 细说JVM（虚拟机实现多态）
```
方法调用：
    在介绍Class文件的时候我们知道，Class文件的编译过程并不包含传统编译的连接阶段，Class文件中方法都是以符号引用的形式存储的，
    而不是方法的入口地址（直接引用）。这个特性使得Java具有强大的动态扩展的能力，但同时也增加了Java方法调用过程的复杂性，因为
    方法需要在类加载期间甚至是运行时才能确定真正的入口地址，即将符号引用转换为直接引用。

    invokestatic：调用静态方法；
    invokespecial：调用实例构造器<init>方法、私有方法和父类方法；
    invokevirtual：调用所有的虚方法；
    invokeinterface：调用接口方法，会在运行时再确定一个实现此接口的对象；
    invokedynamic：先在运行时动态解析出调用点限定符所引用的方法，然后再执行该方法，在此之前的4条调用指令，分派逻辑都是固化在Java虚
    拟机中的，而invokedynamic指令的分派逻辑是由用户所设定的引导方法决定的。
    
虚拟机如何实现动态分派
    由于动态分派是非常频繁的操作，而且动态分派的方法版本选择过程需要运行时在类的方法元数据中搜索合适的目标方法，因此虚拟机会进
    行优化。常用的方法就是为类在方法区中建立一个虚方法表（Virtual Method Table，在invokeinterface执行时也会用到接口方法表，
    Interface Method Table），使用虚方法表索引来替代元数据查找以提升性能。
    
    虚方法表中存放着各个方法的实际入口地址。如果某个方法在子类中没有被重写，那子类的虚方法表里面的地址入口和父类相同方法的地址
    入口是一致的，都指向父类的实现入口。如果子类重写了父类的方法，子类方法表中的地址会替换为指向子类实现版本的入口地址。
    
    为了程序实现上的方便，具有相同签名的方法，在父类和子类的虚方法表中都应该具有一样的索引号，这样当类型变换时，仅仅需要变更查
    找的方法表，就可以从不同的虚方法表中按索引转换出所需的入口地址。
    
    方法表一般在类加载的连接阶段进行初始化，准备了类的变量初始值后，虚拟机会把该类的方法表也初始化完毕。
```

- 为什么HashMap是线程不安全
```
1. resize死循环
    我们都知道HashMap初始容量大小为16,一般来说，当有数据要插入时，都会检查容量有没有超过设定的thredhold，如果超过，需要增大
    Hash表的尺寸，但是这样一来，整个Hash表里的元素都需要被重算一遍。这叫rehash，这个成本相当的大。
    
    大概看下transfer：
    
    对索引数组中的元素遍历
    对链表上的每一个节点遍历：用 next 取得要转移那个元素的下一个，将 e 转移到新 Hash 表的头部，使用头插法插入节点。
    循环2，直到链表节点全部转移
    循环1，直到所有索引数组全部转移
    
    经过这几步，我们会发现转移的时候是逆序的。假如转移前链表顺序是1->2->3，那么转移后就会变成3->2->1。这时候就有点头绪了，死锁
    问题不就是因为1->2的同时2->1造成的吗？所以，HashMap 的死锁问题就出在这个transfer()函数上。
```

- Netty内存池设计
```
    https://zhuanlan.zhihu.com/p/259819465
```

- java中==和equals和hashCode的区别
```
    1）==若是基本数据类型比较，是比较值，若是引用类型，则比较的是他们在内存中的存放地址。对象是存放在堆中，栈中存放的对象的引用，
      所以==是对栈中的值进行比较，若返回true代表变量的内存地址相等；
    
    2）equals是Object类中的方法，Object类的equals方法用于判断对象的内存地址引用是不是同一个地址（是不是同一个对象）。若是类
       中覆盖了equals方法，就要根据具体代码来确定，一般覆盖后都是通过对象的内容是否相等来判断对象是否相等。
    
    3）hashCode()计算出对象实例的哈希码，在对象进行散列时作为key存入。之所以有hashCode方法，因为在批量的对象比较中，hashCode
       比较要比equals快。在添加新元素时，先调用这个元素的hashCode方法，一下子能定位到它应该旋转的物理位置，若该位置没有元素，可
       直接存储；若该位置有元素，就调用它的equals方法与新元素进行比较，若相同则不存，不相同，就放到该位置的链表末端。
    
    4）equals与hashCode方法关系：
       hashCode()是一个本地方法，实现是根据本地机器上关的。equals()相等的对象，hashCode()也一定相等；hashCode()不等，equals()
       一定也不等；hashCode()相等，equals()可能相等，也可能不等。所以在重写equals(Object obj)方法，有必要重写hashCode()方法，
       确保通过equals(Object obj)方法判断结果为true的两个对象具备相等的hashCode()返回值。
    
    5）equals与==的关系：
       Integer b1 = 127;在java编译时被编译成Integer，b1 = Integer.valueOf(127);对于-128到127之间的Integer值，用的是原生数
       据类型int，会在内存里供重用，也就是这之间的Integer值进行==比较时，只是进行int原生数据类型的数值进行比较。而超出-128〜127的范围，
       进行==比较时是进行地址及数值比较。
```


- 数据库迁移方案
```
    数据库迁移方案
```

- ribbon负载均衡实现原理
```
    ribbon为客户端提供负载均衡，dubbo服务调用里的负载均衡等等，很多地方都使用到了负载均衡。
    负载均衡有好几种实现策略，常见的有：
        1.随机 (Random)
        2.轮询 (RoundRobin)
        3.一致性哈希 (ConsistentHash)
        4.哈希 (Hash)
        5.加权（Weighted）
    完整过程是：
    LoadBalancerClient（RibbonLoadBalancerClient是实现类）在初始化的时候（execute方法），会通过ILoadBalance
    （BaseLoadBalancer是实现类）向Eureka注册中心获取服务注册列表，并且每10s一次向EurekaClient发送“ping”，来判断服务的可用性，
    如果服务的可用性发生了改变或者服务数量和之前的不一致，则从注册中心更新或者重新拉取。
```

- API限流方案
```
    目前有几种常见的限流方式：
    
        通过限制单位时间段内调用量来限流
        基于redis的限速器来限流（分布式系统）
        使用漏桶（Leaky Bucket）算法来进行限流
        使用令牌桶（Token Bucket）算法来进行限流（Guava实现，RateLimiter）
    第1种方案：
        通过一个计数器统计单位时间段某个服务的访问量，如果超过了我们设定的阈值，则该单位时间段内则不允许继续访问、或者把接下来的请求放入队
        列中等待到下一个单位时间段继续访问。
        这种方案的核心在于阈值的设置，缺点是需要依赖监控系统来分析调用量，可能存在“突刺消耗”，即单位时间段的前几秒内流量达到阈值，导致该时
        间段内剩余的时间内该服务“拒绝服务”,高并发下仍然可能压垮系统
    第2种方案：
        基于RedisAPI中的INCR，实现限速器，它将 API 的最大请求数限制在每个 IP 地址每秒钟多少个之内： 其中要考虑INCR命令和EXPIRE
       （过期时间）命令的原子性，最终解决是使用Lua脚本（Lua脚本是Redis2.6及以上才支持）
    第3种方案：
        漏桶算法是常用算法之一，不管遇到多大的流量，都以固定速率流出，超出部分直接丢弃，缺点显而易见：不能应对突发性流量，直接导致服务到达瓶颈，
    第4种方案：
        令牌桶算法是漏桶算法的改进，随着时间流逝,系统会按恒定1/QPS时间间隔(如果QPS=100,则间隔是10ms)往桶里加入Token,如果桶已经满了就不
        再加了.新请求来临时,会各自拿走一个Token,
```

- rocketmq怎么保证队列完全顺序消费
```
    通过messageQueueSelector实现，重写select方法
    把订单号取了做了一个取模运算再丢到selector中，selector保证同一个模的都会投递到同一条queue。
    相同订单号的--->有相同的模--->有相同的queue。
    
    从 ConsumeMessageOrderlyService 源码中能够看出 RocketMQ 能够实现局部消费顺序，我认为主要有以下两点：
    1）RocketMQ 会为每个消息队列建一个对象锁，这样只要线程池中有该消息队列在处理，则需等待处理完才能进行下一次消费，保证在当前 Consumer 
    内，同一队列的消息进行串行消费。
    2）向 Broker 端请求锁定当前顺序消费的队列，防止在消费过程中被分配给其它消费者处理从而打乱消费顺序。
```

- reentrylock如何实现公平锁和非公平锁
```
    final boolean nonfairTryAcquire(int acquires) {// 非公平锁
                //获取当前线程
                final Thread current = Thread.currentThread();
                //通过AQS获取同步状态
                int c = getState();
                //同步状态为0，说明临界区处于无锁状态，
                if (c == 0) {
                    //修改同步状态，即加锁
                    if (compareAndSetState(0, acquires)) {
                        //将当前线程设置为锁的owner
                        setExclusiveOwnerThread(current);
                        return true;
                    }
                }
                //如果临界区处于锁定状态，且上次获取锁的线程为当前线程
                else if (current == getExclusiveOwnerThread()) {
                     //则递增同步状态
                    int nextc = c + acquires;
                    if (nextc < 0) // overflow
                        throw new Error("Maximum lock count exceeded");
                    setState(nextc);
                    return true;
                }
                return false;
    }
    
    protected final boolean tryAcquire(int acquires) {//公平锁
                final Thread current = Thread.currentThread();
                int c = getState();
                if (c == 0) {
                    //此处为公平锁的核心，即判断同步队列中当前节点是否有前驱节点
                    if (!hasQueuedPredecessors() &&
                        compareAndSetState(0, acquires)) {
                        setExclusiveOwnerThread(current);
                        return true;
                    }
                }
                else if (current == getExclusiveOwnerThread()) {
                    int nextc = c + acquires;
                    if (nextc < 0)
                        throw new Error("Maximum lock count exceeded");
                    setState(nextc);
                    return true;
                }
                return false;
    }
        公平锁与非公平锁的区别仅在于是否判断当前节点是否存在前驱节点!hasQueuedPredecessors() ，由AQS可知，如果当前线程获取锁失
    败就会被加入到AQS同步队列中，那么，如果同步队列中的节点存在前驱节点，也就表明存在线程比当前节点线程更早的获取锁，故只有
    等待前面的线程释放锁后才能获取锁。
```