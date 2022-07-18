
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Iteneriy {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // get the no of tickets from input
        int n = in.nextInt();

        // map to store all the tickets
        Map<String, String> tickets = new HashMap<String, String>();
        Map<String ,String > reversetickets = new HashMap<String,String>();
        String key = null;
        String value =null ;
        String Start = null;
        // Store the source and destination of the tickets to the map "tickets"
        for (int i = 0; i < n; i++) {
            tickets.put(key = in.next(), value =in.next());
            in.nextLine();
            reversetickets.put(value,key);
            if(!reversetickets.containsKey(key)){
                Start =key;
            }
        }
        System.out.print(Start +" ");
        for(int i = 0 ; i < tickets.size() ; i++){
           System.out.print(tickets.get(Start) +" ");
           Start =  tickets.get(Start);
        }
        in.close();
        
        
        


        

        // write your code here
        
    }
}