package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class OrGate extends Gate {
	private NandGate orGate_x;
	private NandGate orGate_y;
	private NandGate orGate_z;
	
	
	public OrGate() {
		super(2,"OrGate");
		orGate_x = new NandGate();
		orGate_y = new NandGate();
		orGate_z = new NandGate();
		
		
	}
	@Override
	public boolean read() {
		return orGate_z.read();
	}
	@Override
	public void connect(int pinIndex, Emitter emitter) {
		if (pinIndex == 1) {
			orGate_x.connect(pinIndex, emitter);
			orGate_x.connect(0, emitter);
			orGate_z.connect(pinIndex, orGate_x);
		}
		if (pinIndex == 0) {
			orGate_y.connect(pinIndex, emitter);
			orGate_y.connect(1, emitter);
			orGate_z.connect(pinIndex, orGate_y);
		}
	}
	
}

