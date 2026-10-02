package pe.edu.upeu.lacuracao.service.impl;

import lombok.RequiredArgsConstructor;
import pe.edu.upeu.lacuracao.model.Cliente;
import pe.edu.upeu.lacuracao.repository.ClienteRepository;
import pe.edu.upeu.lacuracao.repository.ICrudGenericoRepository;
import pe.edu.upeu.lacuracao.service.IClienteService;

@RequiredArgsConstructor
public class ClienteServiceImp extends CrudGenericoServiceImp<Cliente, Long> implements IClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    protected ICrudGenericoRepository<Cliente, Long> getRepo() {
        return clienteRepository;
    }
}
