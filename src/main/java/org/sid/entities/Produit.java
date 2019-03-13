package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Produit implements Serializable{
	@Id @GeneratedValue
	private Long id;
	private String designation;
	private double prix;
	private int quantité;
	
	public Produit() {
		super();
	}

	public Produit(String designation, double prix, int quantité) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.quantité = quantité;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantité() {
		return quantité;
	}

	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation=" + designation + ", prix=" + prix + ", quantité=" + quantité + "]";
	}
	
	
	
	

}
