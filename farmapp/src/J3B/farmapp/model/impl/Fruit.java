package J3B.farmapp.model.impl;

import J3B.farmapp.model.Item;

public class Fruit implements Item {

    private String name;
    private int hungerStat;

    public Fruit(String name, int hungerStat) {
        this.name = name;
        this.hungerStat = hungerStat;
    }

    public String getName() {
        return this.name;
    }

    public int getHungerStat() {
        return hungerStat;
    }
}
