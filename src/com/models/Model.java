package com.models;

public class Model {
	Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	/**
	 * 2 models sont égaux s'ils ont le meme id
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj==null){
			return false;
		}
		Model vol2 =(Model) obj;
		return id.equals(vol2.getId());
	}
	

}
