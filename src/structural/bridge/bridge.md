### 桥接模式

定义：抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。

应用场景：

- 不希望抽象和具体实现之间有一个固定的绑定关系
- 类的抽象以及它的实现都可以通过生成子类的方式加以扩充。bridge模式使得可以对不同的抽象接口和和实现部分进行组合，并分别对他们进行扩充。
- 对一个抽象的实现部分的修改应对客户不产生影响，即客户的代码不必重新编译
- 有许多类需要生成
- 想在多个用户间共享实现（可能使用引用计数），但同时要求客户不知道这点。

#### 实现

桥接（Bridge）模式包含以下主要角色。

- 抽象化（Abstraction）角色：定义抽象类，并包含一个对实现化对象的引用。
- 扩展抽象化（Refined Abstraction）角色：是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法。
- 实现化（Implementor）角色：定义实现化角色的接口，供扩展抽象化角色调用。
- 具体实现化（Concrete Implementor）角色：给出实现化角色接口的具体实现。