Demo1运行结果
```javascript
test1->通过Java反射机制得到类的包名和类名
包名:test.reflect
完成类名:test.reflect.Person

验证所有的类都是Class类的实例对象
写法1：包名->test.reflect,完整类名->test.reflect.Person
写法2：包名->test.reflect,完整类名->test.reflect.Person

通过Java反射机制，用 Class 创建类对象
Person{age=11, name='joe'}

通过Java反射机制得到一个类的构造函数，并实现创建带参实例对象
无参构造器：Person{age=11, name='ming'}
有参构造器：Person{age=12, name='hong'}

通过Java反射机制操作成员变量
设置并获取成员变量值->jim

通过Java反射机制得到类的一些属性：继承的接口、父类、函数信息、成员信息、类型等
superman的父类:test.reflect.Person
superman的属性
private boolean test.reflect.Superman.blueBriefs
superman的方法
--------------------------
modifier:public
return type:java.lang.String
方法名：toString
方法：public java.lang.String test.reflect.Superman.toString()
--------------------------
modifier:public
return type:void
方法名：setBlueBriefs
方法：public void test.reflect.Superman.setBlueBriefs(boolean)
--------------------------
modifier:public
return type:void
方法名：fly
方法：public void test.reflect.Superman.fly()
--------------------------
modifier:public
return type:boolean
方法名：isBlueBriefs
方法：public boolean test.reflect.Superman.isBlueBriefs()
--------------------------
modifier:public
return type:void
方法名：walk
方法：public void test.reflect.Superman.walk(int)
superman的接口
test.reflect.ActionInterface

通过Java反射机制调用类方法
superman can fly
超人走了200米

通过Java反射机制得到类加载器信息
classLoaderName : sun.misc.Launcher$AppClassLoader
```