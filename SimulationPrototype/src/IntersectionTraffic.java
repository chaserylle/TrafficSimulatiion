import java.util.ArrayList;
import java.util.Scanner;


public class IntersectionTraffic {
	Scanner keyboard = new Scanner(System.in);
	public Lane magsaysay;
	public Lane harrison;
	public Lane shanum;
	public Lane abanao;
	public ArrayList<Lane> intersection = new ArrayList<Lane>(){ 
        { 
            add(magsaysay); 
            add(harrison); 
            add(shanum); 
            add(abanao); 
        } 
    };
	
	public int cars=4;
	public double seconds=5;
	public double redlightDefault = 45; //in seconds
	public double greenLightDefault = 45; //in seconds
	public double yellowLightDeefault = 5; // in seconds
	int temp;
	short lanesLeft = 4;
	
	
	public static void main(String[] args) {
		IntersectionTraffic x = new IntersectionTraffic();
		x.execute();
		
	}
	
	public void execute() {
		startCycle();
	}
	
	public void startCycle() {
		double tempNo=0;
		
		for(int i=0; i<4; i++) {
			if(i==0) {
				System.out.print("No. of cars in queue coming from MAGSAYSAY:");
				tempNo = keyboard.nextDouble();
			}
			if(i==1) {
				System.out.print("No. of cars in queue coming from HARRISON:");
				tempNo = keyboard.nextDouble();
			}
			if(i==2) {
				System.out.print("No. of cars in queue coming from SHANUM:");
				tempNo = keyboard.nextDouble();
			}
			if(i==3) {
				System.out.print("No. of cars in queue coming from ABANAO:");
				tempNo = keyboard.nextDouble();
			}
			intersection.set(i, new Lane(tempNo));
		}
		
			double highest = getMax(intersection);
			
			for(int x=0; x<intersection.size(); x++) {
				intersection.get(x).setCoefficient(((highest - intersection.get(x).getQueue())/cars)*seconds);
			}
			
			highestAndLowest(); //yung pag add ng lowest coef dun sa greenlight ng priority and red light ng least priority
			
	
	}
	
	//yung pag add ng lowest coef dun sa greenlight ng priority and red light ng least priority
	public void highestAndLowest() {
		double smallest = getMinCoef(intersection);
		System.out.println(smallest);
		
		for (int i=0; i<intersection.size(); i++) {
			if(intersection.get(i).getCoefficient()==0) {
				intersection.get(i).setGreenLightDuration(intersection.get(i).getGreenLightDuration()+smallest);
			}
			else{
				intersection.get(i).setRedLightDuration(intersection.get(i).getRedLightDuration()+smallest);
			}
		}
		
		for (int x=0; x<intersection.size(); x++) {
//			System.out.print(intersection.get(x).getGreenLightDuration()+"  ");
			System.out.print(intersection.get(x).getRedLightDuration()+"  ");
		}
		
	}
	
	public double getMax(ArrayList<Lane> data) {
		double max = 0;
		for(int i = 0; i < data.size(); i++)
		{
			if(data.get(i).getQueue() > max)
			{
				max = data.get(i).getQueue();
			}
		}
		return max;
	}
	
	public double getMinCoef(ArrayList<Lane> data) {
		double min = 1000000;
		for(int i = 0; i < data.size(); i++)
		{
			if(data.get(i).getCoefficient() < min && data.get(i).getCoefficient()!=0)
			{
				min = data.get(i).getCoefficient();
			}
		}
		return min;
	}
	
}
