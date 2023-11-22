package com.gildedrose;

import static com.gildedrose.Item.createAgedBrie;
import static com.gildedrose.Item.createBackstage;
import static com.gildedrose.Item.createNormalItem;
import static com.gildedrose.Item.createSulfuras;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class TextTestFixture {

  public static void main(String[] args) {
    String baseline = getBaseline();
    System.out.println(baseline);
  }

  public static String getBaseline() {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(out);
    printStream.println("OMGHAI!");

    Item[] items = new Item[]{
        createNormalItem("+5 Dexterity Vest", 10, 20), //
        createAgedBrie(2, 0), //
        createNormalItem("Elixir of the Mongoose", 5, 7), //
        createSulfuras(0, 80), //
        createSulfuras(-1, 80),
        createBackstage(15, 20),
        createBackstage(10, 49),
        createBackstage(5, 49),
        // this conjured item does not work properly yet
        createNormalItem("Conjured Mana Cake", 3, 6)};

    GildedRose app = new GildedRose(items);

    int days = 3;

    for (int i = 0; i < days; i++) {
      printStream.println("-------- day " + i + " --------");
      printStream.println("name, sellIn, quality");
      for (Item item : items) {
        printStream.println(item);
      }
      printStream.println();
      app.passOneDay();
    }

    // 系统的baseline
    String baseline = out.toString();
    return baseline;
  }

}
