package com.example.ssb.dto;

import java.io.Serializable;

public class Alarma extends User implements Serializable {
    private User user;
    private int estado;

    public Alarma(String user, int estado) {
    }

    public Alarma() {
        this.user = user;
        this.estado = estado;
    }

    public Alarma(int estado) {
        this.estado = estado;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString(){
        return (this.getUser()+" -- "+this.getEstado());
    }
}
