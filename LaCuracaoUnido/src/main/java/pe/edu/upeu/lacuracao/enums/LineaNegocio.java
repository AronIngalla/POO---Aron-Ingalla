package pe.edu.upeu.lacuracao.enums;

import java.util.List;

/** Cada opción del menú File: agrupa los tipos de producto que le corresponden. */
public enum LineaNegocio {
    TECNOLOGIA("Tecnología",
            List.of(TipoProducto.COMPUTACION, TipoProducto.ENTRETENIMIENTO, TipoProducto.CELULARES)),
    MOTOS("Motos",
            List.of(TipoProducto.MOTOS, TipoProducto.ACCESORIOS, TipoProducto.ROPA)),
    TECNOLOGIA_DOMESTICA("Tecnología Doméstica",
            List.of(TipoProducto.LAVADO, TipoProducto.REFRIGERACION, TipoProducto.COCINA));

    private final String titulo;
    private final List<TipoProducto> tipos;

    LineaNegocio(String titulo, List<TipoProducto> tipos) {
        this.titulo = titulo;
        this.tipos = tipos;
    }

    public String getTitulo() { return titulo; }
    public List<TipoProducto> getTipos() { return tipos; }
    public boolean incluye(TipoProducto tipo) { return tipo != null && tipos.contains(tipo); }
}
