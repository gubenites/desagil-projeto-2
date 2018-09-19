package br.pro.hashi.ensino.desagil.rafaelogic.model;

public class XorGate extends Gate {
private NandGate XorGate_x;
private NandGate XorGate_y;
private NandGate XorGate_z;
private NandGate XorGate_w;

	public XorGate() {
		super(2,"XorGate");
		XorGate_x = new NandGate();
		XorGate_y = new NandGate();
		XorGate_z = new NandGate();
		XorGate_w = new NandGate();
		
		
	}
	@Override
	public boolean read() {
		return XorGate_w.read();
	}
	@Override
	public void connect(int pinIndex, Emitter emitter) {
		XorGate_w.connect(0, XorGate_y);
		XorGate_w.connect(1, XorGate_z);
		if (pinIndex == 0) {
			XorGate_z.connect(pinIndex, emitter);
			XorGate_z.connect(1, XorGate_x);
		}
		if (pinIndex == 1) {
			XorGate_y.connect(pinIndex, emitter);
			XorGate_y.connect(0, XorGate_x);

		}			
		XorGate_x.connect(pinIndex, emitter);
	}
}
