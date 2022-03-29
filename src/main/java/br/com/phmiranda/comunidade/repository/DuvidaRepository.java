/*
 * Author: Pedro
 * Project: comunidade
 * User Story: 72
 * Description: Publicando Endpoints
 * Date: 25/03/2022
 */

package br.com.phmiranda.comunidade.repository;

import br.com.phmiranda.comunidade.domain.entity.Duvida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DuvidaRepository extends JpaRepository<Duvida, Long> {
    List<Duvida> findByTitulo(String titulo);
    List<Duvida> findByCursoNome(String curso);
}
