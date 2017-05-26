package com.itdel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itdel.model.Fasilitas;
import com.itdel.repository.FasilitasRepository;

@Service
public class FasilitasServiceImpl implements FasilitasService {

	@Autowired
	FasilitasRepository fasilitasRepository;
	
	@Override
	public void save(Fasilitas fasilitas) {
		fasilitasRepository.save(fasilitas);

	}

	@Override
	public ArrayList<Fasilitas> findAllFasilitas() {
		// TODO Auto-generated method stub
		return (ArrayList<Fasilitas>) fasilitasRepository.findAll();
	}

	@Override
	public Fasilitas findById(int idFasilitas) {
		// TODO Auto-generated method stub
		return fasilitasRepository.findOne(idFasilitas);
	}

	@Override
	public Fasilitas edit(Fasilitas fasilitas) {
		// TODO Auto-generated method stub
		return fasilitasRepository.save(fasilitas);
	}

	@Override
	public void deleteById(int idFasilitas) {
		// TODO Auto-generated method stub
		fasilitasRepository.delete(idFasilitas);
	}

	@Override
	public Fasilitas findByName(String name) {
		List<Fasilitas> listFasilitas =  fasilitasRepository.findAll();
		for(Fasilitas fasilitas: listFasilitas)
		{
			if(fasilitas.getNamaFasilitas().equalsIgnoreCase(name))
				return fasilitas;
		}
		return null;
	}
}
