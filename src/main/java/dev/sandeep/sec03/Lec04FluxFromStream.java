package dev.sandeep.sec03;

import dev.sandeep.common.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec04FluxFromStream {
    public static void main(String[] args) {
        var list = List.of(1, 2, 3, 4, 5);
        var stream = list.stream();

        var flux = Flux.fromStream(list::stream);
//
        flux.subscribe(Util.subscriber("sub1"));
        flux.subscribe(Util.subscriber("sub2"));


//        stream.forEach(System.out::println);
//        stream.forEach(System.out::println);



    }
}
