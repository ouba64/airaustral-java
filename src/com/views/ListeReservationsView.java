/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 

package com.views;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;

/*
 * SimpleTableDemo.java requires no other files.
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.controllers.Controller;
import com.models.Model;
import com.models.Reservation;
import com.models.Vol;
import com.views.ButtonInJTable.ButtonEditor;
import com.views.ButtonInJTable.ButtonRenderer;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ListeReservationsView  extends PanelView  {
    private boolean DEBUG = false;
	private JTable table;
	DefaultTableModel model;
	MonJButton<Reservation> btnSupprimer = new MonJButton<>();
	List<Reservation> reservations;
	
	
    public ListeReservationsView(Controller controller) {
    	super(controller);
        setLayout(new GridLayout(3,1));
        

        Object[][] data = new Object[][] {
    				{null, null, null, null, null,  null},
    				{null, null, null, null, null,  null},
    			};
		String[] columnNames= new String[] {
			"Nom du client", "Prénom du client", "Départ", "Destination", "Nom du vol", "Supprimer"
		};
		model = new DefaultTableModel(data, columnNames);
        table = new JTable();
        table.setModel(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        

		btnSupprimer.setText("Supprimer");
		btnSupprimer.setActionCommand("Supprimer");
		btnSupprimer.addActionListener(controller);
		
        //TableColumn modifierTableColumn = table.getColumnModel().getColumn(5);
        TableColumn supprimerTableColumn = table.getColumnModel().getColumn(5);
        //modifierTableColumn.setCellRenderer(new ButtonRenderer(true));
        //modifierTableColumn.setCellEditor(new ButtonEditor(new JCheckBox(), true));
        
        
        supprimerTableColumn.setCellRenderer(new ButtonRenderer(false));
        supprimerTableColumn.setCellEditor(new ButtonEditor(new JCheckBox(), false));
        


        
        JPanel panel = new JPanel();
        add(panel);
        
        Composant composant = new Composant((Controller) controller, new boolean[] {true, true, true});
        
        JLabel lblTitre = new JLabel("Liste des Réservations trouvées");
        lblTitre.setFont(new Font("Tahoma", Font.PLAIN, 22));
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
        			.addComponent(composant, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblTitre, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
        				.addComponent(composant, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(59, Short.MAX_VALUE))
        );
        panel.setLayout(gl_panel);
        
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
        Dimension d = new Dimension(100, 50);
        panel = new JPanel();
        add(panel);
    }





	@Override
	public Model fillAndGetModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayModel(Model model) {
		// TODO Auto-generated method stub
		
	}
	
	class ButtonEditor extends DefaultCellEditor {

		private String label;
		public ButtonEditor(JCheckBox checkBox, boolean isModifier) {
			super(checkBox);
		}

		public Component getTableCellEditorComponent(JTable table, Object value,
				boolean isSelected, int row, int column) {
			JButton button;

			btnSupprimer.setObject(reservations.get(row));
			btnSupprimer.setPosition(row);
			btnSupprimer.setActionCommand("Suppression");
			button = btnSupprimer;			
			return button;
		}

		public Object getCellEditorValue() {
			return btnSupprimer;			
		}
	}
	
	class ButtonRenderer extends JButton implements TableCellRenderer {
		boolean isModifier;
		public ButtonRenderer(boolean isModifier) {
			setOpaque(true);
			this.isModifier = isModifier;
		}

		public Component getTableCellRendererComponent(JTable table,
				Object value,boolean isSelected, boolean hasFocus, int row, int column) {

			setText("Supprimer");
			
			return this;
		}
	}
	

	public void afficherLigne(Vol vol){
		
	}
	
	public void afficherListeReservations(List<Reservation> vols) {
		Reservation vol;
		model.setRowCount(vols.size());
		this.reservations = vols;
		//table.setModel(model);
		for(int i=0; i<vols.size(); i++){
			vol = vols.get(i);
			table.getModel().setValueAt(vol.getClient().getNom(), i, 0);
			table.getModel().setValueAt(vol.getClient().getPrenom(), i, 1);
			table.getModel().setValueAt(vol.getVol().getDepart(), i, 2);
			table.getModel().setValueAt(vol.getVol().getDestination(), i, 3);
			table.getModel().setValueAt(vol.getVol().getNomVol(), i, 4);
		}
		
	}

	public void supprimerLigne(int position) {
		((DefaultTableModel)table.getModel()).removeRow(position);
		reservations.remove(position);
		
	}
}