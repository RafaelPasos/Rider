package com.prodevsmx.rider.beans.BackEndModels;

/**
 * Created by Damian Garcia on 11/26/2017.
 */

public class Carro {
    String _id;
    String modelo;
    String imageId;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    int numberOfSeats;
    String placas;

    public Carro() { }

    public Carro(String modelo, String imageId) {
        this.modelo = modelo;
        this.imageId = imageId;
    }

}
