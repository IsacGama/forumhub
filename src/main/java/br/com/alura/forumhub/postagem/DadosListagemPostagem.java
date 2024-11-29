package br.com.alura.forumhub.postagem;

import br.com.alura.forumhub.usuario.Usuario;
import br.com.alura.forumhub.usuario.UsuarioDTO;

import java.time.LocalDateTime;

public record DadosListagemPostagem(Long id, String titulo, String mensagem, LocalDateTime data, Boolean ativo, UsuarioDTO autor, String curso) {
    public DadosListagemPostagem(Postagem postagem) {
        this(postagem.getId(), postagem.getTitulo(), postagem.getMensagem(), postagem.getData(), postagem.getAtivo(),new UsuarioDTO(postagem.getAutor().getLogin()), postagem.getCurso());
    }
}
