package hu.bme.mit.train.interfaces;

public interface TrainUser {

	int getJoystickPosition();

	boolean getAlarmFlag();

	void overrideJoystickPosition(int joystickPosition);

	void overrideBreakPosition(boolean breakPosition);

	void setAlarmState(boolean alarmState);

	boolean getAlarmState();

}
