package salao.Dto;

import salao.Model.Cliente;

public record ClienteDto(Long id,String nome,String servico,String data,String hora) {

	public ClienteDto(Cliente clienteSalvo) {
	this(clienteSalvo.getId(),clienteSalvo.getNome(),clienteSalvo.getServico(),clienteSalvo.getData(),clienteSalvo.getHora());
	}

}
