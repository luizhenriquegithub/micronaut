package br.net.uno.model;

import io.micronaut.core.annotation.Introspected;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Introspected
public class Posts implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "O nome e necessario")
    @Size(max = 120)
    private String nome;

    @Min(18)
    @Positive
    private int idade;

    private String url;

    @NotEmpty
    private String text;

    public Posts(Long id, String nome, String url, String text) {
        this.id = id;
        this.nome = nome;
        this.url = url;
        this.text = text;
    }

    public Posts() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", url='" + url + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Posts posts = (Posts) o;
        return Objects.equals(id, posts.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
