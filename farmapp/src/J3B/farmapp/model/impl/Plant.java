package J3B.farmapp.model.impl;

import J3B.farmapp.model.Growable;
import J3B.farmapp.model.Item;

public class Plant implements Growable, Cloneable {

    // Model Plant
    private String name;
    private int growthDays;
    private WaterInfo waterInfo;
    private HealthInfo healthInfo;
    private Fruit fruit;


    // Static Model
    private int fruitProduceChance = (int) (Math.random() * 100);
    private String[] statusType = {"Seed", "Seedling", "Mature", "Sprouting", "HarvestReady"};

    // Dynamic Attribute
    private int age = 0;
    private int status = 0;

    public Plant(String name, int growthDays, WaterInfo waterInfo, HealthInfo healthInfo, Fruit fruit) {
        this.name = name;
        this.growthDays = growthDays;
        this.waterInfo = waterInfo.clone();
        this.healthInfo = healthInfo.clone();
        this.fruit = fruit;
    }

    public void grow() {

        this.age++;

        if(this.status < this.statusType.length - 2) {
            this.status = this.age / this.growthDays;
        }
        else if(this.status != this.statusType.length - 1) {
            this.growHarvest();
        }

        this.healthInfo.nextPhase(this.waterInfo);
        this.waterInfo.nextPhase();

    }

    public void growHarvest() {
        // Set HarvestReady Status depends on fruitProduceChance and Health
        if(this.status == 3) {
            int produceChancePercent = (this.healthInfo.getHealthPercent() * this.fruitProduceChance) / 100;
            System.out.println(produceChancePercent);
            // If random chance has more than 100- productChancePercent
            if((100 - produceChancePercent) <= ((int) (Math.random() * 100))) {
                this.status = this.statusType.length - 1;
            }
        }
    }

    public void water() {
        this.waterInfo.water();
    }

    public String getStatus() {
        return this.statusType[this.status];
    }

    public int getDaysNextStatus() {
        int daysNextStatus = this.growthDays - (this.age % this.growthDays);
        if(status >= this.statusType.length - 2) {
            daysNextStatus = 0;
        }
        return daysNextStatus;
    }

    public Item harvest() {
        if(this.getStatus().equals(this.statusType[this.statusType.length - 1])) {
            return this.fruit;
        }
        return null;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public WaterInfo getWaterInfo() {
        return waterInfo;
    }

    public HealthInfo getHealthInfo() {
        return healthInfo;
    }

    public Plant clone() {
        try {
            Plant newPlant = (Plant) super.clone();
            newPlant.waterInfo = this.waterInfo.clone();
            newPlant.healthInfo = this.healthInfo.clone();
            return newPlant;
        }
        catch(Exception ex) {
            return null;
        }
    }

    public Fruit getFruit() {
        return this.fruit;
    }
}
