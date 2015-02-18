import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        Mijnenveger mijn = new Mijnenveger(10);
        MyFrame frame = new MyFrame(mijn);
        frame.setVisible(true);
    }
}
