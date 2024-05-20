import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Date;
import java.text.SimpleDateFormat;

@SuppressWarnings("serial")
public class OPvisitas extends JFrame implements ActionListener
{
	JTextField nombre;
	String hora;
	JLabel panel;
	JButton agg, eliminar, modificar;
	JComboBox<String> rol;
	JPanel ventana;
	JTable tabla;
	JTableHeader Tcabezera;
	DefaultTableModel modelo = new DefaultTableModel();
			
	String[] cabecera = {"NOMBRE", "ROL", "HORA"};
	
	ImageIcon imgFondo = new ImageIcon(getClass().getResource("/imagenes/1280720_OPvisitas.png"));
	
	public OPvisitas()
	{
		setLayout(null);
		
		//fondo panel----------------------------------------------------------------------------------------
		panel = new JLabel();
		panel.setIcon(new ImageIcon(imgFondo.getImage().getScaledInstance(1040, 585, Image.SCALE_SMOOTH)));
		panel.setBounds(0, 0, 1040, 585);
		add(panel);
		
		//tabla----------------------------------------------------------------------------------------------
		ventana = new JPanel(new BorderLayout());
		ventana.setBounds(120, 180, 800, 300);
		ventana.setBackground(Color.white);
		ventana.setPreferredSize(new Dimension(800, 300));
		Color borderColor = Color.decode("#001655");
		ventana.setBorder(new LineBorder(borderColor, 4));

		modelo = new DefaultTableModel()
        {
            public boolean isCellEditable(int row, int column)
            {
            	//no se pueda editar las 3 columnas
                return column >= 3;
            }
        };
		modelo.setColumnIdentifiers(cabecera);
		tabla = new JTable(modelo);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabla.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        
		//personalizar cabecera de la tabla
		JTableHeader Tcabecera = tabla.getTableHeader();
		Tcabecera.setBackground(todo.color1);
		Tcabecera.setForeground(Color.white);
		tabla.getTableHeader().setPreferredSize(new Dimension(tabla.getTableHeader().getWidth(), 45));
		Tcabecera.setFont(todo.estilo_tabCabecera);
		
		tabla.setFont(todo.estilo_tabContenido);
		
        //medidas de las columnas de la tabla
        tabla.getColumn("NOMBRE").setPreferredWidth(400);
        tabla.getColumn("ROL").setPreferredWidth(200);
        tabla.getColumn("HORA").setPreferredWidth(200);
        tabla.setRowHeight(35);
        
        tabla.getTableHeader().setResizingAllowed(false);//no se pueda cambiar la medida de la tabla
        tabla.getTableHeader().setReorderingAllowed(false);//no se pueda reordenar las columnas
        
		ventana.add(new JScrollPane(tabla), BorderLayout.CENTER);
		ventana.setVisible(true);
		panel.add(ventana);
		
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener()
		{
            public void valueChanged(ListSelectionEvent e)
            {
            	int selectedRow = tabla.getSelectedRow();
            	if (selectedRow >= 0)
            	{
            		Object nom = tabla.getValueAt(selectedRow, 0);
	                Object roo = tabla.getValueAt(selectedRow, 1);
	                Object hor = tabla.getValueAt(selectedRow, 2);
	                nombre.setText(nom.toString());
	                rol.setSelectedItem(roo);
	                hora = hor.toString();//variable con la hora para que la guardes en la base de datos (si es que lo necesitas)
            	}
            }
        });
		
		//botones desde clase todo---------------------------------------------------------------------------
		todo.claseBclub();
		todo.Bclub.addActionListener(this);
		panel.add(todo.Bclub);
		
		todo.claseBinicio();
		todo.Binicio.addActionListener(this);
		panel.add(todo.Binicio);
		
		//botones-----------------------------------------------------------------------------------------
		agg = new JButton("");
		agg.setBounds(959, 172, 55, 55);
		agg.setContentAreaFilled(false);
		agg.setVisible(true);
		agg.setBorder(null);
		agg.addActionListener(this);
		panel.add(agg);
		
		modificar = new JButton("");
		modificar.setBounds(959, 256, 55, 55);
		modificar.setContentAreaFilled(false);
		modificar.setVisible(true);
		modificar.setBorder(null);
		modificar.addActionListener(this);
		panel.add(modificar);
		
		eliminar = new JButton("");
		eliminar.setBounds(959, 340, 55, 55);
		eliminar.setContentAreaFilled(false);
		eliminar.setVisible(true);
		eliminar.setBorder(null);
		eliminar.addActionListener(this);
		panel.add(eliminar);
		
		//textfield----------------------------------------------------------------------------------------
		nombre = new JTextField();
		nombre.setBounds(145, 523, 335, 30);
		nombre.setVisible(true);
		nombre.setBorder(null);
		nombre.setBackground(Color.white);
		nombre.setForeground(Color.gray);
		nombre.setFont(todo.estilo_base);
		panel.add(nombre);
		
		rol = new JComboBox<String>();
		rol.setBounds(510, 520, 225, 39);
		rol.setVisible(true);
		rol.setBorder(new LineBorder(todo.color2, 3));
		rol.setBackground(Color.white);
		rol.setForeground(Color.gray);
		rol.setFont(todo.estilo_base); 
		panel.add(rol);
		rol.addItem("SELECCIONAR");
		rol.addItem("ALUMNO");
		rol.addItem("DOCENTE");
	}
	void hora()
	{
        Date fechaHoraActual = new Date();
        SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm"); //hora 12 hrs, minutos
        hora = formatoHora.format(fechaHoraActual);
	}
	void agregar()
	{
		hora();
		modelo.addRow(new Object[]
				{
						nombre.getText().toUpperCase(),
						rol.getSelectedItem(),
						hora
				});
	}
	void eliminar()
	{
		int fila = tabla.getSelectedRow();
		if(fila == -1)
		{
	        JOptionPane.showMessageDialog(null, "AÚN NO SE HA SELECCIONADO ALGUNA FILA...          ", "ERROR...", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		modelo.removeRow(fila);
	}
	void modificar()
	{
		hora();
		int fila = tabla.getSelectedRow();
		modelo.setValueAt(nombre.getText(), fila, 0);
		modelo.setValueAt(rol.getSelectedItem(), fila, 1);
		modelo.setValueAt(hora, fila, 2);
	}
	void vaciar()
	{
		nombre.setText("");
		rol.setSelectedItem("SELECCIONAR");
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == agg)
		{
			String selectedOption = (String) rol.getSelectedItem();
            if(selectedOption.equals("SELECCIONAR"))
            {
				JOptionPane.showMessageDialog(null, "SELECCIONE UN ROL...          ", "ERROR...",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                agregar();
                vaciar();
            }
		}
		if(e.getSource() == modificar)
		{
			int fila = tabla.getSelectedRow();
			if(fila == -1)
			{
		        JOptionPane.showMessageDialog(null, "AÚN NO SE HA SELECCIONADO ALGUNA FILA...          ", "ERROR...", JOptionPane.ERROR_MESSAGE);
		        return;
		    }
			else
			{
				String selectedOption = (String) rol.getSelectedItem();
	            if(selectedOption.equals("SELECCIONAR"))
	            {
					JOptionPane.showMessageDialog(null, "SELECCIONE UN ROL...          ", "ERROR...",JOptionPane.ERROR_MESSAGE);
	            }
	            else
	            {
	            	modificar();
	                vaciar();
	            }
			}
		}
		if(e.getSource() == eliminar)
		{
			vaciar();
			eliminar();
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
		OPvisitas clase = new OPvisitas();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
}
