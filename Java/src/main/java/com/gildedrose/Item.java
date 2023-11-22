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
