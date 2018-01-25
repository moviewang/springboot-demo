package java8.function;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by Movie on 2017/11/10.
 */
public class FunctionDemo {
    public static void modifyVal(int val, Function<Integer, Integer> function) {
        int newVal = function.apply(val);
        System.out.println("new val:" + newVal);
    }


    public static void main(String[] args) {
        int incr = 10;
        int num = 20;
        modifyVal(num, val -> val + incr);
        modifyVal(num, val -> val * 10);


        Student stu = new Student(null, null, null);
        System.out.println(stu);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(i + "");
        }

        List<String> collect = list.stream().limit(20).collect(Collectors.toList());
        System.out.println(collect.toString());
        try {
            System.out.println(URLEncoder.encode("描述" ,"utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
