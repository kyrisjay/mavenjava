##### Java中List<?>和List之间的区别是什么？java中List和原始类型List之间的区别？
  引用变量类型     名称            可以接受的类型                 能否添加元素       安全性   便利性    表述性
    List         原始类型        任何对应List<E>的参数           可以添加任意类       无      无        无
                                化类型， 包括List<?>            型的元素

    List<?>      通配符类型       以接受任何对应List<E>的         不能添加任何元素     有      无        有
                                 参数化类型，包括List

##### Java中synchronized 和 ReentrantLock 有什么不同？
* 两者的共同点:  
** 都是用来协调多线程对共享对象、变量的访问  
** 都是可重入锁，同一线程可以多次获得同一个锁  
** 都保证了可见性和互斥性  

* 两者的不同点:
4. ReentrantLock 显示的获得、释放锁，synchronized 隐式获得释放锁
5. ReentrantLock 可响应中断、可轮回，synchronized 是不可以响应中断的，为处理锁的不可用性提供了更高的灵活性
6. ReentrantLock 是 API 级别的，synchronized 是 JVM 级别的
7. ReentrantLock 可以实现公平锁
8. ReentrantLock 通过 Condition 可以绑定多个条件
9. 底层实现不一样， synchronized 是同步阻塞，使用的是悲观并发策略，lock 是同步非阻塞，采用的是乐观并发策略
10. Lock 是一个接口，而 synchronized 是 Java 中的关键字，synchronized 是内置的语言实现。
11. synchronized 在发生异常时，会自动释放线程占有的锁，因此不会导致死锁现象发生；而 Lock 在发生异常时，如果没有主动通过 unLock()去释放锁，则很可能造成死锁现象，因此使用 Lock 时需要在 finally 块中释放锁。
12. Lock 可以让等待锁的线程响应中断，而 synchronized 却不行，使用 synchronized 时，等待的线程会一直等待下去，不能够响应中断。
13. 通过 Lock 可以知道有没有成功获取锁，而 synchronized 却无法办到。
14. Lock 可以提高多个线程进行读操作的效率，既就是实现读写锁等

#### 并发编程三要素
原子性:一个不可再被分割的颗粒。原子性指的是一个或多个操作要么全部执行成功要么全部执行失败。  
有序性: 程序执行的顺序按照代码的先后顺序执行。（处理器可能会对指令进行重排序）  
可见性: 一个线程对共享变量的修改,另一个线程能够立刻看到  

##### CyclicBarrier和CountDownLatch的区别，CountDownLatch这个已经上过，要求自己学习CyclicBarrier并且写出代码
1.CyclicBarrier的某个线程运行到屏障点上之后，该线程立即停止运行，直到所有的线程都到达了这个屏障点，所有线程才依次
按顺序被唤醒重新运行；CountDownLatch是某个线程运行到某个点上之后，只是给计数器数值减一，该线程扔继续运行；

2.CyclicBarrier唤醒等待线程虽然是唤醒全部，但等待线程是按顺序依次执行的；CountDownLatch是唤醒多个任务，抢占式
执行；

3.CyclicBarrier可重用的，因为内部计数器可重置；CountDownLatch不可重用，计数器值为0该CountDownLatch就不可再用。


#### ConcurrentHashMap和Hashtable的区别？
 Hashtable
 * 底层数组+链表实现，无论key还是value都不能为null，线程安全，实现线程安全的方式是在修改数据时锁住整个HashTable，
    效率低
 * 初始size为11，扩容：newsize=olesize*2+1
 * 计算index的方法：index=(hash&0x7FFFFFFF)%tab.length

 ConcurrentHashMap
 * 底层采用分段的数组+链表实现，线程安全
 * 通过把整个Map分为N个Segment，可以提供相同的线程安全，但是效率提升N倍，默认提升16倍。(读操作不加锁，由于HashEntry
    的value变量是 volatile的，也能保证读取到最新的值。)
 * Hashtable的synchronized是针对整张Hash表的，即每次锁住整张表让线程独占，ConcurrentHashMap允许多个修改操作并发进行
    ，其关键在于使用了锁分离技术
 * 扩容：段内扩容（段内元素超过该段对应Entry数组长度的75%触发扩容，不会对整个Map进行扩容），插入前检测需不需要扩容，
    有效避免无效扩容
