/**
 * User: phmiranda
 * Project: comunidade
 * Description: this class execute...!
 * Date: 05/05/2020
 */

package br.com.phmiranda.comunidade.repository;

import br.com.phmiranda.comunidade.domain.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    List<Topico> findByCursoNome(String cursoNome);
}
