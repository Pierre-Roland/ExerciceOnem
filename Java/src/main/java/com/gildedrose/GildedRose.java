package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            switch (item.name) {
                case ("Aged Brie"):
                    if (item.quality < 50) {
                        item.quality ++;
                        if (item.sellIn < 0) {
                            item.quality ++;
                        }
                    }
                    break;

                case ("Backstage passes to a TAFKAL80ETC concert"):
                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }
                    else if (item.quality < 50){
                        item.quality ++;
                        if (item.sellIn < 11 && item.quality < 50) {
                            item.quality++;
                            if (item.sellIn < 6 && item.quality < 50) {
                                item.quality ++;
                            }
                        }
                    }
                    break;

                case ("Conjured Mana Cake"):
                    if (item.sellIn < 0) {
                        degradeQuality(3, item);
                    }
                    else if (item.quality > 0) {
                        degradeQuality(1, item);
                    }
                    break;

                default:
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        if (item.sellIn < 0) {
                            degradeQuality(1, item);
                        }
                        else if (item.quality > 0) {
                            item.quality --;
                        }
                    }
                    break;
            }
        }
    }

    public void degradeQuality(int qualityCheck, Item item) {
        if (item.quality > qualityCheck) {
            item.quality -= (qualityCheck == 3) ? 4 : 2;
        }
        else {
            item.quality = 0;
        }
    }
}
