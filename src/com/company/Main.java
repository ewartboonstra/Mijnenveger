package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    public static void main(String[] args) {
        Mijnenveger mijn = new Mijnenveger(10);
        MyFrame frame = new MyFrame(mijn);
        frame.setVisible(true);
    }
}
