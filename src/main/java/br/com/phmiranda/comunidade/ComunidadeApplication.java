/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: SRC-3
 * Description: ALURA - SPRING BOOT API REST: CONSTRUA UMA API
 * Date: 20/07/2022
 */

package br.com.phmiranda.comunidade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
public class ComunidadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComunidadeApplication.class, args);
	}

}
