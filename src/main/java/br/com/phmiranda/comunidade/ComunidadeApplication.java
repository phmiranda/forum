/**
 * User: phmiranda
 * Project: comunidade
 * Description: this class execute...!
 * Date: 05/05/2020
 */

package br.com.phmiranda.comunidade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
public class ComunidadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComunidadeApplication.class, args);
	}

}
