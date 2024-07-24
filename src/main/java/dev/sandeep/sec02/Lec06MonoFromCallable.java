package dev.sandeep.sec02;

import dev.sandeep.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec06MonoFromCallable {

    private static final Logger log = LoggerFactory.getLogger(Lec05MonoFromSupplier.class);

    public static void main(String[] args) {
        Mono.fromCallable(() -> sum(List.of(1, 3, 5, 7)))
                .subscribe(
                        Util.subscriber()
                );
    }

    private static int sum(List<Integer> list) throws Exception {
        log.info("finding sum of {}", list);
        return list.stream().mapToInt(i -> i).sum();
    }
}
