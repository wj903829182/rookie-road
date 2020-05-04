package com.jack.rookiepractice.lambda;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author jack
 * @Classname LambdaTest1
 * Create by jack 2020/4/21
 * @date: 2020/4/21 21:22
 * @Description:
 */
public class LambdaTest1 {


    /**
     * 循环操作
     */
    public static void lambdaTest1() {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        //字符串数组转List
        List<String> players =  Arrays.asList(atp);
        // 以前的循环方式
        for (String player : players) {
            System.out.print(player + "; ");
        }
        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.println(player + "; "));
        // 在 Java 8 中使用双冒号操作符(double colon operator)
        //players.forEach(System.out::println);
    }

    /**
     * 匿名内部类
     */
    public static void lambdaTest2(){
        // 1.2使用 lambda expression
        //new Thread(() -> System.out.println("Hello world !")).start();
        // 2.1使用匿名内部类
        Runnable race1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello world !");
            }
        };
        // 2.2使用 lambda expression
        Runnable race2 = () -> System.out.println("Hello world !");
        // 直接调用 run 方法(没开新线程哦!)
        race1.run();
        race2.run();
    }


    /**
     * Lambdas排序集合
     */
    public static void lambdaTest3(){
        String[] players = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka", "David Ferrer",
                "Roger Federer", "Andy Murray",
                "Tomas Berdych", "Juan Martin Del Potro",
                "Richard Gasquet", "John Isner"};

         // 1.1 使用匿名内部类根据 name 排序 players
        Arrays.sort(players, (s1, s2) -> (s1.compareTo(s2)));
        System.out.println(JSONObject.toJSONString(players));

    }


    public static void main(String[] args) {
        lambdaTest3();
    }
}
