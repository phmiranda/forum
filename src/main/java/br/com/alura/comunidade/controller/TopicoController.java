/**
 * User: phmiranda
 * Project: forum
 * Date: 05/05/2020
 */

package br.com.alura.comunidade.controller;

import br.com.alura.comunidade.entity.dto.DetalheDoTopicoDto;
import br.com.alura.comunidade.entity.dto.TopicoCadastrar;
import br.com.alura.comunidade.entity.dto.TopicoIndex;
import br.com.alura.comunidade.entity.model.Topico;
import br.com.alura.comunidade.repository.CursoRepository;
import br.com.alura.comunidade.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoIndex> index(String cursoNome) {
        if (cursoNome == null){
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoIndex.converter(topicos);
        } else {
            List<Topico> topicos = topicoRepository.findByCursoNome(cursoNome);
            return TopicoIndex.converter(topicos);
        }
    }

    @GetMapping("/{id}")
    public DetalheDoTopicoDto detalhar(@PathVariable Long id) {
        Topico topico = topicoRepository.getOne(id);
        return new DetalheDoTopicoDto(topico);
    }

    @PostMapping()
    public ResponseEntity<TopicoIndex> cadastrar(@RequestBody @Valid TopicoCadastrar topicoCadastrar, UriComponentsBuilder uriBuilder){
        Topico topico = topicoCadastrar.converter(cursoRepository);
        topicoRepository.save(topico);
        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoIndex(topico));
    }

    @PutMapping
    public void atualizar() {

    }

    @DeleteMapping
    public void deletar() {

    }
}
