import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
@SuppressWarnings("serial")
public class baseOPadministrador extends JFrame implements ActionListener
{
	JLabel panel;
	JButton BbaseDOC, BbaseALU, BbaseLIB;
	
	ImageIcon imgFondo = new ImageIcon(getClass().getResource("/imagenes/1280720_baseOPadministrador.png"));
	
	public baseOPadministrador()
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
		
		todo.claseBatras();
		todo.Batras.addActionListener(this);
		panel.add(todo.Batras);
		
		//Botones-------------------------------------------------------------------------------------
		BbaseDOC = new JButton(""); //BASE DE DATOS - DOCENTES
		BbaseDOC.setBounds(165, 180, 165, 165);
		BbaseDOC.setContentAreaFilled(false);
		BbaseDOC.setVisible(true);
		BbaseDOC.setBorder(null);
		BbaseDOC.addActionListener(this);
		panel.add(BbaseDOC);
		
		BbaseALU = new JButton(""); //BASE DE DATOS - ALUMNOS
		BbaseALU.setBounds(435, 180, 165, 165);
		BbaseALU.setContentAreaFilled(false);
		BbaseALU.setVisible(true);
		BbaseALU.setBorder(null);
		BbaseALU.addActionListener(this);
		panel.add(BbaseALU);
		
		BbaseLIB = new JButton(""); //BASE DE DATOS - LIBROS
		BbaseLIB.setBounds(705, 180, 165, 165);
		BbaseLIB.setContentAreaFilled(false);
		BbaseLIB.setVisible(true);
		BbaseLIB.setBorder(null);
		BbaseLIB.addActionListener(this);
		panel.add(BbaseLIB);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == BbaseDOC)
		{
			baseDOC_OPbase clase = new baseDOC_OPbase();
			clase.setBounds(0,0,1040, 585);
			clase.setUndecorated(true);
			clase.setVisible(true);
			clase.setResizable(false);
			clase.setLocationRelativeTo(null);
			dispose();
		}
		if(e.getSource() == BbaseALU)
		{
			baseALU_OPbase clase = new baseALU_OPbase();
			clase.setBounds(0,0,1040, 585);
			clase.setUndecorated(true);
			clase.setVisible(true);
			clase.setResizable(false);
			clase.setLocationRelativeTo(null);
			dispose();
		}
		if(e.getSource() == BbaseLIB)
		{
			baseLIB_OPbase clase = new baseLIB_OPbase();
			clase.setBounds(0,0,1040, 585);
			clase.setUndecorated(true);
			clase.setVisible(true);
			clase.setResizable(false);
			clase.setLocationRelativeTo(null);
			dispose();
		}
		if(e.getSource() == todo.Batras)
		{
			todo.claseFuncionBadministrador();
			dispose();
		}
		if(e.getSource() == todo.Bclub)
		{
			todo.conclusion();
		}
	}
	public static void main(String[] args)
	{
		baseOPadministrador clase = new baseOPadministrador();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
}
