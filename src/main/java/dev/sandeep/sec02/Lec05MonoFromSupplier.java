package dev.sandeep.sec02;

import dev.sandeep.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

import java.util.List;

public class Lec05MonoFromSupplier {
    private static final Logger log = LoggerFactory.getLogger(Lec05MonoFromSupplier.class);
    public static void main(String[] args) {

        Mono.fromSupplier(() -> {
                    try {
                        return sum(List.of(1, 3, 5, 7));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .subscribe(
                        Util.subscriber()
                );


    }

    private static int sum(List<Integer> list) throws Exception {
        log.info("finding sum of {}", list);
        return list.stream().mapToInt(i -> i).sum();
    }
}
