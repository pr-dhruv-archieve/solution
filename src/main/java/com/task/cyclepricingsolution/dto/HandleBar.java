package com.task.cyclepricingsolution.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mahendra Prajapati
 * @since 17-08-2020
 */

@NoArgsConstructor
@Data
public class HandleBar {
    private String material;
    private boolean ring;

    private Map<String, Double> priceMap;

    {
        priceMap = new HashMap<>();
        priceMap.put("steel", 15.0);
        priceMap.put("iron", 10.0);
    }

    public Double getHandleBarPrice() {
        return priceMap.getOrDefault(material, 0.0) + (ring ? 10.0 : 0.0);
    }
}
