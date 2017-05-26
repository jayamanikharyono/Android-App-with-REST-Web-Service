package com.itdel.repository;

import org.springframework.stereotype.Repository;
import com.itdel.model.Fasilitas;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface FasilitasRepository extends JpaRepository<Fasilitas, Serializable>
{
	
}
