package knn;

import java.util.ArrayList;

public class Dataset {

	private ArrayList<Integer> data = new ArrayList<Integer>();
	private int classification;
	
	public void setData(ArrayList<Integer> d) {
		data = d;
	}
	public ArrayList<Integer> getData(){
		return data;
	}
	
	public int getClassification() {
		return classification;
	}
	public void setClassification(int input) {
		classification = input;
	}
}