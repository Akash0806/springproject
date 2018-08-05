package elevator.base;

import org.omg.CORBA.Request;

public class ElevatorRequest {

	int requestFloor;
	RequestSchedulingAlgorithm algorithm;
	
	public ElevatorRequest(RequestSchedulingAlgorithm algorithm) {
		this.algorithm=algorithm;
	}
	
	
	public void removeRequest(){
		
	}
	
	public void assignRequestToQueue(ElevatorRequest elevatorRequest){
		  /**
		   * 1. create queue
		   * 2. push request to queue
		   * 
		   * */
	  }
}
