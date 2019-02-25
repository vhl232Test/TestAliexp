import java.io.*;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {

        WriteCSV writeCSV = new WriteCSV();
        ParseSite parseSite = new ParseSite();
        JsonPars jsonPars = new JsonPars();
        int ofset;

        for ( ofset = 0; ; ofset+=12) {
            writeCSV.writeData(jsonPars.getItemJeson(parseSite.fetch_String(parseSite.parseSite(parseSite.createUri(ofset)))));
           if (jsonPars.count_Item >= 99)break;
        }

        while (true) {
            writeCSV.writeData(jsonPars.getItemJeson(parseSite.fetch_String(parseSite.parseSite(parseSite.createUri(ofset)))));
            ofset+=12;
           if (jsonPars.count_Item >=99) break;
        }

        file_reader("Data.csv");

    }

    public static void file_reader(String name_File){
        File file = new File(name_File);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        char[] faliChar = new char[1000];
        try {
            fileReader.read(faliChar);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (char a: faliChar) {
            System.out.println(a);
        }
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
