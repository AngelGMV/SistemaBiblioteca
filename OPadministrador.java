import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
@SuppressWarnings("serial")
public class OPadministrador extends JFrame implements ActionListener
{
	JLabel panel;
	JButton Balumnos, Bbase, Bregistros;
	
	ImageIcon imgFondo = new ImageIcon(getClass().getResource("/imagenes/1280720_OPadministrador.png"));
	
	public OPadministrador()
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
		Balumnos = new JButton(""); //ALUMNOS
		Balumnos.setBounds(165, 180, 165, 165);
		Balumnos.setContentAreaFilled(false);
		Balumnos.setVisible(true);
		Balumnos.setBorder(null);
		Balumnos.addActionListener(this);
		panel.add(Balumnos);
		
		Bbase = new JButton(""); //BASE DE DATOS
		Bbase.setBounds(435, 180, 165, 165);
		Bbase.setContentAreaFilled(false);
		Bbase.setVisible(true);
		Bbase.setBorder(null);
		Bbase.addActionListener(this);
		panel.add(Bbase);
		
		Bregistros = new JButton(""); //REGISTROS
		Bregistros.setBounds(705, 180, 165, 165);
		Bregistros.setContentAreaFilled(false);
		Bregistros.setVisible(true);
		Bregistros.setBorder(null);
		Bregistros.addActionListener(this);
		panel.add(Bregistros);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == Balumnos)
		{
			alumnosOPadministrador clase = new alumnosOPadministrador();
			clase.setBounds(0,0,1040, 585);
			clase.setUndecorated(true);
			clase.setVisible(true);
			clase.setResizable(false);
			clase.setLocationRelativeTo(null);
			dispose();
		}
		if(e.getSource() == Bbase)
		{
			baseOPadministrador clase = new baseOPadministrador();
			clase.setBounds(0,0,1040, 585);
			clase.setUndecorated(true);
			clase.setVisible(true);
			clase.setResizable(false);
			clase.setLocationRelativeTo(null);
			dispose();
		}
		if(e.getSource() == Bregistros)
		{
			/*registrosOPadministrador clase = new registrosOPadministrador();
			clase.setBounds(0,0,1040, 585);
			clase.setUndecorated(true);
			clase.setVisible(true);
			clase.setResizable(false);
			clase.setLocationRelativeTo(null);
			dispose();*/
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
		OPadministrador clase = new OPadministrador();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
}
