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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Pattern(regexp="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message="Invalid Email Format")
	private String email;
	
	@Size(min=1, message="First name required.")
	private String fname;
	
	@Size(min=1, message="Last name required.")
	private String lname;
	
	@Size(min=8, message="Password must be greater than 8 characters long.")
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="host", fetch = FetchType.LAZY)
	private List<Deadpool> hostedDeadpools;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name = "users_deadpools",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "deadpool_id")
			)
	private List<Deadpool> activeDeadpools;
	
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
			name="users_invited_deadpools",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "deadpool_id")
			)
	private List<Deadpool> invitedDeadpools;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="userPicks", fetch = FetchType.LAZY)
	private List<Pick> userPicks;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name = "users_roles",
		joinColumns = @JoinColumn(name = "user_id"),
		inverseJoinColumns = @JoinColumn(name = "role_id")
			)
	private List<Role> roles;
	
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
    
    public User() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}

	public List<Deadpool> getHostedDeadpools() {
		return hostedDeadpools;
	}

	public void setHostedDeadpools(List<Deadpool> hostedDeadpools) {
		this.hostedDeadpools = hostedDeadpools;
	}

	public List<Deadpool> getActiveDeadpools() {
		return activeDeadpools;
	}

	public void setActiveDeadpools(List<Deadpool> activeDeadpools) {
		this.activeDeadpools = activeDeadpools;
	}

	public List<Pick> getUserPicks() {
		return userPicks;
	}

	public void setUserPicks(List<Pick> userPicks) {
		this.userPicks = userPicks;
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


	public List<Deadpool> getInvitedDeadpools() {
		return invitedDeadpools;
	}

	public void setInvitedDeadpools(List<Deadpool> invitedDeadpools) {
		this.invitedDeadpools = invitedDeadpools;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
    
    
}
