package mtr;

import java.util.List;

public class MtrLine {

    private List<MtrStation> mtrStations; //

    private List<MtrLine> lineConnections; //
    private String name;


    public MtrLine(List<MtrStation> mtrStations) {
        this.mtrStations = mtrStations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MtrLine{" +
                ", mtrStations=" + mtrStations +
                '}';
    }

    public List<MtrStation> getMtrStations() {
        return mtrStations;
    }

    public List<MtrLine> getLineConnections() {
        return lineConnections;
    }

    public void setLineConnections(List<MtrLine> lineConnections) {
        this.lineConnections = lineConnections;
    }
}
