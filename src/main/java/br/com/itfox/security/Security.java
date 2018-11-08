/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.itfox.security;

//import com.tecnick.htmlutils.htmlentities.HTMLEntities;

/**
 *
 * @author belchiorpalma
 */
public class Security {
    public static String getParameter(String s){
        if(s!=null){
            s=s;
            //s = HTMLEntities.htmlentities(s);
        }
        return s;
    }
    
    public static String getParameterConverter(String s){
        if(s!=null){
            s=s;
            //s = HTMLEntities.unhtmlentities(s);
        }
        return s;
    }
    
}
