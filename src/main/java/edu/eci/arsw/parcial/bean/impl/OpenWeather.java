/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.bean.impl;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;
import edu.eci.arsw.parcial.bean.ServiceProvaider;
import edu.eci.arsw.parcial.model.HttpConnection;

import java.util.Date;

@Service("OpenWeather")
public class OpenWeather implements ServiceProvaider {

    /**
     * Implementación de cache de manera concurrente.
     */
    private ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<String, String>();
    Date date = new Date();
    int minutos = 0;

    /**
     * Obtener el contenido de la url especificada con la ciudad dada.
     *
     * @param clima nombre de la ciudad.
     * @throws IOException si el nombre de la ciudad no existe.
     */
    @Override
    public String getDataFromAPI(String ciudad) throws IOException {
        String urlData;
        int tiempoTranscurrido = date.getMinutes() - minutos;
        if (cache.containsKey(ciudad) && tiempoTranscurrido < 5) {
            urlData = cache.get(ciudad);
        } else {
            urlData = HttpConnection.getUrlData("http://api.openweathermap.org/data/2.5/weather?q=" + ciudad + "&APPID=acaf93181b23bc68702cd7ea5c26356e");
            cache.put(ciudad, urlData);
            minutos = date.getMinutes();
        }
        return urlData;
    }

}
