package dev.sandeep.sec02;


import dev.sandeep.common.Util;
import org.reactivestreams.Subscriber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public class Lec07MonoFromRunnable {

    private static final Logger log = LoggerFactory.getLogger(Lec05MonoFromSupplier.class);

    public static void main(String[] args) {
        getProduct(2)
                .subscribe(Util.subscriber());

    }

    private static Mono<String> getProduct(int productId) {
        if(productId == 1) {
            return Mono.fromSupplier(() -> Util.getFaker().commerce().productName());
        }
        return Mono.fromRunnable(() -> notifyBusiness(productId));
    }

    private static void notifyBusiness(int productId) {
        log.info("Notifying business on unavailable product");
    }
}
