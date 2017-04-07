/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtask;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;






/**
 *
 * @author Sergey
 */
public class TestTask {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList < User > users = new ArrayList();

        Map equipmentMap = new HashMap < SportEquipment, Integer > ();
        Shop myShop = new Shop(equipmentMap);

        File file = new File("", "test.txt");
        String s = file.getText();
        ArrayList < String > fieldsArray = file.stringSeparation(s);
        myShop.CreationEquipment(fieldsArray);

        System.out.println("Enter your username");
        Scanner in = new Scanner(System.in);
        String userName = in .nextLine();
        User user = new User(userName);

        users = deSerialize("seriallize.dat", users);
        for (int i = 0; i < users.size(); i++) {
            if (userName.equals(users.get(i).getName())) {
                user = users.get(i);
                users.remove(i);
            }
        }

        boolean flag;
        vriteMenu();
        do {
            String choiceString = in .nextLine();
            vriteMenu();
            flag = choiceAction(choiceString, myShop, user, users);
        } while (flag);

        file.writeFile(myShop.getText());

    }

    private static void vriteMenu() {
        System.out.println("--------------------------------------------------------------------");
        System.out.println("*-для выбора необходимого действия введите соответствующие число");
        System.out.println("1.Show all products ");
        System.out.println("2.Order sport equipment");
        System.out.println("3.Search");
        System.out.println("4.Display report");
        System.out.println("5.Close the program");
        System.out.println("--------------------------------------------------------------------");
    }

    private static boolean choiceAction(String s, Shop shop, User user, ArrayList < User > users) {
        boolean flag = true;

        switch (s) {
            case "1":
                shop.printProduct();
                break;

            case "2":
                orderEquipment(shop, user);
                break;

            case "3":
                searchEquipment(shop);
                break;

            case "4":
                System.out.println("sport equipment in stock");
                shop.printProduct();
                System.out.println("sport equipment in rent");
                writeRentUnit(users, user);

                break;

            case "5":
                flag = false;
                users.add(user);
                Serialize("seriallize.dat", users);
                break;

            default:
                System.out.println("*-Invalid input");
        }
        return flag;
    }

    public static void orderEquipment(Shop shop, User user) {
        boolean flag = false;

        System.out.println("Enter product name");
        Scanner in = new Scanner(System.in);
        String productName = in .nextLine();

        for (Map.Entry entry: shop.getGoods().entrySet()) {
            int key = (int) entry.getValue();
            SportEquipment value = (SportEquipment) entry.getKey();
            if (value.getTitle().equals(productName) && key > 0 && user.getRentUnit().addEquipment(value)) {
                shop.getGoods().put(value, key - 1);
                System.out.println("Sport Equipment add");
                flag = true;
            }
        }
        if (flag == false) System.out.println("Product not found or shopping cart is full");
    }

    public static void searchEquipment(Shop shop) {
        System.out.println("Enter part of the product name or product type");
        Scanner in = new Scanner(System.in);
        String searchString = in .nextLine();
        for (Map.Entry entry: shop.getGoods().entrySet()) {
            int key = (int) entry.getValue();
            SportEquipment value = (SportEquipment) entry.getKey();
            String category = value.getCategory().name();
            if (value.getTitle().indexOf(searchString) != -1 || category.indexOf(searchString) != -1) {
                System.out.println("category-" + value.getCategory() + "; title-" + value.getTitle() + "; prise-" + value.getPrise() + "; quantity" + key + ";");
            }
        }
    }
    public static void Serialize(String fileName, ArrayList < User > users) {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(fileName);
            out = new ObjectOutputStream(fos);
            out.writeObject(users);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static ArrayList < User > deSerialize(String fileName, ArrayList < User > users) {

        FileInputStream fis = null;
        ObjectInputStream in = null;
        try {
            fis = new FileInputStream(fileName); in = new ObjectInputStream(fis);
            users = (ArrayList < User > ) in .readObject(); in .close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    public static void writeRentUnit(ArrayList < User > users, User user) {
        System.out.println("user-" + user.getName() + ":");
        System.out.println(user.getString());
        for (int i = 0; i < users.size(); i++) {
            System.out.println("user-" + users.get(i).getName() + ":");
            System.out.println(users.get(i).getString());
        }
    }
}