package mtr;

public class NetworkInfoController implements Controller {

    @Override
    public String listAllTermini() {
        return null;

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
