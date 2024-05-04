package br.senac.sp.appdesk;

import org.springframework.data.jpa.repository.JpaRepository;


//na tipagem generica criada no extends, estou pasasndo algo como chave-valor, onde a chave seria toda a tabela task
// e o valor o tipo do dado da chave primaria no caso long
public interface taskRepository extends JpaRepository <Task,Long>{
}
