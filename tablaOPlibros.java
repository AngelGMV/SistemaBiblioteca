import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
@SuppressWarnings("serial")
public class tablaOPlibros extends JFrame implements ActionListener
{
	JTextField buscador;
	JLabel panel;
	JPanel ventana;
	JTable tabla;
	JTableHeader Tcabezera;
	JButton boton;
	
	String[] cabecera = {"NOMBRE", "AUTOR", "ESTADO", "INFO"};

    Object[][] datos = {
    		{"Libro 0", "TAI PING ALEJANDRA RUAN LÓPEZ", "DISPONIBLE", "..."},
            {"Libro 1", "Autor 1", "DISPONIBLE", "..."},
            {"Libro 2", "Autor 2", "NO DISPONIBLE", "..."},
            {"Libro 3", "Autor 3", "DISPONIBLE", "..."},
            {"Libro 4", "Autor 4", "DISPONIBLE", "..."},
            {"Libro 5", "Autor 5", "DISPONIBLE", "..."},
            {"Libro 6", "Autor 6", "NO DISPONIBLE", "..."},
            {"Libro 7", "Autor 7", "DISPONIBLE", "..."},
            {"Libro 8", "Autor 8", "NO DISPONIBLE", "..."},
            {"Libro 9", "Autor 9", "NO DISPONIBLE", "..."}
    };
	
	ImageIcon imgFondo = new ImageIcon(getClass().getResource("/imagenes/1280720_tablaOPlibros.png"));
	
	public tablaOPlibros()
	{
		setLayout(null);
		
		//fondo panel----------------------------------------------------------------------------------------
		panel = new JLabel();
		panel.setIcon(new ImageIcon(imgFondo.getImage().getScaledInstance(1040, 585, Image.SCALE_SMOOTH)));
		panel.setBounds(0, 0, 1040, 585);
		add(panel);
		
		//tabla----------------------------------------------------------------------------------------------
		ventana = new JPanel(new BorderLayout());
		ventana.setBounds(120, 255, 800, 300);
		ventana.setBackground(Color.white);
		ventana.setPreferredSize(new Dimension(800, 300));
		ventana.setBorder(new LineBorder(todo.color2, 4));

		DefaultTableModel modelo = new DefaultTableModel(datos, cabecera)
        {
            public boolean isCellEditable(int row, int column)
            {
            	//no se pueda editar las primeras 3 columnas
                return column >= 3;
            }
        };
		
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
		
		tabla.getColumn("INFO").setCellRenderer((TableCellRenderer) new ButtonRenderer());//crear botón en la columna INFO
        tabla.getColumn("INFO").setCellEditor(new ButtonEditor(new JTextField()));//darle funcionalidad al botón
        
        //medidas de las columnas de la tabla
        tabla.getColumn("NOMBRE").setPreferredWidth(335);
        tabla.getColumn("AUTOR").setPreferredWidth(290);
        tabla.getColumn("ESTADO").setPreferredWidth(110);
        tabla.getColumn("INFO").setPreferredWidth(65);
        tabla.setRowHeight(35);
        
        tabla.getTableHeader().setResizingAllowed(false);//no se pueda cambiar la medida de la tabla
        tabla.getTableHeader().setReorderingAllowed(false);//no se pueda reordenar las columnas
        
		ventana.add(new JScrollPane(tabla), BorderLayout.CENTER);
		ventana.setVisible(true);
		panel.add(ventana);
		
		//botones desde clase todo---------------------------------------------------------------------------
		todo.claseBclub();
		todo.Bclub.addActionListener(this);
		panel.add(todo.Bclub);
		
		todo.claseBatras();
		todo.Batras.addActionListener(this);
		panel.add(todo.Batras);
		
		//buscador--------------------------------------------------------------------------------------------
		buscador = new JTextField();
		buscador.setBounds(132, 215, 742, 29);
		buscador.setVisible(true);
		buscador.setBorder(null);
		buscador.setBackground(Color.white);
		buscador.setForeground(Color.gray);
		buscador.setFont(todo.estilo_buscador);
		panel.add(buscador);
		
		//boton---------------------------------------------------------------------------------------------
		boton.addActionListener(this);
		panel.add(boton);
	}
	private static class ButtonRenderer extends JButton implements TableCellRenderer
    {
        public ButtonRenderer()
        {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }
    private class ButtonEditor extends DefaultCellEditor
    {
        private String label;

        public ButtonEditor(JTextField textField)
        {
            super(textField);
            setClickCountToStart(1);

            boton = new JButton();
            boton.setOpaque(true);
            editorComponent = boton;
        }
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)
        {
            label = (value == null) ? "" : value.toString();
            ((JButton) editorComponent).setText(label);
            return editorComponent;
        }
        public Object getCellEditorValue()
        {
            return label;
        }
    }
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == boton)
		{
			preOPtabla clase = new preOPtabla();
			clase.setBounds(0,0,1040, 585);
			clase.setUndecorated(true);
			clase.setVisible(true);
			clase.setResizable(false);
			clase.setLocationRelativeTo(null);
			dispose();
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
		tablaOPlibros clase = new tablaOPlibros();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
}
