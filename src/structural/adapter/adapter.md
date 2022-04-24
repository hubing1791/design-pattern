### 适配器模式

定义：

将一个类的接口转换成客户希望的另外一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。适配器模式分为类结构型模式和对象结构型模式两种，前者类之间的耦合度比后者高，且要求程序员了解现有组件库中的相关组件的内部结构，所以应用相对较少些。

应用场景：

- 你想使用一个已经存在的类，而它的接口不符合你的需求
- 你想创建一个可以复用的类，该类可以与其它不相关的类或者不可预见的类（即那些接口可能不一定兼容的类）
- （仅适用于对象adapter）你想使用一些已经存在的子类，但是不可能对每一个都进行子类化以匹配它们的接口。对象适配器何以适配它们的父类

结构：

1.目标（Target）接口：当前系统业务所期待的接口，它可以是抽象类或接口。
2.适配者（Adaptee）类：它是被访问和适配的现存组件库中的组件接口。
3.适配器（Adapter）类：它是一个转换器，通过继承或引用适配者的对象，把适配者接口转换成目标接口，让客户按目标接口的格式访问适配者。

#### 类适配器

类适配器的权衡如下

- 用一个具体的Adapter类对Adaptee和Target进行匹配。结果是当我们想要匹配一个类以及其它所有它的子类是，类Adapter将不能工作
- 使得Adapter可以重定义Adaptee的部分行为,因为Adapter是Adaptee的一个子类
- 仅仅引入了一个对象，不需要额外的指针以间接得到Adaptee

#### 对象适配器

对象适配器的权衡：

- 允许一个adapter与多个Adaptee——Adaptee本身以及它的所有子类（如果有子类的话）——同时工作。Adapter也可以一次给所有的Adaptee添加功能。
- 使得重定义Adaptee的行为比较困难。这就需要生成Adaptee的子类并且使得Adapter引用这个子类而不是引用Adaptee本身。

#### 双向适配器

不算是一种适配器模式，但是是一个学习点