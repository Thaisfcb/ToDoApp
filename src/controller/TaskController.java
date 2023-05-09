package controller;

/**
 *
 * @author Pichau
 */

import  model.Task;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.ConnectionFactory;
import java.sql.SQLException;
import java.util.ArrayList;

public class TaskController {
    public void save (Task task){
        
        String sql = "INSERT INTO tasks (idProject,"
                + "name,"
                + "description,"
                + "completed,"
                + "notes," 
                + "deadline," 
                + "createdAt," 
                + "updatedAt) VALUES (?,?,?,?,?,?,?,?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
          try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando a Query
            statement = connection.prepareStatement(sql);
            
            //Setando os valores statement
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isIscompleted());
            statement.setString(5, task.getNotes());
            statement.setDate(6, new Date (task.getDeadline().getTime()));
            statement.setDate(7, new Date (task.getCreatedAt().getTime()));
            statement.setDate(8, new Date (task.getUpdatedAt().getTime()));
            
            //Executando a Query
            statement.execute();
          } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a tarefa "
                    + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
             
    }    
    
    
    public void update (Task task){
        String sql = "UPDATE tasks SET "
                +"idProject = ?, "
                +"name = ?, "
                +"description = ?, "
                +"notes=?, "
                +"completed = ?, "
                +"deadline = ?, "
                +"createdAt = ?, "
                +"updatedAt = ? "
                +"WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Estabelecendo a conexao com o DB
            connection = ConnectionFactory.getConnection();
            //Preparando a query
            statement = connection.prepareStatement(sql);
            
            //setando os valores do statement
            statement.setInt (1,task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setString(4, task.getNotes());
            statement.setBoolean(5, task.isIscompleted());
            statement.setDate(6, new Date (task.getDeadline().getTime()));
            statement.setDate(7, new Date(task.getCreatedAt().getTime()));
            statement.setDate(8, new Date( task.getUpdatedAt().getTime()));
            statement.setInt(9, task.getId());
            statement.execute();
            
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar a tarefa"+ e.getMessage());
        } finally{
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void removeByID (int taskID){
        
        String sql = "DELETE FROM tasks WHERE Id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando a Query
            statement = connection.prepareStatement(sql);
            
             //Setando os valores statement
            statement.setInt(1, taskID);
            
            //Executando a Query
            statement.execute();
                    
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro ao deletar tarefa" + ex.getMessage(), ex);   
        } finally {
            ConnectionFactory.closeConnection(connection, statement);   
        }
    }
    
    public List<Task> getAll (int IdProject){
        
        String sql = "SELECT * FROM tasks WHERE IDPROJECT = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        //Lista de tarefas que será devolvida quando o método for chamado
        List<Task> tasks;
        tasks = new ArrayList();
        
        try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            //Setando o valor que corresponde ao filtro de busca
            statement.setInt(1, IdProject);
            
            //Valor retornado pela execução da Query
            resultSet = statement.executeQuery();
            
            //Enquanto existirem valores a serem percorridos no meu resulSet
            while (resultSet.next()){
                
                Task task = new Task ();
                task.setId(resultSet.getInt("Id"));
                task.setIdProject(resultSet.getInt("IdProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setIscompleted(resultSet.getBoolean("completed"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline"));
                task.setCreatedAt(resultSet.getDate("createdAt"));
                task.setUpdatedAt(resultSet.getDate("updatedAt"));
                tasks.add(task);       
            }
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro ao inseir a tarefa" + ex.getMessage(), ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
            
        }
        // Lista de tarefas que foi criada e carregada do banco de dados
        return tasks;
    }
       
}
