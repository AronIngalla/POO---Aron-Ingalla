package pe.edu.upeu.lacuracao.repository;

import pe.edu.upeu.lacuracao.enums.LineaNegocio;

import pe.edu.upeu.lacuracao.model.Marca;

public class MarcaRepository extends AbstractJpaRepository<Marca, Long>{
    private long sequence=1;
    @Override
    protected Long getId(Marca entity) {
        return entity.getIdMarca();
    }

    @Override
    protected void setId(Marca entity, Long id) {
        entity.setIdMarca(id);
    }

    @Override
    protected Long generateId() {
        return sequence++;
    }

    public void seedData() {
        if (findAll().isEmpty()) {
            save(new Marca(generateId(), "Samsung", LineaNegocio.TECNOLOGIA));
            save(new Marca(generateId(), "LG", LineaNegocio.TECNOLOGIA));
            save(new Marca(generateId(), "Sony", LineaNegocio.TECNOLOGIA));
            save(new Marca(generateId(), "HP", LineaNegocio.TECNOLOGIA));
            save(new Marca(generateId(), "Lenovo", LineaNegocio.TECNOLOGIA));
            save(new Marca(generateId(), "Asus", LineaNegocio.TECNOLOGIA));
            save(new Marca(generateId(), "JBL", LineaNegocio.TECNOLOGIA));
            save(new Marca(generateId(), "Pulsar", LineaNegocio.MOTOS));
            save(new Marca(generateId(), "Bajaj", LineaNegocio.MOTOS));
            save(new Marca(generateId(), "Zongshen", LineaNegocio.MOTOS));
            save(new Marca(generateId(), "Honda", LineaNegocio.MOTOS));
            save(new Marca(generateId(), "Yamaha", LineaNegocio.MOTOS));
            save(new Marca(generateId(), "Bosch", LineaNegocio.TECNOLOGIA_DOMESTICA));
            save(new Marca(generateId(), "Coldex", LineaNegocio.TECNOLOGIA_DOMESTICA));
            save(new Marca(generateId(), "Samsung", LineaNegocio.TECNOLOGIA_DOMESTICA));
            save(new Marca(generateId(), "LG", LineaNegocio.TECNOLOGIA_DOMESTICA));
            save(new Marca(generateId(), "Indurama", LineaNegocio.TECNOLOGIA_DOMESTICA));
            save(new Marca(generateId(), "Mabe", LineaNegocio.TECNOLOGIA_DOMESTICA));
        }
    }


}