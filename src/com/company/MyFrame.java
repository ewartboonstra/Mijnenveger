package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by E Boonstra on 18-2-2015.
 */
public class MyFrame extends JFrame{

    private Mijnenveger mijn;

    public MyFrame(final Mijnenveger mijn) {
        this.mijn = mijn;
        setTitle("Mijnenveger");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(mijn.getHeight(),mijn.getWidth()));

        for(int x = 0; x < mijn.getHeight(); x++) {
            for (int y = 0; y < mijn.getWidth(); y++) {
                final Veld Veld = new Veld(mijn.getMijnenveld(x,y));
                Veld.setPreferredSize(new Dimension(50, 50));
                final int finalX = x;
                final int finalY = y;
                Veld.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(Veld.getWaarde() == 9) {
                            Veld.setText("Bomb");
                        } else if(Veld.getWaarde() == 0) {
                            mijn.drawNull(finalX,finalY);
                            //Veld.setText("Test");
                        } else {
                            mijn.setShowmine(true, finalX, finalY);
                            Veld.setText("" + Veld.getWaarde());
                        }
                    }
                });
                add(Veld);
            }
        }
        pack();
    }

}
