package mtr;

import java.util.List;

public class MtrLine {

    private List<MtrStation> mtrStations;
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
}
