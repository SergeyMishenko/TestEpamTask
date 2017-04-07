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
public class RentUnit implements Serializable {
    private SportEquipment[] units;

    public RentUnit() {
        this.units = new SportEquipment[3];
    }


    public SportEquipment[] getSportEquipmentArrey() {
        return units;
    }

    public boolean addEquipment(SportEquipment equipment) {

        for (int i = 0; i < units.length; i++)
            if (units[i] == null) {
                units[i] = equipment;
                return true;
            }
        return false;
    }
}