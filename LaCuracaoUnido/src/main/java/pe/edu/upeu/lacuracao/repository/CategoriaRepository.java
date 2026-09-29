package pe.edu.upeu.lacuracao.repository;

import pe.edu.upeu.lacuracao.enums.LineaNegocio;

import pe.edu.upeu.lacuracao.model.Categoria;

public class CategoriaRepository extends AbstractJpaRepository<Categoria, Long> {
    private long sequence = 1;

    @Override
    protected Long getId(Categoria entity) {
        return entity.getIdCategoria();
    }

    @Override
    protected void setId(Categoria entity, Long id) {
        entity.setIdCategoria(id);
    }

    @Override
    protected Long generateId() {
        return sequence++;
    }

    public void seedData() {
        if (findAll().isEmpty()) {
            save(new Categoria(generateId(), "Impresoras", LineaNegocio.TECNOLOGIA));
            save(new Categoria(generateId(), "Laptops", LineaNegocio.TECNOLOGIA));
            save(new Categoria(generateId(), "Televisores", LineaNegocio.TECNOLOGIA));
            save(new Categoria(generateId(), "Celulares", LineaNegocio.TECNOLOGIA));
            save(new Categoria(generateId(), "Audifonos", LineaNegocio.TECNOLOGIA));
            save(new Categoria(generateId(), "Motos", LineaNegocio.MOTOS));
            save(new Categoria(generateId(), "Cascos", LineaNegocio.MOTOS));
            save(new Categoria(generateId(), "Ropa", LineaNegocio.MOTOS));
            save(new Categoria(generateId(), "Repuestos", LineaNegocio.MOTOS));
            save(new Categoria(generateId(), "Lavado", LineaNegocio.TECNOLOGIA_DOMESTICA));
            save(new Categoria(generateId(), "Refrigeracion", LineaNegocio.TECNOLOGIA_DOMESTICA));
            save(new Categoria(generateId(), "Cocina", LineaNegocio.TECNOLOGIA_DOMESTICA));
        }
    }
}