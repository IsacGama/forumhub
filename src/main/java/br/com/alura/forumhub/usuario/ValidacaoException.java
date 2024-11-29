package br.com.alura.forumhub.usuario;

public class ValidacaoException extends RuntimeException{
  public ValidacaoException(String mensagem){
    super(mensagem);
  }
}
