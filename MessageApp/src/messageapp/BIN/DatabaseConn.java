/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messageapp.BIN;


import Pojo.NewHibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author AHMET
 */
public class DatabaseConn {
    private  SessionFactory sessionFactory;
    
    public void connect(){
        sessionFactory = NewHibernateUtil.getSessionFactory();
        
    }
    public void disConnect(){
        sessionFactory.close();
    }
    
   
}
