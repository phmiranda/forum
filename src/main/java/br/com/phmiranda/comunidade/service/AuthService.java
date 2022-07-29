/**
 * User: Pedro
 * Project:
 * User History: SIGLA-999
 * Description: N/A
 * Date: 30/06/2022
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.dto.request.AuthRequest;
import br.com.phmiranda.comunidade.domain.entity.Usuario;
import br.com.phmiranda.comunidade.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private AuthTokenService authTokenService;
    @Autowired
    UsuarioRepository usuarioRepository;

    public ResponseEntity<?> autenticar(AuthRequest authRequest) {
        UsernamePasswordAuthenticationToken autenticacao = authRequest.converter();

        try {
            Authentication authentication = authenticationManager.authenticate(autenticacao);
            String token = authTokenService.gerarToken(authentication);
            System.out.println(token);
            return ResponseEntity.ok().build();
        } catch (AuthenticationException authenticationException) {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByEmail(username);
        if (usuario.isPresent()) {
            return usuario.get();
        }
        throw new UsernameNotFoundException("O usuário não foi encontrado.");
    }
}
