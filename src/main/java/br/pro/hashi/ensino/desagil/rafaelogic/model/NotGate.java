package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class NotGate extends Gate {
	private NandGate notGate_x;
	
	public NotGate() {
		super(2);
		notGate_x = new NandGate();
		name = "NotGate";
		
	
	}
	@Override
	public boolean read() {
		// TODO Auto-generated method stub
		return notGate_x.read();
	}


	@Override
	public void connect(int pinIndex, Emitter emitter) {
		// TODO Auto-generated method stub	
		notGate_x.connect(0, emitter);
		notGate_x.connect(1, emitter);
	}
}
