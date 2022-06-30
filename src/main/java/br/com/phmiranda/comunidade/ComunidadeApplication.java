/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 71
 * Description: Introdução ao Spring Boot
 * Date: 26/03/2022
 */

package br.com.phmiranda.comunidade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableCaching
@EnableSpringDataWebSupport
@SpringBootApplication
public class ComunidadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComunidadeApplication.class, args);
	}

}
