# sistema-licensias
DESCRIPCION DEL PROYECTO: 
Mi proyecto consiste en el desarrollo de una página web diseñada para facilitar y agilizar 
los trámites relacionados con la obtención, renovación o reposición de licencias. El 
objetivo principal es proporcionar una plataforma intuitiva y accesible que permita a los 
usuarios realizar estos trámites de manera eficiente, reduciendo el tiempo de espera y 
mejorando la experiencia del usuario. 
El sistema incluye funcionalidades clave como: 

• Registro y autenticación de usuarios para garantizar la seguridad de los datos. 

• Formularios dinámicos para capturar la información requerida según el tipo de 
trámite. 

• Integración con bases de datos para almacenar y gestionar los registros de los 
solicitantes. 

• Interfaz amigable y responsiva, optimizada para dispositivos móviles y de 
escritorio. 

El desarrollo del proyecto se realizó utilizando tecnologías como Apache Netbeans. 
Además, se implementaron buenas prácticas de desarrollo web y seguridad para proteger 
los datos personales de los usuarios. 
Este proyecto busca simplificar procesos administrativos tradicionales, promoviendo la 
digitalización y mejorando la accesibilidad a servicios esenciales.

![image](https://github.com/user-attachments/assets/d606da65-5ac3-41c7-a3d8-e970dcd860d2)

en el apartado de menu tenemos la opcion de administrador y usuarios los usuarios pueden crear sus licensias y solo eso 

![image](https://github.com/user-attachments/assets/4226f48b-6472-41e2-bdce-92558a83bc02)

mientras que el administrador 
![image](https://github.com/user-attachments/assets/71326e11-d78e-49da-bf46-8aa6c40e18e4)

tendra que iniciar sesion asi mismo este tendra las siguientes funciones 

![image](https://github.com/user-attachments/assets/ef74f663-3f9c-4369-a82a-1eb232e9d655)

como administrador tambien podra crear lisensias y ver las licensias creadas 

![image](https://github.com/user-attachments/assets/7b9703d5-aace-4b3a-88d0-9298a309af52)

![image](https://github.com/user-attachments/assets/86d8a4aa-4fd8-41aa-b93b-24de7eaff330)

tambien tendra la funcion de modificar y eliminar las licensias 

![image](https://github.com/user-attachments/assets/9ae78c8d-eb2c-4e8b-b012-84a027076c52)



a demas de que tendra la funcion de descargar las licensias en formato de pdf 

![Imagen de WhatsApp 2024-12-18 a las 01 30 40_388ccc8f](https://github.com/user-attachments/assets/ae436fdc-cfbd-4e04-83ca-3903ba4a42b6)

en este caso nuestra base de datos usamos una coneccion hacia el sql 

![image](https://github.com/user-attachments/assets/cbf26124-d7e2-4101-bdbd-b8921a3fa5a5)

en donde se iran guardando las lisensias creadas 

![image](https://github.com/user-attachments/assets/975eb226-706b-41ed-92fe-142784e8c51c)


CLASES DEL PRYECTO

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


Este metodo lo que hace es que muestra la ventana de donde debemos de iniciar sesion como administrador o usuario



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

    CODIGO PARA LA CONEXION DE LA BASE DE DATOS, ESTA CLASE HACE QUE NUESTROS REGISTROS SE GUARDEN EN UNA BASE DE DATOS


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
  METODO PARA MOSTRAR EL MENU DEPENDIENDO DE LA OPCION QUE HAYA ELEGIDO EL USUARIO



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

    String remitente = "fl9840856@gmail.com";
    String contraseña = "ahop zirn xora orlx"; // Si usas una contraseña de aplicación, cámbiala aquí

    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true"); // O usa 465 y "mail.smtp.ssl.enable" para SSL

    Session session = Session.getInstance(props, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(remitente, contraseña);
        }
    });

    try {
        session.setDebug(true); // Habilitar depuración
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(remitente));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        message.setSubject("Archivo adjunto");

        // Verificar archivo
        if (archivoAdjunto == null || !archivoAdjunto.exists()) {
            JOptionPane.showMessageDialog(null, "El archivo no existe.");
            return;
        }

        // Contenido del correo
        MimeBodyPart parteTexto = new MimeBodyPart();
        parteTexto.setText("Adjunto el archivo solicitado.");

        MimeBodyPart parteAdjunto = new MimeBodyPart();
        parteAdjunto.attachFile(archivoAdjunto);

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(parteTexto);
        multipart.addBodyPart(parteAdjunto);

        message.setContent(multipart);

        // Enviar correo
        Transport.send(message);
        JOptionPane.showMessageDialog(null, "Correo enviado exitosamente con el archivo adjunto.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al enviar el correo: " + e.getMessage());
        e.printStackTrace(); // Para depurar la excepción con más detalles
    }
}

METODO PARA PODER ENVIAR EL CORREO AL CLIENTE DE SU LICENCIA


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

                // Seleccionar foto
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Seleccionar Foto del Conductor");
                int resultado = fileChooser.showOpenDialog(null);
                File foto = null;
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    foto = fileChooser.getSelectedFile();
                }

                // Generar PDF para la licencia seleccionada
                generarPDFLicencia(numeroLicencia, nombreLicencia, edad, curp, nacionalidad, tipoVehiculo, tipoSangre, fechaExpedicion, fechaVigencia, foto);
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
                                      String curp, String nacionalidad, String tipoVehiculo,
                                      String tipoSangre, String fechaExpedicion, String fechaVencimiento,
                                      File foto) {
    try {
        // Crear un documento PDF
        PDDocument documento = new PDDocument();
        PDPage pagina = new PDPage(PDRectangle.A4);
        documento.addPage(pagina);

        // Cargar fuente personalizada
        File archivoFuente = new File("C:\\Windows\\Fonts\\Arial.ttf");
        if (!archivoFuente.exists()) {
            JOptionPane.showMessageDialog(null, "No se encontró la fuente Arial.ttf en la ruta especificada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        PDFont fuente = PDType0Font.load(documento, archivoFuente);

        // Cargar imagen de la foto (si existe)
        PDImageXObject imagenFoto = null;
        if (foto != null && foto.exists()) {
            imagenFoto = PDImageXObject.createFromFileByExtension(foto, documento);
        }

        // Crear el contenido de la licencia
        try (PDPageContentStream contenido = new PDPageContentStream(documento, pagina)) {
            // Borde o marco principal
            contenido.addRect(30, 645, 535, 180); // Ajuste del cuadro principal
            contenido.stroke();

            // Foto del conductor (opcional)
            if (imagenFoto != null) {
                contenido.drawImage(imagenFoto, 40, 700, 100, 100); // Posición y tamaño de la foto
            }

            // Encabezado
            contenido.beginText();
            contenido.setFont(fuente, 16);
            contenido.newLineAtOffset(150, 800); // Posición del encabezado
            contenido.showText("LICENCIA DE CONDUCIR");
            contenido.endText();

            // Información de la licencia
            contenido.beginText();
            contenido.setFont(fuente, 12);
            contenido.setLeading(14.5f);
            contenido.newLineAtOffset(150, 770); // Ajustar posición inicial del texto
            contenido.showText("Licencia No.: " + numeroLicencia);
            contenido.newLine();
            contenido.showText("Nombre: " + nombreLicencia);
            contenido.newLine();
            contenido.showText("Edad: " + edad + " años");
            contenido.newLine();
            contenido.showText("CURP: " + curp);
            contenido.newLine();
            contenido.showText("Nacionalidad: " + nacionalidad);
            contenido.newLine();
            contenido.showText("Tipo de Vehículo: " + tipoVehiculo);
            contenido.newLine();
            contenido.showText("Tipo de Sangre: " + tipoSangre);
            contenido.newLine();
            contenido.showText("Fecha de Expedición: " + fechaExpedicion);
            contenido.newLine();
            contenido.showText("Fecha de Vencimiento: " + fechaVencimiento);
            contenido.endText();

            // Descripción adicional debajo del cuadro
            contenido.beginText();
            contenido.setFont(fuente, 10);
            contenido.newLineAtOffset(30, 620); // Posición para la descripción
            contenido.showText("Licensuper licencias activa, gobierno del estado de Oaxaca");
            contenido.endText();
        }

        // Guardar el archivo PDF
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar Licencia como PDF");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Archivos PDF", "pdf"));
        int resultado = fileChooser.showSaveDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = fileChooser.getSelectedFile();
            if (!archivo.getName().endsWith(".pdf")) {
                archivo = new File(archivo.getAbsolutePath() + ".pdf");
            }

            documento.save(archivo);
            JOptionPane.showMessageDialog(null, "PDF guardado con éxito en:\n" + archivo.getAbsolutePath());
        }

        documento.close();
    } catch (IOException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Error al generar el PDF.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

ESTE METODO LO QUE HACE ES QUE TE DEJA VER LOS REGISTROS EN PDF PARA QUE SE PUEDAN DESCARGAR
  
