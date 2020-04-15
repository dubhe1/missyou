package com.missyou.optional;


import org.junit.Test;

import java.util.Optional;

public class OptionalTest {
    @Test
    public void testOptional() {
        Optional<String> empty = Optional.empty();
//        Optional<String> t1 = Optional.of(null);
        Optional<String> t2 = Optional.ofNullable("a");
//        empty.get();
//        return empty;
//        String s = t2.get();
        t2.ifPresent(System.out::println);

        String s = t2.orElse("默认值");
        System.out.println(s);

        t2.map(t -> t + "b").ifPresent(System.out::println);

//        t2.ifPresentOrElse
//                t2.or
//                        t2.stream
//        t2.filter()
//        System.out.println(s1);

//        consumer supplier runnable function predicate

//        t2.or
//        if(t2){
//            s = t2.get()
//        }
//        else{
//            s = "默认值"
//        }

    }
}
