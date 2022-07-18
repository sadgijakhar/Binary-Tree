import java.util.*;
public class DistintValues{
     static HashSet<String> hs = new HashSet<>();
	//Method to print distinct values
	public static void printValues(Map<Integer,String> map){
        hs.addAll(map.values());
        Iterator<String> it = hs.iterator();
        while (it.hasNext()) {
  
            System.out.print(it.next() + " ");
        }
	}
	
	public static void main(String[] x){
		Map<Integer,String> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int key;
		String value;
		for(int i = 1; i <= num; i++){
			key = sc.nextInt();
			value = sc.next();
			map.put(key,value);
		}
		printValues(map);
        sc.close();
	}
}

