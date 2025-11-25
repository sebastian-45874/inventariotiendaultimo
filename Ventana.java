import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField txtId;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JButton btnAgregar;
    private JList lstListado;
    private JButton btnBuscar;
    private JList lstOrdenar;
    private JButton btnOrdenar;
    private JList lstOrdenarID;
    private JButton btnOrdenarID;
    private JTextField txtID2;
    private JButton btnBuscarID;
    private JTextField txtNombre2;
    private JButton btnBuscarNombre;
    private JSpinner spnID;

    int codigo=5;
    InventarioProductos inventario=new InventarioProductos();

    public void llenarJList(){
        DefaultListModel dlm=new DefaultListModel<>();
        for(Producto producto:inventario.getInventario()){
            dlm.addElement(producto);
        }
        lstListado.setModel(dlm);
    }

    public Ventana() {
        llenarJList();
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id=Integer.parseInt(spnID.getValue().toString());
                String nombre=txtNombre.getText();
                double precio= Double.parseDouble(txtPrecio.getText().toString());


                if(id<=codigo){
                    JOptionPane.showMessageDialog(null,"Id no valido");
                }else {
                    Producto producto = new Producto(id, nombre, precio);
                    inventario.agregar(producto);
                    JOptionPane.showMessageDialog(null, "Producto Agregado");
                    codigo = id;
                }

            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultListModel dlm= new DefaultListModel();
                for (Producto producto:inventario.todos()){
                    dlm.addElement(producto.toString());
                }
                lstListado.setModel(dlm);
            }
        });
        btnOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventario.ordenar();
                DefaultListModel dlm2 = new DefaultListModel();
                for (Producto producto:inventario.todos()){
                    dlm2.addElement(producto.toString());
                }
                lstOrdenar.setModel(dlm2);
            }
        });
        btnOrdenarID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inventario.ordenarID();
                DefaultListModel dlm2 = new DefaultListModel();
                for (Producto producto:inventario.todos()){
                    dlm2.addElement(producto.toString());
                }
                lstOrdenarID.setModel(dlm2);
            }
        });

        btnBuscarID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(txtID2.getText());

                Producto encontrado = inventario.buscarPorIdBinario(id);

                if (encontrado != null) {
                    JOptionPane.showMessageDialog(null,"ID  encontrado");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "No existe un producto con el ID " + id);
                }
            }
        });


        btnBuscarNombre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre=txtNombre2.getText();
                Producto encontrado = inventario.buscar(nombre);

                if (encontrado != null) {
                    JOptionPane.showMessageDialog(null,"Producto encontrado");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "No existe un producto con el nombre buscado ");
                }
            }
        });
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
tuuu 