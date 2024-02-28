package salao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import salao.Model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
