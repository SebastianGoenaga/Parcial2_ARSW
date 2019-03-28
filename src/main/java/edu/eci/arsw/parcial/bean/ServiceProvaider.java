/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.bean;

import java.io.IOException;

/**
 * Proveedor de los servicios
 *
 */
public interface ServiceProvaider {

    /**
     *
     * @param ciudad valor a consultar en el API externo
     * @return String json con la informacion retornada por el API
     * @throws IOException
     */
    public String getDataFromAPI(String ciudad) throws IOException;
}
