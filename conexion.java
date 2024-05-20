import java.sql.*;
import javax.swing.JOptionPane;

public class conexion
{
	private String nombreBd = "mydb";
	private String usuario = "root";
	private String password = "bebe09102018";
	private String url="jdbc:mysql://localhost:3306/"+nombreBd+"?useUnicode=true6use"+"JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"+ "severTimeZone=UTC";
	
	Connection conn=null;
	
	public conexion()
	{	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url, usuario, password);
			if(conn!=null)
			{
				JOptionPane.showMessageDialog(null,"CONEXIÓN EXITOSA...","ÉXITO...",JOptionPane.INFORMATION_MESSAGE);
			}
		} 
		catch(ClassNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, "CONEXIÓN FALLIDA, ClassNotFoundException: " + e.getMessage(),"CONEXIÓN FALLIDA...",JOptionPane.INFORMATION_MESSAGE);
		}
		catch(SQLException e)
		{
			JOptionPane.showMessageDialog(null,"CONEXIÓN FALLIDA, SQLException: " + e.getLocalizedMessage(),"CONEXIÓN FALLIDA...",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	public static void main(String[] args)
	{
		
	}
}
