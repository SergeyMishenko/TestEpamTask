/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtask;

import java.io.Serializable;


/**
 *
 * @author Sergey
 */
enum Category {
    tourism,
    clothes,
    fitnessEquipment
};

public class SportEquipment implements Serializable {
    private Category category;
    private String title;
    private int price;

    public SportEquipment(Category category, String title, int price) {
        this.category = category;
        this.title = title;
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPrise(int price) {
        this.price = price;
    }

    public int getPrise() {
        return price;
    };

    public String getString() {
        String userData = "";
        userData = "category-" + category.name() + "; title-" + title + "; prise-" + Integer.toString(price) + ";\n";
        return userData;
    }

}