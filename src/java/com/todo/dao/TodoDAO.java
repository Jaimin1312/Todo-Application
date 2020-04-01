/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todo.dao;
import java.util.*;
import com.todo.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
/**
 *
 * @author jaimin
 */
public class TodoDAO {
    
    public void addTodo(Todo t){
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(t);
        session.getTransaction().commit();
        session.close();
        sf.close();
    }
    
    public void editTodo(Todo t){
         SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        session.merge(t);
        session.getTransaction().commit();
        session.close();
        sf.close();
       
    }
    
    public void deleteTodo(int id){
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        Todo x=(Todo)session.get(Todo.class, id);
        session.delete(x);
        session.getTransaction().commit();
        session.close();
        sf.close();
    }
    
    public List<Todo> listTodo(){
        SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        List<Todo> todolist = session.createSQLQuery("select *from todo order by date desc").addEntity(Todo.class).list();
        session.getTransaction().commit();
        session.close();
        sf.close();
        return todolist;
    }
    
    public Todo getTodo(int id){
         SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();
        Todo todo = (Todo)session.get(Todo.class,id);
        session.getTransaction().commit();
        session.close();
        sf.close();
        return todo;
    }
    
   
   
}
