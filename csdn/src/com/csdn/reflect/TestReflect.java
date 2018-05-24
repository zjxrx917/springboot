package com.csdn.reflect;

import org.junit.Test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class TestReflect {

    //无参构造函数
    @Test
    public void test01() throws Exception {
        //Class<Person> pClass = Person.class;
        Class<?> pClass = Class.forName("com.csdn.reflect.Person");

        //返回的是构造方法对象
        Constructor constructor = pClass.getConstructor();

        Object o = constructor.newInstance();
        //Person o = (Person)constructor.newInstance();
//        o.setAge(18);
//        o.setName("张三");
//        o.setSex("男");
//        o.show();
        System.out.println(o);
    }

    //带参构造
    @Test
    public void test02() throws Exception{
        Class<?> aClass = Class.forName("com.csdn.reflect.Person");
        //字节码文件获取带参构造函数对象

        Constructor<?> constructor = aClass.getConstructor(String.class, Integer.class, String.class);

        Object o = constructor.newInstance("张三", 18, "男");
        System.out.println(o);

    }
    //私有构造函数
    @Test
    public void test03() throws Exception{
        Class<?> aClass = Class.forName("com.csdn.reflect.Person");
        //获取私有构造方法对象
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, Integer.class);

        declaredConstructor.setAccessible(true);
        Object o = declaredConstructor.newInstance("张样", 19);
        System.out.println(o);
    }
    //通过反射操作成员变量
    @Test
    public void test04() throws Exception {
        //Class<?> aClass = Class.forName("com.csdn.reflect.Person");
        Class<?> aClass = Person.class;



        //Field[] fields = aClass.getDeclaredFields();
        Field[] fields = aClass.getFields();
        for (Field f: fields){
            System.out.println(f.getName());
        }
        Constructor<?> con = aClass.getDeclaredConstructor();
        Object obj = con.newInstance();
        System.out.println(obj);

        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);

        name.set(obj, "丽水");
        System.out.println(obj);

    }

    /**
     * 反射获取方法
     * @throws Exception
     */
    @Test
    public void test05() throws Exception {
        Class<?> aClass = Class.forName("com.csdn.reflect.Person");
        Constructor<?> con = aClass.getDeclaredConstructor();
        //通过无参构造函数对象获取实例对象
        Object o = con.newInstance();

        Method show = aClass.getDeclaredMethod("show");
        show.setAccessible(true);

        show.invoke(o);
    }

    /**
     * 反射获取带参有返回值方法
     * @throws Exception
     */
    @Test
    public void test06() throws Exception {
        Class<?> aClass = Class.forName("com.csdn.reflect.Person");
        Constructor<?> con = aClass.getDeclaredConstructor();
        //通过无参构造函数对象获取实例对象
        Object o = con.newInstance();
        //第一个参数表示的是：方法名称，第二个参数表示：方法参数类型的字节码
        Method showMe = aClass.getDeclaredMethod("showMe", String.class, Integer.class);
        showMe.setAccessible(true);

        Object result = showMe.invoke(o, "张三", 18);
        System.out.println(result);
    }

    /**
     * 深度理解反射
     * @throws Exception
     */
    @Test
    public void test07() throws Exception{
        Properties prop = new Properties();
        FileReader fr = new FileReader("class.txt");
        prop.load(fr);

        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");
        System.out.println("className:" + className + ", methodName:" + methodName);
        //反射
        Class<?> aClass = Class.forName(className);

        Constructor<?> con = aClass.getDeclaredConstructor();
        Object o = con.newInstance();

        Method method = aClass.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(o);

    }

    /**
     * 给某个对象的属性赋值工具类测试
     * @throws Exception
     */
    @Test
    public void test08() throws Exception{
        Person p = new Person();

        Class aClass = p.getClass();
        BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
        Person bean = (Person) aClass.newInstance();
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();



        System.out.println(p);
        Tool.setProperty(p, "name", "张三");
        System.out.println(p);

    }


}
