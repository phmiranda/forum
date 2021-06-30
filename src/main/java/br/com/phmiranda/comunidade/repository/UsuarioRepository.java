/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HUXXX - TITLE OF USER HISTORY
 * Description: DESCRIPTION OF USER HISTORY
 * Date: 28/06/2021
 */

package br.com.phmiranda.comunidade.repository;

import br.com.phmiranda.comunidade.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // include your code here.
}
