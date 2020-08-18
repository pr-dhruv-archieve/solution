package com.task.cyclepricingsolution.service;

import com.task.cyclepricingsolution.dto.Cycle;

import java.util.Map;
import java.util.concurrent.BlockingQueue;

public class ResultConsumer implements Runnable {
    private BlockingQueue<Cycle> numbersQueue;
    Map<String, Double> cyclePrice ;

    public ResultConsumer(BlockingQueue<Cycle> numbersQueue,Map<String, Double> cyclePrice) {
        this.numbersQueue = numbersQueue;
        this.cyclePrice = cyclePrice;
    }
    public void run() {
        try {
            generateResult();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void generateResult() throws InterruptedException {
        Cycle result = numbersQueue.take();
        cyclePrice.put(Thread.currentThread().getName().toLowerCase(),result.getCyclePrice());
    }

}