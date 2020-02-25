package com.labs.lucasian.main;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationRun {
    private static String contentErrors;
    public static void main(String[] args) throws IOException, ParseException {
        contentErrors ="";
        AdministradoraDao administradoraDao = new AdministradoraDao();
        try (Reader reader = Files.newBufferedReader(Paths.get("./admin.csv"));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(';')
                     .withTrim().withIgnoreEmptyLines());
        ) {
            List<AdministradoraEntity> listaValida = new ArrayList<>();
            List<AdministradoraEntity> listaInvalida = new ArrayList<>();
            for (CSVRecord csvRecord : csvParser) {
                ValidadorAdministrador validadorAdministrador = new ValidadorAdministrador(csvRecord.getRecordNumber());
                AdministradoraEntity administrador = new AdministradoraEntity();
                administrador.setMultipleArp(false);
                administrador.setFps(false);
                administrador.setFusionada(false);
                try{
                    csvRecord.get(8);
                }catch (ArrayIndexOutOfBoundsException e){
                    validadorAdministrador.setErrorDescripcion("Error en el registro: "+csvRecord.getRecordNumber() +
                            ", faltan campos, para dejar campos vacios concatene con punto y coma en total deben haber 8 ;");
                    concatErrorText(validadorAdministrador.getRegistro(),validadorAdministrador.getErrorDescripcion());
                    break;
                }
                if (validadorAdministrador.validarCampo(csvRecord.get(0),"Codigo Administradora",
                        ValidadorAdministrador.regexCaracteresinvalidos)) {
                    administrador.setCodigo(csvRecord.get(0));
                }
                if (validadorAdministrador.validarCampo(csvRecord.get(1),"Nombre ",
                        ValidadorAdministrador.regexCaracteresinvalidos)) {
                    administrador.setNombre(csvRecord.get(1));
                }
                if (validadorAdministrador.validarTipoIdentificación(csvRecord.get(2))) {
                    administrador.setCodTpId(csvRecord.get(2));
                }
                if (validadorAdministrador.validarCampo(csvRecord.get(3),"Numero identificación"
                        ,ValidadorAdministrador.regexSoloNumeros)) {
                    administrador.setNroId(csvRecord.get(3));
                }
                if (validadorAdministrador.validarNaturaleza(csvRecord.get(4))) {
                    administrador.setNaturaleza(csvRecord.get(4));
                }
                if (csvRecord.get(5) != null) {
                    administrador.setMultipleArp(csvRecord.get(5).trim().equalsIgnoreCase("x"));
                }
                if (csvRecord.get(6) != null) {
                    administrador.setFps(csvRecord.get(6).trim().equalsIgnoreCase("x"));
                }
                if (csvRecord.get(7) != null) {
                    administrador.setFusionada(csvRecord.get(7).trim().equalsIgnoreCase("x"));
                }
                if (administrador.getFusionada() && validadorAdministrador.validarFechaFusion(csvRecord.get(8))) {
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    Date date = formatter.parse(csvRecord.get(8));
                    Time time = new Time(date.getTime());
                    administrador.setFechaFusion(time);
                }
                if(!validadorAdministrador.getErrorDescripcion().isEmpty()){
                    listaInvalida.add(administrador);
                    concatErrorText(validadorAdministrador.getRegistro(),validadorAdministrador.getErrorDescripcion());
                }else{
                    listaValida.add(administrador);
                }
            }
            if (listaInvalida.size() > 0) {
                System.out.println("GENERANDO LOG DE ERRORES");
                generarLogDeErrores(contentErrors);
            } else {
                System.out.println("PERSISTIENDO INFORMACIÓN");
                administradoraDao.insertList(listaValida);
            }
        }

    }

    private static void concatErrorText(long registro,String errorDescription) {
        contentErrors +="---------\n";
        contentErrors +="Registro No: "+registro+"\n";
        contentErrors += errorDescription+"\n";
        contentErrors +="---------";
    }

    private static void persistirLista(List<AdministradoraEntity> listaValida) {

    }

    private static void generarLogDeErrores(String contenido) {
        File file = new File("./logErrores.txt");
        try {
        if (!file.exists()) {
                file.createNewFile();
        }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

//fixme
        /*for (int i=0;i<5;i++){
        AdministradoraEntity administradoraEntity = new AdministradoraEntity();
        administradoraEntity.setCodigo("111");
        administradoraEntity.setNombre("111");
        administradoraEntity.setCodTpId("CC");
        administradoraEntity.setNroId("111");
        administradoraEntity.setNaturaleza("MIXTA");
        administradoraEntity.setMultipleArp(true);
        administradoraEntity.setFps(false);
        administradoraEntity.setFusionada(true);
        administradoraEntity.setFechaFusion(new Time(100000));
        listaValida.add(administradoraEntity);
        }
        administradoraDao.insertList(listaValida);*/
