package Missile.src;

import javax.imageio.ImageIO;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.OverlayLayout;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Missile {

    static BufferedImage image;

    static int missileImageWidth = 712;
    static int missileImageHeight = 400;

    static String memeSubtitle = "";

    public static void main(String[] args) {
        JFrame window = new JFrame("The missile    |    created by github.com/checkthistape");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        //window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);

        double windowWidth = 1280.0;
        double windowHeight = 720.0;

        BufferedImage mainFrame;
        try {

            
            //image = ImageIO.read(new FileInputStream("../missile.jpg")); // for a default version
            
            //image = ImageIO.read(Missile.class.getResourceAsStream("missile.jpg")); // for a jar version 1

            image = ImageIO.read(Missile.class.getResourceAsStream("/Missile/res/missile.jpg")); // for a jar version 2

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

            window.setLocationRelativeTo(null);

            window.setVisible(true);

            try {
                //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Missile/res/missile.wav").getAbsoluteFile()); // for a default version

                // read audio data from source
                //AudioInputStream audioInputSrc = AudioSystem.getAudioInputStream(Missile.class.getResourceAsStream("/Missile/res/missile.wav")); // for a jar version
                
                // add buffer for mark/reset support
                BufferedInputStream bufferedIn = new BufferedInputStream(Missile.class.getResourceAsStream("/Missile/res/missile.wav"));
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedIn);

                // ready for play
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            }
            catch(IOException e){
                JOptionPane.showMessageDialog(null, "Problem with audio file" + e);
            }
            

            

            // Reading from file
            try {
                Thread.sleep(2000);

                // for a default version 1
                // FileReader fileReader = new FileReader("../res/copypasta.txt");
                // BufferedReader bufferedReader = new BufferedReader(fileReader);

                // for a jar version 0 #works
                InputStreamReader fileReader = new InputStreamReader(Missile.class.getResourceAsStream("/Missile/res/copypasta.txt"));
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                // for a jar version 1
                // FileReader fileReader = new FileReader(new InputStreamReader(
                //     ClassLoader.getSystemClassLoader()
                //                .getResourceAsStream("Missile/res/copypasta.txt")));
                //FileReader fileReader = Missile.class.getResourceAsStream("/Missile/res/copypasta.txt");

                // for a jar version 2
                // InputStreamReader fileReader = new InputStreamReader(Missile.class.getResourceAsStream("/Missile/res/copypasta.txt"));
                // InputStream inp = ClassLoader.getSystemClassLoader().getResourceAsStream("/Missile/res/copypasta.txt");
                // BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inp));

                
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