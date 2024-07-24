package dev.sandeep.sec02;


import org.reactivestreams.Subscriber;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("ball");

        mono.subscribe(
                item -> System.out.println("Received: " + item),
                System.err::println,
                () -> System.out.println("Completed bhai")
        );


    }

}

