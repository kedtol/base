package hu.bme.mit.train.sensor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;

import static org.mockito.Mockito.*;

public class TrainSensorTest {

    TrainController trainController;
    TrainUser trainUser;
    TrainSensorImpl trainSensorImpl;


    @Before
    public void before() {
        trainController = mock(TrainController.class);
        trainUser = mock(TrainUser.class);
        trainSensorImpl = new TrainSensorImpl(trainController, trainUser);
    }

    @Test
    public void absMinMargin()
    {
        trainSensorImpl.overrideSpeedLimit(-1);
        verify(trainUser,times(1)).setAlarmState(true);
    }

    @Test
    public void absMaxMargin()
    {
        trainSensorImpl.overrideSpeedLimit(501);
        verify(trainUser,times(1)).setAlarmState(true);
    }

    @Test
    public void relativeMargin()
    {
        trainSensorImpl.overrideSpeedLimit(4);
        verify(trainUser,times(0)).setAlarmState(true);
    }

    @Test
    public void betweenMargin()
    {
        trainSensorImpl.overrideSpeedLimit(300);
        verify(trainUser,times(0)).setAlarmState(false);
    }

}
