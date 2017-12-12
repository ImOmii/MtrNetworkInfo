package mtr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class CsvReader {

    private String csvFile;
    private BufferedReader bufferedReader;
    private String line = "";
    private String csvSplitBy = ",";

    private List<MtrStation> terminuses = new ArrayList<>();
    private Map<String, MtrLine> linesMap = new HashMap<>();

    public CsvReader() {
        csvFile = "MTRsystem_partial.csv";
    }

    public List<MtrLine> loadLines() {

        //All The Lines in the map
        ArrayList<MtrLine> mtrLines = new ArrayList<>();

        //Reset to get populated below
        terminuses.clear();
        linesMap.clear();

        try{

            //Read The CSV file
            bufferedReader = new BufferedReader(new FileReader(csvFile));
            while ((line = bufferedReader.readLine()) != null) {
                ArrayList<MtrStation> mtrStations = new ArrayList<>();

                String[] stations = line.split(csvSplitBy);

                //The first element in the array is the line name
                String lineName = stations[0];

                //Iterate through the stations, starting at 1 because we want to skip over the line name element
                for (int i = 1; i < stations.length; i++) {

                    mtrStations.add(new MtrStation(stations[i]));

                }

                /** Link all the stations */

                //Store the current station outside the loop so it can be used in the next iterations
                MtrStation previousStation = null;

                //Loop through every station
                for (int i = 0; i < mtrStations.size(); i++) {

                    //Access the current station and link the previous station
                    mtrStations.get(i).setPreviousStation(previousStation);

                    //Access the previous station and set it to our current one
                    if (i > 0) {
                        previousStation.setNextStation(mtrStations.get(i));
                    }

                    //Set The local previous station, so that we can access it later
                    previousStation = mtrStations.get(i);

                    //Check if this station is a terminus
                    if(i == 0 || i == mtrStations.size() - 1){
                        terminuses.add(mtrStations.get(i));
                    }

                }
                //Add the current line into the ArrayList
                MtrLine mtrLine = new MtrLine(mtrStations);
                mtrLine.setName(lineName);
                mtrLines.add(mtrLine);
                linesMap.put(lineName, mtrLine);


            }


        }catch (Exception e){
            e.printStackTrace();
        }

        return mtrLines;
    }

    public List<MtrStation> getTerminuses() {
        return terminuses;
    }

    public Map<String, MtrLine> getLinesMap() {
        return linesMap;
    }
}
