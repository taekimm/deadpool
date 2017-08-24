package com.tae.deadpool.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="picks")
public class Pick {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User userPicks;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="deadpool_id")
	private Deadpool relatedDeadpool;
	
	@OneToOne(fetch = FetchType.LAZY)
//	@Column(name = "victim_id")
	@JoinColumn(name="victim_id")
	private Character victim;
	
	@OneToOne(fetch = FetchType.LAZY)
//	@Column(name = "killer_id")
	@JoinColumn(name="killer_id")
	private Character killer;
	
	private Integer score;
	
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
    
    public Pick () {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserPicks() {
		return userPicks;
	}

	public void setUserPicks(User userPicks) {
		this.userPicks = userPicks;
	}

	public Deadpool getRelatedDeadpool() {
		return relatedDeadpool;
	}

	public void setRelatedDeadpool(Deadpool relatedDeadpool) {
		this.relatedDeadpool = relatedDeadpool;
	}

	public Character getVictim() {
		return victim;
	}

	public void setVictim(Character victim) {
		this.victim = victim;
	}

	public Character getKiller() {
		return killer;
	}

	public void setKiller(Character killer) {
		this.killer = killer;
	}
	
	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
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

//SELECT victims.fname, killers.fname FROM characters AS victims 
//JOIN picks ON victims.id = picks.victim_id
//JOIN characters AS killers ON killers.id = picks.killer_id;
