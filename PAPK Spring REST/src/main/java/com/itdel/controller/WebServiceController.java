package com.itdel.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itdel.model.FasilitasJSON;
import com.itdel.model.KegiatanJSON;
import com.itdel.service.FasilitasService;
import com.itdel.service.KegiatanService;


@RestController
public class WebServiceController 
{
	@Autowired
	FasilitasService fasilitasService;
	@Autowired
	KegiatanService kegiatanService;
	
	@RequestMapping(value="/fasilitas/all/", method = RequestMethod.POST)
	public @ResponseBody FasilitasJSON allFasilitas()
	{
		FasilitasJSON fasilitas = new FasilitasJSON();
		fasilitas.setListFasilitas(fasilitasService.findAllFasilitas());
		return fasilitas;
	}
	@RequestMapping(value="/kegiatan/all/", method = RequestMethod.POST)
	public @ResponseBody KegiatanJSON allKegiatan()
	{
		KegiatanJSON kegiatan = new KegiatanJSON();
		kegiatan.setListKegiatan(kegiatanService.findAllKegiatan());
		return kegiatan;
	}
	@RequestMapping(value="/deskripsi/all", method = RequestMethod.POST)
	public @ResponseBody ArrayList<String> deskripsi()
	{
		ArrayList<String> listDeskripsi  = new ArrayList<>();
		listDeskripsi.add("Yayasan Del mulai aktif di kegiatan sosial kemasyarakatan jauh sebelum didirikannya PT Toba Sejahtera, perusahaan yang kemudian menjadi Yayasan Del sebagai tonggak tanggung jawab sosial perusahaan.");
        listDeskripsi.add("Tujuan awal Yayasan Del didirikan adalah untuk memberikan akses pendidikan berkualitas di daerah terpencil bagi siswa/i berprestasi dengan latar belakang ekonomi yang kurang menguntungkan, yaitu dengan mendirikan Politeknik Informatika Del dan SMA Unggul Del di Laguboti, Sumatera Utara serta Sekolah NOAH di Kalisari, Jakarta Timur.");
        listDeskripsi.add("Tidak hanya berkiprah di bidang pendidikan, Yayasan Del juga aktif bekerjasama dengan pemerintah daerah dan lembaga sosial yang ada di Indonesia untuk meningkatkan pelayanan serta memperluas cakrawala bidang pelayanan strategis lainnya.");
        listDeskripsi.add("Politeknik Informatika Del didirikan pada tahun 2001 dan bertujuan untuk menyediakan pendidikan tinggi berkualitas internasional, bagi siswa/i berpotensi, terutama dengan latar belakang ekonomi yang kurang menguntungkan, khususnya yang berasal dari Sumatera Utara.");
        listDeskripsi.add("Dengan lokasi di daerah tepian Danau Toba, berjarak sekitar 400 KM dari kota Medan, area IT Del diharapkan dapat memberikan suasana tenang dan kondusif dalam belajar, karena jauh dari kebisingan dan hiruk pikuk suasana perkotaan/perindustrian.");

		return listDeskripsi;
	}
}
