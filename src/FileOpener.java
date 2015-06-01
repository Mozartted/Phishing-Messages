/**
 * Created by Moz on 6/1/2015.
 */
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.swing.*;

public class FileOpener extends JFrame implements ActionListener {

    //create text area where the file would appear to be processed
    private TextArea textArea=new TextArea("",0,0,TextArea.SCROLLBARS_VERTICAL_ONLY);
    private MenuBar menubar=new MenuBar();

    //items in the menu bar
    private Menu file=new Menu();
    private MenuItem openFile=new MenuItem();
    private MenuItem Scan=new MenuItem();

    public FileOpener(){
        setSize(600,500);
        setTitle("Phishing Scanner");
        textArea.setFont(new Font("Arial",Font.ITALIC,15));
        getContentPane().add(textArea);

    }
}
