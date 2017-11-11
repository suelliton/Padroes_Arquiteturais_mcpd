package com.tads.eaj.ufrn.mcpd.Adapter;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by suelliton on 11/11/2017.
 */

public class GeocoderTrack {
    private String local;
    private Geocoder geocoder;
    private Locale localOrigem = Locale.CANADA;
    private double lat;
    private double lng;
    public GeocoderTrack(Context context,String local) {
        geocoder = new Geocoder(context, localOrigem);
        this.local = local;
    }
    public double[] getCoordenadas(){
        List<Address> enderecos;
        try {

            enderecos = geocoder.getFromLocationName(local,1);
            lat = enderecos.get(0).getLatitude();
            lng = enderecos.get(0).getLongitude();
            double[] coordenadas = {lat,lng};
            return coordenadas;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }




}
