package knn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class ReadAndTrainData {
	
	private ArrayList<Dataset> total = new ArrayList<Dataset>();
	
	public int lineOfFile(File f) {
		int countLine = 0;
		if(f.exists()) {
			FileReader fr;
			try {
				fr = new FileReader(f);
				BufferedReader ln = new BufferedReader(fr);
				try {
					while(ln.readLine() != null) {
						countLine++;
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return countLine;
	}
	
	//private boolean isComma(String)
	
	public void readFile(File f) {

		int totalLine = 0;
		int i = 0, j = 0;
		totalLine = lineOfFile(f);
		//System.out.println("Total line " + totalLine);
		//String [] d = new String[totalLine];
		//ArrayList<String> da = new ArrayList<String>();
		//ArrayList<String> daa = new ArrayList<String>();
		//String [][] datum = new String[totalLine][4];
		ArrayList<ArrayList<String>> datuma = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<Integer>> datumInteger = new ArrayList<ArrayList<Integer>>();
		//int [][] data = new int [totalLine][4];
		if(f.exists()) {
			FileReader fr;
			try {
				fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				try {
					while(totalLine !=0) {
						//d[i] = br.readLine();
						ArrayList<String> daa = new ArrayList<String>();
						//da.add(br.readLine());
						String [] d = br.readLine().split(" ");
						//for(j=0; j<4; j++) {
						//System.out.println("line " + (i+1) + " "+d[i]);
							//datum[i]=da.get(i).split(","); //d[i].split(",");
							//datuma.addAll(i, da.get(i).split(","));
						for(int m=0; m<d.length; m++) {
							daa.add(d[m]);
						}
						datuma.add(daa);
							
						//}
						totalLine--;
						i++;
						//j++;
						
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(i + " " +j);
			totalLine = lineOfFile(f);
			 for(i=0; i<totalLine; i++) {
				 ArrayList<Integer> di = new ArrayList<Integer>();
				 for(j=0; j<datuma.get(i).size(); j++) {
					 //data[i][j] = Integer.parseInt(datum[i][j]);
					 //if(datuma.get(i).get(j).equals("?"))
					 di.add(Integer.parseInt(datuma.get(i).get(j)));
					 datumInteger.add(di);
					 //System.out.println(" Integer " + data[i][j] + " String "+ datum[i][j]);
				 }
			 }
			 
		}
		for(i = 0; i<totalLine; i++) {
			//for(j = 0; j<4; j++) {
			//System.out.println(data[i][0]);
				Dataset totald = new Dataset();
				ArrayList<Integer> dataa = new ArrayList<Integer>();
				for(j=0; j<datumInteger.get(i).size()-1; j++) {
					dataa.add(datumInteger.get(i).get(j));
				}
				totald.setData(dataa);
				totald.setClassification(datumInteger.get(i).get(j));
				total.add(totald);
				//System.out.println(total.get(i).getFirstValue());
			//}
		}
		
		
	}
	public ArrayList<Dataset> getTotalData() {
		return total;
	}
	
}
