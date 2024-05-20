import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
@SuppressWarnings("serial")
public class baseLIB_OPbase extends JFrame implements ActionListener
{
	JTextField buscador, codigo, cantidad, autor, libro;
	JLabel panel;
	JButton agg, eliminar, modificar;
	JComboBox<String> estado;
	JComboBox<Integer> tema;
	JPanel ventana;
	JTable tabla;
	JTableHeader Tcabezera;
	DefaultTableModel modelo = new DefaultTableModel();
			
	String[] cabecera = {"CÓDIGO", "LIBRO", "AUTOR", "ESTADO", "TEMA", "CANT"};
	
	ImageIcon imgFondo = new ImageIcon(getClass().getResource("/imagenes/1280720_baseLIB_OPbase.png"));
	
	public baseLIB_OPbase()
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
            	//no se pueda editar las 6 columnas
                return column >= 6;
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
        tabla.getColumn("CÓDIGO").setPreferredWidth(120);
        tabla.getColumn("LIBRO").setPreferredWidth(200);
        tabla.getColumn("AUTOR").setPreferredWidth(200);
        tabla.getColumn("ESTADO").setPreferredWidth(100);
        tabla.getColumn("TEMA").setPreferredWidth(100);
        tabla.getColumn("CANT").setPreferredWidth(80);
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
	                Object lib = tabla.getValueAt(selectedRow, 1);
	                Object aut = tabla.getValueAt(selectedRow, 2);
	                Object est = tabla.getValueAt(selectedRow, 3);
	                Object tem = tabla.getValueAt(selectedRow, 4);
	                Object can = tabla.getValueAt(selectedRow, 5);
	                codigo.setText(cod.toString());
	                libro.setText(lib.toString());
	                autor.setText(aut.toString());
	                estado.setSelectedItem(est);
	                tema.setSelectedItem(tem);
	                cantidad.setText(can.toString());
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
		
		codigo = new JTextField();
		codigo.setBounds(145, 450, 130, 30);
		codigo.setVisible(true);
		codigo.setBorder(null);
		codigo.setBackground(Color.white);
		codigo.setForeground(Color.gray);
		codigo.setFont(todo.estilo_base);
		panel.add(codigo);
		
		estado = new JComboBox<String>();
		estado.setBounds(333, 445, 168, 39);
		estado.setVisible(true);
		estado.setBorder(new LineBorder(todo.color2, 3));
		estado.setBackground(Color.white);
		estado.setForeground(Color.gray);
		estado.setFont(todo.estilo_base); 
		panel.add(estado);
		estado.addItem("SELECCIONAR");
		estado.addItem("DISPONIBLE");
		estado.addItem("NO DISPONIBLE");
		estado.addItem("EXTRAVIADO");
		
		tema = new JComboBox<Integer>();
		tema.setBounds(540, 445, 100, 39);
		tema.setVisible(true);
		tema.setBorder(new LineBorder(todo.color2, 3));
		tema.setBackground(Color.white);
		tema.setForeground(Color.gray);
		tema.setFont(todo.estilo_base); 
		panel.add(tema);
		tema.addItem(0);
		for(int i=1; i<=24; i++)
		{
		    tema.addItem(i);
		}
		
		cantidad = new JTextField();
		cantidad.setBounds(828, 450, 70, 30);
		cantidad.setVisible(true);
		cantidad.setBorder(null);
		cantidad.setBackground(Color.white);
		cantidad.setForeground(Color.gray);
		cantidad.setFont(todo.estilo_base);
		panel.add(cantidad);
		
		autor = new JTextField();
		autor.setBounds(558, 523, 335, 30);
		autor.setVisible(true);
		autor.setBorder(null);
		autor.setBackground(Color.white);
		autor.setForeground(Color.gray);
		autor.setFont(todo.estilo_base);
		panel.add(autor);
		
		libro = new JTextField();
		libro.setBounds(145, 523, 335, 30);
		libro.setVisible(true);
		libro.setBorder(null);
		libro.setBackground(Color.white);
		libro.setForeground(Color.gray);
		libro.setFont(todo.estilo_base);
		panel.add(libro);
	}
	void agregar()
	{
		modelo.addRow(new Object[]
				{
						codigo.getText(),
						libro.getText().toUpperCase(),
						autor.getText().toUpperCase(),
						estado.getSelectedItem(),
						(Integer)tema.getSelectedItem(),
						cantidad.getText()
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
		modelo.setValueAt(codigo.getText(), fila, 0);
		modelo.setValueAt(libro.getText(), fila, 1);
		modelo.setValueAt(autor.getText(), fila, 2);
		modelo.setValueAt(estado.getSelectedItem(), fila, 3);
		modelo.setValueAt((Integer)(tema.getSelectedItem()), fila, 4);
		modelo.setValueAt(cantidad.getText(), fila, 5);
	}
	void vaciar()
	{
		codigo.setText("");
		estado.setSelectedItem("SELECCIONAR");
		tema.setSelectedItem(0);
		cantidad.setText("");
		autor.setText("");
		libro.setText("");
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == agg)
		{
			String selectedOption = (String) estado.getSelectedItem();
			int selectedOption2 = (Integer) tema.getSelectedItem();
			if(selectedOption.equals("SELECCIONAR") || selectedOption2==0)
            {
				JOptionPane.showMessageDialog(null, "SELECCIONE LA INFORMACIÓN FALTANTE...          ", "ERROR...",JOptionPane.ERROR_MESSAGE);
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
				String selectedOption = (String) estado.getSelectedItem();
				int selectedOption2 = (Integer) tema.getSelectedItem();
				if(selectedOption.equals("SELECCIONAR") || selectedOption2==0)
	            {
					JOptionPane.showMessageDialog(null, "SELECCIONE LA INFORMACIÓN FALTANTE...          ", "ERROR...",JOptionPane.ERROR_MESSAGE);
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
		baseLIB_OPbase clase = new baseLIB_OPbase();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
}
