package com.cg.shop;

import java.math.BigDecimal;

/**
 * Created by LalinPethiyagoda on 10/09/2018.
 */
public enum Fruit_Enum {
     APPLE(0.25) , ORANGE (0.60) , BANANA(0.70);

    private final double fruitPrice;

    Fruit_Enum(double fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    public BigDecimal getFruitPrice() {
        return new BigDecimal(fruitPrice);
    }

}
