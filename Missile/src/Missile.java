package Missile.src;

import javax.swing.JFrame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public class Missile {

    static BufferedImage image;

    static int missileImageWidth = 712;
    static int missileImageHeight = 400;

    static String memeSubtitle = "";

    public static void main(String[] args) {
        JFrame window = new JFrame("The missile");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        double windowWidth = 1280.0;
        double windowHeight = 720.0;

        BufferedImage mainFrame;
        try {

            image = ImageIO.read(new FileInputStream("../missile.jpg"));

            AffineTransform at = new AffineTransform();

            mainFrame = new BufferedImage(missileImageWidth, missileImageHeight, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g = mainFrame.createGraphics();

            g.drawImage(image, at, null);
            g.dispose();

            JLabel label = new JLabel();

            LayoutManager overlay = new OverlayLayout(label);
            label.setLayout(overlay);

            JLabel memeText = new JLabel(memeSubtitle);
            memeText.setFont(new Font("Impact", Font.BOLD, 50));
            memeText.setForeground(Color.white);
            memeText.setAlignmentX(0.5f);
            memeText.setAlignmentY(0.99f);


            label.add(memeText);

            label.setFocusable(true);
            window.add(label);

            label.setIcon(new ImageIcon(mainFrame));

            window.pack();
            window.setVisible(true);

            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Missile/res/missile.wav").getAbsoluteFile());
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(null, "Problem with audio file");
            }
            

            

            // Reading from file
            try {
                Thread.sleep(2000);

                FileReader fileReader = new FileReader("Missile/res/copypasta.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                
                int character;

                int spaceCount = 0;
                int spaceAbsolute = 0;
                

                String txt = "";
                while ((character = bufferedReader.read()) != -1) {
                    if ((char) character == ' ') { spaceCount++; spaceAbsolute++; }
                    if (spaceCount==4) {
                        memeSubtitle = txt;
                        memeText.setText(memeSubtitle);
                        spaceCount=0;

                        txt = "";
                        
                        if(spaceAbsolute%3==0){
                            Thread.sleep(1200);
                        }
                        else {Thread.sleep(1600);}
                        
                    }

                    txt += ((char) character);
                }

                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }

    }
}