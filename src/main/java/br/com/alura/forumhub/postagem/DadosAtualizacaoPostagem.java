package br.com.alura.forumhub.postagem;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAtualizacaoPostagem(
        String titulo,
        String mensagem
) {
}
