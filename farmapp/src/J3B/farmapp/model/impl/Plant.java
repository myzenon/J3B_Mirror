package J3B.farmapp.model.impl;

import J3B.farmapp.model.Growable;

public class Plant implements Growable {

    // Model Plant
    private String name;
    private int growthDays;

    // Status Plant
    private String[] statusType = {"Seed", "Seedling", "Mature", "Sprouting", "HarvestReady"};

    // Age Plant
    private int age = 0;

    public Plant(String name, int growthDays) {
        this.name = name;
        this.growthDays = growthDays;
    }

    public void grow() {
        this.age++;
    }

    public String getStatus() {
        int status = this.age / this.growthDays;
        if(status > statusType.length) {
            status = statusType.length - 1;
        }
        return this.statusType[status];
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getDaysNextStatus() {
        int daysNextStatus = this.growthDays - (this.age % this.growthDays);
        if(age > (this.growthDays * this.statusType.length)) {
            daysNextStatus = 0;
        }
        return daysNextStatus;
    }
}
