import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
@SuppressWarnings("serial")
public class baseALU_OPbase extends JFrame implements ActionListener
{
	JLabel panel;
	JButton Bagg, Beliminar;
	
	ImageIcon imgFondo = new ImageIcon(getClass().getResource("/imagenes/1280720_baseALU_OPbase.png"));
	
	public baseALU_OPbase()
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
		Bagg = new JButton(""); //AÑADIR
		Bagg.setBounds(275, 180, 165, 165);
		Bagg.setContentAreaFilled(false);
		Bagg.setVisible(true);
		Bagg.setBorder(null);
		Bagg.addActionListener(this);
		panel.add(Bagg);
		
		Beliminar = new JButton(""); //ELIMINAR
		Beliminar.setBounds(600, 180, 165, 165);
		Beliminar.setContentAreaFilled(false);
		Beliminar.setVisible(true);
		Beliminar.setBorder(null);
		Beliminar.addActionListener(this);
		panel.add(Beliminar);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == Bagg)
		{
			
		}
		if(e.getSource() == Beliminar)
		{
			
		}
		if(e.getSource() == todo.Batras)
		{
			todo.claseFuncionBbase();
			dispose();
		}
		if(e.getSource() == todo.Bclub)
		{
			todo.conclusion();
		}
	}
	public static void main(String[] args)
	{
		baseALU_OPbase clase = new baseALU_OPbase();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
}
