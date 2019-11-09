package knn;

import java.io.File;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f = new File("F:\\Assignment\\dbms\\KNN DataSet\\shuttle.tst");

		int k_fold = 10;
		int k_value = 3;
		KNN knn = new KNN();
		knn.run_KNN_Algo(f, k_fold, k_value);
	}

}
