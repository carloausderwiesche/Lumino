package de.carloausderwiesche.lumino.controller;

import static org.junit.Assert.*;

import android.content.Context;
import android.hardware.camera2.CameraManager;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import de.carloausderwiesche.lumino.controller.flash.Flash;

@RunWith(AndroidJUnit4.class)
public class FlashTest {
    private Flash flash;



    @Before
    public void initializeFLash(){
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        flash = Flash.getFlashComponent(context);
    }

    @Test
    public void turnFlashOnTest(){
        assertEquals(true, flash.turnFlashOn());
    }

    @Test
    public void turnFlashOffTest(){
        assertEquals(true, flash.turnFlashOff());
    }
}