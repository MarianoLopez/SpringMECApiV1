/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mec.Util;

import java.util.List;

/**
 *
 * @author MarianoLopez
 * @param <T> class
 * @param <K> key
 */
public interface GET<T,K>{
    public List<T> getAll();
    public T getByID(K id);
}
