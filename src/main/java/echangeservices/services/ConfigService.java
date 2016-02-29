/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package echangeservices.services;

import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ConfigService {
    
    private int decouvertMax = 200;

    public int getDecouvertMax() {
        return decouvertMax;
    }

    public void setDecouvertMax(int decouvertMax) {
        this.decouvertMax = decouvertMax;
    }
    
    
}
