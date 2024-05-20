import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.awt.*;

@SuppressWarnings("serial")
public class alumnosOPadministrador extends JFrame implements ActionListener
{
	JTextField buscador;
	JLabel panel;
	JPanel ventana;
	JTable tabla;
	JTableHeader Tcabezera;
	
	JButton botonCorreoTodos;
	static LocalDate ultimoClick;
	static String FILE_PATH = "current_date.txt";
	
	conexion conectar = new conexion();
	String[] cabecera = {"NO. DE CONTROL", "NOMBRE", "CARRERA", "LIB"};
	DefaultTableModel modelo = new DefaultTableModel();
	public Statement st;
	public ResultSet rs;
	
	ImageIcon imgFondo = new ImageIcon(getClass().getResource("/imagenes/1280720_alumnosOPadministrador.png"));
	
	public alumnosOPadministrador()
	{
		setLayout(null);
		
		//fondo panel----------------------------------------------------------------------------------------
		panel = new JLabel();
		panel.setIcon(new ImageIcon(imgFondo.getImage().getScaledInstance(1040, 585, Image.SCALE_SMOOTH)));
		panel.setBounds(0, 0, 1040, 585);
		add(panel);
		
		//buscador--------------------------------------------------------------------------------------------
		buscador = new JTextField();
		buscador.setBounds(132, 215, 742, 29);
		buscador.setVisible(true);
		buscador.setBorder(null);
		buscador.setBackground(Color.white);
		buscador.setForeground(Color.gray);
		buscador.setFont(todo.estilo_buscador);
		panel.add(buscador);
		
		//tabla----------------------------------------------------------------------------------------------
		ventana = new JPanel(new BorderLayout());
		ventana.setBounds(120, 255, 800, 300);
		ventana.setBackground(Color.white);
		ventana.setPreferredSize(new Dimension(800, 300));
		Color borderColor = Color.decode("#001655");
		ventana.setBorder(new LineBorder(borderColor, 4));
		
		tabla = new JTable(modelo);
		mtabla();
		
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
		
		//botón para enviar correo---------------------------------------------------------------------------
		leerUltimoClick();
		
		botonCorreoTodos = new JButton("");
        botonCorreoTodos.setBounds(944, 265, 70, 70);
        botonCorreoTodos.setContentAreaFilled(false);
        botonCorreoTodos.setVisible(true);
        botonCorreoTodos.setBorder(null);
        botonCorreoTodos.addActionListener(this);
        panel.add(botonCorreoTodos);
	}
    public void enviarCorreoAlumnosTodos()
    {
        for(int row=0; row<tabla.getRowCount(); row++)
        {
            String valorLIB = tabla.getValueAt(row, 3).toString();
            if(valorLIB.equals("SÍ"))
            {
            	//todo.enviarCorreoAlumnos();
            }
        }
    }
    private static void leerUltimoClick()
    {
        try(BufferedReader leer = new BufferedReader(new FileReader(FILE_PATH)))
        {
            String dateStr = leer.readLine();
            if(dateStr != null)
            {
                ultimoClick = LocalDate.parse(dateStr);
            }
        }
        catch(IOException e)
        {
            
        }
    }
    private static void guardarUltimoClick()
    {
        try(BufferedWriter escribir = new BufferedWriter(new FileWriter(FILE_PATH)))
        {
            escribir.write(ultimoClick.toString());
        }
        catch(IOException e)
        {
			JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR LA FECHA EN EL ARCHIVO..." + e.getMessage() + "     ", "ERROR...",JOptionPane.ERROR_MESSAGE);
        }
    }
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource() == botonCorreoTodos)
		{
			LocalDate fechaHoy = LocalDate.now();
            if(ultimoClick == null || !ultimoClick.equals(fechaHoy))
            {
    			JOptionPane.showMessageDialog(null, "CORREOS ENVIADOS...     ", "CORREOS ENVIADOS...",JOptionPane.INFORMATION_MESSAGE);
                ultimoClick = fechaHoy;
                guardarUltimoClick();
                //enviarCorreoAlumnosTodos();
            }
            else
            {
    			JOptionPane.showMessageDialog(null, "YA HAS ENVIADO LOS CORREOS HOY...     ", "ERROR...",JOptionPane.ERROR_MESSAGE);
            }
        }
		if(e.getSource() == todo.Batras)
		{
			OPadministrador clase = new OPadministrador();
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
	public void keyPressed(KeyEvent e) 
	{
		if(e.getExtendedKeyCode()==KeyEvent.VK_ENTER)
		{	
			mtabla();
		}
	}
	public void keyReleased(KeyEvent e)
	{
		if(buscador.getText().trim().equals(""))
		{
			mtabla();
		}
	}
	public void keyTyped(KeyEvent e)
	{
		
	}
	public void mtabla()
	{
		DefaultTableModel modelo = new DefaultTableModel()
        {
            public boolean isCellEditable(int row, int column)
            {
            	//no se pueda editar las primeras 4 columnas
                return column >= 4;
            }
        };
        
        String bs = buscador.getText();

		modelo.addColumn(cabecera[0]);
		modelo.addColumn(cabecera[1]);
		modelo.addColumn(cabecera[2]);
		modelo.addColumn(cabecera[3]);
		
		tabla.setModel(modelo);
		
		//medidas de las columnas de la tabla
        tabla.getColumn("NO. DE CONTROL").setPreferredWidth(220);
        tabla.getColumn("NOMBRE").setPreferredWidth(400);
        tabla.getColumn("CARRERA").setPreferredWidth(130);
        tabla.getColumn("LIB").setPreferredWidth(50);
        tabla.setRowHeight(35);
        
        tabla.getTableHeader().setResizingAllowed(false);//no se pueda cambiar la medida de la tabla
        tabla.getTableHeader().setReorderingAllowed(false);//no se pueda reordenar las columnas
        
        String sql = "SELECT * FROM tbmydb where Nombre like '%"+bs+"%' or Nacionalidad like '%"+bs+"%' or Numero like '%"+bs+"%'";
		String datos[]= new String[4];
		try
		{
			st = conectar.conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next())
			{
				datos[0] = rs.getString("Nombre");
				datos[1] = rs.getString("Nacionalidad");
				datos[2] = rs.getString("Numero");
				//datos[3] = rs.getString("Lib"); //agg la columna donde salga si el alumno tiene libros en posesión o no, y añadir al buscador (línea 224)
				modelo.addRow(datos);
			}
			
			tabla.setModel(modelo);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e.getMessage());
		}
	}
	public static void main(String[] args)
	{
		alumnosOPadministrador clase = new alumnosOPadministrador();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
}
