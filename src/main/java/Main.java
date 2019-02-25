import java.io.*;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException {

        WriteCSV writeCSV = new WriteCSV();
        ParseSite parseSite = new ParseSite();
        JsonPars jsonPars = new JsonPars();


        List list_Item = new LinkedList();
        for (int i = 0; i <list_Item.size() ; i++) {
            list_Item.add(i,jsonPars.getItemJeson(parseSite.fetch_String(parseSite.parseSite(parseSite.createUri(0)))));
        }

        System.out.println(parseSite.parseSite(parseSite.createUri(0)));

        writeCSV.writeData(list_Item);

        file_reader("Data.csv");


        //parseSite.parseSite("https://flashdeals.aliexpress.com/en.htm");
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
