package com.f1api.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Corner implements Serializable {
    private BigDecimal rl;

    private BigDecimal rr;

    private BigDecimal fl;

    private BigDecimal fr;
}
