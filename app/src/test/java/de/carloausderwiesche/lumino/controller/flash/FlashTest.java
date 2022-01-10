package de.carloausderwiesche.lumino.controller.flash;

import static org.junit.Assert.*;

import android.content.Context;
import android.hardware.camera2.CameraManager;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FlashTest {
    private Flash flash;
    @Mock
    private Context context;


    @Before
    public void initializeFLash(){
        context = Mockito.mock(Context.class, Context.CAMERA_SERVICE);
        flash = Flash.getFlashComponent(context);
    }

    @Test
    public void turnFlashOnTest(){
        assertEquals(true, flash.turnFlashOn());
    }

}