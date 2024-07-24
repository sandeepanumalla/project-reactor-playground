package dev.sandeep.sec04;

import dev.sandeep.common.Util;
import dev.sandeep.sec04.helper.NameGenerator;
import reactor.core.publisher.Flux;

import java.util.stream.IntStream;

public class Lec02FluxCreateRefactor {
    public static void main(String[] args) {
        var generator = new NameGenerator();
        var flux = Flux.create(generator);
        flux.subscribe(Util.subscriber());

        for (int i = 0; i < 10; i++) {
            generator.generate();
        }
    }
}
