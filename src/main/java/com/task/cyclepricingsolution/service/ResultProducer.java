package com.task.cyclepricingsolution.service;

import com.task.cyclepricingsolution.dto.Cycle;

import java.util.concurrent.BlockingQueue;

public class ResultProducer implements  Runnable{

    private BlockingQueue<Cycle> numbersQueue;
    Cycle cycle;
    public ResultProducer(BlockingQueue<Cycle> numbersQueue, Cycle cycle) {
        this.numbersQueue = numbersQueue;
        this.cycle = cycle;
    }
    public void run() {
        try {
            generateCycle();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void generateCycle() throws InterruptedException {
        numbersQueue.put(cycle);
    }
}