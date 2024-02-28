package salao.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import salao.Dto.ClienteDto;
import salao.Service.ClienteService;

@RestController
@RequestMapping("salao")
@CrossOrigin(origins  = "*")
public class ClienteController {
  
	@Autowired
	private ClienteService service;
	
	@PostMapping
	public ResponseEntity<ClienteDto>salvar(@RequestBody ClienteDto salvando){
		var salve = service.salvar(salvando);
		return new ResponseEntity<ClienteDto>(salve,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDto>>listar(){
		var buscar = service.listar();
		return new ResponseEntity<List<ClienteDto>>(buscar,HttpStatus.OK);
	}
	
	@DeleteMapping("deletar/{id}")
	public ResponseEntity<Void>excluir(@PathVariable Long id){
		 service.excluir(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		
	}
	@GetMapping("busca/{id}")
	public ResponseEntity<ClienteDto>buscaPorId(@PathVariable Long id){
		var busca = service.buscaPorId(id);
		return new ResponseEntity<ClienteDto>(busca,HttpStatus.OK);
	}
}
