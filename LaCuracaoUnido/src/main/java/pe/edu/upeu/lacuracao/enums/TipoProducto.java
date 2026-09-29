package pe.edu.upeu.lacuracao.enums;

import lombok.Getter;

/** Todos los tipos de producto de la tienda (de los tres módulos originales). */
@Getter
public enum TipoProducto {
    // Tecnología
    COMPUTACION("Computación"),
    ENTRETENIMIENTO("Entretenimiento"),
    CELULARES("Comunicación"),
    // Motos
    MOTOS("Motos"),
    ACCESORIOS("Accesorios"),
    ROPA("Ropa"),
    // Tecnología doméstica
    LAVADO("Lavado"),
    REFRIGERACION("Refrigeración"),
    COCINA("Cocina");

    String descripcion;
    TipoProducto(String descripcion) { this.descripcion = descripcion; }

    @Override
    public String toString() { return descripcion; }
}
