package com.sinauacademy.hackme.domain;

import java.util.Date;

public class Invoice {
	private String noFaktur;
	private Date tglFaktur;
	private String lastUser;
	private String dariKepada;
	private Date lastUpdate;
	private String keterangan;
	public String getNoFaktur() {
		return noFaktur;
	}
	public void setNoFaktur(String noFaktur) {
		this.noFaktur = noFaktur;
	}
	public Date getTglFaktur() {
		return tglFaktur;
	}
	public void setTglFaktur(Date tglFaktur) {
		this.tglFaktur = tglFaktur;
	}
	public String getLastUser() {
		return lastUser;
	}
	public void setLastUser(String lastUser) {
		this.lastUser = lastUser;
	}
	public String getDariKepada() {
		return dariKepada;
	}
	public void setDariKepada(String dariKepada) {
		this.dariKepada = dariKepada;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	
	
	
}
