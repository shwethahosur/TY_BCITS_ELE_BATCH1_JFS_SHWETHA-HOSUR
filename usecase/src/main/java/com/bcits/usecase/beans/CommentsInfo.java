package com.bcits.usecase.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "comments_info")
public class CommentsInfo implements Serializable {

	@Id
	@Column
	private String rrNo;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String comments;
	@Column
	private String region;
}
