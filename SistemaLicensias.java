import javax.swing.*;
import java.util.Properties;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font; 
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont; 
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Authenticator;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class SistemaLicensias {

    private static Connection conexion;

    public static void main(String[] args) {
        establecerConexion();
        mostrarVentanaInicioSesion();
    }

    // Método para crear la ventana inicial de selección de usuario
    public static void mostrarVentanaInicioSesion() {
    JFrame ventanaInicio = new JFrame("Seleccione Tipo de Usuario");
    ventanaInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventanaInicio.setSize(400, 300); // Ajustar tamaño para más espacio
    
    // Usar BorderLayout para mayor flexibilidad
    ventanaInicio.setLayout(new BorderLayout());

    // Panel para los botones
    JPanel panelBotones = new JPanel(new GridLayout(2, 1, 10, 10));
    panelBotones.setOpaque(false); // Fondo transparente para mostrar el fondo principal

    // Crear botones con imágenes al lado
    JButton botonAdmin = new JButton("Administrador", new ImageIcon("src/imagenes2/admin_icon.jpg"));
    JButton botonUsuario = new JButton("Usuario", new ImageIcon("src/imagenes2/user_icon.jfif"));

    ImageIcon iconoOriginal = new ImageIcon("src/imagenes2/admin_icon.jpg");
    ImageIcon iconoOriginal2 = new ImageIcon("src/imagenes2/iconos.jpg");
    Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Cambia 30x30 al tamaño deseado
    ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
    botonAdmin.setIcon(iconoRedimensionado);
    Image imagenEscalada2 = iconoOriginal2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Cambia 30x30 al tamaño deseado
    ImageIcon iconoRedimensionado2 = new ImageIcon(imagenEscalada2);
    botonUsuario.setIcon(iconoRedimensionado2);
    
    // Personalizar botones
    botonAdmin.setHorizontalAlignment(SwingConstants.LEFT); // Texto e imagen alineados
    botonAdmin.setFont(new Font("Arial", Font.PLAIN, 14));
    botonAdmin.setBackground(new Color(240, 248, 255)); // Fondo azul claro
    botonAdmin.setFocusPainted(false);

    botonUsuario.setHorizontalAlignment(SwingConstants.LEFT);
    botonUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
    botonUsuario.setBackground(new Color(240, 248, 255));
    botonUsuario.setFocusPainted(false);

    // Agregar botones al panel
    panelBotones.add(botonAdmin);
    panelBotones.add(botonUsuario);

    // Agregar una imagen decorativa en la parte inferior
    JLabel imagenInferior = new JLabel(new ImageIcon("src/imagenes/footer_icon.png"));
    imagenInferior.setHorizontalAlignment(SwingConstants.CENTER);

    // Fondo principal de la ventana
    JLabel fondo = new JLabel(new ImageIcon("src/imagenes/fondo_inicio.png"));
    fondo.setLayout(new BorderLayout()); // Para que los componentes se posicionen correctamente

    // Agregar componentes al fondo
    fondo.add(panelBotones, BorderLayout.CENTER); // Panel de botones al centro
    fondo.add(imagenInferior, BorderLayout.SOUTH); // Imagen decorativa al pie de la ventana

    // Agregar fondo a la ventana
    ventanaInicio.setContentPane(fondo);

    ventanaInicio.setLocationRelativeTo(null); // Centrar ventana
    ventanaInicio.setVisible(true);

    // Acciones de los botones
    botonAdmin.addActionListener(e -> {
        ventanaInicio.dispose(); // Cierra la ventana de selección
        mostrarLogin("administrador"); // Llama a login con administrador
    });

    botonUsuario.addActionListener(e -> {
        ventanaInicio.dispose(); // Cierra la ventana de selección
        mostrarLoginusuario("usuario"); // Llama a login con usuario
    });
}


    public static void establecerConexion() {
        try {
            String url = "jdbc:mysql://localhost:3306/sistema_licensias";
            String usuario = "root"; // Cambia esto por tu usuario de MySQL
            String contrasena = "1234"; // Cambia esto por tu contraseña de MySQL
            conexion = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("Conexión exitosa a la base de datos.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }
    
    public static void mostrarLoginusuario(String Usuarioss) {
    JFrame ventanaMenuUsu = new JFrame("Menú Principal");
    ventanaMenuUsu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventanaMenuUsu.setSize(400, 300); // Tamaño ajustado
    
    // Usar un BorderLayout para mayor flexibilidad
    ventanaMenuUsu.setLayout(new BorderLayout());

    // Panel para los botones con un GridLayout ajustado
    JPanel panelBotones = new JPanel(new GridLayout(2, 1, 10, 10));
    panelBotones.setOpaque(false); // Para mantener el fondo del marco

    // Crear botones con texto e imágenes
    JButton botonRegistrar = new JButton("Registrar Nueva Licencia", new ImageIcon("src/imagenes2/registrar.png"));
    JButton botonSalir = new JButton("Salir", new ImageIcon("src/imagenes2/salir.png"));
    
    ImageIcon iconoOriginal = new ImageIcon("src/imagenes2/registrar.png");
    ImageIcon iconoOriginal2 = new ImageIcon("src/imagenes2/salir.png");
    Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Cambia 30x30 al tamaño deseado
    ImageIcon iconoRedimensionado = new ImageIcon(imagenEscalada);
    botonRegistrar.setIcon(iconoRedimensionado);
    Image imagenEscalada2 = iconoOriginal2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH); // Cambia 30x30 al tamaño deseado
    ImageIcon iconoRedimensionado2 = new ImageIcon(imagenEscalada2);
    botonSalir.setIcon(iconoRedimensionado2);
    

    // Personalizar el estilo de los botones
    botonRegistrar.setHorizontalAlignment(SwingConstants.LEFT);
    botonRegistrar.setFont(new Font("Arial", Font.PLAIN, 14));
    botonRegistrar.setBackground(new Color(240, 248, 255)); // Color de fondo azul claro
    botonRegistrar.setFocusPainted(false);

    botonSalir.setHorizontalAlignment(SwingConstants.LEFT);
    botonSalir.setFont(new Font("Arial", Font.PLAIN, 14));
    botonSalir.setBackground(new Color(240, 248, 255));
    botonSalir.setFocusPainted(false);

    // Agregar una imagen decorativa en la parte superior
    JLabel imagenDecorativa = new JLabel(new ImageIcon("src/imagenes2/.jpg"));
    imagenDecorativa.setHorizontalAlignment(SwingConstants.CENTER);
    
    // Agregar los botones al panel
    panelBotones.add(botonRegistrar);
    panelBotones.add(botonSalir);

    // Agregar los componentes a la ventana
    ventanaMenuUsu.add(imagenDecorativa, BorderLayout.NORTH);
    ventanaMenuUsu.add(panelBotones, BorderLayout.CENTER);
    
    botonRegistrar.setPreferredSize(new Dimension(100, 20)); // Ancho 200px, Alto 50px
    botonSalir.setPreferredSize(new Dimension(100, 20));

    // Configurar fondo de la ventana
    ventanaMenuUsu.getContentPane().setBackground(new Color(173, 216, 230)); // Fondo verde claro
    
    ventanaMenuUsu.setLocationRelativeTo(null); // Centrar ventana
    ventanaMenuUsu.setVisible(true);

    // Acciones de los botones
    botonRegistrar.addActionListener(e -> mostrarFormularioRegistro(ventanaMenuUsu));
    botonSalir.addActionListener(e -> {
        ventanaMenuUsu.dispose();
        JOptionPane.showMessageDialog(null, "Saliendo del sistema. ¡Hasta luego!");
    });
}


    // Modificado para aceptar tipo de usuario
    public static void mostrarLogin(String tipoUsuario) {
        JFrame ventanaLogin = new JFrame("Inicio de Sesión");
        ventanaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaLogin.setSize(400, 300);
        ventanaLogin.setLayout(new BorderLayout());

        // Panel para campos de texto
        JPanel panelCentro = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel etiquetaUsuario = new JLabel("Usuario:");
        JTextField campoUsuario = new JTextField();
        JLabel etiquetaContrasena = new JLabel("Contraseña:");
        JPasswordField campoContrasena = new JPasswordField();
        JButton botonLogin = new JButton("Iniciar Sesión");

        panelCentro.add(etiquetaUsuario);
        panelCentro.add(campoUsuario);
        panelCentro.add(etiquetaContrasena);
        panelCentro.add(campoContrasena);
        panelCentro.add(new JLabel()); // Espacio vacío
        panelCentro.add(botonLogin);

        // Panel para la imagen
        JLabel imagenPlaceholder = new JLabel("Espacio para imagen", JLabel.CENTER);
        imagenPlaceholder.setPreferredSize(new Dimension(100, 100));
        ventanaLogin.add(imagenPlaceholder, BorderLayout.NORTH);

        // Fondo azul
        ventanaLogin.getContentPane().setBackground(Color.GREEN);
        ventanaLogin.setLocationRelativeTo(null);

        // Título en la parte superior
        JLabel titulo = new JLabel("Bienvenido a LicenSúper", JLabel.CENTER);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        ventanaLogin.add(titulo, BorderLayout.SOUTH);

        ventanaLogin.add(panelCentro, BorderLayout.CENTER);

        // Mostrar ventana
        ventanaLogin.setVisible(true);

        // Acción para el botón
        botonLogin.addActionListener(e -> {
            if (tipoUsuario.equals("administrador")) {
                // Verificar si es administrador
                String usuarioAdmin = "admin";
                String contrasenaAdmin = "1234";
                String usuario = campoUsuario.getText();
                String contrasena = new String(campoContrasena.getPassword());

                if (usuario.equals(usuarioAdmin) && contrasena.equals(contrasenaAdmin)) {
                    JOptionPane.showMessageDialog(ventanaLogin, "Inicio de sesión exitoso.");
                    ventanaLogin.dispose();
                    mostrarMenuPrincipal();
                } else {
                    JOptionPane.showMessageDialog(ventanaLogin, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                // Aquí puedes agregar validaciones para el usuario si es necesario
                JOptionPane.showMessageDialog(ventanaLogin, "Bienvenido Usuario.");
                ventanaLogin.dispose();
                mostrarMenuPrincipal();  // Aquí puedes mostrar el menú de usuario
            }
        });

        // Cargar una imagen en el JLabel
        try {
            ImageIcon iconoImagen = new ImageIcon("src/imagenes2/logox.png");
            Image imagenEscalada = iconoImagen.getImage().getScaledInstance(350, 100, Image.SCALE_SMOOTH);
            iconoImagen = new ImageIcon(imagenEscalada);
            imagenPlaceholder.setText(null); // Quitar texto
            imagenPlaceholder.setIcon(iconoImagen); // Establecer imagen
        } catch (Exception ex) {
            System.out.println("Error al cargar la imagen: " + ex.getMessage());
        }
    }
//-----------------------------------------------------------------------//
    public static void mostrarMenuPrincipal() {
    JFrame ventanaMenu = new JFrame("Menú Principal");
    ventanaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventanaMenu.setSize(400, 300); // Tamaño ajustado
    ventanaMenu.setLayout(new GridLayout(5, 1, 5, 5)); // Ajustar a 5 filas para el nuevo botón

    // Crear los botones con texto e imágenes
    JButton botonRegistrar = new JButton("Registrar Nueva Licencia", redimensionarImagen("src/imagenes2/registrar.png", 40, 40));
    JButton botonVer = new JButton("Ver Licencias Existentes", redimensionarImagen("src/imagenes2/verr.jpg", 40, 40));
    JButton botonDescargarPDF = new JButton("Descargar PDF de Licencia", redimensionarImagen("src/imagenes2/pdf.jpg", 40, 40));
    JButton botonEnviarCorreo = new JButton("Enviar por Correo", redimensionarImagen("src/imagenes2/correo.jpg", 40, 40)); // Nuevo botón
    JButton botonSalir = new JButton("Salir", redimensionarImagen("src/imagenes2/salir.png", 40, 40));

    // Agregar los botones a la ventana
    ventanaMenu.add(botonRegistrar);
    ventanaMenu.add(botonVer);
    ventanaMenu.add(botonDescargarPDF);
    ventanaMenu.add(botonEnviarCorreo); // Agregar el nuevo botón
    ventanaMenu.add(botonSalir);

    // Estilo de fondo
    ventanaMenu.getContentPane().setBackground(new Color(173, 216, 230)); // Fondo verde claro
    ventanaMenu.setLocationRelativeTo(null); // Centrar ventana
    ventanaMenu.setVisible(true);

    // Acciones de los botones
    botonRegistrar.addActionListener(e -> mostrarFormularioRegistro(ventanaMenu));
    botonVer.addActionListener(e -> mostrarLicenciasExistentes(ventanaMenu));
    botonEnviarCorreo.addActionListener(e -> enviarCorreo(ventanaMenu));
    botonDescargarPDF.addActionListener(e -> mostrarLicenciasParaPDF(ventanaMenu)); // Acción para descargar PDF

    botonSalir.addActionListener(e -> {
        ventanaMenu.dispose();
        JOptionPane.showMessageDialog(null, "Saliendo del sistema. ¡Hasta luego!");
    });
}

// Método para redimensionar las imágenes
private static Icon redimensionarImagen(String ruta, int ancho, int alto) {
    ImageIcon iconoOriginal = new ImageIcon(ruta);
    Image imagen = iconoOriginal.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
    return new ImageIcon(imagen);
}

    public static void enviarCorreo(JFrame ventanaAnterior) {
    // Crear ventana
    JFrame ventanaEnvio = new JFrame("ENVIAR CORREO");
    ventanaEnvio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ventanaEnvio.setSize(400, 200);
    ventanaEnvio.setLayout(new GridLayout(3, 2, 5, 5));
    ventanaEnvio.setLocationRelativeTo(null);

    // Componentes
    JLabel labelDestinatario = new JLabel("Correo del destinatario:");
    JTextField campoDestinatario = new JTextField();

    JButton botonSeleccionarArchivo = new JButton("Seleccionar Archivo");
    JLabel labelArchivoSeleccionado = new JLabel("Ningún archivo seleccionado");

    JButton botonEnviar = new JButton("Enviar");
    JButton botonCancelar = new JButton("Cancelar");

    // Contenedor para el archivo seleccionado
    final File[] archivoSeleccionado = {null};

    // Acción para seleccionar archivo
    botonSeleccionarArchivo.addActionListener(e -> {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(ventanaEnvio);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            archivoSeleccionado[0] = fileChooser.getSelectedFile();
            labelArchivoSeleccionado.setText("Archivo: " + archivoSeleccionado[0].getName());
        }
    });

    // Acción para enviar correo
    botonEnviar.addActionListener(e -> {
        String destinatario = campoDestinatario.getText().trim();

        if (destinatario.isEmpty()) {
            JOptionPane.showMessageDialog(ventanaEnvio, "Por favor, ingresa un correo válido.");
            return;
        }

        if (archivoSeleccionado[0] == null) {
            JOptionPane.showMessageDialog(ventanaEnvio, "Selecciona un archivo antes de enviar.");
            return;
        }

        enviarCorreoConAdjunto(destinatario, archivoSeleccionado[0]);
    });

    // Acción para cancelar
    botonCancelar.addActionListener(e -> ventanaEnvio.dispose());

    // Agregar componentes a la ventana
    ventanaEnvio.add(labelDestinatario);
    ventanaEnvio.add(campoDestinatario);
    ventanaEnvio.add(botonSeleccionarArchivo);
    ventanaEnvio.add(labelArchivoSeleccionado);
    ventanaEnvio.add(botonEnviar);
    ventanaEnvio.add(botonCancelar);

    ventanaEnvio.setVisible(true);
}

private static void enviarCorreoConAdjunto(String destinatario, File archivoAdjunto) {
    String remitente = "fl9840856@gmail.com"; // Tu correo
    String contraseña = "tacato14";           // Tu contraseña

    // Configurar propiedades SMTP
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");

    // Crear sesión
    Session session = Session.getInstance(props, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(remitente, contraseña);
        }
    });

    try {
        // Crear el mensaje
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(remitente));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        message.setSubject("Archivo adjunto");

        // Parte del mensaje de texto
        MimeBodyPart parteTexto = new MimeBodyPart();
        parteTexto.setText("Adjunto el archivo solicitado.");

        // Parte del archivo adjunto
        MimeBodyPart parteAdjunto = new MimeBodyPart();
        parteAdjunto.attachFile(archivoAdjunto);

        // Combinar ambas partes
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(parteTexto);
        multipart.addBodyPart(parteAdjunto);

        message.setContent(multipart);

        // Enviar el mensaje
        Transport.send(message);
        JOptionPane.showMessageDialog(null, "Correo enviado exitosamente con el archivo adjunto.");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al enviar el correo: " + e.getMessage());
    }
}


    
public static void mostrarLicenciasParaPDF(JFrame ventanaAnterior) {
    JFrame ventanaLicencias = new JFrame("Seleccionar Licencia para Descargar PDF");
    ventanaLicencias.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ventanaLicencias.setSize(800, 400);
    ventanaLicencias.setLocationRelativeTo(null);
    try {
        String sql = "SELECT * FROM licencias";
        Statement statement = conexion.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        String[] columnas = {"No. Licencia", "Nombre", "Edad", "CURP", "Nacionalidad", "Tipo Vehículo", "Tipo Sangre", "Expedición", "Vigencia"};
        ArrayList<String[]> datos = new ArrayList<>();

        while (resultSet.next()) {
            String numeroLicencia = String.valueOf(resultSet.getInt("numero_licencia"));
            String nombre = resultSet.getString("nombre_apellidos");
            String edad = String.valueOf(resultSet.getInt("edad"));
            String curp = resultSet.getString("curp");
            String nacionalidad = resultSet.getString("nacionalidad");
            String tipoVehiculo = resultSet.getString("tipo_vehiculo");
            String tipoSangre = resultSet.getString("tipo_sangre");
            String fechaExpedicion = resultSet.getString("fecha_expedicion");
            String fechaVigencia = resultSet.getString("fecha_vigencia");

            datos.add(new String[]{numeroLicencia, nombre, edad, curp, nacionalidad, tipoVehiculo, tipoSangre, fechaExpedicion, fechaVigencia});
        }

        String[][] datosArray = datos.toArray(new String[0][]);
        JTable tabla = new JTable(datosArray, columnas);
        JScrollPane scrollPane = new JScrollPane(tabla);

        JPanel panelBotones = new JPanel();
        JButton botonDescargar = new JButton("Descargar PDF");
        JButton botonRegresar = new JButton("Regresar");

        botonDescargar.addActionListener(e -> {
            int filaSeleccionada = tabla.getSelectedRow();
            if (filaSeleccionada != -1) {
                String nombreLicencia = tabla.getValueAt(filaSeleccionada, 1).toString(); // Nombre del titular
                String numeroLicencia = tabla.getValueAt(filaSeleccionada, 0).toString(); // Número de licencia
                String edad = tabla.getValueAt(filaSeleccionada, 2).toString();
                String curp = tabla.getValueAt(filaSeleccionada, 3).toString();
                String nacionalidad = tabla.getValueAt(filaSeleccionada, 4).toString();
                String tipoVehiculo = tabla.getValueAt(filaSeleccionada, 5).toString();
                String tipoSangre = tabla.getValueAt(filaSeleccionada, 6).toString();
                String fechaExpedicion = tabla.getValueAt(filaSeleccionada, 7).toString();
                String fechaVigencia = tabla.getValueAt(filaSeleccionada, 8).toString();
                // Generar PDF para la licencia seleccionada
                generarPDFLicencia(numeroLicencia, nombreLicencia, edad, curp, nacionalidad, tipoVehiculo, tipoSangre, fechaExpedicion, fechaVigencia);
            } else {
                JOptionPane.showMessageDialog(ventanaLicencias, "Por favor, selecciona una licencia.");
            }
        });

        botonRegresar.addActionListener(e -> {
            ventanaLicencias.dispose();
            ventanaAnterior.setVisible(true);
        });

        panelBotones.add(botonDescargar);
        panelBotones.add(botonRegresar);

        ventanaLicencias.setLayout(new BorderLayout());
        ventanaLicencias.add(scrollPane, BorderLayout.CENTER);
        ventanaLicencias.add(panelBotones, BorderLayout.SOUTH);

        ventanaLicencias.setVisible(true);
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al obtener licencias.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    public static void generarPDFLicencia(String numeroLicencia, String nombreLicencia, String edad, 
            String curp, String nacionalidad, String tipoVehiculo, String tipoSangre, String fechaExpedicion, String fechaVencimiento) {
        
    try {
        // Crear un documento PDF
        PDDocument documento = new PDDocument();

        // Crear una página de tamaño A4
        PDPage pagina = new PDPage(PDRectangle.A4);
        documento.addPage(pagina);

        // Cargar la fuente personalizada (Arial.ttf)
        File archivoFuente = new File("C:\\Windows\\Fonts\\Arial.ttf");
        
        if (!archivoFuente.exists()) {
            JOptionPane.showMessageDialog(null, "No se encontró la fuente Arial.ttf en la ruta especificada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        PDFont fuentePersonalizada = PDType0Font.load(documento, archivoFuente);
        
        // Crear un objeto de texto en la página
        try (PDPageContentStream contenido = new PDPageContentStream(documento, pagina)) {
            contenido.beginText();
            contenido.setFont(fuentePersonalizada, 12); // Usar la fuente cargada
            contenido.setLeading(14.5f);
            contenido.newLineAtOffset(50, 750);
            
            contenido.showText("Licencia No. " + numeroLicencia);
            contenido.newLine();
            contenido.showText("Nombre: " + nombreLicencia);
            contenido.newLine();
            contenido.showText("Edad: " + edad);
            contenido.newLine();
            contenido.showText("CURP: " + curp);
            contenido.newLine();
            contenido.showText("Nacionalidad:" + nacionalidad);
            contenido.newLine();
            contenido.showText("Vehiculo:" + tipoVehiculo);
            contenido.newLine();
            contenido.showText("Sangre: " + tipoSangre);
            contenido.newLine();
            contenido.showText("Fecha del tramite: " + fechaExpedicion);
            contenido.newLine();
            contenido.showText("Fecha Vencimiento: " + fechaVencimiento);
            contenido.newLine();

            // Añadir más datos de la licencia si es necesario

            contenido.endText();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir en el PDF.", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return;
        }

        // Pedir al usuario dónde guardar el PDF
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Licencia como PDF");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Files", "pdf"));
        int resultado = fileChooser.showSaveDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            if (!archivo.getName().endsWith(".pdf")) {
                archivo = new File(archivo.getAbsolutePath() + ".pdf");
            }

            documento.save(archivo);
            JOptionPane.showMessageDialog(null, "PDF guardado con éxito en:\n" + archivo.getAbsolutePath());
        }

        // Cerrar el documento
        documento.close();
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al generar el PDF.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
}




    public static void mostrarFormularioRegistro(JFrame ventanaAnterior) {
        JFrame ventanaRegistro = new JFrame("Registrar Nueva Licencia");
        ventanaRegistro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaRegistro.setSize(400, 500); // Tamaño ajustado
        ventanaRegistro.setLayout(new GridLayout(8, 2, 10, 10));

        JLabel etiquetaNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField();
        JLabel etiquetaEdad = new JLabel("Edad:");
        JTextField campoEdad = new JTextField();
        JLabel etiquetaCURP = new JLabel("CURP:");
        JTextField campoCURP = new JTextField();
        JLabel etiquetaNacionalidad = new JLabel("Nacionalidad:");
        JTextField campoNacionalidad = new JTextField();
        JLabel etiquetaTipoVehiculo = new JLabel("Tipo Vehículo:");
        JTextField campoTipoVehiculo = new JTextField();
        JLabel etiquetaTipoSangre = new JLabel("Tipo Sangre:");
        JTextField campoTipoSangre = new JTextField();
        JButton botonGuardar = new JButton("Guardar");
        JButton botonRegresar = new JButton("Regresar");

        ventanaRegistro.add(etiquetaNombre);
        ventanaRegistro.add(campoNombre);
        ventanaRegistro.add(etiquetaEdad);
        ventanaRegistro.add(campoEdad);
        ventanaRegistro.add(etiquetaCURP);
        ventanaRegistro.add(campoCURP);
        ventanaRegistro.add(etiquetaNacionalidad);
        ventanaRegistro.add(campoNacionalidad);
        ventanaRegistro.add(etiquetaTipoVehiculo);
        ventanaRegistro.add(campoTipoVehiculo);
        ventanaRegistro.add(etiquetaTipoSangre);
        ventanaRegistro.add(campoTipoSangre);
        ventanaRegistro.add(botonRegresar);
        ventanaRegistro.add(botonGuardar);

        ventanaRegistro.getContentPane().setBackground(Color.cyan); // Fondo negro
        ventanaRegistro.setVisible(true);
        ventanaRegistro.setLocationRelativeTo(null);

        botonGuardar.addActionListener(e -> {
            // Tu lógica para guardar la licencia
             String nombre = campoNombre.getText();
    String edadTexto = campoEdad.getText();
    String curp = campoCURP.getText();
    String nacionalidad = campoNacionalidad.getText();
    String tipoVehiculo = campoTipoVehiculo.getText();
    String tipoSangre = campoTipoSangre.getText();
         // Validación de campos vacíos
    if (nombre.isEmpty() || edadTexto.isEmpty() || curp.isEmpty() || nacionalidad.isEmpty() || tipoVehiculo.isEmpty() || tipoSangre.isEmpty()) {
        JOptionPane.showMessageDialog(ventanaRegistro, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validación de la edad
    int edad;
    try {
        edad = Integer.parseInt(edadTexto);
        if (edad < 17) {
            JOptionPane.showMessageDialog(ventanaRegistro, "No se pueden registrar menores de 17 años.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(ventanaRegistro, "La edad debe ser un número.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Validación del tipo de sangre
    if (!tipoSangre.matches("[A-Za-z+-]{1,3}")) {
        JOptionPane.showMessageDialog(ventanaRegistro, "El tipo de sangre debe ser válido (ej. O+, AB-, etc.).", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Inserción de los datos en la base de datos
        String sql = "INSERT INTO licencias (nombre_apellidos, edad, curp, nacionalidad, tipo_vehiculo, tipo_sangre, fecha_expedicion, fecha_vigencia) " +
                     "VALUES (?, ?, ?, ?, ?, ?, CURDATE(), '2029-12-02')";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, nombre);
        statement.setInt(2, edad);
        statement.setString(3, curp);
        statement.setString(4, nacionalidad);
        statement.setString(5, tipoVehiculo);
        statement.setString(6, tipoSangre);
        statement.executeUpdate();

        JOptionPane.showMessageDialog(ventanaRegistro, "Licencia registrada con éxito.");
        ventanaRegistro.dispose();
        ventanaAnterior.setVisible(true);
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(ventanaRegistro, "Error al guardar la licencia.", "Error", JOptionPane.ERROR_MESSAGE);
    }
});

        botonRegresar.addActionListener(e -> {
            ventanaRegistro.dispose();
            ventanaAnterior.setVisible(true);
        });
    }

   public static void mostrarLicenciasExistentes(JFrame ventanaAnterior) {
    JFrame ventanaLicencias = new JFrame("Licencias Existentes");
    ventanaLicencias.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ventanaLicencias.setSize(800, 400);
    ventanaLicencias.setLocationRelativeTo(null);
    try {
        String sql = "SELECT * FROM licencias";
        Statement statement = conexion.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        String[] columnas = {"No. Licencia", "Nombre", "Edad", "CURP", "Nacionalidad", "Tipo Vehículo", "Tipo Sangre", "Expedición", "Vigencia"};
        ArrayList<String[]> datos = new ArrayList<>();

        while (resultSet.next()) {
            String numeroLicencia = String.valueOf(resultSet.getInt("numero_licencia"));
            String nombre = resultSet.getString("nombre_apellidos");
            String edad = String.valueOf(resultSet.getInt("edad"));
            String curp = resultSet.getString("curp");
            String nacionalidad = resultSet.getString("nacionalidad");
            String tipoVehiculo = resultSet.getString("tipo_vehiculo");
            String tipoSangre = resultSet.getString("tipo_sangre");
            String fechaExpedicion = resultSet.getString("fecha_expedicion");
            String fechaVigencia = resultSet.getString("fecha_vigencia");

            datos.add(new String[]{numeroLicencia, nombre, edad, curp, nacionalidad, tipoVehiculo, tipoSangre, fechaExpedicion, fechaVigencia});
        }

        String[][] datosArray = datos.toArray(new String[0][]);
        JTable tabla = new JTable(datosArray, columnas);
        JScrollPane scrollPane = new JScrollPane(tabla);

        JPanel panelBotones = new JPanel();
        JButton botonEliminar = new JButton("Eliminar");
        JButton botonModificar = new JButton("Modificar");
        JButton botonRegresar = new JButton("Regresar");

        botonEliminar.addActionListener(e -> {
            int filaSeleccionada = tabla.getSelectedRow();
            if (filaSeleccionada != -1) {
                String numeroLicencia = tabla.getValueAt(filaSeleccionada, 0).toString();
                int confirmacion = JOptionPane.showConfirmDialog(ventanaLicencias, "¿Está seguro de eliminar esta licencia?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    eliminarLicencia(numeroLicencia);
                    ((DefaultTableModel) tabla.getModel()).removeRow(filaSeleccionada);
                    JOptionPane.showMessageDialog(ventanaLicencias, "Licencia eliminada exitosamente.");
                }
            } else {
                JOptionPane.showMessageDialog(ventanaLicencias, "Por favor, seleccione una licencia para eliminar.");
            }
        });

        botonModificar.addActionListener(e -> {
            int filaSeleccionada = tabla.getSelectedRow();
            if (filaSeleccionada != -1) {
                String numeroLicencia = tabla.getValueAt(filaSeleccionada, 0).toString();
                mostrarFormularioModificar(numeroLicencia, ventanaLicencias);
            } else {
                JOptionPane.showMessageDialog(ventanaLicencias, "Por favor, seleccione una licencia para modificar.");
            }
        });

        botonRegresar.addActionListener(e -> {
            ventanaLicencias.dispose();
            ventanaAnterior.setVisible(true);
        });

        panelBotones.add(botonEliminar);
        panelBotones.add(botonModificar);
        panelBotones.add(botonRegresar);

        ventanaLicencias.setLayout(new BorderLayout());
        ventanaLicencias.add(scrollPane, BorderLayout.CENTER);
        ventanaLicencias.add(panelBotones, BorderLayout.SOUTH);

        ventanaLicencias.setVisible(true);
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al obtener licencias.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private static void eliminarLicencia(String numeroLicencia) {
    try {
        String sql = "DELETE FROM licencias WHERE numero_licencia = ?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, numeroLicencia);
        statement.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al eliminar la licencia.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

public static void mostrarLicenciasExistentes(JFrame ventanaAnterior, String tipoUsuario) {

    JFrame ventanaLicencias = new JFrame("Licencias Existentes");

    ventanaLicencias.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    ventanaLicencias.setSize(800, 400);

    ventanaLicencias.setLocationRelativeTo(null);



    try {

        String sql = "SELECT * FROM licencias";

        Statement statement = conexion.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);



        String[] columnas = {"No. Licencia", "Nombre", "Edad", "CURP", "Nacionalidad", "Tipo Vehículo", "Tipo Sangre", "Expedición", "Vigencia"};

        ArrayList<String[]> datos = new ArrayList<>();



        while (resultSet.next()) {

            String numeroLicencia = String.valueOf(resultSet.getInt("numero_licencia"));

            String nombre = resultSet.getString("nombre_apellidos");

            String edad = String.valueOf(resultSet.getInt("edad"));

            String curp = resultSet.getString("curp");

            String nacionalidad = resultSet.getString("nacionalidad");

            String tipoVehiculo = resultSet.getString("tipo_vehiculo");

            String tipoSangre = resultSet.getString("tipo_sangre");

            String fechaExpedicion = resultSet.getString("fecha_expedicion");

            String fechaVigencia = resultSet.getString("fecha_vigencia");



            datos.add(new String[]{numeroLicencia, nombre, edad, curp, nacionalidad, tipoVehiculo, tipoSangre, fechaExpedicion, fechaVigencia});

        }



        String[][] datosArray = datos.toArray(new String[0][]);

        JTable tabla = new JTable(datosArray, columnas);

        JScrollPane scrollPane = new JScrollPane(tabla);



        JPanel panelBotones = new JPanel();

        JButton botonEliminar = new JButton("Eliminar");

        JButton botonModificar = new JButton("Modificar");

        JButton botonRegresar = new JButton("Regresar");



        // Validar si el usuario es administrador

        if ("administrador".equals(tipoUsuario)) {

            botonEliminar.addActionListener(e -> {

                int filaSeleccionada = tabla.getSelectedRow();

                if (filaSeleccionada != -1) {

                    String numeroLicencia = tabla.getValueAt(filaSeleccionada, 0).toString();

                    int confirmacion = JOptionPane.showConfirmDialog(ventanaLicencias, "¿Está seguro de eliminar esta licencia?", "Confirmación", JOptionPane.YES_NO_OPTION);

                    if (confirmacion == JOptionPane.YES_OPTION) {

                        eliminarLicencia(numeroLicencia);

                        ((DefaultTableModel) tabla.getModel()).removeRow(filaSeleccionada);

                        JOptionPane.showMessageDialog(ventanaLicencias, "Licencia eliminada exitosamente.");

                    }

                } else {

                    JOptionPane.showMessageDialog(ventanaLicencias, "Por favor, seleccione una licencia para eliminar.");

                }

            });



            botonModificar.addActionListener(e -> {

                int filaSeleccionada = tabla.getSelectedRow();

                if (filaSeleccionada != -1) {

                    String numeroLicencia = tabla.getValueAt(filaSeleccionada, 0).toString();

                    mostrarFormularioModificar(numeroLicencia, ventanaLicencias);

                } else {

                    JOptionPane.showMessageDialog(ventanaLicencias, "Por favor, seleccione una licencia para modificar.");

                }

            });



            panelBotones.add(botonEliminar);

            panelBotones.add(botonModificar);

        } else {

            JLabel etiquetaRestriccion = new JLabel("* Solo los administradores pueden eliminar o modificar licencias.");

            etiquetaRestriccion.setForeground(Color.RED);

            panelBotones.add(etiquetaRestriccion);

        }



        botonRegresar.addActionListener(e -> {

            ventanaLicencias.dispose();

            ventanaAnterior.setVisible(true);

        });



        panelBotones.add(botonRegresar);



        ventanaLicencias.setLayout(new BorderLayout());

        ventanaLicencias.add(scrollPane, BorderLayout.CENTER);

        ventanaLicencias.add(panelBotones, BorderLayout.SOUTH);



        ventanaLicencias.setVisible(true);

    } catch (SQLException ex) {

        ex.printStackTrace();

        JOptionPane.showMessageDialog(null, "Error al obtener licencias.", "Error", JOptionPane.ERROR_MESSAGE);

    }

}

    private static void mostrarFormularioModificar(String numeroLicencia, JFrame ventanaAnterior) {
    JFrame ventanaModificar = new JFrame("Modificar Licencia");
    ventanaModificar.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    ventanaModificar.setSize(400, 500);
    ventanaModificar.setLayout(new GridLayout(8, 2, 10, 10));

    JLabel etiquetaNombre = new JLabel("Nombre:");
    JTextField campoNombre = new JTextField();
    JLabel etiquetaEdad = new JLabel("Edad:");
    JTextField campoEdad = new JTextField();
    JLabel etiquetaCURP = new JLabel("CURP:");
    JTextField campoCURP = new JTextField();
    JLabel etiquetaNacionalidad = new JLabel("Nacionalidad:");
    JTextField campoNacionalidad = new JTextField();
    JLabel etiquetaTipoVehiculo = new JLabel("Tipo Vehículo:");
    JTextField campoTipoVehiculo = new JTextField();
    JLabel etiquetaTipoSangre = new JLabel("Tipo Sangre:");
    JTextField campoTipoSangre = new JTextField();
    JButton botonGuardar = new JButton("Guardar");
    JButton botonCancelar = new JButton("Cancelar");

    // Cargar datos actuales
    try {
        String sql = "SELECT * FROM licencias WHERE numero_licencia = ?";
        PreparedStatement statement = conexion.prepareStatement(sql);
        statement.setString(1, numeroLicencia);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            campoNombre.setText(resultSet.getString("nombre_apellidos"));
            campoEdad.setText(String.valueOf(resultSet.getInt("edad")));
            campoCURP.setText(resultSet.getString("curp"));
            campoNacionalidad.setText(resultSet.getString("nacionalidad"));
            campoTipoVehiculo.setText(resultSet.getString("tipo_vehiculo"));
            campoTipoSangre.setText(resultSet.getString("tipo_sangre"));
        } else {
            JOptionPane.showMessageDialog(ventanaModificar, "Licencia no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(ventanaModificar, "Error al cargar datos de la licencia.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Agregar campos al formulario
    ventanaModificar.add(etiquetaNombre);
    ventanaModificar.add(campoNombre);
    ventanaModificar.add(etiquetaEdad);
    ventanaModificar.add(campoEdad);
    ventanaModificar.add(etiquetaCURP);
    ventanaModificar.add(campoCURP);
    ventanaModificar.add(etiquetaNacionalidad);
    ventanaModificar.add(campoNacionalidad);
    ventanaModificar.add(etiquetaTipoVehiculo);
    ventanaModificar.add(campoTipoVehiculo);
    ventanaModificar.add(etiquetaTipoSangre);
    ventanaModificar.add(campoTipoSangre);
    ventanaModificar.add(botonCancelar);
    ventanaModificar.add(botonGuardar);

    // Acción para guardar los cambios
    botonGuardar.addActionListener(e -> {
        try {
            String sql = "UPDATE licencias SET nombre_apellidos = ?, edad = ?, curp = ?, nacionalidad = ?, tipo_vehiculo = ?, tipo_sangre = ? WHERE numero_licencia = ?";
            PreparedStatement statement = conexion.prepareStatement(sql);
            statement.setString(1, campoNombre.getText());
            statement.setInt(2, Integer.parseInt(campoEdad.getText()));
            statement.setString(3, campoCURP.getText());
            statement.setString(4, campoNacionalidad.getText());
            statement.setString(5, campoTipoVehiculo.getText());
            statement.setString(6, campoTipoSangre.getText());
            statement.setString(7, numeroLicencia);

            statement.executeUpdate();

            JOptionPane.showMessageDialog(ventanaModificar, "Licencia modificada exitosamente.");
            ventanaModificar.dispose();
            ventanaAnterior.setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(ventanaModificar, "Error al modificar la licencia.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(ventanaModificar, "Por favor, ingrese datos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    });

    // Acción para cancelar la modificación
    botonCancelar.addActionListener(e -> {
        ventanaModificar.dispose();
        ventanaAnterior.setVisible(true);
    });

    ventanaModificar.setVisible(true);
}}