package knn;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class KNN {
	
	
	public ArrayList<ArrayList<Distance>> calculateDistance(ArrayList<Dataset> test, ArrayList<Dataset> train) {
		
		
		ArrayList<ArrayList<Distance>> dist = new ArrayList<ArrayList<Distance>>();
		for(int i=0; i<test.size(); i++) {
			
			
			ArrayList<Distance> d = new ArrayList<Distance>();
			for(int j=0; j<train.size(); j++) {
				
				double distance = 0.0;
				
				Distance dis = new Distance();
				
				
				for(int k=0; k<test.get(i).getData().size(); k++) {
					distance += (double)((test.get(i).getData().get(k)-train.get(j).getData().get(k))*(test.get(i).getData().get(k)-train.get(j).getData().get(k)));
				}
				
				distance = Math.sqrt(distance);
				
				dis.setDistance(distance);
				dis.setClassification(train.get(j).getClassification());
				d.add(dis);
				//dist.add(d);
			}
			//Collections.sort(d);
			dist.add(d);
		}
		//System.out.println(allDistance);
		return dist;
	}
	
	public int getPriorityClass(ArrayList<Integer> classes) {
		
		int cls=0;
		Collections.sort(classes);
		//System.out.println(classes);
		classes.add(-2);
		int initial = classes.get(0);
		//System.out.println("initial "+initial);
		int countClasses=1;
		
		HashMap<Integer, Integer> clss = new HashMap<Integer, Integer>();
		//System.out.println("test");
		for(int i=1; i<classes.size(); i++) {
			if(initial != classes.get(i)) {
				//System.out.println(" t "+initial+"  "+countClasses);
				clss.put(initial, countClasses);
				countClasses=0;
				initial = classes.get(i);
			}
			countClasses++;
		}
		
//		for(int i=0; i<classes.size(); i++) {
//			clss.put(classes.get(i), 1);
//			
//		}
		//System.out.println(clss.keySet()+" "+clss.values());
		int max = Collections.max(clss.values());
		for(Entry<Integer, Integer> entry: clss.entrySet()) {
			if(entry.getValue() == max) {
				cls = entry.getKey();
			}
		}
		//System.out.println("priority cls "+ cls);
		return cls;
	}
	
	public void run_KNN_Algo(File f, int k_fold, int k_value) {
		
		ReadAndTrainData r = new ReadAndTrainData();
		r.readFile(f);
		
		CrossValidation cv = new CrossValidation(r.getTotalData(), k_fold);
		cv.generateTrainData();
		
		ArrayList<ArrayList<Dataset>> test = new ArrayList<ArrayList<Dataset>>();
		ArrayList<ArrayList<Dataset>> train = new ArrayList<ArrayList<Dataset>>();
		test = cv.getTestData();
		train = cv.getTrainedData();
		
		
		
		for(int i=0; i<k_fold; i++) {
			ArrayList<ArrayList<Distance>> allDistance = new ArrayList<ArrayList<Distance>>();
			allDistance = calculateDistance(test.get(i), train.get(i));
			int matched = 0; //notMatched=0;
			for(int j=0; j<allDistance.size(); j++) {
				
				ArrayList<Distance> d = new ArrayList<Distance>();
				d = allDistance.get(j);
				Collections.sort(d);
				ArrayList<Integer> classes = new ArrayList<Integer>();
				for(int k=0; k<k_value; k++) {
					classes.add(d.get(k).getClassification());
					//System.out.println(classes.get(k));
				}
				//System.out.println("tests");
				int pc = getPriorityClass(classes);
				
				if(pc == test.get(i).get(j).getClassification()) {
					matched++;
				}
				//else notMatched++;
			}
			double accuracy=0.0;
			System.out.println("matched "+matched);
			//System.out.println();
			accuracy =(double) matched/test.get(i).size();
			System.out.println("accuracy "+accuracy);
			double accuracyInPersentage;
			accuracyInPersentage = accuracy*100;
			
			System.out.println("Accuracy "+ accuracyInPersentage +"%");
			System.out.println();
		}
	}
}
