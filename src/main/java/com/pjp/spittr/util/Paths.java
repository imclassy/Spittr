/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pjp.spittr.util;

/**
 *
 * @author pjaraba
 */
public class Paths {
    
    public static String VIEWS_PATH = "/WEB-INF/views/";
    
    public static String getJspViewPath(String viewName){
        return VIEWS_PATH + viewName + ".jsp";
    }
}
