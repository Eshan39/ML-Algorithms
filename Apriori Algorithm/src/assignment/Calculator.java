package assignment;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Calculator {
	
	public void calculateConfidence(File f,String t1, String t2) {
		
		Map<String, Double> m = new HashMap<String, Double>();
		
		ItemsetGenerator<String> generator = new ItemsetGenerator<>();
		List<Set<String>> itemsetList = new ArrayList<>();
        ReadAndGetData r =new ReadAndGetData();
        r.readFile(f);
        itemsetList = r.getTotalData();
        List<String> tmp = new ArrayList<String>();
        ItemsetData<String> data = generator.generate(itemsetList, 2);
        for (Set<String> itemset : data.getItemsetList()) {
        	m.put(itemset.toString(), data.getSupport(itemset));
        	tmp.add(itemset.toString());
           // System.out.printf("%9s, support: %1.1f\n", itemset, data.getSupport(itemset));
           // System.out.println(m.toString());
        }
        //previous week task 
        if(m.containsKey(t2)&&m.containsKey(t1)) {
        	double confidence = (m.get(t2)/m.get(t1))*100;
            System.out.println("Confidence is "+confidence +"%");
        }
        else {
        	System.out.println("Transaction not valid!");
        }
        
       
	}

}
