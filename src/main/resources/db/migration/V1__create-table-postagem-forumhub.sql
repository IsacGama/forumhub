CREATE TABLE usuarios (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL
);

CREATE TABLE postagem (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,            -- Identificador único de cada postagem
    usuario_id BIGINT,                               -- Referência para o usuário (autor) da postagem
    titulo VARCHAR(255) NOT NULL,                     -- Título da postagem
    mensagem VARCHAR(500) NOT NULL,                   -- Mensagem ou conteúdo da postagem (usando VARCHAR em vez de TEXT)
    data DATETIME DEFAULT CURRENT_TIMESTAMP,          -- Data de criação da postagem
    curso VARCHAR(100) NOT NULL,                      -- Curso relacionado ao tópico
    ativo BOOLEAN DEFAULT TRUE,                       -- Status ativo da postagem
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id)   -- Chave estrangeira para a tabela 'usuarios'
      REFERENCES usuarios(id)                      -- Relaciona a postagem ao usuário
      ON DELETE CASCADE,                            -- Se o usuário for deletado, as postagens relacionadas também serão deletadas
    CONSTRAINT uc_titulo_mensagem UNIQUE (titulo, mensagem)  -- Unicidade na combinação de título e mensagem
);

