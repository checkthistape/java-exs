
# missile.exe <img src="https://github.com/checkthistape/missile.exe/blob/main/res/missile.jpg" width="59px" height="33px"></p>

<p text-align="left"><b>missile.exe</b> is a fun and innovative project designed to create an executable meme experience.
The highlight of this project is the creation of a meme <strong>executable</strong> titled <strong>"The missile knows..."</strong>
which includes both sound and programmatically generated subtitles that synchronize perfectly with the audio.</p>
<hr></hr>

<h2>Features</h2>
<ul>
  <li><b>Executable Meme</b>: Enjoy a hilarious meme experience with "The missile knows..." in the form of an executable file.</li>
  <li><b>Dynamic Subtitles</b>: Subtitles are generated programmatically to match the sound, providing an immersive and synchronized meme experience.</li>
  <li><b>No Installation Required</b>: You don't need to install JRE or any Oracle Java software separately. Everything is included in the .exe file for seamless execution.</li>
  <li><b>Portable</b>: The executable file can be easily shared with others, allowing them to enjoy the meme without any additional downloads or installations.</li>
  <li><b>Cross-platform Compatibility</b>: While primarily for Windows, the project also includes a .jar file suitable for Linux systems.</li>
</ul>

</br>

<h2>How to Use</h2>
<b>Download:</b> Simply download the last <a href="https://github.com/checkthistape/missile.exe/releases/download/java/missile-v3.exe">release</a>.</br>
<b>Run</b>: Double-click the executable file to launch the meme experience.</br>
<b>Enjoy</b>: Sit back and enjoy "The missile knows..." meme with dynamically generated subtitles.</br>

</br>

<h2>Sequence of Commands and Actions to Pack a Program</h2>

```
# Command to create a .class file with a .java file
javac Missile/src/Missile.java

# Create a manifest file with the correct path to the main class.

manifest.MF:
Manifest-Version: 1.0
Main-Class: Missile.src.Missile 
Class-Path: .
Created-By: checkthistape

# Command to create a jar package with a manifest file from the folder and all resources (image, text, music)
jar cfm missile.jar Missile/manifest.MF Missile/*

# Command to check what modules my project uses
jdeps -verbose  .\missile.jar

RESULT:
missile.jar -> java.base
missile.jar -> java.desktop
   Missile.src.Missile                                -> java.awt.Color                                     java.desktop
   Missile.src.Missile                                -> java.awt.Component                                 java.desktop
   Missile.src.Missile                                -> java.awt.Container                                 java.desktop
   Missile.src.Missile                                -> java.awt.Font                                      java.desktop
   Missile.src.Missile                                -> java.awt.Graphics2D                                java.desktop
   Missile.src.Missile                                -> java.awt.Image                                     java.desktop
   Missile.src.Missile                                -> java.awt.LayoutManager                             java.desktop
   Missile.src.Missile                                -> java.awt.geom.AffineTransform                      java.desktop
   Missile.src.Missile                                -> java.lang.invoke.MethodHandles$Lookup              java.base
   Missile.src.Missile                                -> java.lang.invoke.MethodType                        java.base
   Missile.src.Missile                                -> java.lang.invoke.StringConcatFactory               java.base
   Missile.src.Missile                                -> javax.imageio.ImageIO                              java.desktop
   Missile.src.Missile                                -> javax.sound.sampled.AudioInputStream               java.desktop
   Missile.src.Missile                                -> javax.sound.sampled.AudioSystem                    java.desktop
   Missile.src.Missile                                -> javax.sound.sampled.Clip                           java.desktop
   Missile.src.Missile                                -> javax.swing.Icon                                   java.desktop
   Missile.src.Missile                                -> javax.swing.ImageIcon                              java.desktop
   Missile.src.Missile                                -> javax.swing.JFrame                                 java.desktop
   Missile.src.Missile                                -> javax.swing.JLabel                                 java.desktop
   Missile.src.Missile                                -> javax.swing.JOptionPane                            java.desktop
   Missile.src.Missile                                -> javax.swing.JTextArea                              java.desktop
   Missile.src.Missile                                -> javax.swing.OverlayLayout                          java.desktop

# Command to create a "diet" jdk folder with modules my project needs (java.base, java.desktop)
jlink --add-modules java.base,java.desktop --output folder

# run.bat file:

@echo off
setlocal

set "HERE=%~dp0"

start "" "%HERE%\jre\bin\javaw.exe" -jar "%HERE%\missile.jar"

endlocal

# Utility that packs JRE with a .jar package and runs it with a .bat file (in that case, run.bat) (https://github.com/dgiagio/warp)
warp-packer --arch windows-x64 --input_dir project --exec run.bat --output missile.exe

```
</br>

<h2>Contributions</h2>
Contributions to the project are welcome! Feel free to submit pull requests, report issues, or suggest new features to enhance the meme experience.</br>

</br>

<h2>License</h2>
This project is licensed under the MIT License, allowing for open collaboration and modification.</br>

</br>

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Shell Script](https://img.shields.io/badge/shell_script-%23121011.svg?style=for-the-badge&logo=gnu-bash&logoColor=white) ![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-0078d7.svg?style=for-the-badge&logo=visual-studio-code&logoColor=white)

<hr></hr>

</br>

	 Disclaimer: This project is not affiliated with any official missile programs or organizations.
</br>

by [checkhtistape](https://github.com/checkthistape)
>MIT License [©](https://github.com/checkthistape/databaseimitating/blob/main/LICENSE) 
