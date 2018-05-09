package com.example.nikul;


import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.example.data.entity.User;


import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class Test {


    @org.junit.Test
    public void test(){
        User user = new User();
        user.setAge(25);
        org.junit.Assert.assertEquals(25,user.getAge());
    }

    @org.junit.Test
    public void testPackage(){
        Context appContext= InstrumentationRegistry.getTargetContext();
        Assert.assertEquals("com.example.nikul.myapplication",appContext.getPackageName());
    }


}
