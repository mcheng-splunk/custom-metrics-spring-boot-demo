package de.mokkapps.custommetricsdemo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import io.micrometer.core.instrument.Metrics;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

  private final AtomicInteger testGauge;
  private final Counter testCounter;
  private final Counter myCounter;

  public Scheduler(MeterRegistry meterRegistry) {
    // Counter vs. gauge, summary vs. histogram
    // https://prometheus.io/docs/practices/instrumentation/#counter-vs-gauge-summary-vs-histogram
    //testGauge = meterRegistry.gauge("custom_gauge", new AtomicInteger(0));
    testGauge = Metrics.gauge("mcheng.gauge.total_clicks", new AtomicInteger(0));
    testCounter = Metrics.counter("mcheng.count.accept_clicks");
    myCounter = Metrics.counter("mcheng_count.cancel_clicks");
  }

  @Scheduled(fixedRateString = "1000", initialDelayString = "0")
  public void schedulingTask() {
    testGauge.set(Scheduler.getRandomNumberInRange(0, 100));

    testCounter.increment();
    myCounter.increment();
  }

  private static int getRandomNumberInRange(int min, int max) {
    if (min >= max) {
      throw new IllegalArgumentException("max must be greater than min");
    }

    Random r = new Random();
    return r.nextInt((max - min) + 1) + min;
  }
}
