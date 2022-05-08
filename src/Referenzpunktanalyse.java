import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Referenzpunktanalyse {

    public static void main(String[] args) {

        //cleanCSV(null);
        readCSV();
    }


    public static void convertData(){

    }

    public static void readCSV(){
        try (
                //Bereinigung: Ersetzen " "" durch " und """ durch "
                //Also das Strings nur einfach in " eingeschlossen sind
                Reader reader = Files.newBufferedReader(Paths.get("/home/ben/Studium/AIN4/Projekt/Referenzpunktanalyse/referencedata/AB_OG1_Flur_bereinigt.csv"));
        ) {

            CsvToBean<CSVRecord> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVRecord.class)
                    .withSeparator(';')
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();


            /*ReferenceRecordStore Store = new ReferenceRecordStore(csvToBean);
            Store.printPostionList();
            Store.printUniqueSSIDs();
            Store.printAPcountForAllPositions();*/
            List<String> allowedIDs = new ArrayList<>();
            allowedIDs.add("eduroam");
            allowedIDs.add("HFU Open");
            allowedIDs.add("HFU Guest");
            ReferenceRecordStore cleanStore = new ReferenceRecordStore(csvToBean, allowedIDs);
            System.out.println("\n===\nCleaned\n===\n");
            cleanStore.printTotalRecordCount();
            cleanStore.printPostionList();
            cleanStore.printUniqueSSIDs();
            cleanStore.printAPcountForAllPositions();
            /*
            Iterator<CSVRecord> csvUserIterator = csvToBean.iterator();
            System.out.println("Looping now");
            while (csvUserIterator.hasNext()) {
                CSVRecord csvUser = csvUserIterator.next();
                System.out.println("Position : " + csvUser.getPosition());
                System.out.println("SSID : " + csvUser.getSsid());
                System.out.println("RSSI : " + csvUser.getRssi());
                System.out.println("Datum : " + csvUser.getDatum());
                System.out.println("==========================");
            }*/



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void cleanCSV(String[] allowedSSIDs) {
        CSVReader reader = null;
        try {
            //parsing a CSV file into CSVReader class constructor
            reader = new CSVReader(new FileReader("/home/ben/Studium/AIN4/Projekt/Referenzpunktanalyse/referencedata/AB_OG1_Flur.csv"));
            String[] nextLine;
            //reads one line at a time
            while ((nextLine = reader.readNext()) != null) {
                for (String token : nextLine) {
                    System.out.print(token);
                }
                System.out.print("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
