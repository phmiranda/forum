/**
 * User: phmiranda
 * Project: comunidade
 * Description: this class execute...!
 * Date: 23/12/2020
 */

package br.com.phmiranda.comunidade.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "respostas")
@AllArgsConstructor
@NoArgsConstructor
public class Resposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "autor_id", nullable = false)
	private Usuario autor;

	@ManyToOne
	@JoinColumn(name = "topico_id", nullable = false)
	private Topico topico;

	@Column(name = "mensagem", nullable = false)
	private String mensagem;

	@Column(name = "solucao", nullable = false)
	private Boolean solucao = false;

	@Column(name = "data_criacao", nullable = false)
	private LocalDateTime dataCriacao = LocalDateTime.now();

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
		Resposta other = (Resposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
