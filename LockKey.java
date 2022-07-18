import java.util.HashMap;
import java.util.Scanner;

public class LockKey {

    public static void main(String arg[]) {
        Scanner in = new Scanner(System.in);

        // get the number of keys
        int n = in.nextInt();

        char keys[] = new char[n];
        char locks[] = new char[n];
        HashMap<Character,Character> hs = new HashMap<>();
        // store all the keys to the array "keys"
        for (int i = 0; i < n; i++) {
            keys[i] = in.next(".").charAt(0);
        }
        for (int i = 0; i < n; i++) {
            locks[i] = in.next(".").charAt(0);
        }
        for (int i = 0; i < n; i++) {
            hs.put(locks[i] , keys[i]);
        }
        boolean flag = true;
        char [] temp = keys;
        for(int i =0 ; i < n  ; i++){
            if(hs.containsValue(locks[i])){
                locks[i] = temp[i];
                
            }
            else{
                System.out.println("Not Possible");
                flag = false;
                break;
            }
            
        }
        if(flag){
            for(int i = 0 ; i< n ; i++){
                System.out.println(temp[i] +" "+ locks[i]);
            }
        }
        in.close();
        //write your code here
    }
}

