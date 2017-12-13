package mtr;

import java.util.List;
import java.util.Map;

public class NetworkInfoController implements Controller {

    private CsvReader csvReader;
    private List<MtrLine> mtrLines;

    public NetworkInfoController() {
        csvReader = new CsvReader();

        mtrLines = csvReader.loadLines();
    }

    @Override
    public String listAllTermini() {


        List<MtrStation> terminuses = csvReader.getTerminuses();

        //todo prettyify it here instead of returning to string. do a string builder perhaps

        return terminuses.toString();

        /**
         * LINE
         * STATION
         * * TERMINI extends station (END OF THE LINE STATION)
         * CSV READER
         *
         * FUNCTIONS
         * - list which station is a terminus
         * - list all known stations
         * - find which lines connect to the current line
         * - find a path between two stations
         */
    }

    @Override
    public String listStationsInLine(String line) {

        Map<String, MtrLine> mtrLineMap = csvReader.getLinesMap();


        return mtrLineMap.get(line).toString();
    }

    @Override
    public String listAllDirectlyConnectedLines(String line) {
        return null;
    }

    @Override
    public String showPathBetween(String stationA, String stationB) {
        return null;

        //Dijkstra algorithm
    }
}
