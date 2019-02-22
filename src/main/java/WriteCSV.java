import com.opencsv.CSVWriter;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    protected void writeData(String[] data){
        String filePath = "F:\\csv\\test.csv";

        File file = new File(filePath);
        try {
            FileWriter fileWriter = new FileWriter(file);
            CSVWriter writer = new CSVWriter(fileWriter);
            writer.writeNext(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
