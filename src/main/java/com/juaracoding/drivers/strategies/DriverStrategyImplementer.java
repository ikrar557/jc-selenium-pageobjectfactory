package com.juaracoding.drivers.strategies;

public class DriverStrategyImplementer {

    public static DriverStrategy chooseStrategy(String strategy) {
        switch (strategy){
            case "chrome":
                return new ConnectChrome();
            case "firefox":
                return new ConnectFirefox();
            default:
                return null;
        }
    }

}
