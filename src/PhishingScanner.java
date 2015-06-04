import java.util.ArrayList;

/**
 * Created by Moz on 6/1/2015.
 */
/*The program acts as phishing Scanner and Scans files (Emails) to detect if the email is a phishing Scam by ranking the mail
* The rank is given on an infinite scale ie it can be from 1 to 100000000 or whatever the phishing no lands on
* The Arrangements of the words and their various phishing on are given in an array. both left and right.*/
public class PhishingScanner {
    ArrayList <String> Phishingwords=new ArrayList<String>();
    ArrayList<Integer>Ranking=new ArrayList<Integer>();

    PhishingScanner(){
        //initializing the various array elements in Phishingwords
        Phishingwords.add(0,"Invoice");
        Phishingwords.add(1,"Post");
        Phishingwords.add(2,"Label");
        Phishingwords.add(3,"Document");
        Phishingwords.add(4,"Postal");
        Phishingwords.add(5,"calculations");
        Phishingwords.add(6,"copy");
        Phishingwords.add(7,"Fedex");
        Phishingwords.add(8,"Statement");
        Phishingwords.add(9,"financial");
        Phishingwords.add(10,"dhl");
        Phishingwords.add(11,"usps");
        Phishingwords.add(12,"notification");
        Phishingwords.add(13,"n");
        Phishingwords.add(14,"irs");
        Phishingwords.add(15,"ups");
        Phishingwords.add(16,"no");
        Phishingwords.add(17,"delivery");
        Phishingwords.add(18,"tickets");
        Phishingwords.add(19,"8");

        //initializing elements of Ranking
        //highest ranked
        Ranking.add(0,3);
        Ranking.add(1,3);
        Ranking.add(2,3);
        Ranking.add(3,3);
        Ranking.add(4,3);
        Ranking.add(5,3);
        Ranking.add(6,3);

        //middle ranked
        Ranking.add(7,2);
        Ranking.add(8,2);
        Ranking.add(9,2);
        Ranking.add(10,2);
        Ranking.add(11,1);
        Ranking.add(12,2);
        Ranking.add(13,1);
        Ranking.add(14,2);
        Ranking.add(15,2);

        //low ranked
        Ranking.add(16,1);
        Ranking.add(17,1);
        Ranking.add(18,1);
        Ranking.add(19,1);

    }


    public int Scan(String s, ArrayList<String> phishingwords,ArrayList<Integer> Ranking) {
       int Rank = 0;
        boolean phishingCheck=false;
        while(phishingCheck==false){
            for(int Count=0;Count<20;Count++){
                if(phishingwords.get(Count)==s){
                    Rank=Ranking.get(Count);
                    phishingCheck=true;
                }
            }

        }
        return Rank;
    }
}
