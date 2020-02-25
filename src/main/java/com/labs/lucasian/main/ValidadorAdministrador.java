package com.labs.lucasian.main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorAdministrador {

    private String registro;
    private String campo;
    private String descripción;

    public ValidadorAdministrador() {
    }

    private boolean validarTexto(String texto, String regex){
        Pattern patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(texto);
        return emparejador.find();
    }

    public boolean esAdministradoraValida(AdministradoraVO administradora){
        if(!validarTexto(administradora.getCodigoAdministradora(),""))
            return false;
        if(!validarTexto(administradora.getNombre(),""))
            return false;
        if(!validarTexto(administradora.getCodigoAdministradora(),""))
            return false;
        if(!validarTexto(administradora.getIdentificacion(),""))
            return false;
        if(!validarTexto(administradora.getNaturaleza(),""))
            return false;
        if(!validarTexto(administradora.getNaturaleza(),""))
            return false;
        if(!validarTexto(administradora.getNaturaleza(),""))
            return false;
        if(!validarTexto(administradora.getNaturaleza(),""))
            return false;
        return true;
    }
    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }
}
