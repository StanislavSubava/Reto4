package Ventanas;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ModeloMysql.conexionMYSQL;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class VentanaRegistro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JTextField textNom;
    public JTextField textApe;
    public JTextField textUser;
    public JTextField textFechNa;
    public JTextField textFechIns;
    public JPasswordField textContra;
    public JPasswordField textRContra;
    private JLabel lblPremium;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaRegistro frame = new VentanaRegistro();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VentanaRegistro() {
        super("Ventana Registro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 706, 626);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(10, 11, 670, 565);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnAtras = new JButton("Atras");
        btnAtras.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                VentanaLogin obj = new VentanaLogin();
                obj.setVisible(true);
                dispose();
            }

        });
        btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAtras.setBounds(10, 11, 137, 37);
        panel.add(btnAtras);
        setVisible(true);

        JLabel lblNewLabel = new JLabel("Nombre");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(50, 73, 111, 28);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Usuario");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(175, 127, 111, 28);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Contraseña");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(50, 173, 111, 28);
        panel.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Repetir Contraseña");
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_3.setBounds(336, 166, 162, 43);
        panel.add(lblNewLabel_3);
//Las fechas tienen un parametro enconcreto - o /
        JLabel lblNewLabel_4 = new JLabel("Fecha de nacimiento");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_4.setBounds(50, 242, 162, 28);
        panel.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Fecha de inscripcion");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_5.setBounds(50, 291, 162, 28);
        panel.add(lblNewLabel_5);

        textNom = new JTextField();
        textNom.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textNom.setBounds(157, 73, 169, 28);
        panel.add(textNom);
        textNom.setColumns(10);

        JLabel lblNewLabel_8 = new JLabel("Apellido");
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_8.setBounds(336, 73, 129, 28);
        panel.add(lblNewLabel_8);

        textApe = new JTextField();
        textApe.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textApe.setColumns(10);
        textApe.setBounds(450, 72, 188, 28);
        panel.add(textApe);

        textUser = new JTextField();
        textUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textUser.setColumns(10);
        textUser.setBounds(279, 126, 169, 28);
        panel.add(textUser);

        textFechNa = new JTextField();
        textFechNa.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textFechNa.setColumns(10);
        textFechNa.setBounds(222, 242, 169, 28);
        panel.add(textFechNa);

        textFechIns = new JTextField();
        textFechIns.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textFechIns.setColumns(10);
        textFechIns.setBounds(232, 290, 169, 28);
        panel.add(textFechIns);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String contraseña = new String(textContra.getPassword());
                String repContraseña = new String(textRContra.getPassword());
                String sentencia = "INSERT INTO clientes(Nombre, Apellido, UsuarioCliente, ContraseñaCliente, repContraseñaCliente, FechaNacimiento, FechaRegistro) VALUES (?, ?, ?, ?, ?, ?, ?)";
                String textMal = "Hay errores a la hora de meter los datos en la base de datos";
                String nombre = textNom.getText();
                String apellido = textApe.getText();
                String usuario = textUser.getText();
                String fechNacimiento = textFechNa.getText();
                String fechInscripcion = textFechIns.getText();


                if(nombre.isEmpty() || apellido.isEmpty()  || usuario.isEmpty() || contraseña.isEmpty() || repContraseña.isEmpty()
                	||	fechNacimiento.isEmpty() || fechInscripcion.isEmpty())
                {
                    JOptionPane.showMessageDialog(null, "Campos Vacios,Porfavor Rellene todos los Campos");
                    return;} else {}


                    // Verificar si ya existe un usuario con el mismo nombre de usuario
                    String verificarUsuarioQuery = "SELECT * FROM clientes WHERE UsuarioCliente = ?";
                    try {
                        Connection connection = conexionMYSQL.metodoConexion();
                    PreparedStatement verificarUsuarioStmt = connection.prepareStatement(verificarUsuarioQuery);
                    verificarUsuarioStmt.setString(1, textUser.getText());
                    ResultSet resultSet = verificarUsuarioStmt.executeQuery();
                  
                    if (resultSet.next()) {
                        JOptionPane.showMessageDialog(null, "Ya existe un usuario con el mismo nombre de usuario");
                        textUser.setText(""); // Vaciar el campo de usuario
                        return; // Salir del método si ya existe un usuario con el mismo nombre de usuario
                    }

                    PreparedStatement st = connection.prepareStatement(sentencia);

                 
                    st.setString(1, nombre);
                    st.setString(2, apellido);
                    st.setString(3, usuario);
                    st.setString(4, contraseña);
                    st.setString(5, repContraseña);
                    st.setString(6, fechNacimiento);
                    st.setString(7, fechInscripcion);

                    int rowsAffected = st.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, null);
                    	VentanaLogin obj = new VentanaLogin();
        				System.out.println(obj);
        				dispose();

                        if (lblPremium.isVisible()) {
                            String sentencia2 = "UPDATE clientes SET Tipo='Premium' WHERE Usuario = ?";

                            PreparedStatement st2 = connection.prepareStatement(sentencia2);
                            st2.setString(1, usuario);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, textMal);
                    }

                    String contr = new String(textContra.getPassword());
                    String repContr = new String(textRContra.getPassword());

                    if (!contr.equals(repContr)) {
                        JOptionPane.showMessageDialog(null, "Error al poner o repetir la Contraseña");
                        textRContra.setText("");
                    }
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat sdfDB = new SimpleDateFormat("yyyy-MM-dd");

                    try {
                        Date fechanacimiento = sdf.parse(fechNacimiento);
                        Date fechaInscripcion = sdf.parse(fechInscripcion);
                        String fechaNacimientoDB = sdf.format(fechanacimiento);
                        String fechaInscripcionDB = sdfDB.format(fechaInscripcion);
                    } catch (ParseException e1) {
                        e1.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al parsear la fecha: " + e1.getMessage());
                    }

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            }
        });
        btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnGuardar.setBounds(136, 487, 162, 53);
        panel.add(btnGuardar);

        JButton btnPremium = new JButton("Premium");
        btnPremium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                lblPremium.setVisible(!lblPremium.isVisible());

            }
        });
        btnPremium.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnPremium.setBounds(402, 487, 162, 53);
        panel.add(btnPremium);

        textContra = new JPasswordField();
        textContra.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textContra.setBounds(157, 176, 169, 28);
        panel.add(textContra);

        textRContra = new JPasswordField();
        textRContra.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textRContra.setBounds(501, 172, 169, 28);
        panel.add(textRContra);

        lblPremium = new JLabel("Cuenta Premium");
        lblPremium.setIcon(new ImageIcon("fondolog.jpg"));
        //lblPremium.setIcon(new ImageIcon("C:\\Users\\in1dm3\\Desktop\\xxx\\Reto4_Grupo7\\src\\Img\\corona.jpg"));
        lblPremium.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPremium.setHorizontalAlignment(SwingConstants.CENTER);
        lblPremium.setBounds(388, 400, 176, 81);
        panel.add(lblPremium);
        lblPremium.setVisible(false);
    }
}
