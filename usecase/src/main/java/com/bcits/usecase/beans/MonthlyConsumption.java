package com.bcits.usecase.beans;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "monthly_Consumption_info")
public class MonthlyConsumption implements Serializable {
	@EmbeddedId
	private MonthlyConsumptionPK consumptionPK;
	@Column
	private int unitsConsumed;
	@Column
	private String region;
	@Column
	private double billAmount;

}
