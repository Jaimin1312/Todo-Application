/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addtodo;
import com.todo.dao.*;
import com.todo.model.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author jaimin
 */
public class AddTodo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Todo t = new Todo();
        t.setTitle("Today Work");
        t.setDescription("Java Learning");
        t.setStatus("Pending");
        DateFormat lastupdatedate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String lastupdatedatestring = lastupdatedate.format(new Date());
        try {
             Date d = lastupdatedate.parse(lastupdatedatestring);
        t.setDate(d);
            
        } catch (Exception e) {
        }
       
        TodoDAO td = new TodoDAO();
        td.addTodo(t);
        System.out.println("todo added");
      
    }
    
}
