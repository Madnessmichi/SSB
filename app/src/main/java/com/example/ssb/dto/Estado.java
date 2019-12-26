package com.example.ssb.dto;
import java.io.Serializable;
import java.util.Date;

import java.io.Serializable;

public class Estado implements Serializable {
 private boolean estado;

 public Estado(boolean estado) {
  this.estado = estado;
 }

 public boolean isEstado() {
  return estado;
 }

 public void setEstado(boolean estado) {
  this.estado = estado;
 }
}
