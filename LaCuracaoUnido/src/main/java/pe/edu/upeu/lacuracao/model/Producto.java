package pe.edu.upeu.lacuracao.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.upeu.lacuracao.enums.TipoProducto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Producto {
    private Long idProducto;
    @NotBlank(message = "El nombre del producto es obligatorio")
    private String nombre;
    @NotNull(message = "El tipo de producto es obligatorio")
    private TipoProducto tipoProducto;
    @NotNull(message = "El precio del producto es obligatorio")
    @Positive(message = "El precio del producto debe ser positivo")
    private Double pu;
    @NotNull(message = "La utilidad es obligatoria")
    @PositiveOrZero(message = "La utilidad debe ser positiva o cero")
    private Double utilidad;
    @NotNull(message = "El stock es obligatorio")
    @PositiveOrZero(message = "El stock debe ser positivo o cero")
    private Double stock;
    @NotNull(message = "La categoría del producto es obligatoria")
    private Categoria idCategoria;
    @NotNull(message = "La marca del producto es obligatoria")
    private Marca idMarca;
    @NotNull(message = "La unidad de medida del producto es obligatoria")
    private UnidMedida idUnidad;
}
