package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.view.SimplePanel;

public class GateView extends SimplePanel implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	
	private Gate gate;
	private JCheckBox input_0;
	private JCheckBox input_1;
	private JCheckBox output_0;
	
	public GateView(Gate gate) {
		super(245,300);
		
		this.gate = gate;
		
		input_0 = new JCheckBox();
		input_1 = new JCheckBox();
		output_0 = new JCheckBox();
		
		JLabel input_0Label = new JLabel("input_0");
		JLabel input_1Label = new JLabel("input_1");
		JLabel output_0Label = new JLabel("output_0");

		add(input_0Label, 10, 10, 75, 25);
		add(input_0, 85, 10, 150, 25);
		add(input_1Label, 10, 45, 75, 25);
		add(input_1, 85, 45, 150, 25);
		add(output_0Label, 10, 265, 150, 25);
		add(output_0, 85, 265, 150, 25);
		
		input_0.addActionListener(this);
		input_1.addActionListener(this);
		
		output_0.setEnabled(false);
		
		update();
		
		addMouseListener(this);
	}
	private void update() {
		boolean input0,input1;
		
		input0 = input_0.isSelected();
		input1 = input_1.isSelected();	
		
		boolean output0 = gate.read(input0,input1);
		
		if (output0) {
			output_0.setSelected(true);
		}
		else {
			output_0.setSelected(false);
		}
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
