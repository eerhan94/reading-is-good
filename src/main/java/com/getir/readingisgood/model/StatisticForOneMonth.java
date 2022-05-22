package com.getir.readingisgood.model;

/**
 * The type Statistic for one month. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
public class StatisticForOneMonth {
  private String month;
  private int totalOrderCount;
  private int totalBookCount;
  private double totalPurchasedAmount;

  /**
   * Gets month.
   *
   * @return the month
   */
public String getMonth() {
    return month;
  }

  /**
   * Sets month.
   *
   * @param month the month
   */
public void setMonth(String month) {
    this.month = month;
  }

  /**
   * Gets total order count.
   *
   * @return the total order count
   */
public int getTotalOrderCount() {
    return totalOrderCount;
  }

  /**
   * Sets total order count.
   *
   * @param totalOrderCount the total order count
   */
public void setTotalOrderCount(int totalOrderCount) {
    this.totalOrderCount = totalOrderCount;
  }

  /**
   * Gets total book count.
   *
   * @return the total book count
   */
public int getTotalBookCount() {
    return totalBookCount;
  }

  /**
   * Sets total book count.
   *
   * @param totalBookCount the total book count
   */
public void setTotalBookCount(int totalBookCount) {
    this.totalBookCount = totalBookCount;
  }

  /**
   * Gets total purchased amount.
   *
   * @return the total purchased amount
   */
public double getTotalPurchasedAmount() {
    return totalPurchasedAmount;
  }

  /**
   * Sets total purchased amount.
   *
   * @param totalPurchasedAmount the total purchased amount
   */
public void setTotalPurchasedAmount(double totalPurchasedAmount) {
    this.totalPurchasedAmount = totalPurchasedAmount;
  }

  @Override
  public String toString() {
    return "StatisticForOneMonth{"
        + "month='"
        + month
        + '\''
        + ", totalOrderCount="
        + totalOrderCount
        + ", totalBookCount="
        + totalBookCount
        + ", totalPurchasedAmount="
        + totalPurchasedAmount
        + '}';
  }
}
