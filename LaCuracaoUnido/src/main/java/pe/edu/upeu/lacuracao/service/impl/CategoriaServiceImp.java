package pe.edu.upeu.lacuracao.service.impl;

import pe.edu.upeu.lacuracao.enums.LineaNegocio;

import pe.edu.upeu.lacuracao.dto.ComboBoxOption;
import pe.edu.upeu.lacuracao.model.Categoria;
import pe.edu.upeu.lacuracao.repository.CategoriaRepository;
import pe.edu.upeu.lacuracao.repository.ICrudGenericoRepository;
import pe.edu.upeu.lacuracao.service.ICategoriaService;

import java.util.ArrayList;
import java.util.List;

public class CategoriaServiceImp extends CrudGenericoServiceImp<Categoria, Long>
        implements ICategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImp(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    protected ICrudGenericoRepository<Categoria, Long> getRepo() {
        return categoriaRepository;
    }

    @Override
    public List<ComboBoxOption> listarCombobox() {
        if(categoriaRepository.findAll().isEmpty()) {
            categoriaRepository.seedData();
        }
        List<ComboBoxOption> listar = new ArrayList<>();
        for (Categoria m : categoriaRepository.findAll()) {
            ComboBoxOption cb = new ComboBoxOption();
            cb.setKey(String.valueOf(m.getIdCategoria()));
            cb.setValue(m.getNombre());
            listar.add(cb);
        }
        return listar;
    }

    @Override
    public List<ComboBoxOption> listarCombobox(LineaNegocio linea) {
        if (categoriaRepository.findAll().isEmpty()) {
            categoriaRepository.seedData();
        }
        List<ComboBoxOption> listar = new ArrayList<>();
        for (var m : categoriaRepository.findAll()) {
            if (m.getLinea() != linea) continue;
            ComboBoxOption cb = new ComboBoxOption();
            cb.setKey(String.valueOf(m.getIdCategoria()));
            cb.setValue(m.getNombre());
            listar.add(cb);
        }
        return listar;
    }
}
