package br.com.projetousuario.model;

public class Adm {
    
    private Integer idAdm;
    private String nomeAdm;
    private String emailAdm;
    private String senhaAdm;
    private String dataNascimentoAdm;

    public Adm() {
    }

    public Adm(Integer idAdm, String nomeAdm, String emailAdm, String senhaAdm, String dataNascimentoAdm) {
        this.idAdm = idAdm;
        this.nomeAdm = nomeAdm;
        this.emailAdm = emailAdm;
        this.senhaAdm = senhaAdm;
        this.dataNascimentoAdm = dataNascimentoAdm;
    }

    public Integer getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(Integer idAdm) {
        this.idAdm = idAdm;
    }

    public String getNomeAdm() {
        return nomeAdm;
    }

    public void setNomeAdm(String nomeAdm) {
        this.nomeAdm = nomeAdm;
    }

    public String getEmailAdm() {
        return emailAdm;
    }

    public void setEmailAdm(String emailAdm) {
        this.emailAdm = emailAdm;
    }

    public String getSenhaAdm() {
        return senhaAdm;
    }

    public void setSenhaAdm(String senhaAdm) {
        this.senhaAdm = senhaAdm;
    }

    public String getDataNascimentoAdm() {
        return dataNascimentoAdm;
    }

    public void setDataNascimentoAdm(String dataNascimentoAdm) {
        this.dataNascimentoAdm = dataNascimentoAdm;
    }

    
    
}
