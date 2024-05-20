import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
@SuppressWarnings("serial")
public class OPlibros extends JFrame implements ActionListener
{
	JLabel panel;
	JButton Btabla, Bdevoluciones;
	
	ImageIcon imgFondo = new ImageIcon(getClass().getResource("/imagenes/1280720_OPlibros.png"));
	
	public OPlibros()
	{
		setLayout(null);
		
		//fondo panel----------------------------------------------------------------------------------------
		panel = new JLabel();
		panel.setIcon(new ImageIcon(imgFondo.getImage().getScaledInstance(1040, 585, Image.SCALE_SMOOTH)));
		panel.setBounds(0, 0, 1040, 585);
		add(panel);
		
		//botones desde clase todo---------------------------------------------------------------------------
		todo.claseBclub();
		todo.Bclub.addActionListener(this);
		panel.add(todo.Bclub);
		
		todo.claseBinicio();
		todo.Binicio.addActionListener(this);
		panel.add(todo.Binicio);
		
		//Botones-------------------------------------------------------------------------------------
		Btabla = new JButton(""); //TABLA
		Btabla.setBounds(275, 180, 165, 165);
		Btabla.setContentAreaFilled(false);
		Btabla.setVisible(true);
		Btabla.setBorder(null);
		Btabla.addActionListener(this);
		panel.add(Btabla);
		
		Bdevoluciones = new JButton(""); //DEVOLUCIONES
		Bdevoluciones.setBounds(600, 180, 165, 165);
		Bdevoluciones.setContentAreaFilled(false);
		Bdevoluciones.setVisible(true);
		Bdevoluciones.setBorder(null);
		Bdevoluciones.addActionListener(this);
		panel.add(Bdevoluciones);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == Btabla)
		{
			tablaOPlibros clase = new tablaOPlibros();
			clase.setBounds(0,0,1040, 585);
			clase.setUndecorated(true);
			clase.setVisible(true);
			clase.setResizable(false);
			clase.setLocationRelativeTo(null);
			dispose();
		}
		if(e.getSource() == Bdevoluciones)
		{
			devOPlibros clase = new devOPlibros();
			clase.setBounds(0,0,1040, 585);
			clase.setUndecorated(true);
			clase.setVisible(true);
			clase.setResizable(false);
			clase.setLocationRelativeTo(null);
			dispose();
		}
		if(e.getSource() == todo.Binicio)
		{
			todo.claseFuncionBinicio();
			dispose();
		}
		if(e.getSource() == todo.Bclub)
		{
			todo.conclusion();
		}
	}
	public static void main(String[] args)
	{
		OPlibros clase = new OPlibros();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
}
