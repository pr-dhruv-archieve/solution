package com.task.cyclepricingsolution.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mahendra Prajapati
 * @since 17-08-2020
 */

@NoArgsConstructor
@Data
public class Wheel {
    private String spokesType;
    private Integer numberOfSpokes;
    private Double rimThickness;
    private String rimType;
    private String tireType;

    private Map<String, Double> spokePriceMap;
    private Map<String, Double> rimPriceMap;
    private Map<String, Double> tirePriceMap;

    {
        spokePriceMap = new HashMap<>();
        spokePriceMap.put("steel", 10.0);
        spokePriceMap.put("iron", 6.0);

        rimPriceMap = new HashMap<>();
        rimPriceMap.put("Steel", 10.0);
        rimPriceMap.put("iron", 6.0);

        tirePriceMap = new HashMap<>();
        tirePriceMap.put("tubeless", 230.0);
        tirePriceMap.put("tube", 200.0);

    }

    public Double getWheelPrice() {
        int monthValue = LocalDate.now().getMonthValue();
        Double finalWheelPrice = numberOfSpokes * spokePriceMap.getOrDefault(spokesType, 0.0)
                + rimThickness * rimPriceMap.getOrDefault(rimType, 0.0)
                + tirePriceMap.getOrDefault(tireType, 0.0);
        if(monthValue <= 11 && monthValue >= 1)
            finalWheelPrice += 20;
        else
            finalWheelPrice += 30;
        return finalWheelPrice;
    }
}
