/*
 * Author: Pedro
 * Project: comunidade
 * User Story: SRC-3
 * Description: CONSTRUÇÃO DO SERVIÇO DE CADASTRO E GERENCIAMENTO DE TÓPICOS.
 * Date: 20/07/2021
 */

package br.com.phmiranda.comunidade.domain;

import br.com.phmiranda.comunidade.domain.enums.DuvidaStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "duvidas")
public class Duvida {

    @Id
    @Column(name = "id", nullable = false, length = 100)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = true)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = true)
    private Usuario usuario;

    @OneToMany(mappedBy = "duvida")
    @Column(name = "resposta_id", nullable = true)
    private List<Resposta> respostas = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao", nullable = false, length = 25)
    private DuvidaStatus duvidaStatus = DuvidaStatus.NAO_RESPONDIDO;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Duvida(String titulo, String descricao, Curso curso) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Duvida other = (Duvida) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }

    public DuvidaStatus getDuvidaStatus() {
        return duvidaStatus;
    }

    public void setDuvidaStatus(DuvidaStatus duvidaStatus) {
        this.duvidaStatus = duvidaStatus;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
