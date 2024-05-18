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

    @NotNull
    private String title;

    private String description;
    @PositiveOrZero
    private Integer score;
    @PositiveOrZero
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
