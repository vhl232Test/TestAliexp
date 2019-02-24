import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        WriteCSV writeCSV = new WriteCSV();
        ParseSite parseSite = new ParseSite();
        JsonPars jsonPars = new JsonPars();
       /* try {
            parseSite.parseSite(parseSite.createUri(0));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }*/


        //Item [] itemMass = new Item[3];
        List<Item> itemMass = new LinkedList<>();
        try {
            itemMass.add(jsonPars.getItemJeson(parseSite.parseSite(parseSite.createUri(0))));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        writeCSV.writeData(itemMass);

        readFileReader(new File("Data.csv"));

        readFileBuf(new File("Data.csv"));

    }
    protected static void readFileBuf(File file) {
        FileReader fileReader = null;
        BufferedReader reader = null;
        try {

            fileReader = new FileReader(file);
            reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }//некоректно работает

    public static void readFileReader(File file){
        try {
            FileReader fileReader = new FileReader(file);
            char[] a= new char[500];
            fileReader.read(a);
            for (char c:a) {
                System.out.print(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
