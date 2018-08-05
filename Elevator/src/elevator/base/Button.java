package elevator.base;

public abstract class Button {
	private int buttonPressFromFloorNum;
	private boolean isButtonPressed;
   	public abstract void placeRequest();
   	
   	public Button(int buttonPressFromFloorNum){
   		this.buttonPressFromFloorNum=buttonPressFromFloorNum;
   	}
   	
	public int getButtonPressFromFloorNum() {
		return buttonPressFromFloorNum;
	}
	public void setButtonPressFromFloorNum(int buttonPressFromFloorNum) {
		this.buttonPressFromFloorNum = buttonPressFromFloorNum;
	}
	public boolean isButtonPressed() {
		return isButtonPressed;
	}
	public void setButtonPressed(boolean isButtonPressed) {
		this.isButtonPressed = isButtonPressed;
	}
   	
   	
}
