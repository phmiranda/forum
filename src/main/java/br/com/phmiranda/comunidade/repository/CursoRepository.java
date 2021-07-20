/*
 * Author: Pedro
 * Project: comunidade
 * User Story: PGT-HU002
 * Description: CONSTRUÇÃO DO SERVIÇO DE CADASTRO DE CURSOS.
 * Date: 20/07/2021
 */

package br.com.phmiranda.comunidade.repository;

import br.com.phmiranda.comunidade.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {
    Curso findByNome(String nomeCurso);
}
