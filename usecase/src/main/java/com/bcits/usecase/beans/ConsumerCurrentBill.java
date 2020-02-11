package com.bcits.usecase.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;



import lombok.Data;

@Data
@Entity
@Table(name = "current_bill")
public class ConsumerCurrentBill {
	@Id
	@Column
	private String rrNo;
	@Column
	private Integer meterNo;
	@Column
	private Date previousMeterReadDate;
	@Column
	private Date currentMeterReadDate;
	@Column
	private Integer billNumber;
	@Column
	private Integer previousMeterReading;
	@Column
	private Integer currentMeterReading;
	@Column
	private Integer units;
	@Column
	private Date dueDate;
	@Column
	private double payableAmt;
	@Column
	private String meterStatus;
	@Column
	private String region;
	@Column
	private String consumerType;
	@Column
	private int count;
	

}
