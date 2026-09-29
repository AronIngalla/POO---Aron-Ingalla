package pe.edu.upeu.lacuracao.service.impl;

import pe.edu.upeu.lacuracao.enums.LineaNegocio;

import lombok.RequiredArgsConstructor;
import pe.edu.upeu.lacuracao.dto.ComboBoxOption;
import pe.edu.upeu.lacuracao.enums.TipoProducto;
import pe.edu.upeu.lacuracao.model.Producto;
import pe.edu.upeu.lacuracao.repository.ICrudGenericoRepository;
import pe.edu.upeu.lacuracao.repository.ProductoRepository;
import pe.edu.upeu.lacuracao.service.IProductoService;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ProductoServiceImp extends CrudGenericoServiceImp<Producto, Long> implements IProductoService {

    private final ProductoRepository productoRepository;

    @Override
    protected ICrudGenericoRepository<Producto, Long> getRepo() {
        return productoRepository;
    }

    @Override
    public List<ComboBoxOption> listarTipoProducto() {
        List<ComboBoxOption> listar = new ArrayList<>();
        for (TipoProducto tp : TipoProducto.values()) {
            ComboBoxOption cb = new ComboBoxOption();
            cb.setKey(String.valueOf(tp.name()));
            cb.setValue(tp.getDescripcion());
            listar.add(cb);
        }
        return listar;
    }

    @Override
    public List<ComboBoxOption> listarTipoProducto(LineaNegocio linea) {
        List<ComboBoxOption> listar = new ArrayList<>();
        for (TipoProducto tp : linea.getTipos()) {
            ComboBoxOption cb = new ComboBoxOption();
            cb.setKey(tp.name());
            cb.setValue(tp.getDescripcion());
            listar.add(cb);
        }
        return listar;
    }

    @Override
    public List<Producto> findAll() {
        if(productoRepository.findAll().isEmpty()) {
            productoRepository.seedData();
        }
        return productoRepository.findAll();
    }

}
