package com.itdel.model;

import java.util.ArrayList;

public class FasilitasJSON 
{
	private ArrayList<Fasilitas> listFasilitas =  new ArrayList<>();
	
	public ArrayList<Fasilitas> getListFasilitas() {
		return listFasilitas;
	}
	public void setListFasilitas(ArrayList<Fasilitas> listFasilitas) {
		this.listFasilitas = listFasilitas;
	} 
	
	public void addFasilitas(Fasilitas fasilitas)
	{
		listFasilitas.add(fasilitas);
	}
}
