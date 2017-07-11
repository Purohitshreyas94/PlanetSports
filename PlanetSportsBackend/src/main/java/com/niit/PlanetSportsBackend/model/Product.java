package com.niit.PlanetSportsBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Product 
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int prodid;
  
  String prodname;
  @JsonIgnore
  String proddesc;
  int quantity,price;
  @JsonIgnore
  int catid;
  @JsonIgnore
  int suppid;
  
@Transient
  MultipartFile file;

public MultipartFile getFile() {
	return file;
}
public void setFile(MultipartFile file) {
	this.file = file;
}

  public int getProdid() 
  {
	return prodid;
  }
public void setProdid(int prodid) {
	this.prodid = prodid;
}
public String getProdname() {
	return prodname;
}
public void setProdname(String prodname) {
	this.prodname = prodname;
}
public String getProddesc() {
	return proddesc;
}
public void setProddesc(String proddesc) {
	this.proddesc = proddesc;
}
public int getCatid() {
	return catid;
}
public void setCatid(int catid) {
	this.catid = catid;
}
public int getSuppid() {
	return suppid;
}
public void setSuppid(int suppid) {
	this.suppid = suppid;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
  
  
}
