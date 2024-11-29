package br.com.alura.forumhub.postagem;

import br.com.alura.forumhub.usuario.Usuario;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record DadosCadastroPostagem(
        @NotBlank(message = "{titulo.obrigatorio}")
        @Size(min = 2, max = 100) String titulo,
        @NotBlank(message = "{mensagem.obrigatorio}")
        String mensagem,
        @Future LocalDateTime data,
        Boolean ativo,
        @NotBlank(message = "{autor.obrigatorio}")
        String autor,
        @NotBlank(message = "{curso.obrigatorio}")
        String curso
) {
}
