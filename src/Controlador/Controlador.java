
package Controlador;
import Modelo.*;
import Vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener{
    DefaultTableModel modeloTabla;
    DefaultTableModel modeloTabla2;
    private VistaUno vista;
    private VistaDos vistaDos;
    private Mascota mascota;
    private Felino felino;
    private Canino canino;
    
    
    private String nombre;
    private String raza;
    private String color;
    private int edad;
    private boolean disponibilidad;
    private String nivelEnt;
    private boolean taxo;
    private int canF, canC;
    private double prom;

    public Controlador(VistaUno vista,VistaDos vistaDos, Mascota mascota) {
        this.vista = vista;
        this.vistaDos = vistaDos;
        this.mascota = mascota;
        this.felino = felino;
        this.canino = canino;
        
        this.vista.jButton1.addActionListener(this);
        this.vista.jButton2.addActionListener(this);
        this.vistaDos.jButton1.addActionListener(this);
    
        modeloTabla=new DefaultTableModel();
        modeloTabla2=new DefaultTableModel();
        
        modeloTabla2.addColumn("Tipo");
        modeloTabla2.addColumn("Nombre");
        modeloTabla2.addColumn("Color");
        modeloTabla2.addColumn("Raza");
        modeloTabla2.addColumn("Edad");
        modeloTabla2.addColumn("Disponibilidad");
        
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Raza");
        modeloTabla.addColumn("Edad");
        modeloTabla.addColumn("Disponibilidad");
        
        vista.jTable1.setModel(modeloTabla);
        vistaDos.jTable1.setModel(modeloTabla2);
    }
    
     public void Iniciar(){
        vista.pack();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setVisible(true);
     }
    ArrayList<Mascota> listMas=new ArrayList<Mascota>();
    public void actionPerformed(ActionEvent e) {
           
        if(vista.jButton1==e.getSource()){
            if(vista.jTextField1.getText().isEmpty() || vista.jTextField2.getText().isEmpty() ||
                    vista.jTextField3.getText().isEmpty() || vista.jTextField4.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Ingrese todos los valores");
                
            }else{
                nombre=vista.jTextField1.getText();
            raza=vista.jTextField2.getText();
            color=vista.jTextField3.getText();
            edad=Integer.parseInt(vista.jTextField4.getText());
            if(vista.jComboBox3.getSelectedItem().equals("Si")){
               disponibilidad=true; 
            }else if(vista.jComboBox3.getSelectedItem().equals("No")){
               disponibilidad=false;
            }
            
            if(vista.jComboBox1.getSelectedItem().equals("Canino")){
                nivelEnt=(String) vista.jComboBox2.getSelectedItem();
                listMas.add(new Canino(nombre, raza, color, edad, disponibilidad, nivelEnt));
                canC+=1;
                
            }else if(vista.jComboBox1.getSelectedItem().equals("Felino")){
                if(vista.jComboBox2.equals("Si")){
                     taxo=true; 
                }else if(vista.jComboBox2.equals("No")){
                     taxo=false;
                }
                listMas.add(new Felino(nombre, raza, color, edad, disponibilidad, edad, taxo));
                canF+=1;
            }
  
                    String[]info =new String[5];

                    info[0]=(String) vista.jComboBox1.getSelectedItem();
                    info[1]=vista.jTextField1.getText();
                    info[2]=vista.jTextField2.getText();
                    info[3]=vista.jTextField4.getText();
                    info[4]=(String) vista.jComboBox3.getSelectedItem();
                    modeloTabla.addRow(info);
                    vista.jTextField1.setText("");
                    vista.jTextField2.setText("");
                    vista.jTextField3.setText("");
                    vista.jTextField4.setText("");
                
            }
            
            
                    
        }else if(vista.jButton2==e.getSource()){
             Object[] filas = new Object[modeloTabla2.getColumnCount()];
             vista.dispose();
             vistaDos.setVisible(true);
             vistaDos.setLocationRelativeTo(null);
            
             for(int i=0; i<listMas.size();i++){
                 if(listMas.get(i).getDisponibilidad()==true){
                 filas[0]=listMas.get(i).getClass().getSimpleName();
                 filas[1]=listMas.get(i).getNombre();
                 filas[2]=listMas.get(i).getColor();
                 filas[3]=listMas.get(i).getRaza();
                 filas[4]=listMas.get(i).getEdad();
                 filas[5]=listMas.get(i).getDisponibilidad();
                 modeloTabla2.addRow(filas);    
                 }
                 prom+=listMas.get(i).getEdad();
             }
             prom=prom/listMas.size();

             vistaDos.jLabel5.setText(Integer.toString(listMas.size()));
             vistaDos.jLabel6.setText(Integer.toString(canC));
             vistaDos.jLabel7.setText(Integer.toString(canF));
             vistaDos.jLabel9.setText(Double.toString(prom));
             
           }
            
            if(vistaDos.jButton1==e.getSource()){
               canC=0;
               canF=0;
               prom=0;
               Object[] filas = new Object[modeloTabla2.getColumnCount()];
               int select = vistaDos.jTable1.getSelectedRow();
               if(select>=0){
                   modeloTabla2.setRowCount(0);
                   listMas.remove(select);
                   for(int i=0; i<listMas.size();i++){
                       if(listMas.get(i).getClass().getSimpleName().equalsIgnoreCase("Canino")){
                         canC+=1;  
                       }else if(listMas.get(i).getClass().getSimpleName().equalsIgnoreCase("Felino")){
                         canF+=1; 
                       }
                        if(listMas.get(i).getDisponibilidad()==true){
                        filas[0]=listMas.get(i).getClass().getSimpleName();
                        filas[1]=listMas.get(i).getNombre();
                        filas[2]=listMas.get(i).getColor();
                        filas[3]=listMas.get(i).getRaza();
                        filas[4]=listMas.get(i).getEdad();
                        filas[5]=listMas.get(i).getDisponibilidad();
                        modeloTabla2.addRow(filas);    
                 }
                        prom+=listMas.get(i).getEdad();
                        
             }
             prom=prom/listMas.size();
             vistaDos.jLabel5.setText(Integer.toString(listMas.size()));
             vistaDos.jLabel6.setText(Integer.toString(canC));
             vistaDos.jLabel7.setText(Integer.toString(canF));
             vistaDos.jLabel9.setText(Double.toString(prom));
               }else{
                   JOptionPane.showMessageDialog(null, "Seleccione una fila");
               }
           }         
    }
}
