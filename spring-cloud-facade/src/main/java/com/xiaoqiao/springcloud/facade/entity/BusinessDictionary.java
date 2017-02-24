package com.xiaoqiao.springcloud.facade.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BUSINESS_DICTIONARY")
public class BusinessDictionary implements Serializable{
    private static final long serialVersionUID = 6627013078789499713L;
	@Id
	@Column(name="ID_")
	private String id;
	@Column(name="TYPE_")
	private String type;
	@Column(name="CODE_")
	private String code;
	@Column(name="VALUE_")
	private String value;
	@Column(name="ORD_")
	private String ord;
	@Column(name="DESC_")

	private String desc_;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getOrd() {
		return ord;
	}
	public void setOrd(String ord) {
		this.ord = ord;
	}
	public String getDesc_() {
		return desc_;
	}
	public void setDesc_(String desc_) {
		this.desc_ = desc_;
	}
}
