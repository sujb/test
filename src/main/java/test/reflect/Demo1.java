package test.reflect;

import java.lang.reflect.*;

/**
 * @Description :
 * @Author : sujinbo
 * @Date : 2018/8/22 10:49
 */
public class Demo1 {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, NoSuchMethodException {
        System.out.println("test1->通过Java反射机制得到类的包名和类名");
        test1();

        System.out.println();
        System.out.println("验证所有的类都是Class类的实例对象");
        test2();

        System.out.println();
        System.out.println("通过Java反射机制，用 Class 创建类对象");
        test3();

        System.out.println();
        System.out.println("通过Java反射机制得到一个类的构造函数，并实现创建带参实例对象");
        test4();

        System.out.println();
        System.out.println("通过Java反射机制操作成员变量");
        test5();

        System.out.println();
        System.out.println("通过Java反射机制得到类的一些属性：继承的接口、父类、函数信息、成员信息、类型等");
        test6();

        System.out.println();
        System.out.println("通过Java反射机制调用类方法");
        test7();

        System.out.println();
        System.out.println("通过Java反射机制得到类加载器信息");
        test8();
    }

    /**
     * 通过Java反射机制得到类的包名和类名
     */
    public static void test1() {
        Person person = new Person();
        System.out.println("包名:" + person.getClass().getPackage().getName());
        System.out.println("完成类名:" + person.getClass().getName());
    }

    /**
     * 验证所有的类都是Class类的实例对象
     */
    public static void test2() throws ClassNotFoundException {
        Class<?> class1 = null;
        Class<?> class2 = null;
        //常用写法
        class1 = Class.forName("test.reflect.Person");
        System.out.println("写法1：包名->" + class1.getPackage().getName() + ",完整类名->" + class1.getName());
        class2 = Person.class;
        System.out.println("写法2：包名->" + class2.getPackage().getName() + ",完整类名->" + class2.getName());
    }

    /**
     * 通过Java反射机制，用 Class 创建类对象，这也就是反射存在的意义所在
     */
    public static void test3() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> clazz = null;
        clazz = Class.forName("test.reflect.Person");
        Person person = (Person) clazz.newInstance();
        person.setAge(11);
        person.setName("joe");
        System.out.println(person);
    }

    /**
     * 通过Java反射机制得到一个类的构造函数，并实现创建带参实例对象
     */
    public static void test4() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = null;
        clazz = Class.forName("test.reflect.Person");
        Person person1 = null;
        Person person2 = null;
        Constructor<?>[] constructors = clazz.getConstructors();
        person1 = (Person) constructors[0].newInstance();
        person1.setName("ming");
        person1.setAge(11);
        System.out.println("无参构造器：" + person1);
        person2 = (Person) constructors[1].newInstance(12, "hong");
        System.out.println("有参构造器：" + person2);
    }

    /**
     * 通过Java反射机制操作成员变量, set 和 get
     */
    public static void test5() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> clazz = Class.forName("test.reflect.Person");
        Object person = clazz.newInstance();
        Field nameField = clazz.getDeclaredField("name");
        //取消访问检查
        nameField.setAccessible(true);
        nameField.set(person, "jim");
        System.out.println("设置并获取成员变量值->" + nameField.get(person));
    }

    /**
     * 通过Java反射机制得到类的一些属性：继承的接口、父类、函数信息、成员信息、类型等
     */
    public static void test6() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("test.reflect.Superman");
        Class<?> superclass = clazz.getSuperclass();
        System.out.println("superman的父类:" + superclass.getName());

        System.out.println("superman的属性");
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field);
        }

        System.out.println("superman的方法");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println("--------------------------");
            System.out.println("modifier:" + Modifier.toString(method.getModifiers()));
            System.out.println("return type:" + method.getReturnType().getName());
            System.out.println("方法名：" + method.getName());
            System.out.println("方法：" + method);
        }

        System.out.println("superman的接口");
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class c : interfaces) {
            System.out.println(c.getName());
        }

    }

    /**
     * 通过Java反射机制调用类方法
     */
    public static void test7() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class clazz = Class.forName("test.reflect.Superman");
        Method methodFly = clazz.getMethod("fly");
        methodFly.invoke(clazz.newInstance());
        Method methodWalk = clazz.getMethod("walk", int.class);
        methodWalk.invoke(clazz.newInstance(), 200);
    }

    /**
     * 通过Java反射机制得到类加载器信息
     * 在java中有三种类类加载器
     * 1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。
     * 2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jre\lib\ext目录中的类
     * 3）AppClassLoader 加载classpath指定的类，是最常用的加载器，同时也是java中默认的加载器。
     */
    public static void test8() throws ClassNotFoundException {
        Class clazz = Class.forName("test.reflect.Superman");
        String classLoaderName = clazz.getClassLoader().getClass().getName();
        System.out.println("classLoaderName : " + classLoaderName);
    }

}
