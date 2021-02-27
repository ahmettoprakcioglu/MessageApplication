/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageapp.BIN;

import javafx.collections.ObservableList;

/**
 *
 * @author AHMET
 */
public interface IDatabase<T> {
    
     public T get(int ID, Class s);
     public ObservableList<T> gets(Class s);
     public void update(T t);
     public void delete(T t);
     public void save(T t);
     public void saveorupdate(T t);
}
