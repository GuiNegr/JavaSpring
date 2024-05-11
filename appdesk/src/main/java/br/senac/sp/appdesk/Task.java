package br.senac.sp.appdesk;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;

@Entity//está indicando que vai ser algo do bd
@Data // gera automaticamente getter/seter/consturores etc
public class Task {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)// deixa o valor abaixo ser a cahve do bd e deixar alto incremento
    private Long id;
    @NotBlank
    private String title;
    @Size(min = 10, max = 255)
    private String description;
    @PositiveOrZero
    private Integer score;
    @PositiveOrZero
    private Integer status;


}
