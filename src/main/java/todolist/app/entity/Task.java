package todolist.app.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Task {
    
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_task;
    
    @ManyToOne
    private Usuario fk;
    
    @NotNull
    @Column(name = "title")
    private String title;
    @NotNull
    @Column(name = "description")
    private String description;
    @NotNull
    @Column(name = "status")
    private boolean status;
    
    public Task(long id_task, String title, String description, boolean status) {
		super();
		
		this.id_task = id_task;
		this.title = title;
		this.description = description;
		this.status = status;
	}


	public Task() {}

	public Usuario getFk() {
		return fk;
	}

	public void setFk(Usuario fk) {
		this.fk = fk;
	}


	public long getId_task() {
		return id_task;
	}

	public void setId_task(long id_task) {
		this.id_task = id_task;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


}