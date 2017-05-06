package J3B.farmapp.model.impl;

import J3B.farmapp.model.Growable;

public class HealthInfo implements Cloneable {
    private int health;

    private int healthIncreasePercent;
    private int healthDecreasePercent;

    private int healthMax;

    public HealthInfo(int healthIncreasePercent, int healthDecreasePercent, int healthMax) {
        this.healthIncreasePercent = healthIncreasePercent;
        this.healthDecreasePercent = healthDecreasePercent;
        this.healthMax = healthMax;
        this.health = this.healthMax;
    }

    public void nextPhase(WaterInfo waterInfo) {
        if(waterInfo.isWaterHigh()) {
            int healthIncrease = this.healthMax * this.healthIncreasePercent / 100;
            if(this.health + healthIncrease < this.healthMax) {
                this.health += healthIncrease;
            }
            else {
                this.health = this.healthMax;
            }
        }
        else if(waterInfo.isWaterLow()) {
            int healthDecrease = this.healthMax * this.healthDecreasePercent / 100;
            if(this.health + healthDecrease > 0) {
                this.health -= healthDecrease;
            }
            else {
                this.health = 0;
            }
        }
    }

    public int getHealthPercent() {
        return this.health * 100 / this.healthMax;
    }

    public int getHealth() {
        return health;
    }

    public int getHealthMax() {
        return healthMax;
    }

    public HealthInfo clone() {
        try {
            return (HealthInfo) super.clone();
        }
        catch (Exception ex) {
            return null;
        }
    }

}
