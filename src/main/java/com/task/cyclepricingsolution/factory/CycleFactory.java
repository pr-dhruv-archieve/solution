package com.task.cyclepricingsolution.factory;

import com.task.cyclepricingsolution.dto.Cycle;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Mahendra Prajapati
 * @since 18-08-2020
 */
public class CycleFactory implements Serializable, Cloneable {

    private static volatile CycleFactory cycleFactory;

    private CycleFactory() {
        super();
    }

    public static CycleFactory getCycleFactory() {
        if(cycleFactory == null) {
            synchronized (CycleFactory.class) {
                if( cycleFactory == null)
                    cycleFactory = new CycleFactory();
            }
        }
        return cycleFactory;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not supported");
    }

    protected Object readResolve() {
        return cycleFactory;
    }

    public Map<String, Double> getCyclePrice(Cycle[] cycles) {
        return null;
    }


}
