package com.tads.eaj.ufrn.mcpd.Adapter;

import android.content.Context;

/**
 * Created by suelliton on 11/11/2017.
 */

public class Geocoder implements CoordenadaAdapter {
    Context context;
    GeocoderTrack geocoder;
    public Geocoder(Context context,String local){
        this.context = context;
        geocoder = new GeocoderTrack(context,local);
    }
    @Override
    public double getLatitude() {
        return geocoder.getCoordenadas()[0];
    }

    @Override
    public double getLongitude() {
        return geocoder.getCoordenadas()[1];
    }
}
