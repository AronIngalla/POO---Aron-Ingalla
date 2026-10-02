package pe.edu.upeu.lacuracao.repository;

import pe.edu.upeu.lacuracao.model.Cliente;

public class ClienteRepository extends AbstractJpaRepository<Cliente, Long> {

    private long sequence = 1;

    @Override
    protected Long getId(Cliente entity) {
        return entity.getIdCliente();
    }

    @Override
    protected void setId(Cliente entity, Long id) {
        entity.setIdCliente(id);
    }

    @Override
    protected Long generateId() {
        return sequence++;
    }
}
