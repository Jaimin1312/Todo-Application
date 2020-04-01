/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todo.controller;

import com.todo.dao.TodoDAO;
import com.todo.model.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author jaimin
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String Home(Model m) {
        TodoDAO td = new TodoDAO();
        List<Todo> listtodoList = td.listTodo();
        m.addAttribute("todos", listtodoList);
        return "index";
    }

    @RequestMapping("/add-todo")
    public String addTodo(Model m) {
        return "createtodo";
    }

    @RequestMapping("/insert-todo")
    public String insertdata(Model m, HttpServletRequest req) {
        TodoDAO td = new TodoDAO();
        Todo t = new Todo();
        t.setTitle(req.getParameter("title"));
        t.setDescription(req.getParameter("description"));
        t.setStatus(req.getParameter("status"));
        DateFormat lastupdatedate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String lastupdatedatestring = lastupdatedate.format(new Date());
        try {
            Date d = lastupdatedate.parse(lastupdatedatestring);
            t.setDate(d);

        } catch (Exception e) {
        }
        td.addTodo(t);
        m.addAttribute("msg", "Todo Added");
        List<Todo> listtodoList = td.listTodo();
        m.addAttribute("todos", listtodoList);
        return "index";
    }

    @RequestMapping("edit/{id}")
    public String edittodo(Model m, HttpServletRequest req, @PathVariable("id") int id) {
        TodoDAO td = new TodoDAO();
        Todo x = td.getTodo(id);
        if (x == null) {
            m.addAttribute("msg", "Todo Not Exits");
            List<Todo> listtodoList = td.listTodo();
            m.addAttribute("todos", listtodoList);
            return "index";
        }
        Todo t = td.getTodo(id);
        m.addAttribute("row", t);
        return "edit";
    }

    @RequestMapping("/Edit/{id}")
    public String updatedata(Model m, HttpServletRequest req, @PathVariable("id") int id) {
        TodoDAO td = new TodoDAO();
        Todo x = td.getTodo(id);
        if (x == null) {
            m.addAttribute("msg", "Todo Not Exits");
            List<Todo> listtodoList = td.listTodo();
            m.addAttribute("todos", listtodoList);
            return "index";
        }
        
        
       
        Todo t = new Todo();
        
        t.setId(id);
        t.setTitle(req.getParameter("title"));
        t.setDescription(req.getParameter("description"));
        t.setStatus(req.getParameter("status"));
        DateFormat lastupdatedate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String lastupdatedatestring = lastupdatedate.format(new Date());
        try {
            Date d = lastupdatedate.parse(lastupdatedatestring);
            t.setDate(d);

        } catch (Exception e) {
        }
        td.editTodo(t);
        m.addAttribute("msg", "Todo Updated");
        List<Todo> listtodoList = td.listTodo();
        m.addAttribute("todos", listtodoList);
        return "index";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model m, @PathVariable("id") int id) {
        TodoDAO td = new TodoDAO();
        Todo t = td.getTodo(id);
        if (t == null) {
            m.addAttribute("msg", "Todo Already Deleted");
            List<Todo> listtodoList = td.listTodo();
            m.addAttribute("todos", listtodoList);
            return "index";
        }
        td.deleteTodo(id);
        m.addAttribute("msg", "Todo Deleted");
        List<Todo> listtodoList = td.listTodo();
        m.addAttribute("todos", listtodoList);
        return "index";
    }
}
