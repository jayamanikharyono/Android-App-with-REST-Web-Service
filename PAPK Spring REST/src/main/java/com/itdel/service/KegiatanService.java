package com.itdel.service;

import java.util.ArrayList;

import com.itdel.model.Kegiatan;

public interface KegiatanService 
{
	public void save(Kegiatan kegiatan);
	public ArrayList<Kegiatan> findAllKegiatan();
	Kegiatan findById(int idKegiatan);
	Kegiatan edit(Kegiatan kegiatan);
	void deleteById(int idKegiatan);
	Kegiatan findByName(String name);

}
