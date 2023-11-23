package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * <p>FIXME: 简要描述本文件的功能</p>
 *
 * @author yinxing
 * @since 2023/11/23
 **/
public class AgedBrie extends Item {

  public AgedBrie(int sellIn, int quality) {
    super("Aged Brie", sellIn, quality);
  }

  @Override
  protected void updateQualityAfterExpiration() {
    if (this.quality < 50) {
      this.quality = this.quality + 1;
    }
  }

  @Override
  protected void updateQuality() {
    if (this.quality >= 50) {
      return;
    }
    this.quality = this.quality + 1;
  }
}
