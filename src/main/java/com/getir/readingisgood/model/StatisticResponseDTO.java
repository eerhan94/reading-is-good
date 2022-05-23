package com.getir.readingisgood.model;

/**
 * The type Statistic response dto. @Author Eyup Erhan KARAASLAN -
 * eyuperhankaraaslan94@gmail.com @Version 1.0
 */
public class StatisticResponseDTO {
  private String month;
  private Integer totalOrderCount;
  private Integer totalBookCount;
  private Double totalPurchasedAmount;

  /**
   * Instantiates a new Statistic response dto.
   *
   * @param month the month
   * @param totalOrderCount the total order count
   * @param totalBookCount the total book count
   * @param totalPurchasedAmount the total purchased amount
   */
  public StatisticResponseDTO(
      String month, Integer totalOrderCount, Integer totalBookCount, Double totalPurchasedAmount) {
    this.month = month;
    this.totalOrderCount = totalOrderCount;
    this.totalBookCount = totalBookCount;
    this.totalPurchasedAmount = totalPurchasedAmount;
  }

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
  public Integer getTotalOrderCount() {
    return totalOrderCount;
  }

  /**
   * Sets total order count.
   *
   * @param totalOrderCount the total order count
   */
  public void setTotalOrderCount(Integer totalOrderCount) {
    this.totalOrderCount = totalOrderCount;
  }

  /**
   * Gets total book count.
   *
   * @return the total book count
   */
  public Integer getTotalBookCount() {
    return totalBookCount;
  }

  /**
   * Sets total book count.
   *
   * @param totalBookCount the total book count
   */
  public void setTotalBookCount(Integer totalBookCount) {
    this.totalBookCount = totalBookCount;
  }

  /**
   * Gets total purchased amount.
   *
   * @return the total purchased amount
   */
  public Double getTotalPurchasedAmount() {
    return totalPurchasedAmount;
  }

  /**
   * Sets total purchased amount.
   *
   * @param totalPurchasedAmount the total purchased amount
   */
  public void setTotalPurchasedAmount(Double totalPurchasedAmount) {
    this.totalPurchasedAmount = totalPurchasedAmount;
  }
}
