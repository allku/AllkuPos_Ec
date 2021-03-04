//    Allku Pos  - Touch Friendly Point Of Sale
//    Copyright (c) 2009-2018 uniCenta & previous Openbravo POS works
//    https://www.allku.expert
//
//    This file is part of Allku Pos
//
//    Allku Pos is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    Allku Pos is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with Allku Pos.  If not, see <http://www.gnu.org/licenses/>.

package com.openbravo.pos.sales;

import com.openbravo.pos.forms.AppLocal;
import com.openbravo.pos.forms.DataLogicSystem;
import com.openbravo.pos.ticket.TicketInfo;
import com.openbravo.pos.ticket.TicketLineInfo;
import java.awt.BorderLayout;
import static java.lang.Math.abs;
import java.util.List;

/**
 *
 * @author JG uniCenta, Jorge Luis
 */
public class JRefundLines extends javax.swing.JPanel {
    
    private JTicketLines ticketlines;
    private List m_aLines;

    private JPanelTicketEdits m_jTicketEdit;
    
/** Creates new form JRefundLines
* @param dlSystem
* @param jTicketEdit 
*/
public JRefundLines(DataLogicSystem dlSystem, JPanelTicketEdits jTicketEdit) {
        
        m_jTicketEdit = jTicketEdit;
        
        initComponents();
        
        ticketlines = new JTicketLines(dlSystem.getResourceAsXML("Ticket.Line"));
        
        jPanel3.add(ticketlines, BorderLayout.CENTER);
    }
    
    /**
     *
     * @param aRefundLines
     */
    public void setLines(List aRefundLines) {
        
        m_aLines = aRefundLines;
        ticketlines.clearTicketLines();
        
        if (m_aLines != null) {
            for (int i = 0; i < m_aLines.size(); i++) {
                ticketlines.addTicketLine((TicketLineInfo) m_aLines.get(i));
            }
        }
    }
     
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        webLabel1 = new com.alee.laf.label.WebLabel();
        m_jbtnAddOne = new javax.swing.JButton();
        m_jbtnAddLine = new javax.swing.JButton();
        m_jbtnAddAll = new javax.swing.JButton();

        setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        setPreferredSize(new java.awt.Dimension(15, 200));
        setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jPanel1.setLayout(new java.awt.BorderLayout());

        webLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("pos_messages"); // NOI18N
        webLabel1.setText(bundle.getString("label.refunds")); // NOI18N
        webLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        m_jbtnAddOne.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jbtnAddOne.setText(AppLocal.getIntString("button.refundone")); // NOI18N
        m_jbtnAddOne.setToolTipText(bundle.getString("tooltip.refunditem")); // NOI18N
        m_jbtnAddOne.setFocusPainted(false);
        m_jbtnAddOne.setFocusable(false);
        m_jbtnAddOne.setMargin(new java.awt.Insets(8, 14, 8, 14));
        m_jbtnAddOne.setPreferredSize(new java.awt.Dimension(110, 45));
        m_jbtnAddOne.setRequestFocusEnabled(false);
        m_jbtnAddOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jbtnAddOneActionPerformed(evt);
            }
        });

        m_jbtnAddLine.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jbtnAddLine.setText(AppLocal.getIntString("button.refundline")); // NOI18N
        m_jbtnAddLine.setToolTipText(bundle.getString("tooltip.refundline")); // NOI18N
        m_jbtnAddLine.setFocusPainted(false);
        m_jbtnAddLine.setFocusable(false);
        m_jbtnAddLine.setMargin(new java.awt.Insets(8, 14, 8, 14));
        m_jbtnAddLine.setPreferredSize(new java.awt.Dimension(110, 45));
        m_jbtnAddLine.setRequestFocusEnabled(false);
        m_jbtnAddLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jbtnAddLineActionPerformed(evt);
            }
        });

        m_jbtnAddAll.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        m_jbtnAddAll.setText(AppLocal.getIntString("button.refundall")); // NOI18N
        m_jbtnAddAll.setToolTipText(bundle.getString("tooltip.refundticket")); // NOI18N
        m_jbtnAddAll.setFocusPainted(false);
        m_jbtnAddAll.setFocusable(false);
        m_jbtnAddAll.setMargin(new java.awt.Insets(8, 14, 8, 14));
        m_jbtnAddAll.setPreferredSize(new java.awt.Dimension(110, 45));
        m_jbtnAddAll.setRequestFocusEnabled(false);
        m_jbtnAddAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                m_jbtnAddAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(webLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(m_jbtnAddOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(m_jbtnAddLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(m_jbtnAddAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(webLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(m_jbtnAddOne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(m_jbtnAddLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(m_jbtnAddAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel3.add(jPanel1, java.awt.BorderLayout.EAST);

        add(jPanel3, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Refound all items in list
     * @param evt 
     */
    private void m_jbtnAddAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jbtnAddAllActionPerformed
        double quantityRefound = 0;
        double quantity = 0;
        
        for (int i = 0; i < m_aLines.size(); i++) {
            TicketLineInfo oLine = (TicketLineInfo) m_aLines.get(i);
            TicketLineInfo oNewLine = new TicketLineInfo(oLine);

            // Count quantity of item by code
            quantity = countQuantityItem(oNewLine.getProductID());
            
            // Count quantity refound of item by code
            quantityRefound = countQuantityRefoundItem(oNewLine.getProductID());
            
            // Compare quantity
            if (quantity >= (quantityRefound + abs(oLine.getMultiply()))) {                    
                oNewLine.setMultiply(-oLine.getMultiply());
                m_jTicketEdit.addTicketLine(oNewLine);
            }
            quantityRefound = 0;
            quantity = 0;
        }
        
    }//GEN-LAST:event_m_jbtnAddAllActionPerformed
    /**
     * Refound one item, one by one
     * @param evt 
     */
    private void m_jbtnAddOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jbtnAddOneActionPerformed
        double quantityRefound = 0;
        double quantity = 0;
        
        int index = ticketlines.getSelectedIndex();
        if (index >= 0) {
            TicketLineInfo oLine = (TicketLineInfo) m_aLines.get(index);
            TicketLineInfo oNewLine = new TicketLineInfo(oLine);
            
            // Count quantity of item by code
            quantity = countQuantityItem(oNewLine.getProductID());
            
            // Count quantity refound of item by code
            quantityRefound = countQuantityRefoundItem(oNewLine.getProductID());
            
            // Compare quantity
            if (quantity > quantityRefound) {
                oNewLine.setMultiply(-1.0);
                m_jTicketEdit.addTicketLine(oNewLine);
            }
        }   
        
    }//GEN-LAST:event_m_jbtnAddOneActionPerformed
    /**
     * Refound one line
     * @param evt 
     */
    private void m_jbtnAddLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_m_jbtnAddLineActionPerformed
        double quantityRefound = 0;
        double quantity = 0;
        
        int index = ticketlines.getSelectedIndex();
        if (index >= 0) {
            TicketLineInfo oLine = (TicketLineInfo) m_aLines.get(index);
            TicketLineInfo oNewLine = new TicketLineInfo(oLine); 
            
            // Count quantity of item by code
            quantity = countQuantityItem(oNewLine.getProductID());
            
            // Count quantity refound of item by code
            quantityRefound = countQuantityRefoundItem(oNewLine.getProductID());
            
            // Compare quantity
            if (quantity >= (quantityRefound + abs(oLine.getMultiply()))) {                    
                oNewLine.setMultiply(-oLine.getMultiply());
                m_jTicketEdit.addTicketLine(oNewLine);
            }
        }        
    }//GEN-LAST:event_m_jbtnAddLineActionPerformed
    /**
     * Count quantity of item by code
     * @param productId
     * @return 
     */
    private double countQuantityItem(String productId) {
        double quantity = 0;
        
        for(int i = 0; i < m_aLines.size(); i++) {
            TicketLineInfo line = (TicketLineInfo) m_aLines.get(i);
            if (productId.equals(line.getProductID())) {
                quantity = quantity + line.getMultiply();
            }
        }
        return abs(quantity);
    }
    /**
     * Count quantity refound of item by code
     * @param productId
     * @return 
     */
    private double countQuantityRefoundItem(String productId) {
        TicketInfo refoundTicket = m_jTicketEdit.m_oTicket;
        double quantityRefound = 0;
        
        for (int i = 0; i < refoundTicket.getLinesCount(); i++) {
            TicketLineInfo refoundLine = refoundTicket.getLine(i);
            if (productId.equals(refoundLine.getProductID())) {
                quantityRefound = quantityRefound + refoundLine.getMultiply();
            }
        }
        return abs(quantityRefound);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton m_jbtnAddAll;
    private javax.swing.JButton m_jbtnAddLine;
    private javax.swing.JButton m_jbtnAddOne;
    private com.alee.laf.label.WebLabel webLabel1;
    // End of variables declaration//GEN-END:variables
    
}
