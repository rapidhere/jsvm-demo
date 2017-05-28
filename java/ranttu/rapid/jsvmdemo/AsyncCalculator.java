package ranttu.rapid.jsvmdemo;

import ranttu.rapid.jsvm.runtime.async.FuturePromise;
import ranttu.rapid.jsvmnode.WorkingPool;

import java.util.Random;

// a async calculator
public class AsyncCalculator {
    private Random rand = new Random();

    public FuturePromise calc(String a, String b) {
        return WorkingPool.submit(() -> {
            double va = Double.valueOf(a);
            double vb = Double.valueOf(b);

            Thread.sleep(100 + rand.nextInt(300));

            return va + vb;
        });
    }
}
