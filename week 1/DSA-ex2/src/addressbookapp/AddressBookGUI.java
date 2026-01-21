package addressbookapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nikolas
 */
public class AddressBookGUI extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AddressBookGUI.class.getName());

    //variables 
    private ArrayList<StandardContact> standardContactList;
    private ArrayList<BusinessContact> businessContactList;
    private int displayNum;
    
    public AddressBookGUI() {
        standardContactList = new ArrayList<>();
        businessContactList = new ArrayList<>();
        displayNum = 0;
        initComponents();
        companyNameLBL.setVisible(false);
        companynameTF.setVisible(false);
        load();
    }
    
    //my methods
    private void display(){
        if (standardRADIO.isSelected()){
            //standard
            displayTA.setText(standardContactList.get(displayNum).showDetails());
        }else{
            //business
            displayTA.setText(businessContactList.get(displayNum).showDetails());
        }
        
    }
    
    private int searchPhone(String phone){
        if (standardRADIO.isSelected()){
            //standard
            for (int x = 0; x<=standardContactList.size() ;x++){
                if (phone.equalsIgnoreCase(standardContactList.get(x).getPhone())){
                    return x;
                }
            }
        }else{
            //business
            for (int x = 0; x<businessContactList.size();x++){
                if (phone.equalsIgnoreCase(businessContactList.get(x).getPhone())){
                    return x;
                }
            }
        }
        return 999;
    }
    
    private void save(){
        File f;
        FileOutputStream fos;
        ObjectOutputStream oos;
        
        //save standard
        try{
            oos = new ObjectOutputStream(fos = new FileOutputStream(f = new File("StandardContacts.dat")));
            oos.writeObject(standardContactList);
        }catch(Exception e){
            System.out.println("error " + e);
        }
        
        //save business
        try{
            oos = new ObjectOutputStream(fos = new FileOutputStream(f = new File("BusinessContacts.dat")));
            oos.writeObject(businessContactList);
        }catch(Exception e){
            System.out.println("error " + e);
        }
    }
    
    private void load(){
        File f;
        FileInputStream fis;
        ObjectInputStream ois;
        
        //first load standard contacts
        try{
            ois = new ObjectInputStream(fis = new FileInputStream(f = new File("StandardContacts.dat")));
            standardContactList = (ArrayList<StandardContact>) ois.readObject();
        }catch(IOException e){
            System.out.println("error " + e);
        }catch(ClassNotFoundException e){
            System.out.println("error " + e);
        }
        
        //next load business contacts
        try{
            ois = new ObjectInputStream(fis = new FileInputStream(f = new File("BusinessContacts.dat")));
            businessContactList = (ArrayList<BusinessContact>) ois.readObject();
        }catch(IOException e){
            System.out.println("error " + e);
        }catch(ClassNotFoundException e){
            System.out.println("error " + e);
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContactType = new javax.swing.ButtonGroup();
        TitleLBL = new javax.swing.JLabel();
        firstNameLBL = new javax.swing.JLabel();
        surnameLBL = new javax.swing.JLabel();
        emailLBL = new javax.swing.JLabel();
        phoneLBL = new javax.swing.JLabel();
        AddressLBL = new javax.swing.JLabel();
        companyNameLBL = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        surnameTF = new javax.swing.JTextField();
        emailTF = new javax.swing.JTextField();
        phoneTF = new javax.swing.JTextField();
        addressTF = new javax.swing.JTextField();
        companynameTF = new javax.swing.JTextField();
        standardRADIO = new javax.swing.JRadioButton();
        businessRADIO = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTA = new javax.swing.JTextArea();
        addBTN = new javax.swing.JButton();
        deleteBTN = new javax.swing.JButton();
        displayBTN = new javax.swing.JButton();
        exitBTN = new javax.swing.JButton();
        forwardsBTN = new javax.swing.JButton();
        backBTN = new javax.swing.JButton();
        searchBTN = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TitleLBL.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TitleLBL.setText("Nikolas' Address Book");

        firstNameLBL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLBL.setText("Name");

        surnameLBL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLBL.setText("surname");

        emailLBL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        emailLBL.setText("email");

        phoneLBL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phoneLBL.setText("phone");

        AddressLBL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        AddressLBL.setText("address");

        companyNameLBL.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        companyNameLBL.setText("company name");

        phoneTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTFActionPerformed(evt);
            }
        });

        ContactType.add(standardRADIO);
        standardRADIO.setSelected(true);
        standardRADIO.setText("Standard Contacts");
        standardRADIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                standardRADIOActionPerformed(evt);
            }
        });

        ContactType.add(businessRADIO);
        businessRADIO.setText("Business Contacts");
        businessRADIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                businessRADIOActionPerformed(evt);
            }
        });

        displayTA.setEditable(false);
        displayTA.setColumns(20);
        displayTA.setRows(5);
        jScrollPane1.setViewportView(displayTA);

        addBTN.setText("ADD");
        addBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBTNActionPerformed(evt);
            }
        });

        deleteBTN.setText("DELETE");
        deleteBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBTNActionPerformed(evt);
            }
        });

        displayBTN.setText("DISPLAY");
        displayBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayBTNActionPerformed(evt);
            }
        });

        exitBTN.setText("EXIT");
        exitBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBTNActionPerformed(evt);
            }
        });

        forwardsBTN.setText(">");
        forwardsBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardsBTNActionPerformed(evt);
            }
        });

        backBTN.setText("<");
        backBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBTNActionPerformed(evt);
            }
        });

        searchBTN.setText("SEARCH");
        searchBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(AddressLBL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(phoneLBL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(emailLBL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(surnameLBL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(firstNameLBL, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(phoneTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(emailTF, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(surnameTF)
                                    .addComponent(addressTF)
                                    .addComponent(nameTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(standardRADIO)
                                    .addComponent(businessRADIO))
                                .addGap(117, 117, 117))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(companyNameLBL)
                                        .addGap(18, 18, 18)
                                        .addComponent(companynameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(backBTN)
                                        .addGap(18, 18, 18)
                                        .addComponent(forwardsBTN))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(exitBTN)
                                            .addComponent(searchBTN)
                                            .addComponent(deleteBTN)
                                            .addComponent(addBTN)
                                            .addComponent(displayBTN))
                                        .addGap(3, 3, 3)))
                                .addGap(10, 10, 10))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(TitleLBL)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TitleLBL, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(forwardsBTN)
                            .addComponent(backBTN))
                        .addGap(9, 9, 9)
                        .addComponent(displayBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameLBL)
                            .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(standardRADIO))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(surnameLBL)
                            .addComponent(surnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(businessRADIO))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLBL)
                            .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneLBL)
                            .addComponent(phoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AddressLBL)
                            .addComponent(addressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(companyNameLBL)
                            .addComponent(companynameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBTN)
                        .addGap(7, 7, 7)
                        .addComponent(searchBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exitBTN))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void phoneTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneTFActionPerformed

    private void deleteBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBTNActionPerformed
    String tempPhone = JOptionPane.showInputDialog(null,"Enter a phone number of contact to delete");
        
        if (searchPhone(tempPhone)!=999){
            if (standardRADIO.isSelected()){
                standardContactList.remove(searchPhone(tempPhone));
            }else{
                businessContactList.remove(searchPhone(tempPhone));
            }
            displayTA.setText("Contact deleted");
        }else{
            displayTA.setText("contact not found");
        }
    }//GEN-LAST:event_deleteBTNActionPerformed

    private void displayBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayBTNActionPerformed
        display();
    }//GEN-LAST:event_displayBTNActionPerformed

    private void exitBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBTNActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitBTNActionPerformed

    private void addBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBTNActionPerformed
        if (standardRADIO.isSelected()){
            //standard contact
            StandardContact s = new StandardContact();
            s.setFirstname(nameTF.getText());
            s.setSurname(surnameTF.getText());
            s.setEmail(emailTF.getText());
            s.setPhone(phoneTF.getText());
            s.setAddress(addressTF.getText());
            
            standardContactList.add(s);
            displayTA.setText("Contact added");
        }else{
            //business contact
            BusinessContact b = new BusinessContact();
            b.setFirstname(nameTF.getText());
            b.setSurname(surnameTF.getText());
            b.setEmail(emailTF.getText());
            b.setPhone(phoneTF.getText());
            b.setAddress(addressTF.getText());
            b.setCompanyName(companynameTF.getText());
            
            businessContactList.add(b);
            displayTA.setText("Business contact added");
        }
        save();
        nameTF.setText("");
        emailTF.setText("");
        surnameTF.setText("");
        phoneTF.setText("");
        addressTF.setText("");
        companynameTF.setText("");
    }//GEN-LAST:event_addBTNActionPerformed

    private void standardRADIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_standardRADIOActionPerformed
        //reset viewing list when changing types of contact. keeps viewing from breaking any values. ie standard list bigger than business, then if you switch to business, display function breaks
        displayNum = 0;
        companyNameLBL.setVisible(false);
        companynameTF.setVisible(false);
        
        if (!standardContactList.isEmpty()){
            display();
        }else{
            displayTA.setText("enter some contacts to see them here");
        }
    }//GEN-LAST:event_standardRADIOActionPerformed

    private void businessRADIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_businessRADIOActionPerformed
        //same function as the other radio button
        displayNum = 0;
        companyNameLBL.setVisible(true);
        companynameTF.setVisible(true);
        
        if (!businessContactList.isEmpty()){
            display();
        }else{
            displayTA.setText("enter some contacts to see them here");
        }
    }//GEN-LAST:event_businessRADIOActionPerformed

    private void backBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBTNActionPerformed
        //go back
        if (displayNum!=0){
            displayNum-=1;
            display();
        }
    }//GEN-LAST:event_backBTNActionPerformed

    private void forwardsBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardsBTNActionPerformed
        //go ahead in terms of currently viewing list
        if (standardRADIO.isSelected()){
                if (displayNum<standardContactList.size()-1){
                    displayNum+=1;
                    display();
                }
            }else{
                if (displayNum<businessContactList.size()-1){
                    displayNum+=1;
                }
                display();
            }
    }//GEN-LAST:event_forwardsBTNActionPerformed

    private void searchBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBTNActionPerformed
        String tempPhone = JOptionPane.showInputDialog(null,"Enter a phone number to search by");
        
        if (searchPhone(tempPhone)!=999){
            displayNum=searchPhone(tempPhone); //yes I am running the same function twice. I dont really care about this at the moment
            display();
        }else{
            displayTA.setText("contact not found");
        }
    }//GEN-LAST:event_searchBTNActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new AddressBookGUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddressLBL;
    private javax.swing.ButtonGroup ContactType;
    private javax.swing.JLabel TitleLBL;
    private javax.swing.JButton addBTN;
    private javax.swing.JTextField addressTF;
    private javax.swing.JButton backBTN;
    private javax.swing.JRadioButton businessRADIO;
    private javax.swing.JLabel companyNameLBL;
    private javax.swing.JTextField companynameTF;
    private javax.swing.JButton deleteBTN;
    private javax.swing.JButton displayBTN;
    private javax.swing.JTextArea displayTA;
    private javax.swing.JLabel emailLBL;
    private javax.swing.JTextField emailTF;
    private javax.swing.JButton exitBTN;
    private javax.swing.JLabel firstNameLBL;
    private javax.swing.JButton forwardsBTN;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTF;
    private javax.swing.JLabel phoneLBL;
    private javax.swing.JTextField phoneTF;
    private javax.swing.JButton searchBTN;
    private javax.swing.JRadioButton standardRADIO;
    private javax.swing.JLabel surnameLBL;
    private javax.swing.JTextField surnameTF;
    // End of variables declaration//GEN-END:variables
}
