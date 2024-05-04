package br.senac.sp.appdesk;

import org.springframework.data.jpa.repository.JpaRepository;

public interface taskRepository extends JpaRepository <Task,Long>{
}
