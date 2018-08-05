package elevator.base;



public class Elevator {
  private int capacity;
  private int currentFloor;
  private int numberFloor;
  private ElevetorButton[] numberButton;
  private boolean isRunning;
  
  public Elevator(int capacity, int currentFloor,int numberFloor) {
		super();
		this.capacity = capacity;
		this.currentFloor = currentFloor;
		this.numberFloor = numberFloor;
		this.numberButton = new ElevetorButton[numberFloor];
	}



  
  
  public int getCapacity() {
	return capacity;
}

public void setCapacity(int capacity) {
	this.capacity = capacity;
}

public int getCurrentFloor() {
	return currentFloor;
}

public void setCurrentFloor(int currentFloor) {
	this.currentFloor = currentFloor;
}

public ElevetorButton[] getNumberButton() {
	return numberButton;
}

public void setNumberButton(ElevetorButton[] numberButton) {
	this.numberButton = numberButton;
}

public boolean isRunning() {
	return isRunning;
}

public void setRunning(boolean isRunning) {
	this.isRunning = isRunning;
}

public boolean openDoor(){
	
	  return true;
  }
  
  public boolean closeDoor(){
		
	  return true;
  }
  
  public void goUp(){
	  
  }
  
  public void goDown(){
	  
  }
  
  public void displayFloor(){
	  
  }
  
  private boolean isElevatorRunning(){
	  
  return isRunning;
  }
  
 
  
 
  
  private boolean verifyCapcity(){
	  
	  return true;
  }
}
