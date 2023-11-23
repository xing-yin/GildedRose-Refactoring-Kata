package com.gildedrose;

import com.gildedrose.items.AgedBrie;
import com.gildedrose.items.Backstage;
import com.gildedrose.items.Sulfuras;
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
        new Item("+5 Dexterity Vest", 10, 20), //
        new AgedBrie(2, 0), //
        new Item("Elixir of the Mongoose", 5, 7), //
        new Sulfuras(0, 80), //
        new Sulfuras(-1, 80),
        new Backstage(15, 20),
        new Backstage(10, 49),
        new Backstage(5, 49),
        // this conjured item does not work properly yet
        new Item("Conjured Mana Cake", 3, 6)};

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
