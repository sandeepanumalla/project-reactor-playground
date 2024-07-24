package dev.sandeep.sec04;

import dev.sandeep.common.Util;
import reactor.core.publisher.Flux;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Lec01FluxCreate {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            String country;
            do {
                country = Util.getFaker().country().name();
                System.out.println("Emitting: " + country);
                fluxSink.next(country);
            } while (!country.equalsIgnoreCase("canada"));
            fluxSink.complete();
        })
                .subscribe(Util.subscriber())
        ;
    }
}
