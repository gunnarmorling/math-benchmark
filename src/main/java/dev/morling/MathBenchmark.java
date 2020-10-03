/*
 * Copyright Gunnar Morling.
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */
package dev.morling;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.infra.Blackhole;

public class MathBenchmark {

    public static void main(String[] args) {
        double res = Math.log(Double.MAX_VALUE);
        System.out.println(res);

        res = Math.exp(40);
        System.out.println(res);
        System.out.println(Double.MAX_VALUE);
    }



    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OperationsPerInvocation(100)
    public void log(Blackhole blackhole) {
        for (int i = 0; i < 100; i++) {
            blackhole.consume(Math.log(i));
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OperationsPerInvocation(100)
    public void exp(Blackhole blackhole) {
        for (int i = 0; i < 100; i++) {
            blackhole.consume(Math.exp(i));
        }
    }
}
