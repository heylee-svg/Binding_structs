这里是一个demo关于设计模式的  链式操作
BinderHandler里作为一个统筹 传两个对象一个是BindView 是MainActivity传过来的的用来回调更新MainActivity的UI的
然后一个IBindState接口用来控制 ScanState PingInfoState 和BindingState三个状态
这三个状态都extends ABindState这里有2个方法以及implements了一个IBindState的接口
extends ABindState是为了调用 getAContext(）和setAContext()
BindContext里添加IBindState的是时候 调用了setAcontext()  由于只有这三个state的父类实现了setAcontext方法 那么new出来的子类调用getAContext的时候实际拿到的是父类setAContext的值
方便了方法重用
再说第二层在BinderHandler里 extends BinderContext  然后BinderContext extends AContext implements IContext