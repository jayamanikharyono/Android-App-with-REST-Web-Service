package com.itdel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itdel.model.Fasilitas;
import com.itdel.model.Kegiatan;
import com.itdel.repository.KegiatanRepository;

@Service
public class KegiatanServiceImpl implements KegiatanService {

	@Autowired
	KegiatanRepository kegiatanRepository;
	
	@Override
	public void save(Kegiatan kegiatan) {
		kegiatanRepository.save(kegiatan);

	}

	@Override
	public ArrayList<Kegiatan> findAllKegiatan() {
		// TODO Auto-generated method stub
		return (ArrayList<Kegiatan>) kegiatanRepository.findAll();
	}

	@Override
	public Kegiatan findById(int idKegiatan) {
		// TODO Auto-generated method stub
		return kegiatanRepository.findOne(idKegiatan);
	}

	@Override
	public Kegiatan edit(Kegiatan kegiatan) {
		// TODO Auto-generated method stub
		return kegiatanRepository.save(kegiatan);
	}

	@Override
	public void deleteById(int idKegiatan) {
		// TODO Auto-generated method stub
		kegiatanRepository.delete(idKegiatan);
	}

	@Override
	public Kegiatan findByName(String name) {
		List<Kegiatan> listKegiatan =  kegiatanRepository.findAll();
		for(Kegiatan kegiatan: listKegiatan)
		{
			if(kegiatan.getNamaKegiatan().equalsIgnoreCase(name))
				return kegiatan;
		}
		return null;
	}

}
