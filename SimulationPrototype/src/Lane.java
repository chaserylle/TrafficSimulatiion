public class Lane {

	private double queue;
	private int carsPassed;
	private double redLightDuration=45; //in seconds
	private double greenLightDuration=45; //in seconds
	private double coefficient; //after using the formula
	private int priorityLevel;
  
	public Lane(double queue) {
		super();
		this.queue = queue;
	}
	
  	public double getQueue() {
  		return queue;
	}
  
	public void setQueue(double queue) {
		this.queue = queue;
	}
	
	public int getCarsPassed() {
		return carsPassed;
	}
	
	public void setCarsPassed(int carsPassed) {
		this.carsPassed = carsPassed;
	}
	
	public double getRedLightDuration() {
		return redLightDuration;
	}
	
	public void setRedLightDuration(double redLightDuration) {
		this.redLightDuration = redLightDuration;
	}
	
	public double getGreenLightDuration() {
		return greenLightDuration;
	}
	
	public void setGreenLightDuration(double greenLightDuration) {
		this.greenLightDuration = greenLightDuration;
	}
	
	public int getPriorityLevel() {
		return priorityLevel;
	}

	public void setPriorityLevel(int priorityLevel) {
		this.priorityLevel = priorityLevel;
	}
	
	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	  
}
