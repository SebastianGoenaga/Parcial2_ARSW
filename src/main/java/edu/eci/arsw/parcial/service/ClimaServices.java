/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import edu.eci.arsw.parcial.bean.ServiceProvaider;
import edu.eci.arsw.parcial.service.contracts.IClimaServices;

/**
 * Implementación de los servicios expuestos
 *
 */
@Service
public class ClimaServices implements IClimaServices {

    /**
     * Implementación con inversión de control para uso de otras APIs.
     */
    @Autowired
    @Qualifier("OpenWeather")
    ServiceProvaider openWeather;

    /**
     *
     * @param ciudad de la ciudad a consultar su estado de clima
     * @throws IOException si no existe el nombre de la ciudad.
     */
    @Override
    public String getClimaCiudad(String ciudad) throws IOException {
        return openWeather.getDataFromAPI(ciudad);
    }
}
