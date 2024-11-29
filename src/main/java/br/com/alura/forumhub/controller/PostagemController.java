package br.com.alura.forumhub.controller;

import br.com.alura.forumhub.postagem.*;
import br.com.alura.forumhub.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("topicos")
public class PostagemController {

    @Autowired
    private PostagemRepository postagemRepository;

    @PostMapping
    @Transactional
    public ResponseEntity postar(@RequestBody @Valid DadosCadastroPostagem dados, UriComponentsBuilder uriBuilder) {

        var usuarioAutenticado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var postagem = new Postagem(dados, usuarioAutenticado);
        postagemRepository.save(postagem);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(postagem.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoPostagem(postagem));
    }



    @GetMapping
    public ResponseEntity<Page<DadosListagemPostagem>> listar(@PageableDefault(size = 10, sort = {"titulo"}) Pageable paginacao) {
        var page = postagemRepository.findAllByAtivoTrue(paginacao).map(DadosListagemPostagem::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity detalhar(@PathVariable Long id) {
        if(postagemRepository.existsById(id)) {
            var postagem = postagemRepository.getReferenceById(id);
            return  ResponseEntity.ok(new DadosDetalhamentoPostagem(postagem));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizar(@PathVariable Long id, @RequestBody @Valid DadosAtualizacaoPostagem dados) {
        var usuarioLogado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (postagemRepository.existsById(id)) {
            var postagem = postagemRepository.getReferenceById(id);

            // Verifica se o usuário logado é o autor da postagem
            if (!postagem.getAutor().equals(usuarioLogado)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Você não tem permissão para editar esta postagem.");
            }

            postagem.atualizarInformacoes(dados);
            return ResponseEntity.ok(new DadosDetalhamentoPostagem(postagem));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var usuarioLogado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (postagemRepository.existsById(id)) {
            var postagem = postagemRepository.getReferenceById(id);

            // Verifica se o usuário logado é o autor da postagem
            if (!postagem.getAutor().equals(usuarioLogado)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Você não tem permissão para excluir esta postagem.");
            }

            postagemRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
