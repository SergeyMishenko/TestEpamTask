/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtask;

import java.io.Serializable;
import static java.lang.Math.abs;


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

    @Override
    public int hashCode() {
        final int prime = 37;
        int result = 1;
        result = prime * result + price;
        result = prime * result + category.ordinal();
        result = prime * result + title.hashCode();
        result = abs(result);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SportEquipment other = (SportEquipment) obj;
        if (category != other.category)
            return false;
        if (title != other.title)
            return false;
        if (price != other.price)
            return false;
        return true;
    }

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