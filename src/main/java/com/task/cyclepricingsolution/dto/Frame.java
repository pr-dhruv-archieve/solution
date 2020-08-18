package com.task.cyclepricingsolution.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mahendra Prajapati
 * @since 17-08-2020
 */

@NoArgsConstructor
@Data
public class Frame {
    private String material;

    private Map<String, Double> framePriceList;

    {
        framePriceList = new HashMap<>();
        framePriceList.put("Steel", 12.0);
        framePriceList.put("iron", 10.0);
    }
    public Double getFramePrice() {
        return framePriceList.getOrDefault("material", 0.0);
    }
}
