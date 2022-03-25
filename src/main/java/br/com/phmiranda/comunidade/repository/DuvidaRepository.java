/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: HU-XXX
 * Description: N/A
 * Date: 25/03/2022
 */

package br.com.phmiranda.comunidade.repository;

import br.com.phmiranda.comunidade.domain.Duvida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuvidaRepository extends JpaRepository<Duvida, Long> {
}
