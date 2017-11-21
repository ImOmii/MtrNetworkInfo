package mtr;

public class Main {

    public Main() {
        NetworkInfoController networkInfoController = new NetworkInfoController();

        TUI tui = new TUI(networkInfoController);
    }

    public static void main(String[] args) {
        new Main();
    }

}
