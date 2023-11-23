package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * <p>FIXME: 简要描述本文件的功能</p>
 *
 * @author yinxing
 * @since 2023/11/23
 **/
public class Backstage extends Item {

  public Backstage(int sellIn, int quality) {
    super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
  }

  @Override
  protected void updateQualityAfterExpiration() {
    this.quality = 0;
  }

  @Override
  protected void updateQuality() {
    if (this.quality >= 50) {
      return;
    }
    this.quality = this.quality + 1;

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
