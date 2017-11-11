package com.tads.eaj.ufrn.mcpd.Adapter;

import android.content.Context;

/**
 * Created by suelliton on 11/11/2017.
 */

public class GPS implements CoordenadaAdapter {
    Context context;
    GPSTracker gps;

    public GPS(Context context){
        this.context = context;
        gps = new GPSTracker(context);
    }
    @Override
    public double getLatitude() {
        return gps.getLatitude();
    }

    @Override
    public double getLongitude() {
        return gps.getLongitude();
    }
}
