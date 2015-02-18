import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by ewart on 12-2-2015.
 */
public class Mijnenveger {
    private int[][] mijnenveld;
    private int mijnen;
    private int height;
    private int width;
    private boolean[][] showmine;


    public Mijnenveger(int mijnen) {
        this.mijnen = mijnen;
        this.mijnenveld = new int[9][9];
        this.showmine = new boolean[9][9];
        this.height = mijnenveld.length;
        this.width = mijnenveld[1].length;
        Random rn = new Random();

        while(mijnen > 0) {

            int rand1 = rn.nextInt(9);
            int rand2 = rn.nextInt(9);
            if (mijnenveld[rand1][rand2] != 9) {

                this.mijnenveld[rand1][rand2] = 9;
                mijnen--;
            }
        }
        genereerVeld();
    }

    public void genereerVeld() {
        //positie bepalen
        for(int x = 0; x < height; x++) {
            for(int y = 0; y < width; y++) {
                int aantal = 0;
                    //kijkt of geselecteerde Veld geen bom is
                    if (mijnenveld[x][y] != 9) {
                        //alle 9 omringende getallen selecteren
                        for(int i = -1; i<2;i++) {
                            for (int j = -1; j < 2; j++) {
                                //checkt if geselecteerde Veld bestaat
                                if (x + i > 0 & x + i < height) {
                                    if (y + j > 0 & y + j < width) {
                                        //kijkt of geselecteerde vak een bom is
                                        if (mijnenveld[(x + i)][(y + j)] == 9) {
                                            aantal++;
                                        }
                                    }
                                }
                            }
                        }
                        this.mijnenveld[x][y] = aantal;
                    }
            }

        }
    }

    public void drawNull(int pos1, int pos2){
         showmine[pos1][pos2] = true;
         System.out.println("------------------------");
         for(int i = -1; i<2;i++) {
            for (int j = -1; j < 2; j++) {
                //checkt if geselecteerde Veld bestaat
                if (pos1 + i > 0 && pos1 + i < height) {
                    if (pos2 + j > 0 && pos2 + j < width) {
                        //als geselecteerde vak een 0 is
                        if (mijnenveld[pos1 + i][pos2 + j] == 0) {
                               // System.out.print("pos = null ");
                            if(showmine[pos1 + i][pos2 + j]) { //als al zichtbaar is
                                //System.out.print("showmine = true ");
                            } else { // als mijn niet zichtbaar is
                                //System.out.print("showmine = false ");
                                drawNull(pos1 + i, pos2 + j);
                            }
                        } else {
                            //System.out.print("pos != null");
                            showmine[pos1 + i][pos2 + j] = true;
                        }
                        System.out.print("[" + i + "," + j + "]\n");
                    }

                }
            }
         }

    }


    @Override
    public String toString() {
        String veld = "+ ";
        for (int i = 1; i <= height; i++) {
            veld += (i - 1) + " ";
        }
        veld += "\n0 ";
        for (int i = 0; i < width; i++) {
            for (int y = 0; y < height; y++) {
                veld += mijnenveld[i][y] + " ";
            }
           veld += "\n" + (i + 1) + " ";
        }
        veld = veld.substring(0, veld.lastIndexOf("\n"));
        return veld;
    }

    public int getMijnenveld(int pos1, int pos2) {
        return mijnenveld[pos1][pos2];
    }

    public void setMijnenveld(int mijnenveld, int pos1, int pos2) {
        this.mijnenveld[pos1][pos2] = mijnenveld;
    }

    public int getMijnen() {
        return mijnen;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean getShowmine(int pos1, int pos2) {
        return showmine[pos1][pos2];
    }

    public void setShowmine(boolean showmine, int pos1, int pos2) {
        this.showmine[pos1][pos2] = showmine;
    }
}

