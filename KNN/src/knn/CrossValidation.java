package knn;

import java.util.ArrayList;
import java.util.Collections;

public class CrossValidation {
	
	private ArrayList<Dataset> total = new ArrayList<Dataset>();
	private ArrayList<ArrayList<Dataset>> train = new ArrayList<ArrayList<Dataset>>();
	private ArrayList<ArrayList<Dataset>> test = new ArrayList<ArrayList<Dataset>>();
	private int k_fold;

	public CrossValidation(ArrayList<Dataset> total, int k_fold) {
		this.total = total;
		this.k_fold = k_fold;
	}
	
	public void generateTrainData() {
		int tests = (total.size()/k_fold)+1;
		for(int i=0; i<k_fold; i++) {
			
			Collections.shuffle(total);
			
			ArrayList<Dataset> temp1 = new ArrayList<Dataset>();
			ArrayList<Dataset> temp2 = new ArrayList<Dataset>();
			int j;
			for(j=0; j<tests; j++) {
				temp1.add(total.get(j));
			}
			test.add(temp1);
			
			for(int k=j; k<total.size(); k++) {
				temp2.add(total.get(k));
			}
			train.add(temp2);
		}
	}
	
	public ArrayList<ArrayList<Dataset>> getTrainedData(){
		return train;
	}
	public ArrayList<ArrayList<Dataset>> getTestData(){
		return test;
	}

}
