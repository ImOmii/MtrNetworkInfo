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
    private List<MtrStation> listNodes = new ArrayList<>();

    public CsvReader() {
        csvFile = "MTRsystem_partial.csv";
    }

    public List<MtrLine> loadLines() {

        //All The Lines in the map
        List<MtrLine> mtrLines = new ArrayList<>();
        //local arraylist nodes

        //Reset to get populated below
        terminuses.clear();
        linesMap.clear();
        listNodes.clear();

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
                MtrStation previousNodeStation = null;

                //Loop through every station
                for (int i = 0; i < mtrStations.size(); i++) {

                    MtrStation nodeStation = getStationInNodes(mtrStations.get(i), listNodes);
                    boolean shouldAddIntoListNodes = false;

                    if(nodeStation == null){
                        shouldAddIntoListNodes = true;
                        nodeStation = mtrStations.get(i);
                    }

                    //Access the current station and link the previous station
                    mtrStations.get(i).setPreviousStation(previousStation);
                    nodeStation.addConnection(previousStation);

                    //Access the previous station and set it to our current one
                    if (i > 0) {
                        previousStation.setNextStation(mtrStations.get(i));
                        previousNodeStation.addConnection(nodeStation);
                    }

                    //Set The local previous station, so that we can access it later
                    previousStation = mtrStations.get(i);
                    previousNodeStation = nodeStation;

                    //Check if this station is a terminus
                    if(i == 0 || i == mtrStations.size() - 1){
                        terminuses.add(mtrStations.get(i));
                    }

                    //Complete Node collection

                    if (shouldAddIntoListNodes) {
                        listNodes.add(nodeStation);
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

        //here

        //local variable previousConnection
         MtrStation previousConnection = null;

//        /*//For loop that goes through all mtrLine and then another for loop that goes to every station within the line
////        for (int i = 0; i < mtrLines.size(); i++) {
////            for (int j = 0; j < mtrLines.get(i).getMtrStations().size(); j++) {
////
////                MtrStation currentStation = mtrLines.get(i).getMtrStations().get(j);
////
////                //Add to list node if it doesn't exist there
////                MtrStation nodeStation = getStationInNodes(currentStation, listNode);
////
////                boolean isNewStation = false;
////
////                if (nodeStation != null) {
////                    isNewStation = false;
////                } else {
////                    isNewStation = true;
////                    nodeStation = currentStation;
////                }
////
////                if (previousConnection != null)
////                    nodeStation.addConnection(previousConnection);
////
//////                if (j != mtrLines.get(i).getMtrStations().size() - 1) {
//////                    MtrStation nextStation = mtrLines.get(i).getMtrStations().get(j + 1);
//////
//////                    if (nextStation != null)
//////                        nextStation.addConnection(nodeStation);
//////                }
////
////                if(isNewStation){
////                    //The station is not in the nodes, so lets add it
////                    listNode.add(nodeStation);
////                }
////
////                previousConnection = mtrLines.get(i).getMtrStations().get(j);
////
////            }
////        }*/
//        //when it finds a new station, itll add it to the nodes array. (you can check if its a new station by doing a string compare)
//        // if its already in the nodes array, itll just use that element and add a new connection

        return mtrLines;
    }

    //If the given station exists in the nodes array, it'll return that station, otherwise it'll return null
    private MtrStation getStationInNodes(MtrStation mtrStation, List<MtrStation> nodes) {

        for (int i = 0; i < nodes.size(); i++) {
            if (mtrStation.getName().equals(nodes.get(i).getName())){
                return nodes.get(i);
            }
        }

        return null;

    }

    //If the given station exists in the nodes array, it'll return that station, otherwise it'll return null
    private boolean isStationInNodes(MtrStation mtrStation, List<MtrStation> nodes) {

        for (int i = 0; i < nodes.size(); i++) {
            if (mtrStation.getName().equals(nodes.get(i).getName())){
                return true;
            }
        }

        return false;

    }

    public List<MtrStation> getTerminuses() {
        return terminuses;
    }

    public Map<String, MtrLine> getLinesMap() {
        return linesMap;
    }

    //Debug remove this later
    public static void main(String[] args) {
        new CsvReader();
    }
}
