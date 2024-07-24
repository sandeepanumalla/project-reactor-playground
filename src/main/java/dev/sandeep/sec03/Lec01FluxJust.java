package dev.sandeep.sec03;

import dev.sandeep.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec01FluxJust {
    private static final Logger logger = LoggerFactory.getLogger(Lec01FluxJust.class);
    public static void main(String[] args) {
        var flux = Flux.just("A", "B", "C", "D", "E");



        flux.subscribe(Util.subscriber("sub1"));
    }
}
