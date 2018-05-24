package com.csdn.test;

import com.csdn.java8.Employee;
import com.csdn.reflect.Person;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.SQLSyntaxErrorException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TestAll {
    @Test
    public void test() {
        System.out.println("hello, project!");
    }

    @Test
    public void testLinkedHashSet() {
        Set set = new LinkedHashSet();
        set.add("java");
        set.add("hello");
        set.add("set");
        set.add("world");
        System.out.println(set);

        List aList = new ArrayList(set);
        System.out.println(aList);

        System.out.println(set.iterator().next());
        System.out.println("*********************");
        List bList = new ArrayList();
        bList.add("hello");
        bList.add("hello");
        bList.add("hello");
        bList.add("world");
        System.out.println("bList: " + bList);
        Set Linked = new LinkedHashSet(bList);
        System.out.println("Linked: " + Linked);
    }

    @Test
    public void testListMap() {
        List<Map<String, String>> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Map map = new HashMap<>();
            map.put("key" + i, i);
            list.add(map);
        }
        System.out.println("list:" + list);
        for (Map<String, String> map : list) {
            if (map.get("key2") == null) {
                map.put("hello", "world");
            }
        }

        System.out.println("======================");
        System.out.println(list);


    }

    @Test
    public void testPattern() {
        //Pattern p = Pattern.compile("1[3|4|5|8][0-9]\\d{8}");
        Pattern p = Pattern.compile("1[34587][0-9]\\d{8}");
        Matcher matcher = p.matcher("hello, 17923398987 Wolrd");
        String s = null;
        if (matcher.find()) {
            System.out.println("------------");
            s = matcher.group(0);
            //System.out.println("group(1)=" + matcher.group(1));
        }
        System.out.println("group:" + s);


//        String line = "This order was placed for QT3000! OK?";
//        String pattern = "T(\\D*)(\\d+)(.*)";
//
//        // 创建 Pattern 对象
//        Pattern r = Pattern.compile(pattern);
//
//        // 现在创建 matcher 对象
//        Matcher m = r.matcher(line);
//        if (m.find( )) {
//            System.out.println("Found value: " + m.group() );
//            System.out.println("Found value: " + m.group(0) );
//            System.out.println("Found value: " + m.group(1) );
//            System.out.println("Found value: " + m.group(2) );
//            System.out.println("Found value: " + m.group(3) );
//        } else {
//            System.out.println("NO MATCH");
//        }


//        String str = "Hello,World! in Java.";
//        Pattern pattern = Pattern.compile("W(or)(ld!)");
//        Matcher matcher = pattern.matcher(str);
//        while(matcher.find()){
//            System.out.println("Group 0:"+matcher.group(0));//得到第0组——整个匹配
//            System.out.println("Group 1:"+matcher.group(1));//得到第一组匹配——与(or)匹配的
//            System.out.println("Group 2:"+matcher.group(2));//得到第二组匹配——与(ld!)匹配的，组也就是子表达式
//            System.out.println("Start 0:"+matcher.start(0)+" End 0:"+matcher.end(0));//总匹配的索引
//            System.out.println("Start 1:"+matcher.start(1)+" End 1:"+matcher.end(1));//第一组匹配的索引
//            System.out.println("Start 2:"+matcher.start(2)+" End 2:"+matcher.end(2));//第二组匹配的索引
//            System.out.println(str.substring(matcher.start(0),matcher.end(1)));//从总匹配开始索引到第1组匹配的结束索引之间子串——Wor
//        }
    }

    @Test
    public void testIdCard() {
        String text = "还是得返回 36072119920229613X erertre";

        Pattern p = Pattern.compile("([1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx])|([1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3})");
        Matcher matcher = p.matcher(text);
        if (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(2));
        }

    }

    @Test
    public void testEnum() {
        //System.out.println(ErrorEnum.COMMON_ERROR.getCode() + "=" + ErrorEnum.COMMON_ERROR.getMsg());
        GenericImpl.testMultiParam("sdf", "s12", "8888");
        String[] arrStr = {"123", "567"};
        String[] arr = new String[3];
        arr[0] = "dd";
        arr[1] = "cc";
        arr[2] = "ff";
        System.out.println(Arrays.asList(arr));
        GenericImpl.testMultiParam(arrStr);
    }

    @Test
    public void testByte() throws Exception {
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < 228264; i++) {
            sb.append("你");
        }

        String s = new String(sb);
        System.out.println(s.length());
        //System.out.println(sb);
        System.out.println(s.getBytes("utf-8").length);
        System.out.println(s.getBytes("gbk").length);
    }

    @Test
    public void testCalendar() throws Exception {
        Calendar calendar = Calendar.getInstance();

        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.YEAR));

        Integer i = 3;
        String ss = "3";
        Integer cc = Integer.valueOf(ss);
        System.out.println(cc.equals(i + 1));

    }

    @Test
    public void testJdk8() {

        List<Person> list = new LinkedList<>();
        Person person = new Person("张三", "男");
        Person person2 = new Person("张5", "女");
        Person person3 = new Person("张5", "女");
        Person person4 = new Person("张7", "男");
        Person person5 = new Person("张8", "男");

        list.add(person);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);

        Map<String, List<Person>> collect = list.stream().collect(Collectors.groupingBy(Person::getSex));

        for (Map.Entry<String, List<Person>> e : collect.entrySet()
                ) {
            if (e.getKey().equals("男")) {
                e.getValue();
                //System.out.println(e.getValue());
            }
            System.out.println(e.getValue());

        }

        TreeSet<Person> treeSet = new TreeSet<Person>(
                new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                }
        );
        treeSet.add(person);
        treeSet.add(person2);
        treeSet.add(person3);
        treeSet.add(person4);
        treeSet.add(person5);
        treeSet.stream().forEach(e-> System.out.println(e));
        //Java8 distinct(根据对象的属性去重)
        TreeSet<Person> collect1 = list.stream().collect(Collectors.toCollection(() -> new TreeSet<Person>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        })));
        System.out.println(collect1);

        TreeSet<Person> treeSet1 = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return 0;
            }
        });
    }

    @Test
    public void testddd() {
        String a = "dsfsd,";
        String b = "dsfs,";
        String c = "sfsf,";
        List<String> list = new ArrayList<>();

        list.add(a);
        list.add(b);
        list.add(c);
        System.out.println(list);

        //Spliterator<String> spliterator = list.sp
        System.out.println();

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
    }

    /**
     * 循环加入字符串，以-分隔，去除最后一个分隔符
     */
    @Test
    public void testContact() {
        Long start = new Date().getTime();

        //String str=new String();
        String str = "";

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            str += i + ",";
            //stringBuilder.append(i+",");
        }
        //System.out.println(stringBuilder);
        System.out.println(str);

        String substring = str.substring(0, str.length() - 1);
        System.out.println(substring);
        System.out.println("耗时：" + (System.currentTimeMillis() - start) + "毫秒");
    }

    @Test
    public void testCalendarAdd() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -5);
        System.out.println(calendar.getTime().toLocaleString());
    }

    @Test
    public void testJdk8ToflatMap() {
        //flatMap
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");
        words.add("java");
        System.out.println(words);
        List<String> collect = words.stream().flatMap(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(Collectors.toList());

        System.out.println(collect);
        System.out.println("==================");
        List<Boolean> java = words.stream().map(word -> (
                word.length() > 0
        )).collect(Collectors.toList());

        System.out.println(java);
        System.out.println("==================");
        List<String> collect2 = words.stream().map(word -> {
            if (word.length() > 4) {
                return word;
            } else {
                return null;
            }

        }).collect(Collectors.toList());
        System.out.println(collect2);
    }

    @Test
    public void testSuper() {
        List<? super String> string = new ArrayList<>();
        string.add("sdf");
        string.add(null);
        System.out.println(string);

        List<? extends String> string2 = new ArrayList<>();
        //string2.add("sdf");(会报错)
        string2.add(null);
        string.stream().collect(Collectors.toList());
    }

    @Test
    public void testJdk8Function() {
        Predicate<String> predicate = (s) -> s.length() > 0;

        boolean foo = predicate.test("foo");// true
        boolean foo1 = predicate.negate().test("foo");// false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;
        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        System.out.println(foo);

        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        String apply = backToString.apply("123");
        System.out.println(toInteger.apply("567") instanceof Integer);
        System.out.println(backToString.apply("1000") instanceof String);
    }

    @Test
    public void testJdk8parallelStream() {
        List<String> strings = Arrays.asList("hel", "world", "scala");

        Function<String, String> function = (e -> {
            if (e.length() > 3) {
                return e;
            } else {
                return null;
            }
        });
        //Object collect = strings.stream().flatMap(function).collect(Collectors.toList());
        // System.out.println(collect);
    }

    /**
     * 匹配中文字符
     */
    @Test
    public void testPatternChinese() {
        List<String> list = Arrays.asList("sdfksfkl", "，速度快附近的时空裂缝", "sfkjdsklfj-sdfk", "sdlfk，是的分开了惊世毒妃");

        Pattern pattern = Pattern.compile("[\\u4E00-\\u9FA5]");

        for (String s : list) {
            Matcher matcher = pattern.matcher(s);
            if (matcher.find()) {
                System.out.println(s);
            }
        }

    }

    @Test
    public void testByteLength() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("e:\\cc.txt"));
            String phone = properties.getProperty("phone");

            System.out.println(phone);
            System.out.println(phone.substring(0, 11));
            System.out.println("17621102655".substring(0, 11));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testIntrospector() throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(Employee.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            //System.out.println(propertyDescriptor);
            String name = propertyDescriptor.getName();
            System.out.println(name);
        }
    }

    @Test
    public void testConcurrentHashMap() {
        ConcurrentHashMap<Integer, String> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i = 0; i < 1000; i++) {
            concurrentHashMap.put(i, i + "," + i);
        }
        Set<Map.Entry<Integer, String>> entries = concurrentHashMap.entrySet();
        for (Map.Entry<Integer, String> e : entries) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }
    }

    @Test
    public void isListMap() {
        List<Map> list = new ArrayList<>();
        Map map = new LinkedHashMap();
        map.put("sdf", "dsf");
        list.add(map);
        Class<?> aClass = list.getClass();

        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            judgeFieldType(field);
        }
        String name = list.get(0).getClass().getName();
        System.out.println("name;"+name);
        System.out.println();
    }

    private static void judgeFieldType(Field field) {
        String name = field.getName();

        if (field.getGenericType() instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) field.getGenericType();

            //判断具体类的类型

            if (pt.getRawType().equals(List.class)) {

                // 判断泛型类的类型
                if (pt.getActualTypeArguments()[0].equals(String.class)) {
                    System.out.println(name + " is List<String>;");
                } else if (pt.getActualTypeArguments()[0].equals(int.class)
                        || pt.getActualTypeArguments()[0].equals(Integer.class)) {
                    System.out.println(name + " is List<int>;");
                }  else if (pt.getActualTypeArguments()[0].equals(Map.class)) {
                    System.out.println("map");
                }
            }
        } else if (field.getGenericType().equals(String.class)) {
            System.out.println(name + " is String;");
        } else if (field.getGenericType().equals(int.class) || field.getGenericType().equals(Integer.class)) {
            System.out.println(name + " is int;");
        }


    }

    @Test
    public void testReplace() {
        String ss = "收到了分开235sf";
        boolean dd = ss.matches("收到了");

        System.out.println(dd);

        String s1 = ss.replaceAll("235sf", "");
        String s = s1.replaceAll("235", "");
        System.out.println(s);

    }
}
