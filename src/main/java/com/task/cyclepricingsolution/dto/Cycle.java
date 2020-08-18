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

    @JsonProperty("wheels")
    public Wheel wheels;

    @JsonProperty("chain")
    public Chain chain;

    // Final Price of the Cycle
    public double getCyclePrice() {
        return frame.getFramePrice() + handleBar.getHandleBarPrice() + seat.getSeatPrice() + wheels.getWheelPrice() + chain.getChainPrice();
    }


}
