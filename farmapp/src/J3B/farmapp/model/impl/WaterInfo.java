package J3B.farmapp.model.impl;

import J3B.farmapp.model.Growable;

public class WaterInfo implements Cloneable {

    private int water;

    private int waterIncreasePercent;
    private int waterDecreasePercent;

    private int waterLowPercent;
    private int waterHighPercent;

    private int waterMax;

    public WaterInfo(int waterIncreasePercent, int waterDecreasePercent, int waterLowPercent, int waterHighPercent, int waterMax) {
        this.waterIncreasePercent = waterIncreasePercent;
        this.waterDecreasePercent = waterDecreasePercent;
        this.waterLowPercent = waterLowPercent;
        this.waterHighPercent = waterHighPercent;
        this.waterMax = waterMax;
        this.water = this.waterMax;
    }

    public void nextPhase() {
        int waterDecrease = this.waterMax * this.waterDecreasePercent / 100;
        if(this.water - waterDecrease > 0) {
            this.water -= waterDecrease;
        }
        else {
            this.water = 0;
        }
    }

    public void water() {
        int waterIncrease = this.waterMax * this.waterIncreasePercent / 100;
        if(this.water + waterIncrease < this.waterMax) {
            this.water += waterIncrease;
        }
        else {
            this.water = this.waterMax;
        }
    }

    public int getWaterPercent() {
        return this.water * 100 / this.waterMax;
    }

    public boolean isWaterHigh() {
        return this.getWaterPercent() >= this.waterHighPercent;
    }

    public boolean isWaterLow() {
        return this.getWaterPercent() <= this.waterLowPercent;
    }

    public int getWater() {
        return water;
    }

    public int getWaterMax() {
        return waterMax;
    }

    public WaterInfo clone() {
        try {
            return (WaterInfo) super.clone();
        }
        catch (Exception ex) {
            return null;
        }
    }

}
