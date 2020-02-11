package com.bcits.usecase.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Admin_Info")
public class AdminInfoBean implements Serializable {
	@Id
	@Column
	private Integer adminId;
	
	@Column
	private String password;
	
}
