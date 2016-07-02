package salestockhw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Q1 {

	// Assumption
	public static final int MAX_AGE = 150;

	public void sort (String inputfile) {

		long [] ageCount = new long [MAX_AGE+1];

		BufferedReader br = null;
		try {
			String str;

			br = new BufferedReader(new FileReader (inputfile));

			while ((str = br.readLine()) != null) {
				try{
					int age = Integer.parseInt(str.trim());
					if (age < 0) continue;
					ageCount[age]++;
				} catch (NumberFormatException e) {
					continue;
				}
			}

			br.close();

			String outputFile;
			int dotIndex = inputfile.lastIndexOf(".");
			if (dotIndex != -1) {
				outputFile = inputfile.substring(0,dotIndex) + "_out" + inputfile.substring(dotIndex);
			} else {
				outputFile = inputfile + "_out";
			}
			
			File file = new File(outputFile);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			for (int age = 0; age < ageCount.length; age++) {
				for (long i = 0; i < ageCount[age]; i++) {
					pw.println(age);
				}
			}

			bw.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void main (String[] args) {

		Q1 q1 = new Q1();
		q1.sort("/Users/marklauw/Developers/workspace/salestockhw/src/salestockhw/input.txt");
		q1.sort("/Users/marklauw/Developers/workspace/salestockhw/src/salestockhw/input");

	}

}
