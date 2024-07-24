package dev.sandeep.sec02;


import dev.sandeep.sec01.subscriber.SubscriberImpl;
import reactor.core.publisher.Mono;

public class Lec02MonoJust {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("ball");

        var subscriber = new SubscriberImpl();
        mono.subscribe(subscriber);

        subscriber.getSubscription().request(10);

        subscriber.getSubscription().request(10);
        subscriber.getSubscription().cancel();
    }
}
