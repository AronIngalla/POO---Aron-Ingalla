package pe.edu.upeu.lacuracao.repository;

import pe.edu.upeu.lacuracao.enums.LineaNegocio;

import pe.edu.upeu.lacuracao.model.UnidMedida;

public class UnidadMedidaRepository extends AbstractJpaRepository<UnidMedida, Long>{
    private long sequence=1;
    @Override
    protected Long getId(UnidMedida entity) {
        return entity.getIdUnidad();
    }

    @Override
    protected void setId(UnidMedida entity, Long id) {
        entity.setIdUnidad(id);
    }

    @Override
    protected Long generateId() {
        return sequence++;
    }

    public void seedData() {
        if (findAll().isEmpty()) {
            save(new UnidMedida(generateId(), "Unidad", LineaNegocio.TECNOLOGIA));
            save(new UnidMedida(generateId(), "Pulgadas", LineaNegocio.TECNOLOGIA));
            save(new UnidMedida(generateId(), "Unidad", LineaNegocio.MOTOS));
            save(new UnidMedida(generateId(), "Motor", LineaNegocio.MOTOS));
            save(new UnidMedida(generateId(), "Unidad", LineaNegocio.TECNOLOGIA_DOMESTICA));
            save(new UnidMedida(generateId(), "Kilos", LineaNegocio.TECNOLOGIA_DOMESTICA));
        }
    }
}
