/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtask;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


/**
 *
 * @author Sergey
 */
public class Shop {
    private Map < SportEquipment, Integer > goods; // Map-value - количество определенного товара

    public Shop(Map < SportEquipment, Integer > goods) {
        this.goods = goods;
    }

    public Map < SportEquipment, Integer > getGoods() {
        return goods;
    }

    public void setGoods(Map < SportEquipment, Integer > goods) {
        this.goods = goods;
    }

    void CreationEquipment(ArrayList < String > fieldArray) {
        int price;
        int i = 0;
        Category category;
        while (i < fieldArray.size()) {
            price = Integer.parseInt(fieldArray.get(i + 2));
            category = Category.valueOf(fieldArray.get(i));
            int quantity = Integer.parseInt(fieldArray.get(i + 3));
            SportEquipment myEquipment = new SportEquipment(category, fieldArray.get(i + 1), price);
            this.goods.put(myEquipment, quantity);
            myEquipment.getClass();
            i += 4;
        }
    }

    void printProduct() {
        for (Map.Entry entry: goods.entrySet()) {
            int key = (int) entry.getValue();
            SportEquipment value = (SportEquipment) entry.getKey();
            System.out.println("category-" + value.getCategory() + "; title-" + value.getTitle() + "; price-" + value.getPrise() + "; quantity-   " + key + ";");
        }
    }

    public String getText() {
        String resultStiString = new String();
        for (Map.Entry entry: goods.entrySet()) {
            int key = (int) entry.getValue();
            SportEquipment value = (SportEquipment) entry.getKey();
            resultStiString += value.getCategory() + "; " + value.getTitle() + "; " + value.getPrise() + "; " + key + "; \n";
        }
        return resultStiString;
    }
}