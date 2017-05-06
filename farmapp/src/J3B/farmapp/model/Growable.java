package J3B.farmapp.model;

import J3B.farmapp.model.impl.Fruit;
import J3B.farmapp.model.impl.HealthInfo;
import J3B.farmapp.model.impl.WaterInfo;

public interface Growable {
    public void grow();
    public String getName();
    public String getStatus();
    public int getAge();
    public int getDaysNextStatus();
    public WaterInfo getWaterInfo();
    public HealthInfo getHealthInfo();
    public void water();
    public Item harvest();
    public Fruit getFruit();
}
