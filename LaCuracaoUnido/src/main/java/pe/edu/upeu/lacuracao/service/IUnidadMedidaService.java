package pe.edu.upeu.lacuracao.service;

import pe.edu.upeu.lacuracao.enums.LineaNegocio;

import pe.edu.upeu.lacuracao.dto.ComboBoxOption;
import pe.edu.upeu.lacuracao.model.UnidMedida;

import java.util.List;

public interface IUnidadMedidaService extends ICrudGenericoService<UnidMedida, Long> {
    List<ComboBoxOption> listarCombobox();
    List<ComboBoxOption> listarCombobox(LineaNegocio linea);
}
