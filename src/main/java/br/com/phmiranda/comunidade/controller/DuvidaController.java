/*
 * Author: phmiranda
 * Project: comunidade
 * Task Number: 73
 * Description: Usando Spring Data
 * Date: 26/03/2022
 */

package br.com.phmiranda.comunidade.controller;

import br.com.phmiranda.comunidade.domain.dto.response.DuvidaResponseDto;
import br.com.phmiranda.comunidade.service.DuvidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/duvidas")
public class DuvidaController {

    @Autowired
    DuvidaService duvidaService;

    @GetMapping
    public List<DuvidaResponseDto> index() {
        return duvidaService.index();
    }

    @GetMapping("/filtro/{id}")
    public void pesquisarPorId() {

    }

    @GetMapping("/filtro/titulo")
    public List<DuvidaResponseDto> pesquisarPorTitulo(String titulo) {
        return duvidaService.pesquisarPorTitulo(titulo);
    }

    @GetMapping("/filtro/curso")
    public List<DuvidaResponseDto> pesquisarPorCursoVinculado(String curso) {
        return duvidaService.pesquisarPorCursoVinculado(curso);
    }
}
