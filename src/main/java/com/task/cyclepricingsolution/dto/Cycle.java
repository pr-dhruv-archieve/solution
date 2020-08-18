package com.task.cyclepricingsolution.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Mahendra Prajapati
 * @since 18-08-2020
 */

@NoArgsConstructor
@Data
public class Cycle {
    // High level Design
    @JsonProperty("frame")
    public Frame frame;

    @JsonProperty("handleBar")
    public HandleBar handleBar;

    @JsonProperty("seat")
    public Seat seat;

    @JsonProperty("wheel")
    public Wheel wheel;

    @JsonProperty("chain")
    public Chain chain;

    // Final Price of the Cycle
    public double getCyclePrice() {
        Double price = 0.0;
        if(frame != null)
            price += frame.getFramePrice();
        if(handleBar != null)
            price += handleBar.getHandleBarPrice();
        if(seat != null)
            price += seat.getSeatPrice();
        if(wheel != null)
            price += wheel.getWheelPrice();
        if(chain != null)
            price += chain.getChainPrice();
        return price;
    }


}
