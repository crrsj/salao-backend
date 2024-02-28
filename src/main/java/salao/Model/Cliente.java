package salao.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import salao.Dto.ClienteDto;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {
   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String nome;
    private String servico;
    private String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    private String hora;
    
    public Cliente(ClienteDto cliente) {
	this.nome = cliente.nome();
	this.servico = cliente.servico();
	this.data = cliente.data();
	this.hora = cliente.hora();
	}
}
