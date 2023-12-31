package com.gildedrose;

/**
 * 重构要点：
 * <p>
 * 口诀：旧的不变，新的创建，一步切换，旧的再见
 * <p>
 * - 每次有一小步的代码变更，立即运行测试（每步可控）
 * <p>
 * - 重构时遇到失败，不要尝试修复，先回退到上次成功的位置
 * <p>
 * - 重构 if,用卫语句，尽早返回(用卫语句简化代码嵌套)
 * <p>
 * - 重构与业务逻辑无关，只关乎结构（难道使用重构的方式能反推出合理的设计？）
 */

class GildedRose {

  Item[] items;

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void passOneDay() {
    for (Item item : items) {
      item.passOneDay();
    }
  }

  // 第一次代码 CR 思考：
  // - 应该使用增强 for 循环、而不是使用索引，更加清晰
  // - 很多硬编码的字符串，比如 "Aged Brie"、"Backstage passes to a TAFKAL80ETC concert"，可以使用静态常量代替
  // - if/else 判断的表达式较长，难以理解具体的语义 ===> 可以抽取变量，使用语义化表达式替换
  // - 分类不清，嵌套很多 if/else，难以阅读和理解代码逻辑 ===> 可以考虑多态替换
  // - 出现了很多魔法值，比如 6、50、11、1，在不了解业务规则的前提下无法理解魔法值含义 ==> 使用语义化的静态变量替换并加注释
  // - quality 的计算较为混乱，一次值的更新可能依赖好几个地方+1，难以维护 ==> 区分类别，根据不同的类别一步到位完成值计算（比如+2，而不是依赖前后两次距离较远的+1）
//  public void updateQualityV0() {
//    for (int i = 0; i < items.length; i++) {
//      if (!items[i].name.equals("Aged Brie")
//          && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//        if (items[i].quality > 0) {
//          if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//            items[i].quality = items[i].quality - 1;
//          }
//        }
//      } else {
//        if (items[i].quality < 50) {
//          items[i].quality = items[i].quality + 1;
//
//          if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//            if (items[i].sellIn < 11) {
//              if (items[i].quality < 50) {
//                items[i].quality = items[i].quality + 1;
//              }
//            }
//
//            if (items[i].sellIn < 6) {
//              if (items[i].quality < 50) {
//                items[i].quality = items[i].quality + 1;
//              }
//            }
//          }
//        }
//      }
//
//      if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//        items[i].sellIn = items[i].sellIn - 1;
//      }
//
//      if (items[i].sellIn < 0) {
//        if (!items[i].name.equals("Aged Brie")) {
//          if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
//            if (items[i].quality > 0) {
//              if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
//                items[i].quality = items[i].quality - 1;
//              }
//            }
//          } else {
//            items[i].quality = items[i].quality - items[i].quality;
//          }
//        } else {
//          if (items[i].quality < 50) {
//            items[i].quality = items[i].quality + 1;
//          }
//        }
//      }
//    }
//  }
}
