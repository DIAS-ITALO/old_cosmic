package br.com.projetousuario.model;

public class Participante {
    
    private Integer idParticipante;
    private Comunidade comunidadePartipante;
    private Usuario usuarioPartipante;

    public Participante() {
    }

    public Participante(Integer idParticipante, Comunidade comunidadePartipante, Usuario usuarioPartipante) {
        this.idParticipante = idParticipante;
        this.comunidadePartipante = comunidadePartipante;
        this.usuarioPartipante = usuarioPartipante;
    }

    public Participante(Integer idParticipante) {
        this.idParticipante = idParticipante;
    }

    public Participante(Usuario usuarioPartipante) {
        this.usuarioPartipante = usuarioPartipante;
    }
    
    

    public Integer getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Integer idParticipante) {
        this.idParticipante = idParticipante;
    }

    public Comunidade getComunidadePartipante() {
        return comunidadePartipante;
    }

    public void setComunidadePartipante(Comunidade comunidadePartipante) {
        this.comunidadePartipante = comunidadePartipante;
    }

    public Usuario getUsuarioPartipante() {
        return usuarioPartipante;
    }

    public void setUsuarioPartipante(Usuario usuarioPartipante) {
        this.usuarioPartipante = usuarioPartipante;
    }
    
    
}
