package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Mijnenveger mijn = new Mijnenveger(10);
        mijn.genereerVeld();
        System.out.print(mijn.toString());
        mijn.drawMijnenveger();

    }
}
