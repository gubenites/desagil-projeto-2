package br.pro.hashi.ensino.desagil.rafaelogic.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;

import br.pro.hashi.ensino.desagil.rafaelogic.model.Gate;
import br.pro.hashi.ensino.desagil.rafaelogic.model.Source;
import br.pro.hashi.ensino.desagil.rafaelogic.view.SimplePanel;

public class GateView extends SimplePanel implements ActionListener, MouseListener {
	private static final long serialVersionUID = 1L;
	
	private Gate gate;
	private JCheckBox input_0;
	private JCheckBox input_1;
	private JCheckBox output_0;
	private Source source; 
	private Source source1; 
	
	// Estes nomes aqui são auto-explicativos, não?
	private Color color;
	private Image image;

	private boolean output0;
	public GateView(Gate gate) {
		super(245,300);
		
		this.gate = gate;
		
		input_0 = new JCheckBox();
		input_1 = new JCheckBox();
		output_0 = new JCheckBox();
		
		source = new Source();
		source1 = new Source();
		
		JLabel input_0Label = new JLabel("input_0");
		JLabel input_1Label = new JLabel("input_1");
		JLabel output_0Label = new JLabel("output_0");

		if (gate.size >= 2) {
			
			add(input_0, 10, 95, 20, 25);
			
			add(input_1, 10, 180, 20, 25);
			
	
		}
		else {
			
			add(input_1, 10, 140, 20, 25);
			


		}

		
		input_0.addActionListener(this);
		input_1.addActionListener(this);
		
		output_0.setEnabled(false);
		
		update();

		// Inicializamos esse atributo com o preto.
		color = Color.BLACK;

		// Usamos isso no Projeto 1, vocês lembram?
		String path = "/" + gate.toString() + ".png";
		URL url = getClass().getResource(path);
		image = new ImageIcon(url).getImage();

		// Toda componente Swing possui este método, que
		// permite adicionar objetos que reagem a eventos
		// de mouse que acontecem nela. Ou seja, ao passar
		// this como parâmetro, estamos pedindo para a
		// componente reagir aos próprios eventos de mouse.
		
		addMouseListener(this);
	}
	private void update() {
		boolean input0,input1;
		
		input0 = input_0.isSelected();
		input1 = input_1.isSelected();	
		
		source.turn(input0);
		source1.turn(input1);
		
		gate.connect(0, source);
		gate.connect(1, source1);
		
		output0 = gate.read();
		
		repaint();
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		update();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
			// Descobre em qual posição o clique ocorreu.
			int x = arg0.getX();
			int y = arg0.getY();
			
			int conta_x = x - 210;
			int conta_y = y - 150;
			
			double distancia = Math.sqrt((Math.pow(conta_x,2)+Math.pow(conta_y, 2)));
			
			// Se o clique foi dentro do retângulo colorido...
			if(distancia <= 10 ) {

				// ...então abrimos o seletor de cor...
				color = JColorChooser.showDialog(this, null, color);

				// ...e atualizamos a tela.
				repaint();
			}
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
	@Override
	public void paintComponent(Graphics g) {

		// Não podemos esquecer desta linha, pois não somos os
		// únicos responsáveis por desenhar o painel, como era
		// o caso no Projeto 1. Agora é preciso desenhar também
		// componentes internas, e isso é feito pela superclasse.
		super.paintComponent(g);

		// Desenha a imagem passando posição e tamanho.
		// O último parâmetro pode ser sempre null.
		g.drawImage(image, 10, 50, 230, 200, null);

		// Desenha um retângulo cheio.
		g.setColor(color);
		
		if(output0 == true) {
			g.fillOval(200,140,20,20);
			
		}
		else {
			g.drawOval(200, 140, 20, 20);
		}
        
		// Evita bugs visuais em alguns sistemas operacionais.
		getToolkit().sync();
    }
	
}
