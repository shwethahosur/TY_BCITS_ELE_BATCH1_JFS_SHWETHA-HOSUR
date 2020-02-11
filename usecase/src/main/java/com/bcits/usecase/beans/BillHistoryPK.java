package com.bcits.usecase.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

import lombok.Data;
@Embeddable
@Data
public class BillHistoryPK implements Serializable {
	private String rrNo;
	private Date date;
}
