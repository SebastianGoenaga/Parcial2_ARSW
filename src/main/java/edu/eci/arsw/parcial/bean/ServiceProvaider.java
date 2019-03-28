/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.parcial.bean;

import java.io.IOException;

public interface ServiceProvaider {

    /**
     *
     * @param clima the value of clima
     * @return
     * @throws IOException
     */
    public String getDataFromAPI(String ciudad) throws IOException;
}
