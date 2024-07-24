package dev.sandeep.sec03.assignment;

import dev.sandeep.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Generate10RandomFirstNames {
    public static void main(String[] args) {

        var flux = Flux.range(1, 10)
                .map(i -> Util.getFaker().name().firstName());

        flux.subscribe(Util.subscriber());
    }
}
