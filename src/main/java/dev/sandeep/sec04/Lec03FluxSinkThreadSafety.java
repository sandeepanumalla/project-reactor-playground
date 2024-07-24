package dev.sandeep.sec04;

import dev.sandeep.common.Util;
import dev.sandeep.sec04.helper.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

import java.util.ArrayList;

public class Lec03FluxSinkThreadSafety {
//    private static final Logger log = LoggerFactory.getLogger(Lec03FluxSinkThreadSafety.class);
//
//    public static void main(String[] args) {
//        demo2();
//    }
//
//    private static void demo() {
//        var list = new ArrayList<>();
//
//        Runnable runnable = () -> {
//            for (int i = 0; i < 1000; i++) {
//                list.add(i);
//            }
//        };
//        for(int i = 0; i < 10; i++) {
//            Thread.ofPlatform().start(runnable);
//        }
//        Util.sleep(1);
//        log.info("list size: {}", list.size());
//    }
//
//    public static void demo2() {
//        var list = new ArrayList<String>();
//        var generator = new NameGenerator();
//        var flux = Flux.create(generator);
//        flux.subscribe(list::add);
//
//        Runnable  runnable = () -> {
//            for (int i = 0; i < 1000; i++) {
//                generator.generate();
//            }
//        };
//        for(int i = 0; i < 10; i++) {
//            Thread.ofPlatform().start(runnable);
//        }
//        Util.sleep(1);
//        log.info("list size with thread safety: {}", list.size());
//
//
//
//    }

    private static final Logger log = LoggerFactory.getLogger(Lec03FluxSinkThreadSafety.class);

    public static void main(String[] args) {

        demo2();

    }

    // arraylist is not thread safe
    private static void demo1(){
        var list = new ArrayList<Integer>();
        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(runnable);
        }
        Util.sleep(3);
        log.info("list size: {}", list.size());
    }

    // arraylist is not thread safe.
    // flux sink is thread safe. we get all the 10000 items safely into array list
    private static void demo2(){
        var list = new ArrayList<String>();
        var generator = new NameGenerator();
        var flux = Flux.create(generator);
        flux.subscribe(list::add);

        Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                generator.generate();
            }
        };
        for (int i = 0; i < 10; i++) {
            Thread.ofPlatform().start(runnable);
        }
        Util.sleep(10);
        log.info("list size: {}", list.size());
    }
}
