package com.jack.rookiepractice.guava;

import com.google.common.base.Optional;

/**
 * @author jack
 * @Classname GuavaTest
 * Create by jack 2020/4/21
 * @date: 2020/4/21 22:30
 * @Description:
 */
public class GuavaTest {
    public static void main(String[] args) {
        /*Optional<Integer> possible = Optional.of(5);
        possible.isPresent(); // returns true`
        possible.get(); // returns 5`
        Optional<Integer> p1=Optional.absent();*/

        Optional<Integer> possible = Optional.absent();;
        System.out.println(possible.orNull());
    }
}
