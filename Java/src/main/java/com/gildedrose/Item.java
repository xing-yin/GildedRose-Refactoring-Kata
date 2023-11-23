package com.gildedrose;

public class Item {

  public String name;
  public int sellIn;
  public int quality;

  protected Item(String name, int sellIn, int quality) {
    this.name = name;
    this.sellIn = sellIn;
    this.quality = quality;
  }

  void passOneDay() {
    updateSellInDays();

    updateQuality();

    if (isExpired()) {
      updateQualityAfterExpiration();
    }
  }

  protected void updateQuality() {
    if (this.quality > 0) {
      this.quality = this.quality - 1;
    }
  }

  /**
   * 1.使用卫语句简化代码嵌套 2.将对应不同类型逻辑放入子类
   */
  protected void updateQualityAfterExpiration() {
    this.updateQuality();
  }

  private boolean isExpired() {
    return this.sellIn < 0;
  }

  // 重构 if,用卫语句，尽早返回
  protected void updateSellInDays() {
    this.sellIn = this.sellIn - 1;
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }

}
