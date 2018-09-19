package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class AndGate extends Gate {
private NandGate AndGate_x;
private NandGate AndGate_y;

	public AndGate() {
		super(2,"AndGate");
		AndGate_x = new NandGate();
		AndGate_y = new NandGate();
		}
	@Override
	public boolean read() {
		return AndGate_y.read();
	}
	@Override
	public void connect(int pinIndex, Emitter emitter) {	
		AndGate_x.connect(pinIndex, emitter);
		AndGate_y.connect(0, AndGate_x);
		AndGate_y.connect(1, AndGate_x);
	}
}

