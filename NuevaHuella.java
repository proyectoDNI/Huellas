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
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
//Interfaz para agregar un nuevo usuario y su template de huella dactilar
public class NuevaHuella extends javax.swing.JFrame {
    private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();
    private DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();
    private DPFPTemplate Template;
    public static String TEMPLATE_PROPERTY = "template";
    public DPFPFeatureSet featuresinscripcion;
    public DPFPFeatureSet featuresverificacion;
    
    @SuppressWarnings("UseSpecificCatch")
    public NuevaHuella() {
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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingresar Usuario");
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
        jPanel1.setToolTipText("Huella Capturada");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Nombre:");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("Huella Capturada");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /*Este código se ejecuta cuando se oprime el boton salir, Regresa a la ventana principal*/
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        close();
        Menu x= new Menu();
        x.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        /*Este código se ejecuta al abrir la ventana, Inicializa los listeners
        e imprime el estado de la huella y las muestras necesarias para completar
        el template
        */
        Iniciar();
        start();
        EstadoHuellas();
        jButton1.setEnabled(false);
        jLabel2.setEnabled(false);
        jTextField1.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        stop();
    }//GEN-LAST:event_formWindowClosing
    /* Se realiza la conexión con la base de datos, para luego enviarle los codigos necesarios
       en SQL y la información del usuario para ser almacenados en la base de datos.
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ByteArrayInputStream datosHuella = new ByteArrayInputStream(Template.serialize());
        Integer tamanoHuella = Template.serialize().length;
        if (jTextField1.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Faltan datos para guardar el usuario");
        }
        else{
            String nombre = jTextField1.getText();
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
                String sql = "SELECT count(*) from huellas";
                ResultSet rs=stmt.executeQuery(sql);
                rs.next();
                int num=rs.getInt(1)+1;
                PreparedStatement guardarStmt = c.prepareStatement("INSERT INTO huellas (num, nombre, template) values(?,?,?);");
                guardarStmt.setInt(1,num);
                guardarStmt.setString(2,nombre);
                guardarStmt.setBinaryStream(3, datosHuella, tamanoHuella);
                guardarStmt.execute();
                guardarStmt.close();
                stmt.close();
                c.commit();
                c.close();
                jTextField1.setText(null);
                jButton1.setEnabled(false);
                jLabel2.setEnabled(false);
                jTextField1.setEnabled(false);
                JOptionPane.showMessageDialog(this,"Usuario Ingresado con Éxito");
                Reclutador.clear();
                jLabel1.setIcon(null);
                start();
                jLabel3.setText("Coleque la huella "+Reclutador.getFeaturesNeeded()+" veces más");
            } catch ( ClassNotFoundException | SQLException e ) {
                System.err.println(e.getClass().getName()+": "+ e.getMessage() );
                JOptionPane.showMessageDialog(this, "USUARIO NO INGRESADO - "+e.getMessage());
                jTextField1.setText(null);
                jButton1.setEnabled(false);
                jLabel2.setEnabled(false);
                jTextField1.setEnabled(false);
                Reclutador.clear();
                jLabel1.setIcon(null);
                start();
                jLabel3.setText("Coleque la huella "+Reclutador.getFeaturesNeeded()+" veces más");
            }
        }
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
            java.util.logging.Logger.getLogger(NuevaHuella.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevaHuella().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
    //Listener que espera el evento de conexión y desconexión del lector de huellas.
    private void conectado() {
        Lector.addReaderStatusListener(new DPFPReaderStatusAdapter(){ 
            @Override@SuppressWarnings("Convert2Lambda")
    public void readerConnected(final DPFPReaderStatusEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                    @Override public void run(){
                        System.out.println("El Lector esta conectado...");
                    } 
                
                });
            }
            @Override@SuppressWarnings("Convert2Lambda")
    public void readerDisconnected(final DPFPReaderStatusEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                    @Override public void run(){
                        System.out.println("El Lector no esta conectado...");
                    }
                });
            }
        });
    }
    //Listener que espera el evento en el que lector empieze a transmitir datos.
    private void captura() {
        Lector.addDataListener(new DPFPDataAdapter(){
            @Override@SuppressWarnings("Convert2Lambda")
    public void dataAcquired(final DPFPDataEvent e){
                SwingUtilities.invokeLater(new Runnable() {@Override 
                public void run(){
                    System.out.println("La Huella ha sido Capturada");
                    ProcesarCaptura(e.getSample());
                    
                }
                });
                
            }
            
        });
    }
    //Listener que espera el evento en que el lector reconoce que esta siendo usado...
    //y el momento en que quitan el dedo del lector.
    private void dedo() {
        Lector.addSensorListener(new DPFPSensorAdapter(){ 
            @Override@SuppressWarnings("Convert2Lambda")
    public void fingerTouched(final DPFPSensorEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                    @Override public void run(){
                        System.out.println("Escaneando...");
                    }
                });
            }
            @Override@SuppressWarnings("Convert2Lambda")
     public void fingerGone(final DPFPSensorEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                @Override public void run(){
                    System.out.println("El dedo ha sido quitado del Lector");
                }
                });
            }
        });
    }
    //Listener que espera el evento de cualquier error en el momento de la lectura
    private void error() {
        Lector.addErrorListener(new DPFPErrorAdapter(){
            @SuppressWarnings("Convert2Lambda")
            public void errorReader(final DPFPErrorEvent e){
                SwingUtilities.invokeLater(new Runnable(){
                   @Override public void run(){
                       System.err.println("Error: "+ e.getError());
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
    //Imprime el numero de muestras necesarias para completar el template.
    public void EstadoHuellas(){
        if(Reclutador.getFeaturesNeeded()>0){
            if(Reclutador.getFeaturesNeeded()>1){
                jLabel3.setText("Coleque la huella "+Reclutador.getFeaturesNeeded()+" veces más");
            }
            else{
                jLabel3.setText("Coleque la huella "+Reclutador.getFeaturesNeeded()+" vez más");
            }
        }
    }
    //LLama la función asincrona para iniciar la captura de huellas.
     public void start(){
        Lector.startCapture();
        System.out.println("Lector listo para usarse");
    }
    //Detiene la función asincrona de la captura de huellas.
    public void stop(){
        Lector.stopCapture();
        System.out.println("Lector apagado...");
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
    @SuppressWarnings("FinallyDiscardsException")
    public void ProcesarCaptura(DPFPSample Sample){
        featuresinscripcion = extraerCaracteristicas(Sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);
        featuresverificacion = extraerCaracteristicas(Sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
        if(featuresinscripcion != null){
            try{
                System.out.println("Captura existosa");
                Reclutador.addFeatures(featuresinscripcion);
                Image image = CrearImagenHuella(Sample);
                DibujarHuella(image);
            }
            catch(DPFPImageQualityException ex){
                System.err.println("Error"+ex.getMessage());
            }
            finally{
                EstadoHuellas();
                switch(Reclutador.getTemplateStatus()){
                    case TEMPLATE_STATUS_READY:
                        stop();
                        setTemplate(Reclutador.getTemplate());
                        jLabel3.setText("La Plantilla de la huella ha sido creada");
                        jButton1.setEnabled(true);
                        jLabel2.setEnabled(true);
                        jTextField1.setEnabled(true);
                    break;
                    case TEMPLATE_STATUS_FAILED:
                        Reclutador.clear();
                        stop();
                        EstadoHuellas();
                        setTemplate(null);
                        JOptionPane.showMessageDialog(this, "La plantilla de la huella no pudo ser creada, repita el proceso");
                        jTextField1.setText(null);
                        jButton1.setEnabled(false);
                        jLabel2.setEnabled(false);
                        jTextField1.setEnabled(false);
                        jLabel1.setIcon(null);
                        start();
                    break;
                }
            }
        }
    }
    //Evento que se ejecuta al cerrar la ventana
    public void close(){
        WindowEvent winClossingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClossingEvent);
    }
}
