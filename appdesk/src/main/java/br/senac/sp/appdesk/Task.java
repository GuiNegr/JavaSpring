package br.senac.sp.appdesk;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity//está indicando que vai ser algo do bd
@Data // gera automaticamente getter/seter/consturores etc
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)// deixa o valor abaixo ser a cahve do bd e deixar alto incremento
    private Long id;
    private String title, description;
    private Integer score;
    private Integer status;


}
