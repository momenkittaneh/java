package com.Eventbelt.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "events")
public class event {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    
    @Size(min=5)
    private String name;
    
    @Size(min=5)
    private String location;
    
	@NotNull(message="You must give a date to create an event")
	@FutureOrPresent
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "user_id")
    private User planner;
    
    private String state;
    
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "comm")
    private List<message> comment;

    
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "UserEvent", 
        joinColumns = @JoinColumn(name = "event_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> join;

	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	public event() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
		}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public User getPlanner() {
		return planner;
	}
	public void setPlanner(User planner) {
		this.planner = planner;
	}
	public String getStat() {
		return state;
	}
	public void setStat(String stat) {
		this.state = stat;
	}

	public List<message> getComment() {
		return comment;
	}
	public void setComment(List<message> comment) {
		this.comment = comment;
	}
	public List<User> getJoin() {
		return join;
	}
	public void setJoin(List<User> join) {
		this.join = join;
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

	
	
	
}
