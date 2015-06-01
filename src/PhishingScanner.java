import java.util.ArrayList;

/**
 * Created by Moz on 6/1/2015.
 */
/*The program acts as phishing Scanner and Scans files (Emails) to detect if the email is a phishing Scam by ranking the mail
* The rank is given on an infinite scale ie it can be from 1 to 100000000 or whatever the phishing no lands on
* The Arrangements of the words and their various phishing on are given in an array. both left and right.*/
public class PhishingScanner {
    ArrayList <String> Phishingwords=new ArrayList<String>();
    ArrayList<Integer>Rnaking=new ArrayList<Integer>();

    PhishingScanner(){
        Phishingwords.add(0,"Invoice");
    }




}
