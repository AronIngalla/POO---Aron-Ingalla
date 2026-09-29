package pe.edu.upeu.lacuracao.service;

import pe.edu.upeu.lacuracao.enums.LineaNegocio;

import pe.edu.upeu.lacuracao.dto.ComboBoxOption;
import pe.edu.upeu.lacuracao.model.Marca;

import java.util.List;

public interface IMarcaService extends ICrudGenericoService<Marca, Long> {
    List<ComboBoxOption> listarCombobox();
    List<ComboBoxOption> listarCombobox(LineaNegocio linea);
}
