import com.opencsv.CSVWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteCSV {
    protected void writeData(List item) {

        File file = new File("Data.csv");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file );
            for (Item item_Mas : item) {
                fileWriter.write(item_Mas.toString() + "\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*BufferedWriter writer = null;
        for (Item item_Mas:item) {
        try {
            writer = new BufferedWriter(new FileWriter(file,true));
            writer.write(item_Mas.toString().concat("\n"));
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }*/
    }}

