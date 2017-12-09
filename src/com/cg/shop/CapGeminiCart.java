package com.cg.shop;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by LalinPethiyagoda on 09/12/2017.
 */
public class CapGeminiCart {

    private List<String> itemsList =null;

    Fruit_Enum appleCost = Fruit_Enum.APPLE;
    Fruit_Enum orangeCost = Fruit_Enum.ORANGE;

    BigDecimal appleUnitCost = new BigDecimal(appleCost.getFruitPrice());
    BigDecimal orangeUnitCost = new BigDecimal(orangeCost.getFruitPrice());


    private long totalAppleCount =0;

    private long totalOrangeCount =0;


    public CapGeminiCart(List cartItems){
        this.itemsList = cartItems;
        this.totalAppleCount =itemsList
                .stream()
                .filter(fruit->"apple".equalsIgnoreCase(fruit))
                .count();

        this.totalOrangeCount =itemsList
                .stream()
                .filter(fruit->"orange".equalsIgnoreCase(fruit))
                .count();

    }

    public void setTotalOrangeCount(long totalOrangeCount) {
        this.totalOrangeCount = totalOrangeCount;
    }


    public long getTotalAppleCount() {
        return totalAppleCount;
    }

    public void setTotalAppleCount(long totalAppleCount) {
        this.totalAppleCount = totalAppleCount;
    }

    public long getTotalOrangeCount() {
        return totalOrangeCount;
    }

    public BigDecimal getCartTotal(){
        return getTotalCostOfApples().add(getTotalCostOfOranges());
    }

    public BigDecimal getTotalCostOfApples(){

        applyAppleOffer();

        return appleUnitCost.multiply(BigDecimal.valueOf(getTotalAppleCount()));
    }

    public BigDecimal getTotalCostOfOranges(){

        applyOrangeOffer();

        return orangeUnitCost.multiply(BigDecimal.valueOf(getTotalOrangeCount()));
    }

    public void applyAppleOffer(){
        long appleCounter =0;
        long reminaingApplesAfterDiscount =0;

        if(getTotalAppleCount()%2==0){
            setTotalAppleCount(getTotalAppleCount()/2);
        }
        else {
            for (int i = 1; i <= getTotalAppleCount(); i++) {
                if (i % 2 == 0) {
                    appleCounter++;
                }
            }
        }
        reminaingApplesAfterDiscount = getTotalAppleCount()%2;
        setTotalAppleCount(appleCounter + reminaingApplesAfterDiscount);
    }

    public void applyOrangeOffer(){
        long orangeCounter =0;
        long remainingOrangesAfterDiscount = 0;
        if(getTotalOrangeCount()%3==0){
            setTotalOrangeCount(getTotalOrangeCount()*2/3);
        }
        else {
            for (int i = 1; i <= getTotalOrangeCount(); i++) {
                if (i % 3 == 0) {
                    orangeCounter += 2;
                }
            }
        }
        remainingOrangesAfterDiscount = getTotalOrangeCount()%3 ;

        setTotalOrangeCount(orangeCounter + remainingOrangesAfterDiscount);
    }

}
