package com.tae.deadpool.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="deadpools")
public class Deadpool {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User host;
		
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "users_deadpools",
			joinColumns = @JoinColumn(name = "deadpool_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private List<User> usersInDeadpool;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "users_invited_deadpools",
			joinColumns = @JoinColumn(name = "deadpool_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private List<User> invitedUsersInDeadpool;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="relatedDeadpool", fetch = FetchType.LAZY)
	private List<Pick> picksByUsers;
	
	@DateTimeFormat(pattern = "MM/dd/yyy HH:mm:ss")
	private Date createdAt;

	@DateTimeFormat(pattern = "MM/dd/yyy HH:mm:ss")
	private Date updatedAt;
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    public Deadpool() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public List<User> getUsersInDeadpool() {
		return usersInDeadpool;
	}

	public void setUsersInDeadpool(List<User> usersInDeadpool) {
		this.usersInDeadpool = usersInDeadpool;
	}

	public List<Pick> getPicksByUsers() {
		return picksByUsers;
	}

	public void setPicksByUsers(List<Pick> picksByUsers) {
		this.picksByUsers = picksByUsers;
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

	public List<User> getInvitedUsersInDeadpool() {
		return invitedUsersInDeadpool;
	}

	public void setInvitedUsersInDeadpool(List<User> invitedUsersInDeadpool) {
		this.invitedUsersInDeadpool = invitedUsersInDeadpool;
	}
    
 }
