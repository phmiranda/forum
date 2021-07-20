/*
 * Author: Pedro
 * Project: comunidade
 * User Story: PGT-HU003
 * Description: CONSTRUÇÃO DO SERVIÇO DE CADASTRO DE TÓPICOS.
 * Date: 20/07/2021
 */

package br.com.phmiranda.comunidade.repository;

import br.com.phmiranda.comunidade.domain.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
