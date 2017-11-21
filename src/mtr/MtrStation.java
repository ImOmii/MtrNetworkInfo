package mtr;

public class MtrStation {
    private String name;

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
}
