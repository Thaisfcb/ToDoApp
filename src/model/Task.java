
package model;

/**
 *
 * @author Pichau
 */

import java.util.Date;

public class Task {
    //ATRIBUTOS
    private int id;
    private int idProject;
    private String name;
    private String description;
    private boolean iscompleted;
    private String notes;
    private Date deadline;
    private Date createdAt;
    private Date updatedAt;

    public Task(int id, int idProject, String name, String description, boolean completed, String notes, Date deadline, Date createdAt, Date updatedAt) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.iscompleted = completed;
        this.notes = notes;
        this.deadline = deadline;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public Task() {
        this.deadline = new Date ();
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIscompleted() {
        return iscompleted;
    }

    public void setIscompleted(boolean iscompleted) {
        this.iscompleted = iscompleted;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", description=" + description + ", iscompleted=" + iscompleted + ", notes=" + notes + ", deadline=" + deadline + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + '}';
    }

    public void setDeadline() {
        
    }

    public void setCreatedAt() {
        
    }

    public void setUpdatedAt() {
        
    }
    
    
    
}
    
    //public Task(){
        //this.deadline = new Date();
        //this.createdAt = new Date();
        //this.updatedAt = new Date();
        
    //}

    

