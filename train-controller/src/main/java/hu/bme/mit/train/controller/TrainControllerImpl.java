package hu.bme.mit.train.controller;

import hu.bme.mit.train.interfaces.TrainController;

public class TrainControllerImpl implements TrainController, Thread {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private boolean breakPosition = false;
	private int time = 0;


	public TrainControllerImpl()
	{
		this.start();
	}

	public void run() 
	{
		followSpeed();	
	}

	@Override
	public void followSpeed() {
		if (!breakPosition)
		{
			if (referenceSpeed < 0) {
				referenceSpeed = 0;
			} else {
				if(referenceSpeed+step > 0) {
					referenceSpeed += step;
				} else {
					referenceSpeed = 0;
				}
			}
		}
		else
		{
			referenceSpeed = 0;
		}
		time++;
		enforceSpeedLimit();
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;	
	}

	@Override
	public void setBreaks(boolean breakPosition)
	{
		this.breakPosition = breakPosition;		
	}

	@Override
	public int getTime()
	{
		return time;
	}

}
