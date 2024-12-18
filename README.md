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



  
