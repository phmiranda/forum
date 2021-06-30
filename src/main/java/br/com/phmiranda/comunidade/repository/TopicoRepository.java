/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HU3 - CADASTRO DO RECURSO DE TÓPICOS
 * Description: CONSTRUÇÃO DO ENDPOINT REFERENTE AO RECURSO DE TÓPICOS
 * Date: 05/05/2020
 */

package br.com.phmiranda.comunidade.repository;

import br.com.phmiranda.comunidade.domain.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);
}
