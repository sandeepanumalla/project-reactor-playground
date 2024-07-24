package dev.sandeep.sec02;

import dev.sandeep.common.Util;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyError {
    public static void main(String[] args) {
        getUsername(1)
                .subscribe(
                        s -> System.out.println(s),
                        err -> {}
                        ,
                        () -> System.out.println("Completed")
                );
    }

    private static Mono<String> getUsername(int userId) {
        return switch (userId) {
            case 1 -> Mono.just("Sandeep");
            case 2 -> Mono.empty();
            default -> Mono.error(new RuntimeException("Not found"));
        };
    }
}
