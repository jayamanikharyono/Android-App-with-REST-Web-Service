package com.itdel.repository;

import com.itdel.model.Kegiatan;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface KegiatanRepository extends JpaRepository<Kegiatan, Serializable>
{
	
}
