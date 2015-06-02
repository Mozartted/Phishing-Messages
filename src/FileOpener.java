/**
 * Created by Moz on 6/1/2015.
 */
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

    //items in the menu bar
    private Menu file=new Menu();
    private MenuItem openFile=new MenuItem();
    private MenuItem Scan=new MenuItem();
    private MenuItem closeProgram=new MenuItem();

    public FileOpener(){
        setSize(600,500);
        setTitle("Phishing Scanner");
        textArea.setFont(new Font("Arial",Font.ITALIC,15));
        getContentPane().add(textArea);

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
        ScanButton.addActionListener(this);
        ScanButton.setVisible(true);;
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
                    while(OpenFIle.hasNext()){
                        textArea.append(OpenFIle.nextLine());
                    }

                }catch(FileNotFoundException exceptionE){
                    JOptionPane.showMessageDialog(null, exceptionE.getMessage());

                }

            }

        }else if(event.getSource()==this.Scan||event.getSource()==this.ScanButton){
            

        }else if(event.getSource()==this.closeProgram){
            this.dispose();
        }
    }
}
