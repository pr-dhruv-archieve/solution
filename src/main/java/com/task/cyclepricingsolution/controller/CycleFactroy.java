package com.task.cyclepricingsolution.controller;

import com.task.cyclepricingsolution.dto.Cycle;
import com.task.cyclepricingsolution.service.CycleBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mahendra Prajapati
 * @since 18-08-2020
 */

@RestController
public class CycleFactroy {

    @Autowired
    private CycleBuilder cycleBuilder;

    @PostMapping("/getCyclePrice")
    public ResponseEntity<?> getCyclesPrice(@RequestBody Cycle[] cycles) {
        return new ResponseEntity<>(cycleBuilder.getCyclePrice(cycles), HttpStatus.OK);
    }

}
