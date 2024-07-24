package dev.sandeep.sec03;

import dev.sandeep.common.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {
    public static void main(String[] args) {
        Flux.range(1, 10)
                .subscribe(Util.subscriber());
    }
}
