/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HU3 - CADASTRO DO RECURSO DE TÓPICOS
 * Description: CONSTRUÇÃO DO ENDPOINT REFERENTE AO RECURSO DE TÓPICOS
 * Date: 23/12/2020
 */

package br.com.phmiranda.comunidade.domain;

import br.com.phmiranda.comunidade.domain.enums.TopicoStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "topicos")
@AllArgsConstructor
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "", nullable = false)
	private Long id;

	@Column(name = "titulo", nullable = false)
	private String titulo;

	@Column(name = "mensagem", nullable = false)
	private String mensagem;

	@Column(name = "data_criacao", nullable = false)
	private LocalDateTime dataCriacao = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private TopicoStatus status = TopicoStatus.NAO_RESPONDIDO;

	@ManyToOne
	@JoinColumn(name = "autor_id", nullable = false)
	private Usuario autor;

	@ManyToOne
	@JoinColumn(name = "curso_id", nullable = false)
	private Curso curso;

	@OneToMany(mappedBy = "topico")
	@JoinColumn(name = "responsa_id", nullable = false)
	private List<Resposta> respostas = new ArrayList<>();

	public Topico() {

	}

	public Topico(String titulo, String mensagem, Curso curso) {
		this.titulo = titulo;
		this.mensagem = mensagem;
		this.curso = curso;
	}

	// VALIDAÇÕES EXTRAS
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
		Topico other = (Topico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
