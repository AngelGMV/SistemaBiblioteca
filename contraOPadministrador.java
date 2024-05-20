import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
@SuppressWarnings("serial")
public class contraOPadministrador extends JFrame implements ActionListener
{
	String contra;
	JButton Bingresar;
	JPasswordField Tcontra;
	JLabel panel;
	
	ImageIcon imgFondo = new ImageIcon(getClass().getResource("/imagenes/1280720_contraOPadministrador.png"));
	
	public contraOPadministrador()
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
		Bingresar = new JButton("");
		Bingresar.setBounds(460, 397, 122, 54);
		Bingresar.setContentAreaFilled(false);
		Bingresar.setVisible(true);
		Bingresar.setBorder(null);
		Bingresar.addActionListener(this);
		panel.add(Bingresar);
		
		//textfield------------------------------------------------------------------------------------------
		Tcontra = new JPasswordField();
		Tcontra.setBounds(275, 252, 570, 56);
		Tcontra.setVisible(true);
		Tcontra.setBorder(null);
		Tcontra.setBackground(Color.white);
		Tcontra.setForeground(Color.gray);
		Tcontra.setFont(todo.estilo_iniciar);
		panel.add(Tcontra);
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == Bingresar)
		{
			do
			{
				contra = new String(Tcontra.getPassword());
				if (contra.equals("123"))
				{
					JOptionPane.showMessageDialog(null, "     ACCESO PERMITIDO...", "ENTRANDO...",JOptionPane.INFORMATION_MESSAGE);
					Tcontra.setText("");
					OPadministrador clase = new OPadministrador();
					clase.setBounds(0,0,1040, 585);
					clase.setUndecorated(true);
					clase.setVisible(true);
					clase.setResizable(false);
					clase.setLocationRelativeTo(null);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "     ACCESO DENEGADO...", "ERROR...",JOptionPane.ERROR_MESSAGE);
					Tcontra.setText("");
					contra = new String(Tcontra.getPassword());
					Tcontra.requestFocus();
				}
			} while(contra.equals("123") != contra.equals("123"));
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
		contraOPadministrador clase = new contraOPadministrador();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
}
