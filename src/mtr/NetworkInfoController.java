package mtr;

import java.util.List;

public class NetworkInfoController implements Controller {

    private CsvReader csvReader;
    private List<MtrLine> mtrLines;

    public NetworkInfoController() {
        csvReader = new CsvReader();

        mtrLines = csvReader.loadLines();
    }

    @Override
    public String listAllTermini() {


        return mtrLines.toString();

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
        return null;
    }

    @Override
    public String listAllDirectlyConnectedLines(String line) {
        return null;
    }

    @Override
    public String showPathBetween(String stationA, String stationB) {
        return null;
    }
}
