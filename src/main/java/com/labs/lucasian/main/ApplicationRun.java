package com.labs.lucasian.main;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;

import java.sql.Time;

public class ApplicationRun {

    public static void main(String[] args) throws IOException {
        AdministradoraDao administradoraDao = new AdministradoraDao();
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

        administradoraDao.insert(administradoraEntity);
//        try(    Reader reader = Files.newBufferedReader(Paths.get("./admin.csv"));
//                CSVParser csvParser = new CSVParser(reader, CSVFormat.newFormat(';')
//                        .withTrim().withIgnoreEmptyLines());
//                )
//        {
//            List<AdministradoraVO> listaValida = new ArrayList<>();
//            List<AdministradoraVO> listaInvalida = new ArrayList<>();
//            for (CSVRecord csvRecord : csvParser) {
//                AdministradoraVO administrador = new AdministradoraVO();
//                administrador.setCodigoAdministradora(csvRecord.get(0));
//                administrador.setNombre(csvRecord.get(1));
//                administrador.setTipoIdentificacion(csvRecord.get(2));
//                administrador.setIdentificacion(csvRecord.get(3));
//                administrador.setNaturaleza(csvRecord.get(4));
//                administrador.setMultipleArp(csvRecord.get(5));
//                administrador.setFsp(csvRecord.get(6));
//                administrador.setFusionada(csvRecord.get(7));
//                administrador.setFechaFusion(csvRecord.get(8));
//                listaValida.add(administrador);
//            }
//        }

    }
}
