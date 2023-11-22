package com.gildedrose;

public class Item {

  public String name;

  public int sellIn;

  public int quality;

  public Item(String name, int sellIn, int quality) {
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

  private void updateQuality() {
    if (!isAgedBrie() && !isBackstage()) {
      if (this.quality > 0) {
        if (!isSulfuras()) {
          this.quality = this.quality - 1;
        }
      }
    } else {
      if (this.quality < 50) {
        this.quality = this.quality + 1;

        if (isBackstage()) {
          if (this.sellIn < 10) {
            if (this.quality < 50) {
              this.quality = this.quality + 1;
            }
          }

          if (this.sellIn < 5) {
            if (this.quality < 50) {
              this.quality = this.quality + 1;
            }
          }
        }
      }
    }
  }

  private void updateQualityAfterExpiration() {
    if (!isAgedBrie()) {
      if (!isBackstage()) {
        if (this.quality > 0) {
          if (!isSulfuras()) {
            this.quality = this.quality - 1;
          }
        }
      } else {
        this.quality = 0;
      }
    } else {
      if (this.quality < 50) {
        this.quality = this.quality + 1;
      }
    }
  }

  private boolean isExpired() {
    return this.sellIn < 0;
  }

  private void updateSellInDays() {
    if (!isSulfuras()) {
      this.sellIn = this.sellIn - 1;
    }
  }

  @Override
  public String toString() {
    return this.name + ", " + this.sellIn + ", " + this.quality;
  }

  // 该行为与 Item 有关，应该放入 Item (内聚，属于 Item 的领域对象)；符合迪米特法则
  public boolean isBackstage() {
    return name.equals("Backstage passes to a TAFKAL80ETC concert");
  }

  public boolean isSulfuras() {
    return this.name.equals("Sulfuras, Hand of Ragnaros");
  }

  public boolean isAgedBrie() {
    return this.name.equals("Aged Brie");
  }

}
