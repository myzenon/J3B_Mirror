/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J3B.farmapp.model.impl;

import J3B.farmapp.model.Item;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    private List<Item> items = new ArrayList<Item>();

    public boolean addItem(Item item) {
        return this.items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean removeItem(Item item) {
        return this.items.remove(item);
    }
}
