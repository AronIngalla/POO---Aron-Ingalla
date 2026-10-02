package pe.edu.upeu.lacuracao.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private Long idCliente;

    @NotBlank(message = "El DNI es obligatorio")
    @Pattern(regexp = "\\d{8}", message = "El DNI debe tener 8 dígitos")
    private String dni;

    @NotBlank(message = "El número de celular es obligatorio")
    @Pattern(regexp = "\\d{9}", message = "El número debe tener 9 dígitos")
    private String numero;

    @NotBlank(message = "Los nombres son obligatorios")
    private String nombres;
}
