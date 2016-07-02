package salestockhw;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Q3 {

	Map <String, Boolean> blacklistMap;
	
	public void initialize(String blacklist) {
		blacklistMap = new HashMap<String, Boolean>();
		BufferedReader br = null;
		try {
			String str;

			br = new BufferedReader(new FileReader (blacklist));

			while ((str = br.readLine()) != null) {
				str = str.replaceAll(" ", "");
				blacklistMap.put(str, true);
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean checkBlacklist(String name, int phoneNumber) {
		return blacklistMap.containsKey(name.trim()+phoneNumber);
	}

	public static void main (String[] args) {

		Q3 q3 = new Q3();
		q3.initialize("/Users/marklauw/Developers/workspace/salestockhw/src/salestockhw/blacklist.txt");
		System.out.println(q3.checkBlacklist("Andi", 1341441));
		System.out.println(q3.checkBlacklist("Melisa", 8565467));
		System.out.println(q3.checkBlacklist("Aslam", 2908345));
		System.out.println(q3.checkBlacklist("ABC", 123456));
		System.out.println(q3.checkBlacklist("Andi", 123456));
		System.out.println(q3.checkBlacklist("ABC", 1341441));
		
	}

}
