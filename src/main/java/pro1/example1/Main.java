package pro1.example1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    // TODO 0: Označenou část kódu spusť vždy v novém vlákně, přístup k těmto
    //         tisíci vláknům uchovej pomocí seznamu "myThreads"
    // TODO 1: Zjisti, jaká hodnota "counter" se na konci metody vypíše
    // TODO 2: Zjisti (bez zásahu do kódu), kolik vláken bylo
    //         před výpisem ve stavu TERMINATED
    // TODO 3: Vyřeš problém zavoláním ____ pro každé vlákno
    // TODO 4: Zjisti opět, jaká hodnota "counter" se na konci metody vypíše
    // TODO 5: Vyřeš další problém

    static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        List<Thread> myThreads = new ArrayList<>();
        var lock = new Object();
        for(int i=0; i<1000; i++)
        {
            var t = new Thread(()->{
                // start thread
                for (int j=0; j<2000; j++) {
                    //synchronized (lock){
                    //    counter++;
                    //}
                    counter.incrementAndGet();
                }
                // end thread
            });
            myThreads.add(t);
            t.start();

        }
        for (var t: myThreads)
            t.join();
        System.out.println(counter);
    }
}