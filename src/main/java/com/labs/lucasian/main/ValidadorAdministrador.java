package com.labs.lucasian.main;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorAdministrador {

    private long numRegistro;
    private String errorDescripcion;
    public static String regexCaracteresinvalidos = "\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|\" + \"\\%+|\\&+|\\+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\]+" +
            "+|\\{+|\\}+|\\^+|\\<+|\\>+|\\”+";
    public static String regexSoloNumeros = ".*[xyz].*";

    public ValidadorAdministrador(long numRegistro) {
        this.numRegistro = numRegistro;
        this.errorDescripcion = "";
    }

    public boolean validarTexto(String texto, String regex){
        Pattern patron = Pattern.compile(regex);
        Matcher emparejador = patron.matcher(texto);
        return emparejador.find();
    }
    public boolean validarCampo(String valor,String campo,String regex){
        if(valor==null || valor.isEmpty()) {
            this.errorDescripcion += "Error en "+campo+" campo vacio, \n";
            return false;
        }
        if(validarTexto(valor,regex)){
            this.errorDescripcion += " "+campo+" contiene caracteres no permitidos, \n";
            return false;
        }
        return true;
    }

    public boolean validarTipoIdentificación(String tipoIdentificacion){
        if(tipoIdentificacion.equalsIgnoreCase("NI")||tipoIdentificacion.equalsIgnoreCase("CC")
                ||tipoIdentificacion.equalsIgnoreCase("PA")||
                tipoIdentificacion.equalsIgnoreCase("RC")){
            return true;
        }
        this.errorDescripcion += "Error en tipo de identificacion valores permitidos NI PA CC RC \n";
        return false;
    }
    public boolean validarFechaFusion(String date){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            formatter.parse(date);
            return true;
        } catch (ParseException e) {
            this.errorDescripcion += "Error en el formato de la fecha \n";
            return false;
        }
    }
    public boolean validarNaturaleza(String naturaleza){
        if(naturaleza.equalsIgnoreCase("MI")||naturaleza.equalsIgnoreCase("PU")||
                naturaleza.equalsIgnoreCase("PR")){
            return true;
        }
        this.errorDescripcion += "Error en el campo naturaleza valores permitidos MI PU PR \n";
        return false;
    }


    public long getRegistro() {
        return numRegistro;
    }

    public void setRegistro(long registro) {
        this.numRegistro = registro;
    }
    public String getErrorDescripcion() {
        return errorDescripcion;
    }

    public void setErrorDescripcion(String errorDescripcion) {
        this.errorDescripcion = errorDescripcion;
    }
}
