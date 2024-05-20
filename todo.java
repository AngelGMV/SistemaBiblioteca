import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Properties;
import java.awt.*;
@SuppressWarnings("serial")
public class todo extends JFrame implements ActionListener
{
	public static Font estilo_iniciar = new Font("fixedsys", 3, 32); //usuario y contraseña
	public static Font estilo_tabCabecera = new Font("calibri", 1, 26); //cabezera
	public static Font estilo_tabContenido = new Font("calibri", 0, 16); //contenido
	public static Font estilo_buscador = new Font("fixedsys", 3, 22); //buscador
	public static Font estilo_base = new Font("fixedsys", 1, 16); //bases de datos
	public static Font estilo_recibos = new Font("fixedsys", 1, 18); //recibos
	
	public static Color color1 = new Color(163, 17, 20); //tinto #A31114
	public static Color color2 = new Color(0, 22, 85); //azul marino #001655

	public static JButton Bclub, Binicio, Batras;
	public static JTextField nombre, LgradoGrupo, libro, fPre, fDev;
	public static JTextField alumno, AgradoGrupo, docente, fecha;
	
	public todo()
	{
		
	}
	public void actionPerformed(ActionEvent e)
	{
		
	}
	public static void main(String[] args)
	{
		conclusion();
		//enviarCorreo();
	}
	public static void conclusion()
	{
		JOptionPane.showMessageDialog(null,
								  "<html><p style =  \" font : 10px;   \">Esta aplicación fue elaborada por el Club de Programación.\r\n\n"
			    + "<html><p style =  \" color : black; font : 12px;   \"><b>FECHA DE ELABORACIÓN:\r\n"
								+ "<html><p style =  \" font : 10px;   \">Semestre Febrero 2023 - Junio 2023\r\n\n"
				+ "<html><p style =  \" color : black; font : 12px;   \"><b>COORDINADORA:\r\n"
				+ "<html><p style =  \" color : #A31114; font : 10px;   \"><b>Elma Cristina Camacho Páez\r\n\n"
				+ "<html><p style =  \" color : black; font : 12px;   \"><b>ALUMNOS:\r\n"
				+ "<html><p style =  \" color : #001655; font : 10px;   \">- <b>(2020-2023)</b> Alejandra Guadalupe Mejía Rosales\r\n"
				+ "<html><p style =  \" color : #001655; font : 10px;   \">- <b>(2020-2023)</b> Ángel Gabriel Muñoz Vega\r\n"
				+ "<html><p style =  \" color : #001655; font : 10px;   \">- <b>(2021-2024)</b> José Ángel Sotelo Izaguirre\r\n"
				+ "<html><p style =  \" color : #001655; font : 10px;   \">- <b>(2021-2024)</b> Tai Ping Alejandra Ruan López\r\n",
				               "AUTORES", JOptionPane.WARNING_MESSAGE, new ImageIcon("club_autores.png"));
	}
	public static void claseBclub()
	{
		Bclub = new JButton(""); //CLUB
		Bclub.setBounds(26, 488, 70, 70);
		Bclub.setContentAreaFilled(false);
		Bclub.setVisible(true);
		Bclub.setBorder(null);
	}
	public static void claseBinicio()
	{
		Binicio = new JButton(""); //REGRESAR A INICIO
		Binicio.setBounds(944, 488, 70, 70);
		Binicio.setContentAreaFilled(false);
		Binicio.setVisible(true);
		Binicio.setBorder(null);
	}
	public static void claseBatras()
	{
		Batras = new JButton(""); //REGRESAR ATRÁS
		Batras.setBounds(944, 108, 70, 70);
		Batras.setContentAreaFilled(false);
		Batras.setVisible(true);
		Batras.setBorder(null);
	}
	public static void claseFuncionBinicio()
	{
		inicio clase = new inicio();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
	public static void claseFuncionBlibros()
	{
		OPlibros clase = new OPlibros();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
	public static void claseFuncionBadministrador()
	{
		OPadministrador clase = new OPadministrador();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
	public static void claseFuncionBbase()
	{
		baseOPadministrador clase = new baseOPadministrador();
		clase.setBounds(0,0,1040, 585);
		clase.setUndecorated(true);
		clase.setVisible(true);
		clase.setResizable(false);
		clase.setLocationRelativeTo(null);
	}
	public static void enviarCorreoLibros()
	{
		String destinatario = "alextaiping007@gmail.com"; //Para:
	    final String remitente = "biblioteca.cbtis224@gmail.com"; //De:
		final String clave = "fmztlhuvllnntcim"; //CONTRASEÑA de la cuenta
		 
	    Properties prop = new Properties();
	    prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getInstance(prop, new javax.mail.Authenticator()
		{
		   protected PasswordAuthentication getPasswordAuthentication()
		   {
			   return new PasswordAuthentication(remitente, clave);
		   }
		});
		try
		{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(remitente));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			message.setSubject("RECIBO DE PRÉSTAMO");//ASUNTO del correo
			   
			String msg = "<H1><b>RECIBO DE PRÉSTAMO</b></H1>\r\n"
					+ "\r\n"
					+ "		<H2><b>Datos del Prestatario:</b></H2>\r\n"
					+ "		<P><b>Nombre: </b>Tai Ping Alejandra Ruan López\r\n"
					+ "		<P><b>No. de Referencia: </b>111111111111111\r\n"
					+ "\r\n"
					+ "		<BR>\r\n"
					+ "\r\n"
					+ "		<H2><b>Datos del Libro:</b></H2>\r\n"
					+ "		<P><b>Nombre: </b>El diario de un adolescente\r\n"
					+ "		<P><b>Fecha de Préstamo: </b>03-04-23\r\n"
					+ "		<P><b>Fecha para Devolución: </b>10-04-23\r\n"
					+ "		<P><b>No. de Préstamo: </b>12312312312312\r\n"
					+ "\r\n"
					+ "		<BR>\r\n"
					+ "		\r\n"
					+ "		<P>Tiene un plazo de una semana para devolver el libro o será sancionado.";//CUERPO del correo
			    
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(msg, "text/html");
			     
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			    
			/*MimeBodyPart attachmentBodyPart = new MimeBodyPart();
			attachmentBodyPart.attachFile(new File("C:/Users/alext/OneDrive/Imágenes/img/im.png"));//ARCHIVO que se enlaza
			multipart.addBodyPart(attachmentBodyPart);*/
			
			message.setContent(multipart);
		   
			Transport.send(message);
			
			JOptionPane.showMessageDialog(null, "CORREO ENVIADO CON ÉXITO...     ", "CORREO ENVIADO",JOptionPane.INFORMATION_MESSAGE);//Mensaje de envío correcto
		}
		catch (MessagingException e)
		{
			e.printStackTrace();
		}
	}
	public static void enviarCorreoAlumnos()
	{
		String destinatario = "alextaiping007@gmail.com"; //Para:
	    final String remitente = "biblioteca.cbtis224@gmail.com"; //De:
		final String clave = "fmztlhuvllnntcim"; //CONTRASEÑA de la cuenta
		 
	    Properties prop = new Properties();
	    prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getInstance(prop, new javax.mail.Authenticator()
		{
		   protected PasswordAuthentication getPasswordAuthentication()
		   {
			   return new PasswordAuthentication(remitente, clave);
		   }
		});
		try
		{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(remitente));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			message.setSubject("AVISO IMPORTANTE");//ASUNTO del correo
			   
			String msg = "<H1><b>AVISO IMPORTANTE</b></H1>\r\n"
					+ "\r\n"
					+ "		<H2><b>Datos del Prestatario:</b></H2>\r\n"
					+ "		<P><b>Nombre: </b>Tai Ping Alejandra Ruan López\r\n"
					+ "		<P><b>Grado Y Grupo: </b>4F\r\n"
					+ "		<P><b>No. de Control: </b>111111111111111\r\n"
					+ "\r\n"
					+ "		<BR>\r\n"
					+ "		\r\n"
					+ "		<P>Se le informa que es necesario que devuelva el o los libros o será sancionado.";//CUERPO del correo
			    
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(msg, "text/html");
			     
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			message.setContent(multipart);
		   
			Transport.send(message);
			
			JOptionPane.showMessageDialog(null, "CORREO ENVIADO CON ÉXITO...     ", "CORREO ENVIADO",JOptionPane.INFORMATION_MESSAGE);//Mensaje de envío correcto
		}
		catch (MessagingException e)
		{
			e.printStackTrace();
		}
	}
	public static void enviarCorreoAsesorias()
	{
		String destinatario = "alextaiping007@gmail.com"; //Para:
	    final String remitente = "biblioteca.cbtis224@gmail.com"; //De:
		final String clave = "fmztlhuvllnntcim"; //CONTRASEÑA de la cuenta
		 
	    Properties prop = new Properties();
	    prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.socketFactory.port", "465");
		prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		Session session = Session.getInstance(prop, new javax.mail.Authenticator()
		{
		   protected PasswordAuthentication getPasswordAuthentication()
		   {
			   return new PasswordAuthentication(remitente, clave);
		   }
		});
		try
		{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(remitente));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
			message.setSubject("INFORMACIÓN DE ASESORÍAS");//ASUNTO del correo
			   
			String msg = "<H1><b>INFORMACIÓN DE ASESORÍAS</b></H1>\r\n"
					+ "\r\n"
					+ "		<H2><b>Datos del Alumno:</b></H2>\r\n"
					+ "		<P><b>Nombre: </b>Tai Ping Alejandra Ruan López\r\n"
					+ "		<P><b>Grado Y Grupo: </b>4F\r\n"
					+ "\r\n"
					+ "		<BR>\r\n"
					+ "\r\n"
					+ "		<H2><b>Datos del Docente:</b></H2>\r\n"
					+ "		<P><b>Nombre: </b>Profe Juan Juanito\r\n"
					+ "\r\n"
					+ "		<BR>\r\n"
					+ "\r\n"
					+ "		<H2><b>Información de la Asesoría:</b></H2>\r\n"
					+ "		<P><b>Fecha: </b>15-05-2023\r\n"
					+ "		<P><b>Tiempo: </b>30 minutos\r\n"
					+ "		<P><b>Cubículo: </b>Cubículo 4\r\n"
					+ "\r\n"
					+ "		<BR>\r\n"
					+ "		\r\n"
					+ "		<P>¡Saludos!";//CUERPO del correo
			    
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(msg, "text/html");
			     
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			
			message.setContent(multipart);
		   
			Transport.send(message);
			
			JOptionPane.showMessageDialog(null, "CORREO ENVIADO CON ÉXITO...     ", "CORREO ENVIADO",JOptionPane.INFORMATION_MESSAGE);//Mensaje de envío correcto
		}
		catch (MessagingException e)
		{
			e.printStackTrace();
		}
	}
	public static void preYdev()
	{
		nombre = new JTextField();
		nombre.setEditable(false);
		nombre.setBounds(145, 215, 750, 28);
		nombre.setVisible(true);
		nombre.setBorder(null);
		nombre.setBackground(Color.white);
		nombre.setForeground(Color.gray);
		nombre.setFont(estilo_recibos);
		
		LgradoGrupo = new JTextField();
		LgradoGrupo.setEditable(false);
		LgradoGrupo.setBounds(615, 290, 280, 28);
		LgradoGrupo.setVisible(true);
		LgradoGrupo.setBorder(null);
		LgradoGrupo.setBackground(Color.white);
		LgradoGrupo.setForeground(Color.gray);
		LgradoGrupo.setFont(estilo_recibos);
		
		libro = new JTextField();
		libro.setEditable(false);
		libro.setBounds(145, 377, 750, 28);
		libro.setVisible(true);
		libro.setBorder(null);
		libro.setBackground(Color.white);
		libro.setForeground(Color.gray);
		libro.setFont(estilo_recibos);
		
		fPre = new JTextField();
		fPre.setEditable(false);
		fPre.setBounds(145, 451, 280, 28);
		fPre.setVisible(true);
		fPre.setBorder(null);
		fPre.setBackground(Color.white);
		fPre.setForeground(Color.gray);
		fPre.setFont(estilo_recibos);
		
		fDev = new JTextField();
		fDev.setEditable(false);
		fDev.setBounds(145, 525, 280, 28);
		fDev.setVisible(true);
		fDev.setBorder(null);
		fDev.setBackground(Color.white);
		fDev.setForeground(Color.gray);
		fDev.setFont(estilo_recibos);
	}
	public static void infoAsesorias()
	{
		alumno = new JTextField();
		alumno.setEditable(false);
		alumno.setBounds(145, 215, 750, 28);
		alumno.setVisible(true);
		alumno.setBorder(null);
		alumno.setBackground(Color.white);
		alumno.setForeground(Color.gray);
		alumno.setFont(estilo_recibos);
		
		AgradoGrupo = new JTextField();
		AgradoGrupo.setEditable(false);
		AgradoGrupo.setBounds(615, 290, 280, 28);
		AgradoGrupo.setVisible(true);
		AgradoGrupo.setBorder(null);
		AgradoGrupo.setBackground(Color.white);
		AgradoGrupo.setForeground(Color.gray);
		AgradoGrupo.setFont(estilo_recibos);
		
		docente = new JTextField();
		docente.setEditable(false);
		docente.setBounds(145, 377, 750, 28);
		docente.setVisible(true);
		docente.setBorder(null);
		docente.setBackground(Color.white);
		docente.setForeground(Color.gray);
		docente.setFont(estilo_recibos);
		
		fecha = new JTextField();
		fecha.setEditable(false);
		fecha.setBounds(145, 451, 280, 28);
		fecha.setVisible(true);
		fecha.setBorder(null);
		fecha.setBackground(Color.white);
		fecha.setForeground(Color.gray);
		fecha.setFont(estilo_recibos);
	}
}
