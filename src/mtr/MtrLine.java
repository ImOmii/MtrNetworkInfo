package mtr;

import java.util.List;

public class MtrLine {

    private List<MtrStation> mtrStations;

    public MtrLine(List<MtrStation> mtrStations) {
        this.mtrStations = mtrStations;
    }

    @Override
    public String toString() {
        return "MtrLine{" +
                ", mtrStations=" + mtrStations +
                '}';
    }
}
