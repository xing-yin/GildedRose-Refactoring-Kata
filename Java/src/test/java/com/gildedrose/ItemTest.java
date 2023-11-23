package com.gildedrose;

import static org.junit.jupiter.api.Assertions.*;

import com.gildedrose.items.Backstage;
import org.junit.jupiter.api.Test;

/**
 * <p>FIXME: 简要描述本文件的功能</p>
 *
 * @author yinxing
 * @since 2023/11/22
 **/
class ItemTest {

  @Test
  public void should_double_increase_backstage_pass_value_when_getting_close_to_expiration() {
    Item item = new Backstage(11, 20);
    item.passOneDay();
    assertEquals(item.quality, 21);
    item.passOneDay();
    assertEquals(item.quality, 23);
    item.passOneDay();
    assertEquals(item.quality, 25);
  }
}