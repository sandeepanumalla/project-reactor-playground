package dev.sandeep.sec03;

import dev.sandeep.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec03FluxFromIterableOrArray {
    public static void main(String[] args) {
        var flux = Flux.fromIterable(List.of("A", "B", "C", "D", "E"));

        flux.subscribe(
            Util.subscriber("sub1")
        );
    }
}
