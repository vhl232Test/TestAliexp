

public class Main {
    public static void main(String[] args) {

        //WriteCSV writeCSV = new WriteCSV();

        //String d []= {"s","e","r"};
        //writeCSV.writeData(d);
        ParseSite parseSite = new ParseSite();
        parseSite.parseSite("https://flashdeals.aliexpress.com/en.htm");
    }
}
