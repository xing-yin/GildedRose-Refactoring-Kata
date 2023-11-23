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
    increaseQuality();
  }

  @Override
  protected void updateQuality() {
    increaseQuality();
  }
}
