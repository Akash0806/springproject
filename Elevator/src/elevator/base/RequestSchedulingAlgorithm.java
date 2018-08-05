package elevator.base;

public abstract class RequestSchedulingAlgorithm {

	 /**
	   * 1.
	   * if elevator running in down directions pick up request
	   * other wise assign on queue
	   * 2. if elevator reach top floor or last press floor 
	   * 3. pick up next request from queue
	   * */
	 public abstract void elevatorScheduling(ElevatorRequest elevatorRequest);
		 
	  
	 
	
}
