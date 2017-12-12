package mtr;

public class MtrStation {
    private String name;

    private MtrStation previousStation;
    private MtrStation nextStation;

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
}
