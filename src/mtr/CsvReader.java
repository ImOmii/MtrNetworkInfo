package mtr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    private String csvFile;
    private BufferedReader bufferedReader;
    private String line = "";
    private String csvSplitBy = ",";

    public CsvReader() {
        csvFile = "MTRsystem_partial.csv";
    }

    public List<MtrLine> loadLines() {
        ArrayList<MtrLine> mtrLines = new ArrayList<>();
        try{

            bufferedReader = new BufferedReader(new FileReader(csvFile));
            while ((line = bufferedReader.readLine()) != null) {
                ArrayList<MtrStation> mtrStations = new ArrayList<>();
                String[] stations = line.split(csvSplitBy);

                for (int i = 0; i < stations.length; i++) {

                    mtrStations.add(new MtrStation(stations[i]));

                }

                mtrLines.add(new MtrLine(mtrStations));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return mtrLines;
    }
}
