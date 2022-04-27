import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class CSVRecord {
    @CsvBindByName(column = "Punkt")
    private int position;

    @CsvBindByName(column = "Richtung")
    private String richtung;

    @CsvBindByName(column = "Grad")
    private int grad;

    @CsvBindByName(column = "SSID")
    private String ssid;

    @CsvBindByName(column = "BSS")
    private String bss;

    @CsvBindByName(column = "RSSI")
    private String rssi;

    @CsvBindByName(column = "Kanal")
    private String kanal;

    @CsvBindByName(column = "Datum")
    private String datum;


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getRichtung() {
        return richtung;
    }

    public void setRichtung(String richtung) {
        this.richtung = richtung;
    }

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public String getBss() {
        return bss;
    }

    public void setBss(String bss) {
        this.bss = bss;
    }

    public String getRssi() {
        return rssi;
    }

    public void setRssi(String rssi) {
        this.rssi = rssi;
    }

    public String getKanal() {
        return kanal;
    }

    public void setKanal(String kanal) {
        this.kanal = kanal;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }



}
