import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;

public class GUIpatata extends JFrame implements ActionListener{

    private GestionEstudianUpeu gestionEstudianUpeu = new GestionEstudianUpeu();

    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField codigoField;
    private JTextArea outputArea;


    private JLabel nombreLabel;
    private JLabel apellidoLabel;
    private JLabel codigoLabel;

    private JButton agregaButton;
    private JButton actulizarButton;
    private JButton eliminarButton;
    

    GUIpatata(){
       ImageIcon icon = new ImageIcon("UPEUs.png");
     
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Registro de estudiantes UpeU");
        this.setSize(450,550);
        this.setLayout(null);
        this.setVisible(true);
        this.setIconImage(icon.getImage());

        this.getContentPane().setBackground(new ColorUIResource(12, 44, 99));


    nombreLabel = new JLabel("Nombre: ");
    nombreLabel.setBounds(20, 20, 80,25);
    this.add(nombreLabel);
    nombreLabel.setForeground(new Color(0x00FF00));

    nombreField = new JTextField();
    nombreField.setBounds(100,20,200,25);
    this.add(nombreField);
    nombreField.setFont(new Font("Consolas", Font.PLAIN,20));
    nombreField.setForeground(new Color(0x00FF00));
    nombreField.setBackground(Color.BLACK);
    nombreField.setCaretColor(Color.white);

    apellidoLabel = new JLabel("Apellido: ");
    apellidoLabel.setBounds(20,60,80,25);
    this.add(apellidoLabel);
    apellidoLabel.setForeground(new Color(0x00FF00));

    apellidoField = new JTextField();
    apellidoField.setBounds(100,60,200,25);
    this.add(apellidoField);
    apellidoField.setFont(new Font("Consolas", Font.PLAIN,20));
    apellidoField.setForeground(new Color(0x00FF00));
    apellidoField.setBackground(Color.BLACK);
    apellidoField.setCaretColor(Color.white);

    codigoLabel = new JLabel("Coddigo: ");
    codigoLabel.setBounds(20,100,80,25);
    this.add(codigoLabel);
    codigoLabel.setForeground(new Color(0x00FF00));

    codigoField = new JTextField();
    codigoField.setBounds(100, 100, 200, 25);;
    this.add(codigoField);
    codigoField.setFont(new Font("Consolas", Font.PLAIN,20));
    codigoField.setForeground(new Color(0x00FF00));
    codigoField.setBackground(Color.BLACK);
    codigoField.setCaretColor(Color.white);

//-------------
    agregaButton = new JButton("Agregar");
    agregaButton.setBounds(50,150,100,25);
    this.add(agregaButton);

    actulizarButton = new JButton("Actulizar");
    actulizarButton.setBounds(160,150,100,25);
    this.add(actulizarButton);

    eliminarButton = new JButton("Eliminar");
    eliminarButton.setBounds(270, 150, 100, 25);
    this.add(eliminarButton);
//-----------------
    outputArea = new JTextArea();
    outputArea.setBounds(20, 200, 350, 200);
    outputArea.setEditable(false);
    this.add(outputArea);


//----------------
 agregaButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            agregarEstudiante();
        } catch (Exception ex) {
           
           JOptionPane.showMessageDialog(null, "Error al agregar estudiante: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});

actulizarButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            actualizarEstudiante();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar estudiante: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});

eliminarButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            eliminarEstudiante();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar estudiante: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});
}

private void agregarEstudiante() {
try {
    String nombre = nombreField.getText();
    String apellido = apellidoField.getText();
    int codigo = Integer.parseInt(codigoField.getText());

    if (nombre.isEmpty() || apellido.isEmpty()) {
        throw new IllegalArgumentException("Nombre y Apellido no pueden estar vacíos.");
    }

    gestionEstudianUpeu.agregarEstudiante(nombre, apellido, codigo);
    mostrarEstudiantes();
    limpiarCampos();
    JOptionPane.showMessageDialog(null, "Estudiante agregado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
} catch (NumberFormatException e) {
    throw new IllegalArgumentException("El código debe ser un número válido.");
}
}

private void actualizarEstudiante() {
try {
    String nombre = nombreField.getText();
    String apellido = apellidoField.getText();
    int codigo = Integer.parseInt(codigoField.getText());

    if (gestionEstudianUpeu.UpeuStudent.isEmpty()) {
        throw new IllegalArgumentException("No hay estudiantes para actualizar.");
    }

    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del estudiante a actualizar:"));
    gestionEstudianUpeu.actualizarEstudiante(id, nombre, apellido, codigo);
    mostrarEstudiantes();
    limpiarCampos();
    JOptionPane.showMessageDialog(null, "Estudiante actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
} catch (NumberFormatException e) {
    throw new IllegalArgumentException("El código o ID debe ser un número válido.");
}
}

private void eliminarEstudiante() {
try {
    if (gestionEstudianUpeu.UpeuStudent.isEmpty()) {
        throw new IllegalArgumentException("No hay estudiantes para eliminar.");
    }

    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del estudiante a eliminar:"));
    gestionEstudianUpeu.eliminarEstudiante(id);
    mostrarEstudiantes();
    limpiarCampos();
    JOptionPane.showMessageDialog(null, "Estudiante eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
} catch (NumberFormatException e) {
    throw new IllegalArgumentException("El ID debe ser un número válido.");
}
}

private void mostrarEstudiantes() {
outputArea.setText(""); 
for (EstudianteUpeu estudiante : gestionEstudianUpeu.UpeuStudent) {
    outputArea.append(estudiante.toString() + "\n");
}
}

private void limpiarCampos() {
nombreField.setText("");
apellidoField.setText("");
codigoField.setText("");
}




    


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

public static void main(String[] args) {
    GUIpatata guIpatata = new GUIpatata();
}





    
}
