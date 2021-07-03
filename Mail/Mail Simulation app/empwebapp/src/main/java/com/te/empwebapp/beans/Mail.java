package com.te.empwebapp.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "mail_info")
public class Mail implements Serializable {
	@Id()
	//@GeneratedValue(strategy = GenerationType.AUTO)
private int mid;
	
	
//	@Column
//	@ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "fromID",joinColumns ={@JoinColumn(name ="uid" )})	  
//private int fromID;
//	@Column
//	@ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "toID",joinColumns ={@JoinColumn(name ="uid" )})	
//private int toID;
	
	
	
	@Column
private String subject;
	@Column
private String messsage;
	@Column
private String status;
	@Column
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="formID")
     private List<User> fuser ; 
	@Column
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "sendmail")
	private List<User> tuser ;
	
	
	

}
