package com.itdel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fasilitas
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String namaFasilitas;
	private String deskripsiFasilitas;
	
	public Fasilitas()
	{
		
	}
	
	

	public Fasilitas(int id, String namaFasilitas, String deskripsiFasilitas) {
		super();
		this.id = id;
		this.namaFasilitas = namaFasilitas;
		this.deskripsiFasilitas = deskripsiFasilitas;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamaFasilitas() {
		return namaFasilitas;
	}

	public void setNamaFasilitas(String namaFasilitas) {
		this.namaFasilitas = namaFasilitas;
	}

	public String getDeskripsiFasilitas() {
		return deskripsiFasilitas;
	}

	public void setDeskripsiFasilitas(String deskripsiFasilitas) {
		this.deskripsiFasilitas = deskripsiFasilitas;
	}
	
	
}
