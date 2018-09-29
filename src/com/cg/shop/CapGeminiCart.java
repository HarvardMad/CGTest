package com.cg.shop;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by LalinPethiyagoda on 10/09/2018.
 */
public class CapGeminiCart {

  private List<String> itemsList = null;

  Fruit_Enum appleCost = Fruit_Enum.APPLE;
  Fruit_Enum orangeCost = Fruit_Enum.ORANGE;
  Fruit_Enum bananaCost = Fruit_Enum.BANANA;


  BigDecimal appleUnitCost = appleCost.getFruitPrice().setScale(2, BigDecimal.ROUND_CEILING);
  BigDecimal orangeUnitCost = orangeCost.getFruitPrice().setScale(2, BigDecimal.ROUND_CEILING);
  BigDecimal bananaUnitCost = bananaCost.getFruitPrice().setScale(2, BigDecimal.ROUND_CEILING);


  private long totalAppleCount = 0;

  private long totalOrangeCount = 0;

  private long totalBananaCount = 0;


  public CapGeminiCart(List cartItems) {
    this.itemsList = cartItems;
    this.totalAppleCount = itemsList
        .stream()
        .filter(fruit -> "apple".equalsIgnoreCase(fruit))
        .count();

    this.totalOrangeCount = itemsList
        .stream()
        .filter(fruit -> "orange".equalsIgnoreCase(fruit))
        .count();

    this.totalBananaCount = itemsList
        .stream()
        .filter(fruit -> "banana".equalsIgnoreCase(fruit))
        .count();

  }

  public long getTotalBananaCount() {
    return totalBananaCount;
  }

  public void setTotalBananaCount(long totalBananaCount) {
    this.totalBananaCount = totalBananaCount;
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

  public BigDecimal getCartTotal() {

    return getTotalCostOfApples().add(getTotalCostOfOranges()).add(getTotalCostOfBananas());
  }

  public BigDecimal getTotalCostOfApples() {

    applyAppleOffer();

    return appleUnitCost.multiply(BigDecimal.valueOf(getTotalAppleCount())).setScale(2, BigDecimal.ROUND_CEILING);
  }

  public BigDecimal getTotalCostOfOranges() {

    applyOrangeOffer();

    return orangeUnitCost.multiply(BigDecimal.valueOf(getTotalOrangeCount())).setScale(2, BigDecimal.ROUND_CEILING);
  }

  public BigDecimal getTotalCostOfBananas() {

    applyBananaOffer();

    return bananaUnitCost.multiply(BigDecimal.valueOf(getTotalBananaCount())).setScale(2, BigDecimal.ROUND_CEILING);
  }

  public void applyAppleOffer() {
    long appleCounter = 0;
    long reminaingApplesAfterDiscount = 0;

    if (getTotalAppleCount() % 2 == 0) {
      setTotalAppleCount(getTotalAppleCount() / 2);
    } else {
      for (int i = 1; i <= getTotalAppleCount(); i++) {
        if (i % 2 == 0) {
          appleCounter++;
        }
      }
    }
    reminaingApplesAfterDiscount = getTotalAppleCount() % 2;
    setTotalAppleCount(appleCounter + reminaingApplesAfterDiscount);
  }

  public void applyOrangeOffer() {
    long orangeCounter = 0;
    long remainingOrangesAfterDiscount = 0;
    if (getTotalOrangeCount() % 3 == 0) {
      setTotalOrangeCount(getTotalOrangeCount() * 2 / 3);
    } else {
      for (int i = 1; i <= getTotalOrangeCount(); i++) {
        if (i % 3 == 0) {
          orangeCounter += 2;
        }
      }
    }
    remainingOrangesAfterDiscount = getTotalOrangeCount() % 3;

    setTotalOrangeCount(orangeCounter + remainingOrangesAfterDiscount);
  }

  //happy path babanans only
  public void applyBananaOffer() {
    long bananaCounter = 0;
    long remainingBananasAfterDiscount = 0;
    if (getTotalOrangeCount() % 3 == 0) {
      setTotalOrangeCount(getTotalOrangeCount() * 2 / 3);
    } else {
      for (int i = 1; i <= getTotalOrangeCount(); i++) {
        if (i % 3 == 0) {
          bananaCounter += 2;

        }
      }
    }
    remainingBananasAfterDiscount = getTotalBananaCount() % 3;

    setTotalBananaCount(remainingBananasAfterDiscount + remainingBananasAfterDiscount);
  }

  public void applyOrangeBananaDiscount() {
    // three for two on bananas and oranges cheapest item free
    //4 b and 3 o
    long bananaCounter = 0;
    long orangeCounter =0;

    long bananaCount = getTotalBananaCount();
    long orangeCount = getTotalOrangeCount();

    long totalOrangesAndBananas = bananaCount + orangeCount;

    if (orangeCount == 0) {
      applyBananaOffer();
    } else if (bananaCount == 0) {
      applyOrangeOffer();
    } else {
      for (long i = 1; i <= bananaCount; i++) {
        if (i % 3 == 0) {
          bananaCounter +=2;
        }
      }
      long totalBananasAndOrangesForFullPay = bananaCount + orangeCount;


    }
  }

}
