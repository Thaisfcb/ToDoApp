/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import controller.ProjectController;
import controller.TaskController;
import java.sql.SQLException;
import java.util.HashSet;
import model.Project;
import model.Task;

/**
 *
 * @author Pichau
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
        /*ProjectController projectController = new ProjectController();
        
        Project project = new Project();
        project.setName("Projeto Teste2");
        project.setDescription("teste2");
        projectController.save(project);*/
        
        TaskController taskController = new TaskController();
        
        Task task = new Task();
        task.setIdProject(3);
        task.setName("Teste");
        task.setDescription("Teste description tasks");
        task.setIscompleted(false);
        task.setNotes("Teste notes tasks");
        task.setDeadline();
        task.setCreatedAt();
        task.setUpdatedAt();
        taskController.save(task);
        
    }
    
}
