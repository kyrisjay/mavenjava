#### 为什么不能根据返回类型来区分重载
* 重载(方法名相同、参数类型,参数个数不同),因为调用方法时不能指定类型信息,方法名相同,编译器不清楚你要调用哪个函数
例: float max(int a,int b);    int max(int a,int b);

#### 写出数据库脏读，幻读，不可重复读的sql语句,并用自己的话总结这三个，mysql数据库的默认事务的隔离级别是什么
* 脏读:指在一个事务处理过程里读取了另一个未提交事务中的数据  
* 幻读:比如事务1将一个数据1全部改为2,此时事务2对这个表中插入了1并且提交给了数据库,而操作的事务1查看修改数据1  
发现还有1存在,发现还有一行没有被修改,其实是事务2添加的,产生幻觉一样  
* 不可重复读:比如事务1在对数据库中的某个数据进行多次查询,返回的数值不一样,是由事务2对其中的数据  
进行了修改并提交
* 事务的隔离级别由低到高Read uncommitted(读未提交) 、Read committed(读提交) 、Repeatable read(重复读) 、
Serializable(序列化),这四个级别可以逐个解决脏读、可重复读、幻读 这几类问题
#### jdbc对事物的处理步骤
* 在JDBC中，事务操作默认是自动提交。也就是说，一条对数据库的更新表达式代表一项事务操作。操作成功后，系统将自动调用commit()来提交，否则将调用rollback()来回退
#### 你对设计模式的理解
* 设计模式的分类
范围	     创建型	                         结构型	                  行为型  
类      Factory Method（工厂方法）         Adapter(类) （适配器）    Interpreter（解释器）
                                                                Template Method（模版方法）  

对象    Abstract Factory（抽象工厂）        Bridge（桥接）           Chain of Responsibility（职责链）      
        Builder（建造者）                  Composite（组合）         Command（命令）     
        Prototype（原型）                  Decorator（装饰者）       Iterator（迭代器）  
        Singleton（单例）                  Façade（外观）            Mediator（中介者）  
                                          Flyweight（享元）         Memento（备忘录）  
                                          Proxy（代理）             Observer（观察者）  
                                                                    State（状体） 
                                                                    Strategy（策略）  
                                                                    Visitor（访问者）
      

#### 分析QUEUE集合,请用两个队列模拟堆栈结构（队列是先进先出，而堆栈是先进后出）


#### 为什么要实现Collection接口而不是继承呢？
* Collection是最基本的集合接口,一些 collection 允许有重复的元素，而另一些则不允许。一些 collection 是有序的，而另一些则是无序的
Java SDK不提供直接继承自Collection的类,Java SDK提供的类都是继承自Collection的“子接口”如List和Set


#### 设有一个二维数组 A[m][n]，假设A[0][0]存放的位置在 644（10），A[2][2]存放的文职在676（10）每个元素占一个空间，
     问 A[3][3]（10）存放在什么位置? 脚注（10）表示用 10进制表示（ 692）C
     
*  A[3][3]地址=644+偏移量=644+length*3+3  
   A[2][2]地址=A[0][0]+length*2+2=676    length=15

#### 
    ```
    public static void main(String args[]) {
        Thread t = new Thread() {
            public void run() {
                pong();
            }
        };
        t.run();
        System.out.print("ping");
    }
    static void pong() {
        System.out.print("pong");
    }
    ```
* pong ping
#### 
    ```
        static boolean foo(char c) {
            System.out.print(c);
            return true;
        }
        
        public static void main(String[] args) {
            int i = 0;
            for (foo('A'); foo('B') && (i < 2); foo('C')) {
                i++;
                foo('D');
            }
        }
    ```
 * ABDCBDCB
 
 #### 
    ```
        class Foo {
            public static void main(String args[]) {
                try {
                    return;
                } finally {
                    System.out.println("Finally");
                }
            }
        }
        ```
 * finally
#### 写出对java项目进行打包的命令,并且执行包里面的程序
*  mvn -Dmaven.test.skip -U clean package

#### 线程类的构造方法、静态块是被哪个线程调用的
* 被new的线程类所调用,而run方法里面的代码才是被线程自身所调用的
#### 数据库如果有千万级数据，你如何提高查询效率
* 数据库设计方面  
** 对查询进行优化，应尽量避免全表扫描，首先应考虑在 where 及 order by 涉及的列上建立索引；  
** 一个表的索引数最好不要超过6个  
** 应尽可能的避免更新索引数据列，因为索引数据列的顺序就是表记录的物理存储顺序，一旦该列值改变将导致整个表记录的顺序的调整，会耗费相当大的资源  
** 尽量使用数字型字段，若只含数值信息的字段尽量不要设计为字符型，这会降低查询和连接的性能，并会增加存储开销  
** 避免频繁创建和删除临时表，以减少系统表资源的消耗   
* SQL语句方面  
** 应尽量避免在 where 子句中使用!=或<>操作符，否则将引擎放弃使用索引而进行全表扫描  
** 应尽量避免在 where 子句中使用 or 来连接条件  
** in 和 not in 也要慎用，否则会导致全表扫描，能用 between 就不要用 in 了  
** 任何地方都不要使用 select * from t ，用具体的字段列表代替“*”，不要返回用不到的任何字段  
* Java方面  
** 尽可能的少造对象  
** 使用JDBC链接数据库操作数据  

#### 说说你在做项目的时候，对数据库的优化有哪些？
* sql语句优化  建表设计  字段优化

#### 写出装饰器模式和状态模式


#### 
* update SC set grade=grade*1.05 where  grade < (select avg(grade) from SC inner join S on S.sno=SC.sno where SSEX='女');
* 