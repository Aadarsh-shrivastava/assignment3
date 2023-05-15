package com.nagarro.assignment3.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;

	@Column(name="quantity")
	private int quantiity;
	
	@Column(name="size")
	private int size;
	
	 @Column(name="image")
	 private String image;

	public Product(int id, String title, int quantiity, int size, String image) {
		super();
		this.id = id;
		this.title = title;
		this.quantiity = quantiity;
		this.size = size;
		this.image = image;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantiity() {
		return quantiity;
	}

	public void setQuantiity(int quantiity) {
		this.quantiity = quantiity;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", title=" + title + ", quantiity=" + quantiity + ", size=" + size + ", image="
				+ image + "]";
	}
	
}
