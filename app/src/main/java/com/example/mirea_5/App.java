package com.example.mirea_5;

import android.app.Application;

import com.example.mirea_5.ioc.ApplicationComponent;

public class App extends Application {

    private static final ApplicationComponent applicationComponent = new ApplicationComponent();

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
