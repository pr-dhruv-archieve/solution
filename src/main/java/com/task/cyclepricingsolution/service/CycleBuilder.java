package com.task.cyclepricingsolution.service;

import com.task.cyclepricingsolution.dto.Cycle;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Mahendra Prajapati
 * @since 18-08-2020
 */

@Service
public class CycleBuilder {

    public ConcurrentMap<String, Double> getCyclePrice(Cycle[] cycles) {
        ConcurrentMap<String, Double> cyclePrice = new ConcurrentHashMap<>();
        BlockingQueue<Cycle> queue = new LinkedBlockingQueue<>(10);

        for (int i = 0; i < cycles.length; i++) {
            new Thread( new ResultProducer(queue,cycles[i])).start();
            new Thread( new ResultConsumer(queue, cyclePrice)).start();
        }
/*
        for (int j = 0; j < cycles.length; j++) {

        }
*/
        return  cyclePrice;
    }

}
