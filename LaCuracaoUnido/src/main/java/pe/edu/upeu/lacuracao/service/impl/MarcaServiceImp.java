package pe.edu.upeu.lacuracao.service.impl;

import pe.edu.upeu.lacuracao.enums.LineaNegocio;

import lombok.RequiredArgsConstructor;
import pe.edu.upeu.lacuracao.dto.ComboBoxOption;
import pe.edu.upeu.lacuracao.model.Marca;
import pe.edu.upeu.lacuracao.repository.ICrudGenericoRepository;
import pe.edu.upeu.lacuracao.repository.MarcaRepository;
import pe.edu.upeu.lacuracao.service.IMarcaService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor

public class MarcaServiceImp extends CrudGenericoServiceImp<Marca, Long>
        implements IMarcaService {

    private final MarcaRepository marcaRepository;
    @Override
    protected ICrudGenericoRepository<Marca, Long> getRepo() {
        return marcaRepository;
    }

    public List<ComboBoxOption> listarCombobox() {
        if(marcaRepository.findAll().isEmpty()) {
            marcaRepository.seedData();
        }
        List<ComboBoxOption> listar = new ArrayList<>();
        for (Marca m : marcaRepository.findAll()) {
            ComboBoxOption cb = new ComboBoxOption();
            cb.setKey(String.valueOf(m.getIdMarca()));
            cb.setValue(m.getNombre());
            listar.add(cb);
        }
        return listar;
    }


    @Override
    public List<ComboBoxOption> listarCombobox(LineaNegocio linea) {
        if (marcaRepository.findAll().isEmpty()) {
            marcaRepository.seedData();
        }
        List<ComboBoxOption> listar = new ArrayList<>();
        for (var m : marcaRepository.findAll()) {
            if (m.getLinea() != linea) continue;
            ComboBoxOption cb = new ComboBoxOption();
            cb.setKey(String.valueOf(m.getIdMarca()));
            cb.setValue(m.getNombre());
            listar.add(cb);
        }
        return listar;
    }
}
