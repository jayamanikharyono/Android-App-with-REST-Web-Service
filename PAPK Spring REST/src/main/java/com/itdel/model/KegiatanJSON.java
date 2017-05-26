package com.itdel.model;

import java.util.ArrayList;

public class KegiatanJSON 
{
	private ArrayList<Kegiatan> listKegiatan = new ArrayList<>();

	public ArrayList<Kegiatan> getListKegiatan() {
		return (ArrayList<Kegiatan>) listKegiatan;
	}
	public void setListKegiatan(ArrayList<Kegiatan> listKegiatan) {
		this.listKegiatan = listKegiatan;
	}
	
	public void addKegiatan(Kegiatan kegiatan)
	{
		listKegiatan.add(kegiatan);
	}
}
