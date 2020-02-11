package com.bcits.usecase.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Bill_history")
public class BillHistory implements Serializable {
	@EmbeddedId
	private BillHistoryPK billHistoryPK;
//	@Column
//	private String rrNo;
	@Column
	private int units;
	@Column
	private String status;
//	@Column
//	private Date date;
	@Column
	private double totalamt;
	@Column
	private double dueamt;
	@Column
	private String region;

}
