/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtask;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Sergey
 */
public class User implements Serializable {
    private RentUnit rentUnit;
    private String name;


    public User(String name) {
        this.rentUnit = new RentUnit();
        this.name = name;
    }
    public void setRentUnit(RentUnit rentUnit) {

        this.rentUnit = rentUnit;
    }

    public RentUnit getRentUnit() {
        return rentUnit;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getString() {
        String userArrayData = "";
        for (int i = 0; i < rentUnit.getSportEquipmentArrey().length; i++) {
            if (rentUnit.getSportEquipmentArrey()[i] != null)
                userArrayData += rentUnit.getSportEquipmentArrey()[i].getString();
        }
        return userArrayData;
    }

}