package com.cg.shop;

/**
 * Created by LalinPethiyagoda on 07/12/2017.
 */
public enum Fruit_Enum {
     APPLE(0.25) , ORANGE (0.50) ;

    private final double fruitPrice;

    Fruit_Enum(double fruitPrice) {
        this.fruitPrice = fruitPrice;
    }

    public double getFruitPrice() {
        return fruitPrice;
    }

}
