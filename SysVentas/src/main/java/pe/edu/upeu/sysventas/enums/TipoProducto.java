package pe.edu.upeu.sysventas.enums;

import lombok.Getter;

@Getter
public enum TipoProducto {
    PRODUCTO(""),
    PREPARADO(""),
    SERVICIO2("");

    String descripcion;
    TipoProducto(String descripcion){
        this.descripcion = descripcion;
    }
}
