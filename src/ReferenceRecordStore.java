import com.opencsv.bean.CsvToBean;
import java.util.*;

public class ReferenceRecordStore {

    List<Integer> capturedPositions = new ArrayList<>();
    List<String> ssids = new ArrayList<>();
    Map<Integer, List<CSVRecord>> records = new HashMap<>();



    ReferenceRecordStore(CsvToBean<CSVRecord> data){
        for (CSVRecord csvUser : data) {
            if(!records.containsKey(csvUser.getPosition())){
                records.put(csvUser.getPosition(),new ArrayList<>());
                records.get(csvUser.getPosition()).add(csvUser);
                capturedPositions.add(csvUser.getPosition());
            }else{
                records.get(csvUser.getPosition()).add(csvUser);
            }
        }
        System.out.println("All Records added, Record Store ready");
    }

    /**
     * CSV Record Storage class to manage multiple reference points
     * @param data CSV Data as CsvToBean Object
     * @param allowedSSIDs List of allowed SSIDs, SSIDs not in list are not stored
     */
    ReferenceRecordStore(CsvToBean<CSVRecord> data, List<String> allowedSSIDs){
        for (CSVRecord csvUser : data) {
            if(!allowedSSIDs.contains(csvUser.getSsid()))
                continue;
            if(!records.containsKey(csvUser.getPosition())){
                records.put(csvUser.getPosition(),new ArrayList<>());
                records.get(csvUser.getPosition()).add(csvUser);
                capturedPositions.add(csvUser.getPosition());
            }else{
                records.get(csvUser.getPosition()).add(csvUser);
            }
        }
        System.out.println("All Records added, Record Store ready");
    }

    /**
     * Returns a List with the names of all SSIDs in Store
     * @return Return SSIDs as String List
     */
    public List<String> getSSIDList(){
        if(ssids.isEmpty()){
            for(int pos : records.keySet()){
                for(CSVRecord record : records.get(pos)){
                    if(!ssids.contains(record.getSsid()))
                        ssids.add(record.getSsid());
                }
            }
        }
        return ssids;
    }

    public void printUniqueSSIDs(){
        System.out.println("There are " + getSSIDList().size() + " SSIDs in store : ");
        for(String item : getSSIDList()){
            System.out.println("'" + item + "'");
        }
        System.out.println();

    }

    /**
     * Prints all positions in store
     */
    public void printPostionList(){
        System.out.println("There are " + records.keySet().size() + " Positions in Store: ");
        for (int key : records.keySet()){
            System.out.print(key + ",");
        }
        System.out.println();
    }

    /**
     * Prints all position and the amount of APs associated with it
     */
    public void printAPcountForAllPositions(){
        for(int pos : records.keySet()){
            System.out.println("Position " + pos + " has " + records.get(pos).size() + " Access Points"); //FIXME Winkel wird ignoriert, falsches Ergebnis!
        }
    }





}
