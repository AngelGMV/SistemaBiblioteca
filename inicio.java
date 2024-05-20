import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Objects;

@SuppressWarnings("serial")
public class inicio extends JFrame implements ActionListener
{
	JLabel panel;
	JButton Bsalir, Badministrador, Blibros, Basesorias, Bvisitas;
	
	ImageIcon imgFondo = new ImageIcon(getClass().getResource("/imagenes/1280720_inicio.png"));
	
	public inicio()
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
		
		//Botones-------------------------------------------------------------------------------------
		Bsalir = new JButton(""); //SALIR
		Bsalir.setBounds(944, 488, 70, 70);
		Bsalir.setContentAreaFilled(false);
		Bsalir.setVisible(true);
		Bsalir.setBorder(null);
		Bsalir.addActionListener(this);
		panel.add(Bsalir);
		
		Badministrador = new JButton(""); //ADMINISTRADOR
		Badministrador.setBounds(250, 110, 165, 165);
		Badministrador.setContentAreaFilled(false);
		Badministrador.setVisible(true);
		Badministrador.setBorder(null);
		Badministrador.addActionListener(this);
		panel.add(Badministrador);
		
		Blibros = new JButton(""); //LIBROS
		Blibros.setBounds(623, 110, 165, 165);
		Blibros.setContentAreaFilled(false);
		Blibros.setVisible(true);
		Blibros.setBorder(null);
		Blibros.addActionListener(this);
		panel.add(Blibros);
		
		Basesorias = new JButton(""); //ASESORÍAS
		Basesorias.setBounds(250, 315, 165, 165);
		Basesorias.setContentAreaFilled(false);
		Basesorias.setVisible(true);
		Basesorias.setBorder(null);
		Basesorias.addActionListener(this);
		panel.add(Basesorias);
		
		Bvisitas = new JButton(""); //VISITAS
		Bvisitas.setBounds(623, 315, 165, 165);
		Bvisitas.setContentAreaFilled(false);
		Bvisitas.setVisible(true);
		Bvisitas.setBorder(null);
		Bvisitas.addActionListener(this);
		panel.add(Bvisitas);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == Badministrador)
		{
			contraOPadministrador clase = new contraOPadministrador();
			clase.setBounds(0,0,1040, 585);
			clase.setUndecorated(true);
			clase.setVisible(true);
			clase.setResizable(false);
			clase.setLocationRelativeTo(null);
			dispose();
		}
		if(e.getSource() == Blibros)
		{
			OPlibros clase = new OPlibros();
			clase.setBounds(0,0,1040, 585);
			clase.setUndecorated(true);
			clase.setVisible(true);
			clase.setResizable(false);
			clase.setLocationRelativeTo(null);
			dispose();
		}
		if(e.getSource() == Basesorias)
		{
			OPasesorias clase = new OPasesorias();
			clase.setBounds(0,0,1040, 585);
			clase.setUndecorated(true);
			clase.setVisible(true);
			clase.setResizable(false);
			clase.setLocationRelativeTo(null);
			dispose();
		}
		if(e.getSource() == Bvisitas)
		{
			OPvisitas clase = new OPvisitas();
			clase.setBounds(0,0,1040, 585);
			clase.setUndecorated(true);
			clase.setVisible(true);
			clase.setResizable(false);
			clase.setLocationRelativeTo(null);
			dispose();
		}
		if(e.getSource() == Bsalir)
		{
			int valor= JOptionPane.showConfirmDialog(this, "¿Estás seguro de cerrar la aplicación?", "¡ADVERTENCIA!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(valor== JOptionPane.YES_OPTION)
			{
				System.exit(0);
			}
		}
		if(e.getSource() == todo.Bclub)
		{
			todo.conclusion();
		}
	}
	public static void main(String[] args)
	{
		inicio clase = new inicio();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
}
