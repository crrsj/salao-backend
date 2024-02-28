package salao.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salao.Dto.ClienteDto;
import salao.Model.Cliente;
import salao.Repository.ClienteRepository;

@Service
public class ClienteService {
	@Autowired
  private ClienteRepository repository;
	
	public ClienteDto salvar(ClienteDto cliente) {		
		var salvarCliente = new Cliente(cliente);
		var clienteSalvo = repository.save(salvarCliente);
		return new ClienteDto(clienteSalvo);
	}
	
	public void excluir(Long id) {
    	repository.deleteById(id);
	}
	public List<ClienteDto>listar(){
		var busca = repository.findAll().stream().map(ClienteDto::new).toList();
		return busca;
	}
	public ClienteDto buscaPorId(Long id) {
		var buscaId = repository.getReferenceById(id);
		return new ClienteDto(buscaId);
	}
}
