package assignment;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReadAndGetData {
	
	private List<Set<String>> itemsetList = new ArrayList<>();
	
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
		ArrayList<ArrayList<String>> datuma = new ArrayList<ArrayList<String>>();
		if(f.exists()) {
			FileReader fr;
			try {
				fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				try {
					while(totalLine !=0) {
						ArrayList<String> daa = new ArrayList<String>();
						String [] d = br.readLine().split(",");
						for(int m=0; m<d.length; m++) {
							daa.add(d[m]);
						}
						datuma.add(daa);
						totalLine--;
						i++;
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
		totalLine = lineOfFile(f);
		for(i=0; i<totalLine; i++) {
			Set<String> s = new HashSet<String>();
			for(j=0; j<datuma.get(i).size();j++) {
				String ss = datuma.get(i).get(j);
				s.add(ss);
			}
			itemsetList.add(s);
		}
	}
	
	public List<Set<String>> getTotalData() {
		return itemsetList;
	}
}