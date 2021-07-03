package com.te.empwebapp.beans;


import java.io.Serializable;
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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "user_info")
public class User implements Serializable {
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
private int uid;
	@Column
private String userName;
	@Column
private String email;
	@Column
private String password;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "fuser")  

   private List<Mail> recivedmail;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="toID")
private List<Mail> sendmail;

}
