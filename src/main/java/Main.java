import java.io.*;
import java.net.URISyntaxException;

public class Main {
    private static long maxTimeWork = System.currentTimeMillis()+60000;
    public static void main(String[] args) throws URISyntaxException {


        WriteCSV writeCSV = new WriteCSV();
        ParseSite parseSite = new ParseSite();
        int ofset=0;


        while (true) {
            writeCSV.writeData(parseSite.parseSite(parseSite.createUri(ofset)));
            ofset+=12;
          if (ofset>100 || ifWeHaveSomeTime() )break;
        }



    }


    public static boolean ifWeHaveSomeTime(){
       return System.currentTimeMillis() <= maxTimeWork;
    }
}
