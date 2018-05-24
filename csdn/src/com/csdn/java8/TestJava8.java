package com.csdn.java8;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.function.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TestJava8 {

    @Test
    public void testComparator(){

        //TreeSet<Employee> treeSet = new TreeSet<Employee>();
        TreeSet<Employee> treeSet = new TreeSet<Employee>((a,b)->{
            int i = a.getAge() - b.getAge();
            int i2 = i==0? a.getName().compareTo(b.getName()): i;
            int result = i2==0? a.getSex().compareTo(b.getSex()):i2;
            return result;
        });

        Employee e1 = new Employee("zhangsan", "男", 17);
        Employee e2 = new Employee("lisi", "女", 18);
        Employee e3 = new Employee("wangwu", "女", 17);
        Employee e4 = new Employee("wangwu", "男", 17);

        //System.out.println(Integer.compare(1, 2));
        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        treeSet.add(e4);
        for (Employee employee: treeSet
             ) {
            System.out.println(employee.getName() + "=" + employee.getAge() + "=" + employee.getSex());
        }
    }

    /**
     * Lambda表达式
     */
    @Test
    public void test01() {
        //第一种写法（java7）(Employee如果姓名、性别、年龄都相同，则是同一个元素，则不添加。按年龄、姓名、性别排序)
//        TreeSet<Employee> treeSet = new TreeSet<>(new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                int num = o1.getAge()-o2.getAge();
//                int num2 = num == 0?o1.getName().compareTo(o2.getName()): num;
//                int result = num2 == 0 ? o1.getSex().compareTo(o2.getSex()) : num2;
//                return result;
//            }
//        });

        //lambda表达式中有 {} 则说明不止有一行代码，如果只有一行代码则可以省略{}，就如if条件后面只有一行代码，可以省略大括号
        Comparator<Employee> com = (a, b) -> {
            int compare = Integer.compare(b.getAge(), a.getAge());
            int result = compare==0? a.getName().compareTo(b.getName()): compare;
            return result;
        };

        //TreeSet<Employee> treeSet = new TreeSet<>(com);
        TreeSet<Employee> treeSet = new TreeSet<>((a, b) -> {
            int compare = Integer.compare(b.getAge(), a.getAge());
            int result = compare==0? a.getName().compareTo(b.getName()): compare;
            return result;
        });
        Employee e1 = new Employee("zhangsan", "male", 19);
        Employee e2 = new Employee("zhangsan", "female", 20);
        Employee e3 = new Employee("lisi", "female", 20);
        treeSet.add(e1);
        treeSet.add(e2);
        treeSet.add(e3);
        for (Employee employee : treeSet) {
            System.out.println(employee.getName() + "=" + employee.getAge());
        }
    }
    @Test
    public void test02(){
        List<Employee> list = Arrays.asList(
                new Employee("zhangsan", "male", 19),
                new Employee("zhangsan", "female", 20),
                new Employee("lisi", "female", 20)
        );
        //带大括号的和不带大括号的
        //List<Employee> collect = list.stream().filter(employee -> employee.getAge() > 19).collect(Collectors.toList());
        List<Employee> collect = list.stream().filter(employee -> {return employee.getAge() > 19;}).filter(e->e.getName().equals("lisi"))
                .collect(Collectors.toList());
        for (Employee employee : collect) {
            System.out.println(employee.getName() + "=" + employee.getAge());
        }
    }

    /**
     * Lambda基础语法======================================================================================
     * 语法一：无参数，无返回值
     */
    @Test
    public void test03() {
        Runnable runnable = () -> System.out.println("hello, world, Lambda");
        Thread thread= new Thread(runnable);
        Thread thread2= new Thread(runnable);
        Thread thread3= new Thread(runnable);
        thread.start();
        thread2.start();
        thread3.start();

    }
    /**语法二
     * 有参数，无返回值
     */
    @Test
    public void testConsumer() {
        Consumer consumer = (e) -> {
            System.out.println(e);
        };
        consumer.accept("hello, world, consumer!");
    }

    /**
     * 语法三
     * 有两个以上的参数，并且有返回值，并且Lambda体中有多条语句
     */
    @Test
    public void testcomparator() {
        Comparator<Integer> comparator = (a, b) -> {
            //多条语句，Lambda必须用大括号
            System.out.println("函数式接口");
            return a.compareTo(b);
        };
        int compare = comparator.compare(2, 1);
        System.out.println(compare);
    }

    /**
     * 语法四：若Lambda体中只有一条语句，有返回值，return和大括号可以省略
     */
    @Test
    public void test04(){
        Comparator<String> comparator = (a, b) -> b.compareTo(a);
        int compare = comparator.compare("afa", "caa");
        System.out.println(compare);
    }

    /**
     * 语法五：Lambda的参数列表类型，可以省略，jvm可以通过上下文，推断出类型，“类型推断”
     */
    @Test
    public void test05() {
    }

    //**********Lambda需要函数式接口支持：接口中只有一个抽象方法的接口，称为函数式接口***************************

    //对一个数进行操作
    @Test
    public void test06() {
        Integer operate = operate(3, (b) -> b * b);
        System.out.println(operate);
    }

    public Integer operate(Integer a, MyFunction<Integer> my) {
        return my.getOperate(a);
    }

    /**
     * Lambda内置了函数接口，测试
     * java8内置的四大核心函数式接口
     *
     * 1、Consumer<T> 消费型接口
     *      void accept（T t）;
     * 2、Supplier<T> 供给型接口
     *      T get();
     * 3、Function<T, R> 函数型接口，T:代表参数，R代表返回值
     *      R apply(T t);
     * 4、Predicate<T> 断言型接口 ， 做一些判断的接口
     *      boolean test<T t>;
     */
    @Test
    public void testFunction() {
        // Consumer接口
        happy(1000d, (a) -> System.out.println("消费了" + a + "元"));

        // Supplier接口(产生十个随机数)
        List<Integer> support = support(10, () -> {
            return (int)(Math.random()*100);// 注意不要写成(int)Math.random()*100，这个结果为0，因为先执行了强制转换
        });
        System.out.println(support);

        // Function<T, R> 函数型接口
        //转大写
        String s = convertString("hello, world, Function", (e) -> e.toUpperCase());
        System.out.println(s);
        //取除了最后一个字符的子串
        String convertString = convertString("hello, function;", e -> e.substring(0, e.length() - 1));
        System.out.println(convertString);

        //将满足条件的字符串，添加到集合中去
        System.out.println("========================");
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("Predicate");
        list.add("TestAll");
        list.add("aestall");
        List string = addString(list, (e) -> {
            Pattern pattern = Pattern.compile("[A-Z]");
            Matcher matcher = pattern.matcher(e);

            if (e.length() > 5 && matcher.find()) {
                System.out.println(e);
                System.out.println(matcher.group(0));
                System.out.println(matcher.group());
                return true;
            } else {
                return false;
            }
        });
        System.out.println(string);
    }

    public void happy(Double money, Consumer consumer) {
        consumer.accept(money);
    }

    public List<Integer> support(int num, Supplier<Integer> supplier) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());
        }
        return  list;
    }

    //专门处理字符串的，函数型接口
    public String convertString(String str, Function<String, String> function) {
        return function.apply(str);

    }

    public  List addString(List<String> list, Predicate<String> predicate){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (predicate.test(list.get(i))) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    /**
     * 方法引用
     * **********最重要一点：Lambda体中方法引用的参数列表和返回值类型要与函数式抽象接口参数列表和返回值一致************************
     */
    @Test
    public void testRef() {
        Comparator<String> comparator = (a, b) -> a.compareTo(b);
        int compare = comparator.compare("aa", "dc");
        System.out.println(compare);
        //第二种写法
        Comparator<String> comparator2 = String::compareTo;
        int compare2 = comparator2.compare("dd", "aa");
        System.out.println(compare2);

        Comparator<Integer> c = (a, b) -> a.compareTo(b);
        System.out.println(c.compare(3, 1));

        Comparator<Integer> c2 = Integer::compare;
        Comparator<Integer> c3 = Integer::compareTo;

        System.out.println(c2.compare(1,3));
        System.out.println("============================");
        BiPredicate<String, String> bp = (a, b) -> a.equals(b);
        System.out.println(bp.test("hello", "hello"));
        //实例方法名（第一个参数是实例方法调用者，第二个参数是实例方法的参数，则可以用 类名：：方法 （className::method）来调用）
        BiPredicate<String, String> bp2 = String::equalsIgnoreCase;
        System.out.println(bp2.test("hello", "HELLO"));
    }

    /**
     * 构造器引用===================================================================
     * 格式：className::new
     */
    @Test
    public void testConstruct(){
        //Employee employee = Employee::new;
        //供给型创建对象
        //Supplier<Employee> sup = Employee::new;
        Supplier<Employee> sup = () -> new Employee("zhangsan", "female", 18);
        System.out.println(sup.get());

        System.out.println("=============");
        Function<String, Employee> function = Employee::new;
        System.out.println(function.apply("wangwu"));
        System.out.println("========数组引用================");

        Function<Integer, String[]> function1 = (a) -> new String[a];
        String[] apply = function1.apply(3);
        apply[0]="hello";
        apply[1]="world";
        apply[2]="Array";
        //apply[3]="repeat";
        for (String s : apply) {
            System.out.println(s);
        }
        System.out.println("=====数组第二种方式");
        Function<Integer, String[]> function2 = String[]::new;
        String[] apply2 = function2.apply(10);
        System.out.println(apply2.length);
    }

    /**
     * ========================强大的StreamApi===============================
     */
    @Test
    public void testGenerateStreamApi() {
        /**
         * 获取Stream有四种方式：集合获取和数组获取
         */
        String[] arr = new String[6];
        Stream<String> stream = Arrays.stream(arr);

        Stream<String> string = Stream.of("String", "sdhel");

        //第三种无限流
        //迭代
        Stream<Integer> stream3 = Stream.iterate(0, (a) -> a + 10);
        //stream3.forEach(e -> System.out.println(e));
        //stream3.forEach(System.out::println);
        stream3.limit(10).forEach(System.out::println);//只要前10个
        //生成
        Stream.generate(() -> Math.random()).limit(5).forEach(e-> System.out.println(e));

        List<String> list = new LinkedList<>();
        list.add("hello, world");
        list.add("hello, java");
        list.add("hello, Stream");
        list.add(" Stream");
        List<String> collect = list.stream().filter((e) -> e.matches("[/D]")).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void testStreamApi() {
        /**
         * 筛选和切片（filter，limit，skip，distinct）
         * distinct去重，根据hashcode和equals去重，必须重写自定义对象的两个方法
         *
         */
        Employee e1 = new Employee("zhangsan", "male", 19);
        Employee e2 = new Employee("zhangsan", "female", 20);
        Employee e3 = new Employee("lisi", "female", 20);
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        //中间操作（没有任何过程，只要终止操作才有）
        Stream<Employee> employeeStream = employees.stream().filter(e -> {
            System.out.println("中间操作！");
            return e.getAge() >= 20;
        });
        //终止操作（“惰性求值或者叫延迟加载”）
        employeeStream.forEach(System.out::println);
    }
    /**
     * 映射（map， flatMap）
     */
    @Test
    public void testMapper() {
        Employee e1 = new Employee("zhangsan", "male", 19);
        Employee e2 = new Employee("zhangsan", "female", 20);
        Employee e3 = new Employee("lisi", "female", 20);
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        List<Employee> employees2 = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);

        List list2 = new ArrayList();
        list2.add(employees);
        list2.add(employees2);
        //测试一
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        //Function 传递一个参数 T， 返回一个结果 R
        list.stream().map((e) -> e.toUpperCase())
                .forEach(System.out::println);
        System.out.println("=========5555555=============");
        Map<String, IntSummaryStatistics> collect = employees.stream().collect(Collectors.groupingBy(Employee::getSex, Collectors.summarizingInt(Employee::getAge)));
        System.out.println("分组求和：" + collect);

        //Stream stream = list2.stream().flatMap(e->e)

        System.out.println("=========5555=============");
        //测试二
        employees.stream().map(e -> e.getName())
                .forEach(e -> System.out.println(e));
        System.out.println("===========flatMap============");
    }
    /**
     * 排序：sorted（自然排序），
     */
    @Test
    public void testSort() {
        Employee e1 = new Employee("zhangsan", "male", 19);
        Employee e2 = new Employee("lisi", "female", 20);
        Employee e4 = new Employee("alisi", "female", 20);
        Employee e5 = new Employee("alisi", "male", 20);
        Employee e3 = new Employee("zhangsan", "female", 20);
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        //自然排序
        List<String> list = Arrays.asList( "bbb", "acc", "ddd","aaa");
        list.stream().sorted().forEach(System.out::println);
        //自然排序二
        employees.stream().map(e-> e.getName()).sorted().forEach(System.out::println);
        //定制排序
        employees.stream().sorted((a, b) -> {
            int i = a.getAge() - b.getAge();
            int result = i==0? a.getName().compareTo(b.getName()): i;
            return result;
        }).forEach(System.out::println);
    }

    /**
     * 终止操作（查找与匹配：allMatch，anyMatch，noneMatch，findFirst，findAny，count，max，min）
     */
    @Test
    public void testMatch() {
        Employee e1 = new Employee("zhangsan", "male", 19);
        Employee e2 = new Employee("lisi", "female", 20);
        Employee e4 = new Employee("alisi", "female", 20);
        Employee e5 = new Employee("alisi", "male", 20);
        Employee e3 = new Employee("zhangsan", "female", 25);
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);


        boolean b = employees.stream().allMatch(e -> e.getAge() > 19);
        boolean b1 = employees.stream().anyMatch(e -> e.getAge() > 19);
        boolean b2 = employees.stream().noneMatch(e -> e.getAge() > 20);
        System.out.println("b="+b+",b1="+b1+",b2="+b2);
        System.out.println("=======================================");

        //employees.clear();
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first.orElse(new Employee("wuwu")));
        employees.stream().findAny();

        //count,max,min
        System.out.println("====================================");
        long count = employees.stream().count();
        System.out.println(count);
        Optional<Employee> max = employees.stream().max((x, y) -> x.getAge() - y.getAge());
        System.out.println(max.orElse(new Employee()));
    }

    /**
     * 归约和收集
     */
    @Test
    public void testreduce() {
        //第一种reduce
        Integer[] arr= new Integer[]{1,2,3,3};
        Integer integer = Stream.of(arr).reduce((result, item) -> {
            result += item;
            return result;
        }).orElse(0);
        System.out.println(integer);

        //第二种reduce
        Integer reduce = Stream.of(arr).reduce(2, (x, y) -> {
            return x + y;
        });
        System.out.println(reduce);

        Employee e1 = new Employee("zhangsan", "male", 19);
        Employee e2 = new Employee("lisi", "female", 20);
        Employee e4 = new Employee("alisi", "female", 20);
        Employee e5 = new Employee("alisi", "male", 20);
        Employee e3 = new Employee("zhangsan", "female", 25);
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);

        Optional<Integer> reduce1 = employees.stream().map(Employee::getAge).reduce(Integer::sum);
        System.out.println(reduce1.orElse(0));

        System.out.println("===============================================");
        //Collectors(晚上重点看一下)
        List<Integer> collect = Stream.of(arr).filter(e -> e >= 2).collect(Collectors.toList());
        //收集到其他特殊的集合中去
        LinkedHashSet<Integer> collect1 = Stream.of(arr).filter(e -> e >= 2)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(collect);
        System.out.println(collect1);

        //按性别分组
        Map<String, List<Employee>> collect2 = employees.stream().collect(Collectors.groupingBy(e -> e.getSex()));
        System.out.println(collect2);
        //多级分组
        Map<String, Map<Integer, List<Employee>>> collect3 =
                employees.stream().collect(Collectors.groupingBy(Employee::getSex, Collectors.groupingBy(Employee::getAge)));
        System.out.println(collect3.toString());
    }

    /**
     * 分片或者分区
     */
    @Test
    public void test8() {
        Employee e1 = new Employee("zhangsan", "10", 19);
        Employee e2 = new Employee("lisi", "10", 20);
        Employee e4 = new Employee("alisi", "32", 20);
        Employee e5 = new Employee("alisi", "20", 20);
        Employee e3 = new Employee("zhangsan", "20", 25);
        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);
        employees.add(e5);
        //分组
        LongSummaryStatistics collect4 = employees.stream().collect(Collectors.summarizingLong(e -> Long.valueOf(e.getSex())));
        System.out.println(collect4);
        //分两个区
        Map<Boolean, List<Employee>> collect = employees.stream().collect(Collectors.partitioningBy(e -> e.getAge() >= 20));
        System.out.println(collect);
        //join
        String collect1 = employees.stream().map(Employee::getName).collect(Collectors.joining());
        String collect2 = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
        String collect3 = employees.stream().map(Employee::getName).collect(Collectors.joining(",", "^","$"));
        System.out.println(collect1);
        System.out.println(collect2);
        System.out.println(collect3);
    }

    /**
     * 并行流
     */
    @Test
    public void testparllen() {
        //串行流
        Instant now = Instant.now();
        long reduce = LongStream.rangeClosed(0, 100000000000L).reduce(0, Long::sum);
        Instant now1 = Instant.now();
        System.out.println(Duration.between(now, now1).getSeconds());
//        long reduce1 = LongStream.rangeClosed(0, 100000000000L).parallel().reduce(0, Long::sum);
//        Instant now2 = Instant.now();
//        System.out.println(Duration.between(now1, now2).getSeconds());

    }

}
