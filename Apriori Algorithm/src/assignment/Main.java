package assignment;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		
        //ItemsetGenerator<String> generator = new ItemsetGenerator<>();
        File f = new File("F:\\Study\\dataset.txt");
        ItemsetGenerator<String> generator = new ItemsetGenerator<>();
		List<Set<String>> itemsetList = new ArrayList<>();
        ReadAndGetData r =new ReadAndGetData();
        r.readFile(f);
        itemsetList = r.getTotalData();
        
        ItemsetData<String> data = generator.generate(itemsetList, 2);
        for (Set<String> itemset : data.getItemsetList()) {
        	//m.put(itemset.toString(), data.getSupport(itemset));
            System.out.printf("%9s, support: %1.1f\n", itemset, data.getSupport(itemset));
           // System.out.println(m.toString());
        }
        
        
        while(true) {
	        Scanner in = new Scanner(System.in);
	        
	        System.out.println("Enter a transaction ");
	        String t2 = in.nextLine(); 
	        System.out.println("Enter dependent transaction ");
	        String t1 = in.nextLine();
	        
	        Calculator calculator = new Calculator();
	        calculator.calculateConfidence(f, t1, t2);
        }
    }

}

