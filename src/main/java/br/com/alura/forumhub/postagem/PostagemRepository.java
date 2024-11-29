package br.com.alura.forumhub.postagem;

import aj.org.objectweb.asm.commons.Remapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {
    Page<Postagem> findAllByAtivoTrue(Pageable paginacao);
}
