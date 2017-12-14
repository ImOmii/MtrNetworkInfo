package mtr;

import java.util.ArrayList;
import java.util.List;

public class MtrStation {
    private String name; //Hold the name of stations

    private MtrStation previousStation; //Holds previous stations
    private MtrStation nextStation; //Holds the next station

    private List<MtrStation> connections = new ArrayList<>();

    public MtrStation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    } //Getter for name

    public void setName(String name) {
        this.name = name;
    } //Setter for name

//    @Override
//    public String toString() {
//        return "MtrStation{" +
//                "name='" + name + '\'' +
//                '}';
//    }

    public String toString(){
        //Generate the name of station in console
        return name;
    }

    public MtrStation getPreviousStation() {
        return previousStation;
    }

    public void setPreviousStation(MtrStation previousStation) {
        this.previousStation = previousStation;
    }

    public MtrStation getNextStation() {
        return nextStation;
    }

    public void setNextStation(MtrStation nextStation) {
        this.nextStation = nextStation;
    }

    public List<MtrStation> getConnections() {
        return connections;
    }

    public void setConnections(List<MtrStation> connections) {
        this.connections = connections;
    }

    public void addConnection(MtrStation mtrStation) {
        connections.add(mtrStation);
    }
}
