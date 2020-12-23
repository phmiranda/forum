/**
 * User: phmiranda
 * Project: comunidade
 * Description: this class execute...!
 * Date: 05/05/2020
 */

package br.com.alura.comunidade.repository;

import br.com.alura.comunidade.entity.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByNome(String curso);
}
