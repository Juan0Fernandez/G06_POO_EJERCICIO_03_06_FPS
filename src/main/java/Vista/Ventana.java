package Vista;

import Controlador.CntrlFigura;
import Modelo.Figura;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame implements ActionListener, MouseListener{

    private PanelPrincipal panelPrincipal;
    private JComboBox cmbFigura;
    private JTextField txtColor;
    private JTextField txtLargo;
    private JTextField txtAncho;
    private JButton btnBorrar;
    private CntrlFigura cntrlFig = new CntrlFigura();
    private JPanel pan2, pan1;
    
    public Ventana(String titulo) throws HeadlessException {
        super(titulo);
        this.setSize(1000, 1000);
        this.iniciaComponentes();
        
        pan2 = new JPanel();
        pan1 = new JPanel();
        
        this.setLayout(new BorderLayout());
        
        pan1.setLayout(new BorderLayout());
        pan2.setLayout(new BorderLayout());
        
        this.panelPrincipal = new PanelPrincipal();
        
        this.panelPrincipal.addMouseListener(this);
        
        pan1.add(this.cmbFigura, BorderLayout.NORTH);
        pan1.add(this.btnBorrar, BorderLayout.SOUTH);
        
        pan2.add(this.txtColor, BorderLayout.NORTH);
        pan2.add(this.txtAncho, BorderLayout.CENTER);
        pan2.add(this.txtLargo, BorderLayout.SOUTH);
        
        this.add(pan1, BorderLayout.NORTH);
        this.add(pan2, BorderLayout.SOUTH);
        this.add(panelPrincipal, BorderLayout.CENTER);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void iniciaComponentes(){
        this.cmbFigura = new JComboBox();
        
        this.cmbFigura.addItem("Rectangulo");
        this.cmbFigura.addItem("Estrella");
        this.cmbFigura.addItem("Circulo");
        this.cmbFigura.addItem("Cuadrado");
        this.cmbFigura.addItem("Triangulo");
        
        this.txtColor = new JTextField();
        this.txtLargo = new JTextField();
        this.txtAncho = new JTextField();
        this.btnBorrar = new JButton();
        
        txtLargo.setText("Largo");
        txtColor.setText("Color");
        txtAncho.setText("Ancho");
        
        this.btnBorrar = new JButton("Borrar");
        
        this.btnBorrar.addActionListener(this);
        this.cmbFigura.addActionListener(this);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==cmbFigura){
            JComboBox cmb = (JComboBox) e.getSource();
            String figura = (String) cmb.getSelectedItem();
            switch (figura) {
                case "Estrella":
                    txtLargo.setEnabled(false);
                    txtAncho.setText("Radio");
                    txtLargo.setText("");
                    break;
                case "Circulo":
                    txtLargo.setEnabled(false);
                    txtAncho.setText("Radio");
                    txtLargo.setText("");
                    break;
                case "Cuadrado":
                    txtLargo.setEnabled(false);
                    txtLargo.setText("");
                    txtAncho.setText("Lado");
                    break;
                case "Rectangulo":
                    txtLargo.setEnabled(true);
                    txtAncho.setEnabled(true);
                    txtLargo.setText("Largo");
                    txtAncho.setText("Ancho");
                    break;
                case "Triangulo":
                    txtLargo.setEnabled(true);
                    txtAncho.setEnabled(true);
                    txtLargo.setText("Largo");
                    txtAncho.setText("Ancho");
                    break;
                default:
                    break;
            }
            this.repaint();
        }else if(e.getSource()==btnBorrar){
            panelPrincipal.setDibujar(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        String l="",a="";
  
        switch ((String) cmbFigura.getSelectedItem()) {
            case "Estrella":
                l="-1";
                a=txtAncho.getText();
                break;
            case "Circulo":
                l="-1";
                a=txtAncho.getText();
                break;
            case "Cuadrado":
                l="-1";
                a=txtAncho.getText();
                break;
            case "Rectangulo":
                l=txtLargo.getText();
                a=txtAncho.getText();
                break;
            case "Triangulo":
                l=txtLargo.getText();
                a=txtAncho.getText();
                break;
            default:
                break;
        }
        
        Figura fig = cntrlFig.crearFigura(txtColor.getText(), l, a, e.getPoint(), (String) cmbFigura.getSelectedItem());

        if(fig!=null){
            panelPrincipal.setFigura(fig);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
