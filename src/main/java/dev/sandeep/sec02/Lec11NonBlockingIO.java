package dev.sandeep.sec02;

import dev.sandeep.common.Util;
import dev.sandeep.sec03.client.ExternalServiceClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.IntStream;

public class Lec11NonBlockingIO {
    private static final Logger logger = LoggerFactory.getLogger(Lec11NonBlockingIO.class);

    public static void main(String[] args) {

        var client = new ExternalServiceClient();

        logger.info("Starting");

        IntStream.range(1, 5)
                .forEach(i -> client.getProductName(i)
                        .subscribe(Util.subscriber()));


        Util.sleep(2);
    }
}
