package br.pro.hashi.ensino.desagil.rafaelogic.model;

public abstract class Gate implements Emitter, Receiver {
	public int size;
	protected String name;
	
	
	protected Gate(int size) {
		this.size = size;
	}
	public int getSize() {
		return size;
	}
}

