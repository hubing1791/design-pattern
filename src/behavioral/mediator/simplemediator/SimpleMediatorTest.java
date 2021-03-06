package behavioral.mediator.simplemediator;

//在实际开发中，通常采用以下两种方法来简化中介者模式，使开发变得更简单。
//不定义中介者接口，把具体中介者对象实现成为单例。
//同事对象不持有中介者，而是在需要的时候直接获取中介者对象并调用。

import java.util.ArrayList;
import java.util.List;

public class SimpleMediatorTest {
        public static void main(String[] args) {
        SimpleColleague c1, c2;
        c1 = new SimpleConcreteColleague1();
        c2 = new SimpleConcreteColleague2();
        c1.send();
        System.out.println("-----------------");
        c2.send();
    }
}

//简单单例中介者
class SimpleMediator {
    private static SimpleMediator smd = new SimpleMediator();
    private List<SimpleColleague> colleagues = new ArrayList<SimpleColleague>();
    private SimpleMediator() {
    }
    public static SimpleMediator getMedium() {
        return (smd);
    }
    public void register(SimpleColleague colleague) {
        if (!colleagues.contains(colleague)) {
            colleagues.add(colleague);
        }
    }
    public void relay(SimpleColleague scl) {
        for (SimpleColleague ob : colleagues) {
            if (!ob.equals(scl)) {
                ((SimpleColleague) ob).receive();
            }
        }
    }
}
//抽象同事类
interface SimpleColleague {
    void receive();
    void send();
}
//具体同事类
class SimpleConcreteColleague1 implements SimpleColleague {
    SimpleConcreteColleague1() {
        SimpleMediator smd = SimpleMediator.getMedium();
        smd.register(this);
    }
    public void receive() {
        System.out.println("具体同事类1：收到请求。");
    }
    public void send() {
        SimpleMediator smd = SimpleMediator.getMedium();
        System.out.println("具体同事类1：发出请求...");
        smd.relay(this); //请中介者转发
    }
}
//具体同事类
class SimpleConcreteColleague2 implements SimpleColleague {
    SimpleConcreteColleague2() {
        SimpleMediator smd = SimpleMediator.getMedium();
        smd.register(this);
    }
    public void receive() {
        System.out.println("具体同事类2：收到请求。");
    }
    public void send() {
        SimpleMediator smd = SimpleMediator.getMedium();
        System.out.println("具体同事类2：发出请求...");
        smd.relay(this); //请中介者转发
    }
}