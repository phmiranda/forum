/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: HU-XXX
 * Description: N/A
 * Date: 25/03/2022
 */

package br.com.phmiranda.comunidade.repository;

import br.com.phmiranda.comunidade.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
