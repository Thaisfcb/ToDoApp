package controller;

/**
 *
 * @author Pichau
 */


import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.ConnectionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Project; 

public class ProjectController {
    public void save (Project project){
        
        String sql = "INSERT INTO projects (name,"
                + "description,"
                + "createdAt," 
                + "updatedAt)"
                + "VALUES (?,?,?,?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
          try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //Cria um PreparedStatement , classe usada para executar a query
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date (project.getCreatedAt().getTime()));
            statement.setDate(4, new Date (project.getUpdatedAt().getTime()));
            
            //Executando a Query
            statement.execute();
          } catch (SQLException ex) {
                throw new RuntimeException("Erro ao salvar o projeto", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
             
    }    
    
    
    public void update(Project project){
        String sql = "UPDATE projects SET "
                + "name = ?, "
                + "description = ?, "
                + "createdAt = ?, "
                + "updatedAt = ?, "
                + "WHERE Id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando a Query
            statement = connection.prepareStatement(sql);
            
            //Setando os valores statement 
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, new Date (project.getCreatedAt().getTime()));
            statement.setDate(4, new Date (project.getUpdatedAt().getTime()));
            statement.setInt(5, project.getId());
            
            //Executando a Query
            statement.execute(); 
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro ao atualizar projeto", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void removeByID (int IDPROJECT) {
        
        String sql = "DELETE FROM projects WHERE Id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando a Query
            statement = connection.prepareStatement(sql);
            
             //Setando os valores statement
            statement.setInt(1, IDPROJECT);
            
            //Executando a Query
            statement.execute();
                    
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro ao deletar projeto", ex);   
        } finally {
            ConnectionFactory.closeConnection(connection, statement);   
        }
    }
    
    public List<Project> getAll (){
        
        String sql = "SELECT * FROM projects";
        
        List<Project> projects = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        //Classe que vai recuperar os dados do banco de dados
        ResultSet resultSet = null;

        try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            //Valor retornado pela execução da Query
            resultSet = statement.executeQuery();
            
            //Enquanto existir dados no banco de dados, faça
            while (resultSet.next()){
                
                Project project = new Project ();
                project.setId(resultSet.getInt("Id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdatedAt(resultSet.getDate("updatedAt"));
                
                //Adicionando projeto na lista de projetos
                projects.add(project);       
            }
        } catch (SQLException ex) {
            throw new RuntimeException ("Erro ao buscar projetos", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
            
        }
        // Lista de tarefas que foi criada e carregada do banco de dados
        return projects;
    }   
}
