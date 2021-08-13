/*
 * Author: Pedro
 * Project: comunidade
 * User Story: PGT-HU004
 * Description: CONSTRUÇÃO DO SERVIÇO DE CADASTRO DE RESPOSTAS.
 * Date: 20/07/2021
 */

package br.com.phmiranda.comunidade.repository;

import br.com.phmiranda.comunidade.domain.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Long> {
    // include your code here.
}
