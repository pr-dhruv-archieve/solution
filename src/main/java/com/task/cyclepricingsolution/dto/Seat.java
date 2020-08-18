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
public class Seat {
    private String material;

    private Map<String, Double> priceMap;
    {
        priceMap = new HashMap<>();;
        priceMap.put("rubber", 20.0);
        priceMap.put("leather", 30.0);
    }

    public Double getSeatPrice() {
        return priceMap.getOrDefault(material, 0.0);
    }
}
