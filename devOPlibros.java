import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
@SuppressWarnings("serial")
public class devOPlibros extends JFrame implements ActionListener, KeyListener
{
	JLabel panel;
	JButton guardar;
	JTextField noControl, noPre;
	
	ImageIcon imgFondo = new ImageIcon(getClass().getResource("/imagenes/1280720_devOPlibros.png"));
	
	public devOPlibros()
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
		
		//boton--------------------------------------------------------------------------------------------
		guardar = new JButton(""); //TABLA
		guardar.setBounds(850, 507, 55, 55);
		guardar.setContentAreaFilled(false);
		guardar.setVisible(true);
		guardar.setBorder(null);
		guardar.addActionListener(this);
		panel.add(guardar);
		
		//textfield--------------------------------------------------------------------------------------------
		todo.preYdev();
		
		todo.nombre.addActionListener(this);
		panel.add(todo.nombre);
		
		noControl = new JTextField();
		noControl.setEditable(false);
		noControl.setBounds(145, 290, 280, 28);
		noControl.setVisible(true);
		noControl.setBorder(null);
		noControl.setBackground(Color.white);
		noControl.setForeground(Color.gray);
		noControl.setFont(todo.estilo_recibos);
		panel.add(noControl);
		
		todo.LgradoGrupo.addActionListener(this);
		panel.add(todo.LgradoGrupo);
		
		todo.libro.addActionListener(this);
		panel.add(todo.libro);
		
		todo.fPre.addActionListener(this);
		panel.add(todo.fPre);
		
		noPre = new JTextField();
		noPre.setBounds(615, 451, 280, 28);
		noPre.setVisible(true);
		noPre.setBorder(null);
		noPre.setBackground(Color.white);
		noPre.setForeground(Color.gray);
		noPre.setFont(todo.estilo_recibos);
		noPre.addKeyListener(this);
		panel.add(noPre);
		
		todo.fDev.addActionListener(this);
		panel.add(todo.fDev);
	}
	public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            String no = noPre.getText();
            JOptionPane.showMessageDialog(null, "Nombre: " + no);
        }
    }
    public void keyTyped(KeyEvent e)
    {
    	
    }
    public void keyReleased(KeyEvent e)
    {
    	
    }
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == guardar)
		{
			
		}
		if(e.getSource() == todo.Batras)
		{
			todo.claseFuncionBlibros();
			dispose();
		}
		if(e.getSource() == todo.Bclub)
		{
			todo.conclusion();
		}
	}
	public static void main(String[] args)
	{
		devOPlibros clase = new devOPlibros();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
}
