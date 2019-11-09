package knn;

public class Distance implements Comparable{
	
	private double dis;
	private int classification;
	
	public void setDistance(double dis) {
		this.dis = dis;
	}
	public double getDistance() {
		return dis;
	}
	
	
	public void setClassification(int c) {
		classification = c;
	}
	public int getClassification() {
		return classification;
	}
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		Distance d = (Distance) arg0;
		if(this.dis<d.dis)
			return 1;
		return 0;
	}
	
	

}
