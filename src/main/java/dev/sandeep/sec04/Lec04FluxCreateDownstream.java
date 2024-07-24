package dev.sandeep.sec04;


import dev.sandeep.common.Util;
import dev.sandeep.sec01.subscriber.SubscriberImpl;
import org.reactivestreams.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateDownstream {

    private static final Logger log = LoggerFactory.getLogger(Lec04FluxCreateDownstream.class);

    public static void main(String[] args) {
        var subscriber = new SubscriberImpl();
        Flux.<String>create(fluxSink -> {
            for (int i = 0; i < 10; i++) {
                var name = Util.getFaker().name().firstName();
                log.info("emitting: {}", name);
                fluxSink.next(name);
            }
            fluxSink.complete();
        }).subscribe(subscriber);

        subscriber.getSubscription().cancel();

    }
}
