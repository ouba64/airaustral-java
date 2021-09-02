package com.views;

import javax.swing.JButton;

public class MonJButton<T> extends JButton {
	T object;

	/**
	 * Correspond à la position de l'objet (Vol) dans la liste ceci pour
	 * permettre de supprimer ou mettre à jour la ligne correspandante dans la
	 * table.
	 */
	int position;

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

}
