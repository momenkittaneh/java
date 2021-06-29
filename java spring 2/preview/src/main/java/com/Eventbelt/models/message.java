package com.Eventbelt.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name = "messeages")
public class message {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Size(min=10)
    private String messeage;
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "user_id")
    private User mycomm;
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "event_id")
    private event comm;
    
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	public message() {
		super();
	}
	
	public message(@Size(min = 10) String messeage, User mycomm, event comm) {
		super();
		this.messeage = messeage;
		this.mycomm = mycomm;
		this.comm = comm;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMesseage() {
		return messeage;
	}
	public void setMesseage(String messeage) {
		this.messeage = messeage;
	}
	public User getMycomm() {
		return mycomm;
	}
	public void setMycomm(User mycomm) {
		this.mycomm = mycomm;
	}
	public event getComm() {
		return comm;
	}
	public void setComm(event comm) {
		this.comm = comm;
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
