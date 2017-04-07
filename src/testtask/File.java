/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtask;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Sergey
 */
public class File {
    protected String filePath;
    protected String fileName;

    public File(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }


    public String getText() {
        StringBuffer fileText = new StringBuffer();
        int i;

        try (FileInputStream fin = new FileInputStream(filePath + fileName)) {
            while ((i = fin.read()) != -1) {
                fileText.append((char) i);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return fileText.toString();
    }

    public ArrayList < String > stringSeparation(String fileText) {

        ArrayList < String > fieldsArray = new ArrayList < String > ();
        int i = 0;
        int j = 0;
        final int offset = 2;
        fileText = fileText.replaceAll("\n", "");
        fileText = fileText.replaceAll("  ", "");
        while (j < fileText.length()) {
            i = fileText.indexOf(";", j);
            fieldsArray.add(fileText.substring(j, i));
            j = i + offset;
        }
        return fieldsArray;

    }

    public void writeFile(String text) {
        try (FileWriter writer = new FileWriter(filePath + fileName, false)) {
            writer.write(text);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}