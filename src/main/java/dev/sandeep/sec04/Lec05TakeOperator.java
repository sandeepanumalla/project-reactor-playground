package dev.sandeep.sec04;

import dev.sandeep.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;

public class Lec05TakeOperator {
    private static final Logger log = LoggerFactory.getLogger(Lec05TakeOperator.class);

    public static void main(String[] args) {
//        Flux.range(1 ,10)
//                .log("before")
//                .take(3)
//                .log("after")
//                .subscribe(Util.subscriber());


//        Flux.range(1, 10)
//                .log("before")
//                .takeWhile(i -> i < 5)
//                .log("after")
//                .subscribe(Util.subscriber());

        Flux.range(1, 10)
                .log("before")
                .takeUntil(i -> i == 5)
                .log("after")
                .subscribe(Util.subscriber());

    }
}
