package com.arpax.ARPA.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Stock")
@EntityListeners(AuditingEntityListener.class)
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String code;

	private String name;

	private String createdDate;

	private String modifiedDate;

	private String modifiedBy;


	public Stock() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
