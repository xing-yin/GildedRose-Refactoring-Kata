package com.gildedrose.items;

import com.gildedrose.Item;

/**
 * <p>FIXME: 简要描述本文件的功能</p>
 *
 * @author yinxing
 * @since 2023/11/23
 **/
public class Sulfuras extends Item {

  public Sulfuras(int sellIn, int quality) {
    super("Sulfuras, Hand of Ragnaros", sellIn, quality);
  }

  @Override
  protected void updateSellInDays() {
    // do nothing,override default logic
  }

  @Override
  protected void updateQualityAfterExpiration() {
  }

  @Override
  protected void updateQuality() {

  }
}
