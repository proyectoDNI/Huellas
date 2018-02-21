package pruebas.codigo.huellas;

import pruebas.codigo.huellas.Menu;
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
//Interfaz identificar un usuario a través de su huella dactilar
public class IdentificarHuella extends javax.swing.JFrame {
    //DECLARACIÓN DE LAS VARIABLES.
    private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();
    private DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();
    private DPFPVerification Verificador = DPFPGlobal.getVerificationFactory().createVerification();
    private DPFPTemplate Template;
    public DPFPFeatureSet featuresinscripcion = null;
    public DPFPFeatureSet featuresverificacion = null;
    public static String TEMPLATE_PROPERTY = "template";
    public static long ti,tf;
    @SuppressWarnings("static-access")
    public float Max=Verificador.PROBABILITY_ONE;
    public float Beta;
    
    @SuppressWarnings("UseSpecificCatch")
    public IdentificarHuella() {
        try{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Imposible modificar el tema visual","LookandFeel invalido", JOptionPane.ERROR_MESSAGE);
        }
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Indentificar Usuraio");
        setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Huella Capturada", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setToolTipText("");

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*Esta función inicializa el lector para adquirir las huellas determina el 
    nivel treshold con el cual se determina si se acepta o rechaza una huella*/
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Iniciar();
        Verificador.setFARRequested((int)(0.1*DPFPVerification.PROBABILITY_ONE));
        Beta=(float) (Verificador.getFARRequested()*0.01/Max);
        start();
        jLabel2.setText("INGRESE HUELLA");
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        stop();
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        close();
        Menu x= new Menu();
        x.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IdentificarHuella.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IdentificarHuella().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
    //DECLARACIÓN DE LAS FUNCIONES.
    
    //Listener que espera el evento de conexión y desconexión del lector de huellas.
    private void conectado() {
        Lector.addReaderStatusListener(new DPFPReaderStatusAdapter(){ 
            @Override public void readerConnected(final DPFPReaderStatusEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                    @Override public void run(){
                        EnviarTexto("El Lector esta conectado...");
                    } 
                });
            }
            @Override public void readerDisconnected(final DPFPReaderStatusEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                    @Override public void run(){
                        EnviarTexto("El Lector no esta conectado...");
                    }
                });
            }
        });
    }
    //Listener que espera el evento en el que lector empieze a transmitir datos.
    private void captura() {
        Lector.addDataListener(new DPFPDataAdapter(){
            @Override public void dataAcquired(final DPFPDataEvent e){
                SwingUtilities.invokeLater(new Runnable() {@Override 
                public void run(){
                    ProcesarCaptura(e.getSample());
                    EnviarTexto("La Huella ha sido Capturada");
                }
                });
                
            }
            
        });
    }
    //Listener que espera el evento en que el lector reconoce que esta siendo usado...
    //y el momento en que quitan el dedo del lector.
    private void dedo() {
        Lector.addSensorListener(new DPFPSensorAdapter(){ 
            @Override public void fingerTouched(final DPFPSensorEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                    @Override public void run(){
                        EnviarTexto("Escaneando...");
                        ti=System.currentTimeMillis();
                    }
                });
            }
            @Override public void fingerGone(final DPFPSensorEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                @Override public void run(){
                    EnviarTexto("El dedo ha sido quitado del Lector");
                }
                });
            }
        });
    }
    //Listener que espera el evento de cualquier error en el momento de la lectura
    private void error() {
        Lector.addErrorListener(new DPFPErrorAdapter(){
            public void errorReader(final DPFPErrorEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                   @Override public void run(){
                       EnviarTexto("Error: "+ e.getError());
                   } 
                });
            }
        });
    }
    //Inicializa los listeners necesarios para el uso del lector.
    protected void Iniciar(){
        captura();
        conectado();
        dedo();
        error();
    }
    //Evento que se ejecuta al cerrar la ventana
    public void close(){
        WindowEvent winClossingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClossingEvent);
    }
    //Extrae la informacion del sample obtenido por el lector.
    public DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose){
        DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
        try{
            return extractor.createFeatureSet(sample, purpose);
        }
        catch (DPFPImageQualityException e){
            return null;
        }
    }
    //Genera la imagen para mostrar en la interfaz
    public Image CrearImagenHuella(DPFPSample sample){
        return DPFPGlobal.getSampleConversionFactory().createImage(sample);
    }
    //Dibuja la huella en la interfaz.
    public void DibujarHuella(Image image){
        jLabel1.setIcon(new ImageIcon(image.getScaledInstance(jLabel1.getWidth(),
                                                                        jLabel1.getHeight(),
                                                                        Image.SCALE_DEFAULT
                                                                     )
                                              )
                                );
        repaint();
    }
    //Escribe en consola.
    public void EnviarTexto(String string){
        System.out.println(string);
        if("La Huella ha sido Capturada".equals(string)){
            ProcesoFinal();
        }
    }
    //LLama la función asincrona para iniciar la captura de huellas.
    public void start(){
        Lector.startCapture();
        EnviarTexto("Utilizando el lector");
        
    }
    //Detiene la función asincrona de la captura de huellas.
    public void stop(){
        Lector.stopCapture();
        EnviarTexto("No se esta usando el lector");
    }
    //Función par adquirir el template
    public DPFPTemplate getTemplate(){
        return Template;
    }
    //Agrega las características de una nueva muestra al template.
    public void setTemplate(DPFPTemplate Template){
        DPFPTemplate old = this.Template;
        this.Template = Template;
        firePropertyChange(TEMPLATE_PROPERTY, old, Template);
    }
    //Procesa la información obtenida del lector.
    public void ProcesarCaptura(DPFPSample Sample){
        featuresinscripcion = extraerCaracteristicas(Sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
        featuresverificacion = extraerCaracteristicas(Sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
        if(featuresinscripcion != null){
            try{
                System.out.println("Las caracteristicas de la huella han sido creadas");
                Reclutador.addFeatures(featuresinscripcion);
                Image image = CrearImagenHuella(Sample);
                DibujarHuella(image);
                jLabel2.setText("");
            }
            catch(DPFPImageQualityException ex){
                System.err.println("Error"+ex.getMessage());
            }
            
        }
    }
    /*Realiza la conexión a la base de datos, para luego el template de la 
    huella almacenada que coincida con la huella adquirida en este instante, 
    con el cual se toma la primera coincidencia se adquiere el nombre y se 
    identifica a la persona. Si la huella no coincide con alguna de la base de 
    datos se dice que el usuario no existe*/
    @SuppressWarnings("ConvertToTryWithResources")
    private void ProcesoFinal(){
        stop();
        System.out.println("\nResultado Comparación (<="+Verificador.getFARRequested()+"):");
        System.out.println("\nResultado Comparación (<="+Beta+"):");
        Reclutador.clear();
        @SuppressWarnings("UnusedAssignment")
        Connection c = null;
        @SuppressWarnings("UnusedAssignment")
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                "postgres", "12345");
            c.setAutoCommit(false);
            stmt=c.createStatement();
            String sql = "SELECT num, nombre, template FROM huellas ORDER by num;";
            ResultSet rs=stmt.executeQuery(sql);
            boolean bandera=true;
            String nombre = null;
            while(rs.next()){
                byte templateBuffer[] = rs.getBytes("template");
                DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
                setTemplate(referenceTemplate);
                DPFPVerificationResult result = Verificador.verify(featuresverificacion,getTemplate());
                System.out.println(rs.getInt("num")+": "+(result.getFalseAcceptRate()/Max));
                if(result.isVerified()&&bandera){
                    bandera=false;
                    nombre=rs.getString("nombre");
                    tf=System.currentTimeMillis();
                }
            }
            if (bandera){
                tf=System.currentTimeMillis();
                JOptionPane.showMessageDialog(null,"El Usuario No Existe");
            }
            else{
                JOptionPane.showMessageDialog(null,"Nombre:  "+nombre);
            }
            stmt.close();
            c.close();
            long t=tf-ti;
            System.out.println("Tiempo: "+t+" [ms]\n");
            /*@SuppressWarnings("UnusedAssignment")
            FileWriter flwriter = null;
            try {
                flwriter = new FileWriter("C:\\Users\\juanm\\Documents\\tiempo.txt", true);
                BufferedWriter bfwriter = new BufferedWriter(flwriter);
                bfwriter.write(t+"\r\n");
                bfwriter.close();
            } catch (IOException ex) {
                Logger.getLogger(IdentificarHuella.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        } catch ( ClassNotFoundException | SQLException e ) {
            System.err.println(e.getClass().getName()+": "+ e.getMessage() );
        }
        jLabel1.setIcon(null);
        start();
        jLabel2.setText("INGRESE HUELLA");
    }
}
