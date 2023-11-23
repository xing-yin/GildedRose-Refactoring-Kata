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
  public boolean isBackstage() {
    return true;
  }
}
