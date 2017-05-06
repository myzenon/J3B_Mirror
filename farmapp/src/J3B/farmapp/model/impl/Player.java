package J3B.farmapp.model.impl;

public class Player {

    private String name;

    private Bag inventory;

    private int hunger;
    private int maxHunger;

    public Player(String name, Bag inventory, int maxHunger) {
        this.name = name;
        this.inventory = inventory;
        this.maxHunger = maxHunger;
        this.hunger = this.maxHunger;
    }

    public String getName() {
        return name;
    }

    public Bag getInventory() {
        return inventory;
    }

    public int getHunger() {
        return hunger;
    }

    public int getMaxHunger() {
        return maxHunger;
    }

    public void sleep() {
        if(this.hunger > 0) {
            this.hunger--;
        }
    }

    public void eatFruit(Fruit fruit) {
        if(this.hunger + fruit.getHungerStat() < this.maxHunger) {
            this.hunger += fruit.getHungerStat();
        }
        else {
            this.hunger = this.maxHunger;
        }
        this.inventory.removeItem(fruit);
    }

}
