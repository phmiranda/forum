/*
 * Author: Pedro
 * Project: comunidade
 * User Story: HU06 - AUTENTICAÇÃO DA API.
 * Description: DESENVOLVIMENTO DO FLUXO DE AUTENTICAÇÃO DA API.
 * Date: 01/07/2021
 */

package br.com.phmiranda.comunidade.service;

import br.com.phmiranda.comunidade.domain.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UsuarioAuthTokenService {
    @Value("${comunidade.jwt.secret}")
    private String secretToken;

    @Value("${comunidade.jwt.expiration}")
    private String expiracaoToken;

    public String gerarToken(Authentication authentication) {
        Usuario logado = (Usuario) authentication.getPrincipal();

        Date dataCriacaoToken = new Date();
        Date dataExpiracaoToken = new Date(dataCriacaoToken.getTime() + Long.parseLong(expiracaoToken));

        return Jwts.builder()
                .setIssuer("API DA COMUNIDADE DA ALURA.")
                .setSubject(logado.getId().toString())
                .setIssuedAt(dataCriacaoToken)
                .setExpiration(dataExpiracaoToken)
                .signWith(SignatureAlgorithm.HS256, secretToken)
                .compact();
    }

    public Boolean isTokenValido(String token) {
        try{
            Jwts.parser().setSigningKey(this.secretToken).parseClaimsJws(token);
            return true;
        }catch (Exception exception) {
            return false;
        }
    }

    public Long getIdUsuario(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.secretToken).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
