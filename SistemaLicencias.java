        
/**
 *
 * @author alexv
 */

   import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SistemaLicencias {

  
    private static ArrayList<Licencia> listaLicencias = new ArrayList<>();

    public static void main(String[] args) {
        
        JFrame ventanaLogin = new JFrame("Sistema de Licencias - Inicio de Sesión");
        ventanaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaLogin.setSize(400, 200);
        ventanaLogin.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        
        JLabel etiquetaUsuario = new JLabel("Usuario:");
        JTextField campoUsuario = new JTextField(15);

        
        JLabel etiquetaContrasena = new JLabel("Contraseña:");
        JPasswordField campoContrasena = new JPasswordField(15);

       
        JButton botonLogin = new JButton("Iniciar Sesión");

       
        gbc.gridx = 0; gbc.gridy = 0;
        ventanaLogin.add(etiquetaUsuario, gbc);
        gbc.gridx = 1; gbc.gridy = 0;
        ventanaLogin.add(campoUsuario, gbc);
        gbc.gridx = 0; gbc.gridy = 1;
        ventanaLogin.add(etiquetaContrasena, gbc);
        gbc.gridx = 1; gbc.gridy = 1;
        ventanaLogin.add(campoContrasena, gbc);
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        ventanaLogin.add(botonLogin, gbc);

        
        ventanaLogin.setVisible(true);

        
        botonLogin.addActionListener(e -> {
            
            String usuarioAdmin = "equipo6";
            String contrasenaAdmin = "12345";

            
            String usuario = campoUsuario.getText();
            String contrasena = new String(campoContrasena.getPassword());

           
            if (usuario.equals(usuarioAdmin) && contrasena.equals(contrasenaAdmin)) {
                JOptionPane.showMessageDialog(ventanaLogin, "Inicio de sesión exitoso.");
                ventanaLogin.dispose(); // Cerrar ventana de login
                mostrarMenuPrincipal();
            } else {
                JOptionPane.showMessageDialog(ventanaLogin, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void mostrarMenuPrincipal() {
        
        JFrame ventanaMenu = new JFrame("Menú Principal - Sistema de Licencias");
        ventanaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaMenu.setSize(400, 300);
        ventanaMenu.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        // Botones en panel menú
        JButton botonRegistrar = new JButton("Registrar Nueva Licencia");
        JButton botonVer = new JButton("Ver Licencias Existentes");
        JButton botonSalir = new JButton("Salir");

        
        ventanaMenu.add(botonRegistrar);
        ventanaMenu.add(botonVer);
        ventanaMenu.add(botonSalir);

        
        ventanaMenu.setVisible(true);

        
        botonRegistrar.addActionListener(e -> mostrarFormularioRegistro(ventanaMenu));
        botonVer.addActionListener(e -> mostrarLicenciasExistentes(ventanaMenu));
        botonSalir.addActionListener(e -> {
            ventanaMenu.dispose();
            JOptionPane.showMessageDialog(null, "Saliendo del sistema. ¡Hasta luego!");
        });
    }

    public static void mostrarFormularioRegistro(JFrame ventanaAnterior) {
        
        JFrame ventanaRegistro = new JFrame("Registrar Nueva Licencia");
        ventanaRegistro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaRegistro.setSize(400, 450);
        ventanaRegistro.setLayout(new GridLayout(7, 2, 10, 10));

        
        JLabel etiquetaNombre = new JLabel("Nombre:");
        JTextField campoNombre = new JTextField();
        JLabel etiquetaEdad = new JLabel("Edad:");
        JTextField campoEdad = new JTextField();
        JLabel etiquetaCiudad = new JLabel("Ciudad:");
        JTextField campoCiudad = new JTextField();
        JLabel etiquetaFolio = new JLabel("Folio:");
        JTextField campoFolio = new JTextField();
        JLabel etiquetaCorreo = new JLabel("Correo:");
        JTextField campoCorreo = new JTextField();
        JButton botonGuardar = new JButton("Guardar");
        JButton botonRegresar = new JButton("Regresar");

        
        ventanaRegistro.add(etiquetaNombre);
        ventanaRegistro.add(campoNombre);
        ventanaRegistro.add(etiquetaEdad);
        ventanaRegistro.add(campoEdad);
        ventanaRegistro.add(etiquetaCiudad);
        ventanaRegistro.add(campoCiudad);
        ventanaRegistro.add(etiquetaFolio);
        ventanaRegistro.add(campoFolio);
        ventanaRegistro.add(etiquetaCorreo);
        ventanaRegistro.add(campoCorreo);
        ventanaRegistro.add(botonRegresar);
        ventanaRegistro.add(botonGuardar);

       
        ventanaRegistro.setVisible(true);

       
        botonGuardar.addActionListener(e -> {
            String nombre = campoNombre.getText();
            String edad = campoEdad.getText();
            String ciudad = campoCiudad.getText();
            String folio = campoFolio.getText();
            String correo = campoCorreo.getText();

            if (nombre.isEmpty() || edad.isEmpty() || ciudad.isEmpty() || folio.isEmpty() || correo.isEmpty()) {
                JOptionPane.showMessageDialog(ventanaRegistro, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                listaLicencias.add(new Licencia(nombre, edad, ciudad, folio, correo));
                JOptionPane.showMessageDialog(ventanaRegistro, "Licencia registrada con éxito.");
                ventanaRegistro.dispose();
                ventanaAnterior.setVisible(true);
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
    ventanaLicencias.setSize(600, 400);

   
    String[] columnas = {"Nombre", "Edad", "Ciudad", "Folio", "Correo"};
    String[][] datos = new String[listaLicencias.size()][5];

    for (int i = 0; i < listaLicencias.size(); i++) {
        Licencia licencia = listaLicencias.get(i);
        datos[i][0] = licencia.getNombre();
        datos[i][1] = licencia.getEdad();
        datos[i][2] = licencia.getCiudad();
        datos[i][3] = licencia.getFolio();
        datos[i][4] = licencia.getCorreo();
    }

    JTable tablaLicencias = new JTable(datos, columnas);
    JScrollPane scrollPane = new JScrollPane(tablaLicencias);
    
    
    JButton botonRegresar = new JButton("Regresar");
    botonRegresar.setPreferredSize(new Dimension(100, 30)); // Tamaño personalizado

   
    ventanaLicencias.setLayout(new BorderLayout());
    ventanaLicencias.add(scrollPane, BorderLayout.CENTER);

    
    JPanel panelInferior = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    panelInferior.add(botonRegresar);
    ventanaLicencias.add(panelInferior, BorderLayout.SOUTH);

    
    ventanaLicencias.setVisible(true);

    
    botonRegresar.addActionListener(e -> {
        ventanaLicencias.dispose();
        ventanaAnterior.setVisible(true);
    });
}

    static class Licencia {
        private String nombre, edad, ciudad, folio, correo;

        public Licencia(String nombre, String edad, String ciudad, String folio, String correo) {
            this.nombre = nombre;
            this.edad = edad;
            this.ciudad = ciudad;
            this.folio = folio;
            this.correo = correo;
        }

        public String getNombre() { return nombre; }
        public String getEdad() { return edad; }
        public String getCiudad() { return ciudad; }
        public String getFolio() { return folio; }
        public String getCorreo() { return correo; }
    }
}