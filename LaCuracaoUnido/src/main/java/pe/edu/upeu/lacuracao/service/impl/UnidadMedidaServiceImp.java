package pe.edu.upeu.lacuracao.service.impl;

import pe.edu.upeu.lacuracao.enums.LineaNegocio;

import lombok.RequiredArgsConstructor;
import pe.edu.upeu.lacuracao.dto.ComboBoxOption;
import pe.edu.upeu.lacuracao.model.UnidMedida;
import pe.edu.upeu.lacuracao.repository.ICrudGenericoRepository;
import pe.edu.upeu.lacuracao.repository.UnidadMedidaRepository;
import pe.edu.upeu.lacuracao.service.IUnidadMedidaService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class UnidadMedidaServiceImp extends CrudGenericoServiceImp<UnidMedida, Long>
        implements IUnidadMedidaService {

    private final UnidadMedidaRepository unidadMedidaRepository;

    @Override
    protected ICrudGenericoRepository<UnidMedida, Long> getRepo() {
        return unidadMedidaRepository;
    }

    @Override
    public List<ComboBoxOption> listarCombobox() {
        if(unidadMedidaRepository.findAll().isEmpty()) {
            unidadMedidaRepository.seedData();
        }
        List<ComboBoxOption> listar = new ArrayList<>();
        for (UnidMedida m : unidadMedidaRepository.findAll()) {
            ComboBoxOption cb = new ComboBoxOption();
            cb.setKey(String.valueOf(m.getIdUnidad()));
            cb.setValue(m.getNombreMedida());
            listar.add(cb);
        }
        return listar;
    }


    @Override
    public List<ComboBoxOption> listarCombobox(LineaNegocio linea) {
        if (unidadMedidaRepository.findAll().isEmpty()) {
            unidadMedidaRepository.seedData();
        }
        List<ComboBoxOption> listar = new ArrayList<>();
        for (var m : unidadMedidaRepository.findAll()) {
            if (m.getLinea() != linea) continue;
            ComboBoxOption cb = new ComboBoxOption();
            cb.setKey(String.valueOf(m.getIdUnidad()));
            cb.setValue(m.getNombreMedida());
            listar.add(cb);
        }
        return listar;
    }
}
