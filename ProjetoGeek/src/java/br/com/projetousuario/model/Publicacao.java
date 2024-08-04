package br.com.projetousuario.model;

public class Publicacao {

    private Integer idPublicacao;
    private String conteudoPublicacao;
    private Comunidade comunidadePublicacao;
    private Usuario usuarioPublicacao;

    public Publicacao() {
    }

    public Publicacao(Integer idPublicacao, String conteudoPublicacao, Comunidade comunidadePublicacao, Usuario usuarioPublicacao) {
        this.idPublicacao = idPublicacao;
        this.conteudoPublicacao = conteudoPublicacao;
        this.comunidadePublicacao = comunidadePublicacao;
        this.usuarioPublicacao = usuarioPublicacao;
    }

    public Integer getIdPublicacao() {
        return idPublicacao;
    }

    public void setIdPublicacao(Integer idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public String getConteudoPublicacao() {
        return conteudoPublicacao;
    }

    public void setConteudoPublicacao(String conteudoPublicacao) {
        this.conteudoPublicacao = conteudoPublicacao;
    }

    public Comunidade getComunidadePublicacao() {
        return comunidadePublicacao;
    }

    public void setComunidadePublicacao(Comunidade comunidadePublicacao) {
        this.comunidadePublicacao = comunidadePublicacao;
    }

    public Usuario getUsuarioPublicacao() {
        return usuarioPublicacao;
    }

    public void setUsuarioPublicacao(Usuario usuarioPublicacao) {
        this.usuarioPublicacao = usuarioPublicacao;
    }
    
    
    
    
}
