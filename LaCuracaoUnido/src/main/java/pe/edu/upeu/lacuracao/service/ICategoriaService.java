package pe.edu.upeu.lacuracao.service;

import pe.edu.upeu.lacuracao.enums.LineaNegocio;

import pe.edu.upeu.lacuracao.dto.ComboBoxOption;
import pe.edu.upeu.lacuracao.model.Categoria;
import java.util.List;

public interface ICategoriaService extends ICrudGenericoService<Categoria, Long>{
    List<ComboBoxOption> listarCombobox();
    List<ComboBoxOption> listarCombobox(LineaNegocio linea);
}
