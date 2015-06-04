/**
 * Created by Moz on 6/1/2015.
 */
import com.sun.xml.internal.stream.writers.UTF8OutputStreamWriter;

import java.awt.*;
import java.io.*; //opening the file chosen
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;

public class FileOpener extends JFrame implements ActionListener {

    //create text area where the file would appear to be processed
    private TextArea textArea=new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
    private JButton ScanButton=new JButton();
    private MenuBar menubar=new MenuBar();

    //adding a layout class
    private FlowLayout layout=new FlowLayout();

    //items in the menu bar
    private Menu file=new Menu();
    private MenuItem openFile=new MenuItem();
    private MenuItem Scan=new MenuItem();
    private MenuItem closeProgram=new MenuItem();

    //temporary file to file temporary
     PrintStream output;
    private int Ranker;


    public FileOpener(){
        setSize(600,500);
        setTitle("Phishing Scanner");
        textArea.setFont(new Font("Arial",Font.PLAIN,15));
        getContentPane().add(textArea);
        this.setLayout(layout);

        //creating menu
        setMenuBar(menubar);
        file.setLabel("Menu");
        menubar.add(file);

        //adding open file sub-menu
        openFile.setLabel("Open File");
        openFile.addActionListener(this);
        openFile.setShortcut(new MenuShortcut(KeyEvent.VK_I,false));
        file.add(openFile);

        //adding scan file sub-menu
        Scan.setLabel("Scan File");
        Scan.addActionListener(this);
        Scan.setShortcut(new MenuShortcut(KeyEvent.VK_S));
        file.add(Scan);

        //adding event to close program
        closeProgram.setLabel("Close");
        closeProgram.addActionListener(this);
        closeProgram.setShortcut(new MenuShortcut(KeyEvent.VK_F4));
        file.add(closeProgram);

        //adding button
        ScanButton.setText("Scan File");
        ScanButton.setSize(14, 3);
        ScanButton.addActionListener(this);
        ScanButton.setVisible(true);
        this.add(ScanButton);



    }//end constructor

    public void actionPerformed (ActionEvent event){
        //checks if the action performed is to scan or to open file
        if (event.getSource()==this.openFile){
            JFileChooser open=new JFileChooser();//open dialog to select file to scan

            int Option=open.showOpenDialog(open);

            if(Option==JFileChooser.APPROVE_OPTION){
                this.textArea.setText("");//clearing the screen
                try{
                    Scanner OpenFIle=new Scanner(new FileReader(open.getSelectedFile().getPath()));
                    File tempFile=new File("tempfile.txt");
                    output=new PrintStream(tempFile);

                    while(OpenFIle.hasNext()){
                        String nextLine=OpenFIle.nextLine();
                        textArea.append(nextLine);
                        output.print(nextLine);
                    }
                }catch(FileNotFoundException exceptionE){
                    JOptionPane.showMessageDialog(null, exceptionE.getMessage());
                }catch (IOException exception){
                    JOptionPane.showMessageDialog(null,String.format("Error processing file"));
                }

            }

        }else if(event.getSource()==this.Scan||event.getSource()==this.ScanButton){
            /*Calling a class from the Phishing Scanner class to use in Ranking each word
            * and thus determine its ranking, this ranking is returned from the method and
            * its added to the overall ranking used in the whole program to determine ranki-
            * ng of the file.
            * */

            try{
             Scanner Scanning=new Scanner(new  FileReader("tempfile.txt"));

                boolean indicator=true;
                PhishingScanner newScan=new PhishingScanner(indicator);
                while(Scanning.hasNext()){

                  Ranker=+ newScan.Scan(Scanning.next(),newScan.Phishingwords,newScan.Ranking);
                }
                String Likeness=LikelyHoodOfBeingPhishing(Ranker);
                JOptionPane.showMessageDialog(null,String.format("The File has a ranking of %d on the Phishing Scale, %s",Ranker,Likeness));



            }catch(FileNotFoundException exception){
                JOptionPane.showMessageDialog(null,String.format("Error Processing File...."));
                dispose();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }else if(event.getSource()==this.closeProgram){
            this.dispose();
        }
    }

    public static String LikelyHoodOfBeingPhishing(int RankNo){
        String message = null;
       if(RankNo>15) message = String.format("The File is most likely a Phishing Scam");
        if(RankNo>8&&RankNo<15)message=String.format("The File has a 50% chance of being a phishing Scam");
        if(RankNo<8&&RankNo>4)message=String.format("the File has 20% chances of being a phishing Scam");
        if(RankNo<4)message=String.format("the File is not a Phishing Scam");

        return message;
    }

    public static void main(String [] args){
        FileOpener application=new FileOpener();
        application.setVisible(true);
        application.setSize(600,300);
        application.setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
