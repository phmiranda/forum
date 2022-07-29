/**
 * User: Pedro
 * Project: comunidade
 * User History: nº 999
 * Description: N/A
 * Date: 28/07/2022
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.entity.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthTokenService {

    @Value("${comunidade.jwt.expiration}")
    private String expiracao;

    @Value("${comunidade.jwt.secret}")
    private String secret;

    public String gerarToken(Authentication authentication) {
        Usuario usuario = (Usuario) authentication.getPrincipal();
        Date dataGeracaoToken = new Date();
        Date dataExpiracaoToken = new Date(dataGeracaoToken.getTime() + Long.parseLong(expiracao));
        return Jwts.builder()
            .setIssuer("API da Comunidade da Alura")
            .setSubject(usuario.getId().toString())
            .setIssuedAt(dataGeracaoToken)
            .setExpiration(dataExpiracaoToken)
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();

    }
}
