package com.task.cyclepricingsolution.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mahendra Prajapati
 * @since 17-08-2020
 */
@NoArgsConstructor
@Data
public class Chain {
    private boolean containsGears;
    private Integer numberOfGears;

    public Double getChainPrice() {
        if(containsGears)
            return 20.0;
        else
            return numberOfGears * 25.0;
    }

}
