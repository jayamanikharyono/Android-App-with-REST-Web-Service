package com.itdel.service;

import java.util.ArrayList;
import java.util.List;

import com.itdel.model.Fasilitas;

public interface FasilitasService 
{
	public void save(Fasilitas fasilitas);
	public ArrayList<Fasilitas> findAllFasilitas();
	Fasilitas findById(int idFasilitas);
	Fasilitas edit(Fasilitas fasilitas);
	void deleteById(int idFasilitas);
	Fasilitas findByName(String name);
}
