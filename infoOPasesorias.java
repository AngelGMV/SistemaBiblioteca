import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.*;
@SuppressWarnings("serial")
public class infoOPasesorias extends JFrame implements ActionListener, KeyListener
{
	JLabel panel;
	JButton guardar;
	JTextField noControl, noPre;
	JComboBox<String> cubiculo;
	
	ImageIcon imgFondo = new ImageIcon(getClass().getResource("/imagenes/1280720_infoOPasesorias.png"));
	
	public infoOPasesorias()
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
		todo.infoAsesorias();
		
		todo.alumno.addActionListener(this);
		panel.add(todo.alumno);
		
		noControl = new JTextField();
		noControl.setBounds(145, 290, 280, 28);
		noControl.setVisible(true);
		noControl.setBorder(null);
		noControl.setBackground(Color.white);
		noControl.setForeground(Color.gray);
		noControl.setFont(todo.estilo_recibos);
		noControl.addKeyListener(this);
		panel.add(noControl);
		
		todo.AgradoGrupo.addActionListener(this);
		panel.add(todo.AgradoGrupo);
		
		todo.docente.addActionListener(this);
		todo.docente.setText(OPasesorias.docente);
		panel.add(todo.docente);
		
		todo.fecha.addActionListener(this);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaActual = sdf.format(new Date());
        todo.fecha.setText(fechaActual);
		panel.add(todo.fecha);
		
		cubiculo = new JComboBox<String>();
		cubiculo.setBounds(600, 445, 311, 39);
		cubiculo.setVisible(true);
		cubiculo.setBorder(new LineBorder(todo.color2, 3));
		cubiculo.setBackground(Color.white);
		cubiculo.setForeground(Color.gray);
		cubiculo.setFont(todo.estilo_recibos); 
		panel.add(cubiculo);
		cubiculo.addItem("SELECCIONAR");
		cubiculo.addItem("CUBÍCULO 1");
		cubiculo.addItem("CUBÍCULO 2");
		cubiculo.addItem("CUBÍCULO 3");
		cubiculo.addItem("CUBÍCULO 4");
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
			//todo.enviarCorreoAsesorias();
			String selectedCubicle = (String) cubiculo.getSelectedItem();
            if(selectedCubicle.equals("SELECCIONAR"))
            {
            	JOptionPane.showMessageDialog(null, "SELECCIONE EL CUBÍCULO...          ", "ERROR",JOptionPane.ERROR_MESSAGE);
            }
		}
		if(e.getSource() == todo.Batras)
		{
			OPasesorias clase = new OPasesorias();
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
		infoOPasesorias clase = new infoOPasesorias();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
}
