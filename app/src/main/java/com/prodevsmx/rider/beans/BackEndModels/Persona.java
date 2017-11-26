package com.prodevsmx.rider.beans.BackEndModels;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Damian Garcia on 11/26/2017.
 */

public class Persona {

    private String _id ;

    private String facebookId ;

    private String name ;
    private String imagen ;
    private String email ;
    private String telephone ;
    private GeoPoint home ;
    private ArrayList<Carro> carros ;
    private JSONObject facebookObject;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public GeoPoint getHome() {
        return home;
    }

    public void setHome(GeoPoint home) {
        this.home = home;
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }

    public void setCarros(ArrayList<Carro> carros) {
        this.carros = carros;
    }

    public JSONObject getFacebookObject() {
        return facebookObject;
    }

    public void setFacebookObject(JSONObject facebookObject) {
        this.facebookObject = facebookObject;
    }
}
