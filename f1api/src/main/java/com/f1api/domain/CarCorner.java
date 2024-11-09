package com.f1api.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.f1api.util.Constants;
import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarCorner implements Serializable {
    private BigDecimal rl;

    private BigDecimal rr;

    private BigDecimal fl;

    private BigDecimal fr;

    @JsonCreator
    public CarCorner(List<BigDecimal> temperatures) {
        if (temperatures != null && temperatures.size() == 4) {
            this.rl = temperatures.get(Constants.CornerSides.RL);
            this.rr = temperatures.get(Constants.CornerSides.RR);
            this.fl = temperatures.get(Constants.CornerSides.FL);
            this.fr = temperatures.get(Constants.CornerSides.FR);
        } else {
            throw new IllegalArgumentException("Expected a list with exactly 4 elements for brakesTemperature");
        }
    }
}
