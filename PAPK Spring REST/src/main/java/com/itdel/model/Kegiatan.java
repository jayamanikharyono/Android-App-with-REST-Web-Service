package com.itdel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Kegiatan 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String namaKegiatan;
	private String deskripsiKegiatan;
	
	public Kegiatan()
	{
		
	}
	
	public Kegiatan(int id, String namaKegiatan, String deskripsiKegiatan) {
		super();
		this.id = id;
		this.namaKegiatan = namaKegiatan;
		this.deskripsiKegiatan = deskripsiKegiatan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamaKegiatan() {
		return namaKegiatan;
	}

	public void setNamaKegiatan(String namaKegiatan) {
		this.namaKegiatan = namaKegiatan;
	}

	public String getDeskripsiKegiatan() {
		return deskripsiKegiatan;
	}

	public void setDeskripsiKegiatan(String deskripsiKegiatan) {
		this.deskripsiKegiatan = deskripsiKegiatan;
	}
	
	
}
