package com.drive.drive.servicios;

import java.util.List;

import com.drive.drive.modelos.Archivo;

public interface ArchivoService {
    
    public List<Archivo> obtenerTodosLosArchivos();
    public Archivo guardarArchivo();
}
