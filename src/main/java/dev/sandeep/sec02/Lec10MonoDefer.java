package dev.sandeep.sec02;

import dev.sandeep.common.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Lec10MonoDefer {
    private static final Logger log = LoggerFactory.getLogger(Lec10MonoDefer.class);

    public static void main(String[] args) {

    }

    private static int sum(List<Integer> list) {
        Util.sleep(1);
        return list.stream().mapToInt(i -> i).sum();
    }
}
