import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
@SuppressWarnings("serial")
public class baseDOC_OPbase extends JFrame implements ActionListener
{
	JTextField buscador, rfc, correo, docente;
	JLabel panel;
	JButton agg, eliminar, modificar;
	JComboBox<String> genero;
	JPanel ventana;
	JTable tabla;
	JTableHeader Tcabezera;
	DefaultTableModel modelo = new DefaultTableModel();
			
	String[] cabecera = {"RFC", "DOCENTE", "CORREO", "GÉNERO"};
	
	ImageIcon imgFondo = new ImageIcon(getClass().getResource("/imagenes/1280720_baseDOC_OPbase.png"));
	
	public baseDOC_OPbase()
	{
		setLayout(null);
		
		//fondo panel----------------------------------------------------------------------------------------
		panel = new JLabel();
		panel.setIcon(new ImageIcon(imgFondo.getImage().getScaledInstance(1040, 585, Image.SCALE_SMOOTH)));
		panel.setBounds(0, 0, 1040, 585);
		add(panel);
		
		//tabla----------------------------------------------------------------------------------------------
		ventana = new JPanel(new BorderLayout());
		ventana.setBounds(120, 255, 800, 160);
		ventana.setBackground(Color.white);
		ventana.setPreferredSize(new Dimension(800, 160));
		Color borderColor = Color.decode("#001655");
		ventana.setBorder(new LineBorder(borderColor, 4));

		modelo = new DefaultTableModel()
        {
            public boolean isCellEditable(int row, int column)
            {
            	//no se pueda editar las 4 columnas
                return column >= 4;
            }
        };
		modelo.setColumnIdentifiers(cabecera);
		tabla = new JTable(modelo);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tabla.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        
		//personalizar cabecera de la tabla
		JTableHeader Tcabecera = tabla.getTableHeader();
		Tcabecera.setBackground(todo.color1);
		Tcabecera.setForeground(Color.white);
		tabla.getTableHeader().setPreferredSize(new Dimension(tabla.getTableHeader().getWidth(), 45));
		Tcabecera.setFont(todo.estilo_tabCabecera);
		
		tabla.setFont(todo.estilo_tabContenido);
		
        //medidas de las columnas de la tabla
        tabla.getColumn("RFC").setPreferredWidth(180);
        tabla.getColumn("DOCENTE").setPreferredWidth(300);
        tabla.getColumn("CORREO").setPreferredWidth(210);
        tabla.getColumn("GÉNERO").setPreferredWidth(110);
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
            		Object cod = tabla.getValueAt(selectedRow, 0);
	                Object doc = tabla.getValueAt(selectedRow, 1);
	                Object cor = tabla.getValueAt(selectedRow, 2);
	                Object gen = tabla.getValueAt(selectedRow, 3);
	                rfc.setText(cod.toString());
	                docente.setText(doc.toString());
	                correo.setText(cor.toString());
	                genero.setSelectedItem(gen);
            	}
            }
        });
		
		//botones desde clase todo---------------------------------------------------------------------------
		todo.claseBclub();
		todo.Bclub.addActionListener(this);
		panel.add(todo.Bclub);
		
		todo.claseBatras();
		todo.Batras.addActionListener(this);
		panel.add(todo.Batras);
		
		//botones-----------------------------------------------------------------------------------------
		agg = new JButton("");
		agg.setBounds(959, 340, 55, 55);
		agg.setContentAreaFilled(false);
		agg.setVisible(true);
		agg.setBorder(null);
		agg.addActionListener(this);
		panel.add(agg);
		
		modificar = new JButton("");
		modificar.setBounds(959, 422, 55, 55);
		modificar.setContentAreaFilled(false);
		modificar.setVisible(true);
		modificar.setBorder(null);
		modificar.addActionListener(this);
		panel.add(modificar);
		
		eliminar = new JButton("");
		eliminar.setBounds(959, 507, 55, 55);
		eliminar.setContentAreaFilled(false);
		eliminar.setVisible(true);
		eliminar.setBorder(null);
		eliminar.addActionListener(this);
		panel.add(eliminar);
		
		//textfield-----------------------------------------------------------------------------------------
		buscador = new JTextField();
		buscador.setBounds(132, 215, 742, 29);
		buscador.setVisible(true);
		buscador.setBorder(null);
		buscador.setBackground(Color.white);
		buscador.setForeground(Color.gray);
		buscador.setFont(todo.estilo_buscador);
		panel.add(buscador);
		
		rfc = new JTextField();
		rfc.setBounds(145, 450, 190, 30);
		rfc.setVisible(true);
		rfc.setBorder(null);
		rfc.setBackground(Color.white);
		rfc.setForeground(Color.gray);
		rfc.setFont(todo.estilo_base);
		panel.add(rfc);
		
		genero = new JComboBox<String>();
		genero.setBounds(361, 445, 225, 39);
		genero.setVisible(true);
		genero.setBorder(new LineBorder(todo.color2, 3));
		genero.setBackground(Color.white);
		genero.setForeground(Color.gray);
		genero.setFont(todo.estilo_base); 
		panel.add(genero);
		genero.addItem("SELECCIONAR");
		genero.addItem("H");
		genero.addItem("M");
		
		correo = new JTextField();
		correo.setBounds(615, 450, 280, 30);
		correo.setVisible(true);
		correo.setBorder(null);
		correo.setBackground(Color.white);
		correo.setForeground(Color.gray);
		correo.setFont(todo.estilo_base);
		panel.add(correo);
		
		docente = new JTextField();
		docente.setBounds(145, 523, 750, 30);
		docente.setVisible(true);
		docente.setBorder(null);
		docente.setBackground(Color.white);
		docente.setForeground(Color.gray);
		docente.setFont(todo.estilo_base);
		panel.add(docente);
	}
	void agregar()
	{
		modelo.addRow(new Object[]
				{
						rfc.getText().toUpperCase(),
						docente.getText().toUpperCase(),
						correo.getText().toUpperCase(),
						genero.getSelectedItem()
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
		int fila = tabla.getSelectedRow();
		modelo.setValueAt(rfc.getText(), fila, 0);
		modelo.setValueAt(docente.getText(), fila, 1);
		modelo.setValueAt(correo.getText(), fila, 2);
		modelo.setValueAt(genero.getSelectedItem(), fila, 3);
	}
	void vaciar()
	{
		rfc.setText("");
		genero.setSelectedItem("SELECCIONAR");
		correo.setText("");
		docente.setText("");
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == agg)
		{
			String selectedOption = (String) genero.getSelectedItem();
            if(selectedOption.equals("SELECCIONAR"))
            {
				JOptionPane.showMessageDialog(null, "SELECCIONE UN GÉNERO...          ", "ERROR...",JOptionPane.ERROR_MESSAGE);
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
				String selectedOption = (String) genero.getSelectedItem();
				if(selectedOption.equals("SELECCIONAR"))
	            {
					JOptionPane.showMessageDialog(null, "SELECCIONE UN GÉNERO...          ", "ERROR...",JOptionPane.ERROR_MESSAGE);
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
		baseDOC_OPbase clase = new baseDOC_OPbase();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
}
