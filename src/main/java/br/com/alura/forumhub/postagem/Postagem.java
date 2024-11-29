package br.com.alura.forumhub.postagem;

import br.com.alura.forumhub.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "postagem")
@Entity(name = "Postagem")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime data;
    private Boolean ativo;
    private String curso;

    // Relacionamento com o usuário (autor da postagem)
    @ManyToOne
    @JoinColumn(name = "usuario_id")  // Coluna de junção para o relacionamento
    @NotNull  // Garantir que toda postagem tenha um autor
    private Usuario autor;

    public Postagem(DadosCadastroPostagem dados, Usuario autor) {
        this.ativo = true;
        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.data = LocalDateTime.now();
        this.autor = autor;  // Atribuindo o usuário como autor da postagem
        this.curso = dados.curso();
    }

    public void atualizarInformacoes(DadosAtualizacaoPostagem dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
    }
}


