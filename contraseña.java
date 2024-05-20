import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
@SuppressWarnings("serial")
public class contraseña extends JFrame implements ActionListener
{
	String contra, usuar;
	JButton Bingresar;
	JTextField Tusuar;
	JPasswordField Tcontra;
	JLabel panel;
	
	ImageIcon imgFondo = new ImageIcon(getClass().getResource("/imagenes/1280720_contraseña.png"));
	
	public contraseña()
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
		Bingresar = new JButton("");
		Bingresar.setBounds(460, 430, 122, 54);
		Bingresar.setContentAreaFilled(false);
		Bingresar.setVisible(true);
		Bingresar.setBorder(null);
		Bingresar.addActionListener(this);
		panel.add(Bingresar);
		
		//textfield------------------------------------------------------------------------------------------
		Tusuar = new JTextField();
		Tusuar.setBounds(275, 225, 570, 56);
		Tusuar.setVisible(true);
		Tusuar.setBorder(null);
		Tusuar.setBackground(Color.white);
		Tusuar.setForeground(Color.gray);
		Tusuar.setFont(todo.estilo_iniciar);
		panel.add(Tusuar);
		
		Tcontra = new JPasswordField();
		Tcontra.setBounds(275, 313, 570, 56);
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
				usuar = Tusuar.getText();
				contra = new String(Tcontra.getPassword());
				if (usuar.equals("biblio") && contra.equals("123"))
				{
					JOptionPane.showMessageDialog(null, "INICIO DE SESIÓN CORRECTO...     ", "ENTRANDO...",JOptionPane.INFORMATION_MESSAGE);
					Tcontra.setText("");
					Tusuar.setText("");
					inicio clase = new inicio();
					clase.setBounds(0,0,1040, 585);
					clase.setUndecorated(true);
					clase.setVisible(true);
					clase.setResizable(false);
					clase.setLocationRelativeTo(null);
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "ERROR DE INICIO DE SESIÓN...     ", "ERROR...",JOptionPane.ERROR_MESSAGE);
					Tcontra.setText("");
					Tusuar.setText("");
					usuar = Tusuar.getText();
					contra = new String(Tcontra.getPassword());
					Tusuar.requestFocus();
				}
			} while(usuar.equals("biblio") != contra.equals("123"));
		}
		if(e.getSource() == todo.Bclub)
		{
			todo.conclusion();
		}
	}
	public static void main(String[] args)
	{
		contraseña clase = new contraseña();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
}
