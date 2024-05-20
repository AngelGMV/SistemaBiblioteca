import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
@SuppressWarnings("serial")
public class preOPtabla extends JFrame implements ActionListener, KeyListener
{
	JLabel panel;
	JButton guardar;
	JTextField noControl, noPre;
	
	ImageIcon imgFondo = new ImageIcon(getClass().getResource("/imagenes/1280720_preOPtabla.png"));
	
	public preOPtabla()
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
		guardar = new JButton("");
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
		noControl.setBounds(145, 290, 280, 28);
		noControl.setVisible(true);
		noControl.setBorder(null);
		noControl.setBackground(Color.white);
		noControl.setForeground(Color.gray);
		noControl.setFont(todo.estilo_recibos);
		noControl.addKeyListener(this);
		panel.add(noControl);
		
		todo.LgradoGrupo.addActionListener(this);
		panel.add(todo.LgradoGrupo);
		
		todo.libro.addActionListener(this);
		panel.add(todo.libro);
		
		todo.fPre.addActionListener(this);
		panel.add(todo.fPre);
		
		noPre = new JTextField();
		noPre.setEditable(false);
		noPre.setBounds(615, 451, 280, 28);
		noPre.setVisible(true);
		noPre.setBorder(null);
		noPre.setBackground(Color.white);
		noPre.setForeground(Color.gray);
		noPre.setFont(todo.estilo_recibos);
		panel.add(noPre);
		
		todo.fDev.addActionListener(this);
		panel.add(todo.fDev);
	}
	public void keyPressed(KeyEvent e)
    {
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            String no = noControl.getText();
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
			todo.enviarCorreoLibros();
		}
		if(e.getSource() == todo.Batras)
		{
			tablaOPlibros clase = new tablaOPlibros();
			clase.setBounds(0,0,1040, 585);
			clase.setUndecorated(true);
			clase.setVisible(true);
			clase.setResizable(false);
			clase.setLocationRelativeTo(null);
			dispose();
		}
		if(e.getSource() == todo.Bclub)
		{
			todo.conclusion();
		}
	}
	public static void main(String[] args)
	{
		preOPtabla clase = new preOPtabla();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
}
