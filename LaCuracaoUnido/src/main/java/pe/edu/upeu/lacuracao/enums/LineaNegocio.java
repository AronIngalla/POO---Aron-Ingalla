package pe.edu.upeu.lacuracao.enums;

import java.util.List;

/** Opciones del combo "Tipo de producto": agrupa los subtipos de cada línea. */
public enum LineaNegocio {
    TECNOLOGIA("Tecnología",
            List.of(TipoProducto.COMPUTACION, TipoProducto.ENTRETENIMIENTO, TipoProducto.CELULARES)),
    TECNOLOGIA_DOMESTICA("Tecnología Hogar",
            List.of(TipoProducto.LAVADO, TipoProducto.REFRIGERACION, TipoProducto.COCINA)),
    MOTOS("Motos",
            List.of(TipoProducto.MOTOS, TipoProducto.ACCESORIOS, TipoProducto.ROPA));

    private final String titulo;
    private final List<TipoProducto> tipos;

    LineaNegocio(String titulo, List<TipoProducto> tipos) {
        this.titulo = titulo;
        this.tipos = tipos;
    }

    public String getTitulo() { return titulo; }
    public List<TipoProducto> getTipos() { return tipos; }
    public boolean incluye(TipoProducto tipo) { return tipo != null && tipos.contains(tipo); }

    /** Devuelve la línea a la que pertenece un subtipo (para editar un producto). */
    public static LineaNegocio de(TipoProducto tipo) {
        for (LineaNegocio l : values()) if (l.incluye(tipo)) return l;
        return null;
    }

    @Override
    public String toString() { return titulo; }
}
