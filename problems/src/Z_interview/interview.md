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

- Netty FastThreadLocal怎么Fast？
```
    JDK的ThreadLocal是根据它的哈希值然后再取模计算出索引位置,如果冲突还要再根据开放地址法-线性探测继续寻找下一个可用索引的
    位置.性能是比较低的
    在 FastThreadLocal 内部，使用了索引常量代替了 Hash Code 和哈希表
    public FastThreadLocal() {
        index = InternalThreadLocalMap.nextVariableIndex();
    }
    FastThreadLocal 内部维护了一个索引常量 index，该常量在每次创建 FastThreadLocal 中都会自动+1，从而保证了下标的不重复性。
    
    要利用 FastThreadLocal 带来的性能优势，就必须结合使用 FastThreadLocalThread 线程类或其子类，因为 FastThreadLocalThread 
    线程类会存储必要的状态，如果使用了非 FastThreadLocalThread 线程类则会回到常规 ThreadLocal。
    
    在使用完 FastThreadLocal 之后不用 remove 了，因为在 FastThreadLocalRunnable 中已经加了移除逻辑，在线程运行完时会移除全
    部绑定在当前线程上的所有变量。
    
    1.创建FastThreadLocal时它的索引值index就确定下来了，并不需要再去计算hash值，减少了计算时间以及哈市碰撞的概率
    2.FastThreadLocalThread netty自己实现的线程类，在线程结束以后会自己清楚map中的所有数据，不需要手动删除。

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

- 高性能队列
```
    队列的底层一般分成三种：数组、链表和堆。其中，堆一般情况下是为了实现带有优先级特性的队列，暂且不考虑。
    我们就从数组和链表两种数据结构来看，基于数组线程安全的队列，比较典型的是ArrayBlockingQueue，它主要通过加锁的方式来保证线
    程安全；基于链表的线程安全队列分成LinkedBlockingQueue和ConcurrentLinkedQueue两大类，前者也通过锁的方式来实现线程安全，
    而后者以及上面表格中的LinkedTransferQueue都是通过原子变量compare and swap（以下简称“CAS”）这种不加锁的方式来实现的。
    
    单线程情况下，不加锁的性能 > CAS操作的性能 > 加锁的性能。
    在多线程情况下，为了保证线程安全，必须使用CAS或锁，这种情况下，CAS的性能超过锁的性能，前者大约是后者的8倍。
    ArrayBlockingQueue  通过 ReentrantLock lock 加锁
    
    Disruptor的设计方案
    环形数组结构
    为了避免垃圾回收，采用数组而非链表。同时，数组对处理器的缓存机制更加友好。
    元素位置定位
    数组长度2^n，通过位运算，加快定位的速度。下标采取递增的形式。不用担心index溢出的问题。index是long类型，即使100万QPS的处理
    速度，也需要30万年才能用完。
    无锁设计
    每个生产者或者消费者线程，会先申请可以操作的元素在数组中的位置，申请到之后，直接在该位置写入或者读取数据。
    
    一个生产者
    生产者单线程写数据的流程比较简单：
    
    申请写入m个元素；
    若是有m个元素可以入，则返回最大的序列号。这儿主要判断是否会覆盖未读的元素；
    若是返回的正确，则生产者开始写入元素
    
    多生产者
    多个生产者的情况下，会遇到“如何防止多个线程重复写同一个元素”的问题。Disruptor的解决方法是，每个线程获取不同的一段数组空
    间进行操作。这个通过CAS很容易达到。只需要在分配元素的时候，通过CAS判断一下这段空间是否已经分配出去即可。
```

- Reactor模式的理解
```
    Reactor模式的 五种角色
    
   1.Handle(句柄或者描述符) ： 本质上是一种资源，是由系统提供的，该资源用户表示一个个的事件，比如文件描述符，或者是针对网络通信的描述符socket，事件
    既可以来自内部也可以来自外部，外部事件比如说客户的链接请求，客户发送过来的数据，内部事件：比如操作系统产生的定时器的事件，它本质上就是一个文件
    描述符，本身就是一个产生事件产生的发源地。
    
   2.（Synchronous event separator）同步事件分离器： 它本身是一个系统调用，用于等待同步事件的发生（事件可是能一个也可能是多个），调用方再调用它的时候
    会被阻塞，一直阻塞到同步时间分离器上有事件产生为止，对于Linux来说，同步时间分离器就是常用的I/O多路复用的机制。比如select,poll,epoll等，在java NIO
    中就是Selecter 的 select方法。
    
   3.Event Handler(事件处理器)：本身由多个回调方法构成，这些回调方法构成了与应用相关的对于某个事件的反馈机制。Netty相比于java NIO来说，在事件处理器这个
    角色上就进行另一个升级，他为我们开发这提供了大量的回调接口，供我们再绑定事件产生的时候进行业务代码的绑定。
    
   4.Concrete Event Handler(具体事件处理器) : 他是事件处理器的实现，它本身实现了事件处理器所提供的的各个回调方法，从而实现了业务逻辑。
    
   5.初始分发起(Initiation Dispatcher)：实际上就是Reactor角色，它本身定义了一些规范，这些规范用语控制事件的调度方式，同时又提供了应用进行事件处理的注册
    删除等设施，用户调度事件，通过同步事件分离器等待事件发生，一旦事件发生，首先分离事件调用事件处理器，最后去出发回到方法，来处理事件
```

- 如何理解两阶段提交
```
    提交请求（投票）阶段
        协调者向所有参与者发送prepare请求与事务内容，询问是否可以准备事务提交，并等待参与者的响应。
        参与者执行事务中包含的操作，并记录undo日志（用于回滚）和redo日志（用于重放），但不真正提交。
        参与者向协调者返回事务操作的执行结果，执行成功返回yes，否则返回no。
    
    提交（执行）阶段
    分为成功与失败两种情况。
    
    若所有参与者都返回yes，说明事务可以提交：
        协调者向所有参与者发送commit请求。
        参与者收到commit请求后，将事务真正地提交上去，并释放占用的事务资源，并向协调者返回ack。
        协调者收到所有参与者的ack消息，事务成功完成。
    
    若有参与者返回no或者超时未返回，说明事务中断，需要回滚：
        协调者向所有参与者发送rollback请求。
        参与者收到rollback请求后，根据undo日志回滚到事务执行前的状态，释放占用的事务资源，并向协调者返回ack。
        协调者收到所有参与者的ack消息，事务回滚完成。
```

- 如何设计动态扩容缩容的分库分表方案？
```
方案一：停机迁移
    这个方案是一般公司都比较常用的，在网站上放一个公告，说“几点到几点要进行系统升级，到时候系统将不可用”，类似这样的公告。
    然后大家就一起加班，从凌晨开始做数据迁移，搞了多个数据迁移的工具，从单库把数据获取到，在调用分库分表中间件，中间件把数
    据放到新的数据库中，整个过程可能要跑个几小时，迁移完之后大家开始验证数据。验证成功之后修改应用系统的配置，把原来调用单
    库的配置修改为使用中间件。然后在验证下功能，没问题的话就可以对外提供服务了。
    缺点：
    1、一定会出现几小时的停机（凌晨也还好，很多用户都睡觉了）
    2、如果在凌晨4点还没有搞定，大家开始慌了，到凌晨6点还没搞定，那么新库的数据回滚，单库继续提供服务，第二天在继续搞。
方案二：不停机迁移（双写方案）
    1、系统中修改写数据库的代码，同时写单库和新库；
    2、数据迁移工具获取到老库的数据，在新库中进行比较，如果新库中不存在，那么把数据保存到新库中；如果新库中存在数据，那么比
       较更新时间，如果老库的更新时间大于新库，那么修改新库的数据；如果老库的更新时间小于新库的，那么保持不变。
    3、迁移完之后需要比较数据是否完全一样，在凌晨的时候，数据肯定会变为一致，因为很少数据进来。
    4、最后凌晨，系统把写老库的代码删掉，都写新库。
       整个迁移的过程就结束了，这个过程只有在删除写老库代码的时候，会停下服务（你使用了集群，其实对用户来说是无感知的）。
```

- 同一个jar的不同版本的加载
```
    jar的加载都是在运行时进行的，先加载那个取决于那个jar先被用到
    遇见第二个的话，加载的话首先是交给系统类加载去加载，如果系统类加载器里有了不会再加载第二个了。
```

- 说一说PRC
```
RPC的作用
    屏蔽远程调用跟本地调用的区别，让我们感觉就是调用项目内的方法。
    隐藏底层网络通信的复杂性，让我们更专注于业务逻辑。
动态代理
    RPC 会给接口生成一个代理类，所以我们调用这个接口实际调用的是动态生成的代理类，由代理类来触发远程调用，
    这样我们调用远程接口就无感知了。
    动态代理的方式： Javasisst  需要考虑代理类的生成效率和调用效率
序列化
    就是吧我们的请求参数进行序列化，通过网络进行传输，序列化需要总和考虑通用性、性能、可读性和兼容性
RPC协议
    需要定义一个协议，来约定一些规范，制定一些边界使得二进制数据可以被还原。
    一般 RPC 协议都是采用协议头+协议体的方式。
    协议头放一些元数据，包括：魔法位、协议的版本、消息的类型、序列化方式、整体长度、头长度、扩展位等。
    dubbo协议 ： magic（定义协议类别），包括一些flag标志位，序列化类别，请求号，消息总长度。
网络传输
    组装好数据就等着发送了，这时候就涉及网络传输了。
    Java 语言的都会用 Netty ，人家已经封装的很好了，也做了很多优化，拿来即用，便捷高效。
真正工业级别的 RPC
    以上提到的只是 RPC 的基础流程，这对于工业级别的使用是远远不够的。
    1、生产环境中的服务提供者都是集群部署的，所以有多个提供者，而且还会随着大促等流量情况动态增减机器。
       因此需要注册中心，作为服务的发现。
    2、还需要有路由分组策略，调用者根据下发的路由信息选择对应的服务提供者，能实现分组调用、灰度发布、流量隔离等功能。
    3、还需要有负载均衡策略，一般经过路由过滤之后还是有多个服务提供者可以选择，通过负载均衡策略来达到流量均衡。
    4、当然还需要有异常重试，毕竟网络是不稳定的，而且有时候某个服务提供者也可能出点问题，所以一次调用出错进行重
       试，较少业务的损耗。
    5、还需要限流熔断，限流是因为服务提供者不知道会接入多少调用者，也不清楚每个调用者的调用量，所以需要衡量一下自身
       服务的承受值来进行限流，防止服务崩溃。
       
```

- 数据库不使用索引的情况
```
    1、like查询已 '%...'开头，以'xxx%'结尾会继续使用索引。
    2  where语句中使用 <>和 !=
    3  where语句中使用 or，但是没有把or中所有字段加上索引。
    4  where语句中对字段表达式操作 where storeid * 2
    5  where语句中使用Not In
    6 对于多列索引，需要使用第一个索引才会命中索引
```