package br.com.projetousuario.model;

public class Comunidade {

    private Integer idComunidade;
    private String nomeComunidade;
    private String descricaoComunidade;
    private Categoria categoriaComunidade;
    private Usuario moderadorComunidade;


    public Comunidade() {
    }

    public Comunidade(int idComunidade, String nomeComunidade) {
        this.idComunidade = idComunidade;
        this.nomeComunidade = nomeComunidade;
    }

    

    public Integer getIdComunidade() {
        return idComunidade;
    }

    public void setIdComunidade(Integer idComunidade) {
        this.idComunidade = idComunidade;
    }

    public String getNomeComunidade() {
        return nomeComunidade;
    }

    public void setNomeComunidade(String nomeComunidade) {
        this.nomeComunidade = nomeComunidade;
    }

    public String getDescricaoComunidade() {
        return descricaoComunidade;
    }

    public void setDescricaoComunidade(String descricaoComunidade) {
        this.descricaoComunidade = descricaoComunidade;
    }

    public Categoria getCategoriaComunidade() {
        return categoriaComunidade;
    }

    public void setCategoriaComunidade(Categoria categoriaComunidade) {
        this.categoriaComunidade = categoriaComunidade;
    }

    public Usuario getModeradorComunidade() {
        return moderadorComunidade;
    }

    public void setModeradorComunidade(Usuario moderadorComunidade) {
        this.moderadorComunidade = moderadorComunidade;
    }


    

    public Comunidade(Integer idComunidade, String nomeComunidade, String descricaoComunidade, Categoria categoriaComunidade, Usuario moderadorComunidade) {
        this.idComunidade = idComunidade;
        this.nomeComunidade = nomeComunidade;
        this.descricaoComunidade = descricaoComunidade;
        this.categoriaComunidade = categoriaComunidade;
        this.moderadorComunidade = moderadorComunidade;

    }

    public Comunidade(Integer idComunidade) {
        this.idComunidade = idComunidade;
    }

    
    
}
