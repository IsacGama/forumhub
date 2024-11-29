package br.com.alura.forumhub.postagem;

import br.com.alura.forumhub.usuario.Usuario;
import br.com.alura.forumhub.usuario.UsuarioDTO;

import java.time.LocalDateTime;

public record DadosDetalhamentoPostagem(Long id, String titulo, String mensagem, LocalDateTime data, UsuarioDTO autor, String curso) {
    public DadosDetalhamentoPostagem(Postagem postagem) {
        this(postagem.getId(), postagem.getTitulo(), postagem.getMensagem(), postagem.getData(), new UsuarioDTO(postagem.getAutor().getLogin()), postagem.getCurso());
    }
}
