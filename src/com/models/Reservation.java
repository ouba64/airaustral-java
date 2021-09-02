package com.models;

public class Reservation extends Model {

	protected User client;
	Vol vol;

	public Reservation() {

	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

}
