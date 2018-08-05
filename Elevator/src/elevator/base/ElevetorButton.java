package elevator.base;

public class ElevetorButton extends Button{
	
	Direction direction;
	
	public ElevetorButton(Direction direction,int buttonPressedFromFloor){
		super(buttonPressedFromFloor);
		this.direction=direction;
	}

	@Override
	public void placeRequest() {
		// TODO Auto-generated method stub
		
	}
    
}
