package dev.sandeep.sec04;

import dev.sandeep.common.Util;
import reactor.core.publisher.Flux;

public class Lec06FluxCreate {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            synchronousSink.next(1);
            synchronousSink.complete();
        }).subscribe(Util.subscriber());
    }
}
