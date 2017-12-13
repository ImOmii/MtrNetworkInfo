package mtr;

import java.util.List;

public class MtrStation {
    private String name;

    private MtrStation previousStation;
    private MtrStation nextStation;

    private List<MtrStation> connections;

    public MtrStation(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MtrStation{" +
                "name='" + name + '\'' +
                '}';
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
