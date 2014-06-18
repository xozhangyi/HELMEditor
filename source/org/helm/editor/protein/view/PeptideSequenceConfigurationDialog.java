/*******************************************************************************
 * Copyright C 2012, The Pistoia Alliance
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
/*
 * PeptideSequenceLayoutConfigurationDialog.java
 *
 * Created on Jan 7, 2011, 5:18:44 PM
 */
package org.helm.editor.protein.view;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;

/**
 * 
 * @author ZHANGTIANHONG
 */
public class PeptideSequenceConfigurationDialog extends javax.swing.JDialog {

	/** Creates new form PeptideSequenceLayoutConfigurationDialog */
	public PeptideSequenceConfigurationDialog(java.awt.Frame parent,
			PeptideSequenceViewer viewer, boolean modal) {
		super(parent, modal);
		this.viewer = viewer;
		initComponents();
		customInit();
	}

	private void customInit() {
		letterPerLinTextField.setText(String
				.valueOf(PeptideSequenceViewer.DEFAULT_LETTERS_PER_LINE));
		tickIntervalTextField.setText(String
				.valueOf(PeptideSequenceViewer.DEFAULT_TICK_INTERVAL));
		markerStyleComboBox.setModel(new DefaultComboBoxModel(
				PeptideSequenceViewer.SUPPORTED_LABEL_MODES));
		String defaultModeText = PeptideSequenceViewer
				.getPositionLabelModeText(PeptideSequenceViewer.DEFAULT_LABEL_MODE);
		markerStyleComboBox.setSelectedItem(defaultModeText);
		fitContentCheckBox
				.setSelected(PeptideSequenceViewer.DEFAULT_FIT_CONTENT);
	}

	public void setParameters(PeptideSequenceViewer viewer) {
		letterPerLinTextField
				.setText(String.valueOf(viewer.getLettersPerLine()));
		tickIntervalTextField.setText(String.valueOf(viewer.getTickInterval()));
		String mode = PeptideSequenceViewer.getPositionLabelModeText(viewer
				.getPositionLabelMode());
		markerStyleComboBox.setSelectedItem(mode);
		fitContentCheckBox.setSelected(viewer.isFitContent());
	}

	public int getLettersPerLine() {
		int i = PeptideSequenceViewer.DEFAULT_LETTERS_PER_LINE;
		try {
			i = Integer.parseInt(letterPerLinTextField.getText().trim());
			if (i <= 0) {
				i = PeptideSequenceViewer.DEFAULT_LETTERS_PER_LINE;
			}
		} catch (NumberFormatException nfe) {
		}
		return i;
	}

	public int getTickInterval() {
		int i = PeptideSequenceViewer.DEFAULT_TICK_INTERVAL;
		try {
			i = Integer.parseInt(tickIntervalTextField.getText().trim());
			if (i <= 0) {
				i = PeptideSequenceViewer.DEFAULT_TICK_INTERVAL;
			}
		} catch (NumberFormatException nfe) {
		}
		return i;

	}

	public int getPositionLabelMode() {
		String modeText = (String) markerStyleComboBox.getSelectedItem();
		int mode = PeptideSequenceViewer.getPositiontLabelMode(modeText);
		return mode;
	}

	public boolean isFitContent() {
		return fitContentCheckBox.isSelected();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		parameterPanel = new javax.swing.JPanel();
		letterPerLineLabel = new javax.swing.JLabel();
		letterPerLinTextField = new javax.swing.JTextField();
		tickIntervalLabel = new javax.swing.JLabel();
		tickIntervalTextField = new javax.swing.JTextField();
		markerStyleLabel = new javax.swing.JLabel();
		markerStyleComboBox = new javax.swing.JComboBox();
		fitContentLabel = new javax.swing.JLabel();
		fitContentCheckBox = new javax.swing.JCheckBox();
		buttonPanel = new javax.swing.JPanel();
		okButton = new javax.swing.JButton();
		cancelButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Protein Viewer Configuration");
		setResizable(false);

		parameterPanel
				.setBorder(javax.swing.BorderFactory.createEtchedBorder());
		parameterPanel.setLayout(new java.awt.GridLayout(4, 2, 2, 0));

		letterPerLineLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		letterPerLineLabel.setText("  Letters per Line: ");
		letterPerLineLabel
				.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
		parameterPanel.add(letterPerLineLabel);

		letterPerLinTextField.setText("40");
		parameterPanel.add(letterPerLinTextField);

		tickIntervalLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		tickIntervalLabel.setText("  Tick Interval: ");
		parameterPanel.add(tickIntervalLabel);

		tickIntervalTextField.setText("20");
		parameterPanel.add(tickIntervalTextField);

		markerStyleLabel
				.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		markerStyleLabel.setText("  Label Style: ");
		parameterPanel.add(markerStyleLabel);

		markerStyleComboBox.setModel(new javax.swing.DefaultComboBoxModel(
				new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
		parameterPanel.add(markerStyleComboBox);

		fitContentLabel.setText("  Fit Content:");
		parameterPanel.add(fitContentLabel);
		parameterPanel.add(fitContentCheckBox);

		buttonPanel.setBorder(new javax.swing.border.SoftBevelBorder(
				javax.swing.border.BevelBorder.RAISED));
		buttonPanel.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

		okButton.setText("OK");
		okButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				okButtonActionPerformed(evt);
			}
		});
		buttonPanel.add(okButton);

		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});
		buttonPanel.add(cancelButton);

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(org.jdesktop.layout.GroupLayout.TRAILING, buttonPanel,
						org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 201,
						Short.MAX_VALUE)
				.add(layout.createParallelGroup(
						org.jdesktop.layout.GroupLayout.LEADING).add(
						parameterPanel,
						org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 201,
						Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
				.add(layout
						.createSequentialGroup()
						.addContainerGap(111, Short.MAX_VALUE)
						.add(buttonPanel,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
				.add(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(layout
								.createSequentialGroup()
								.add(parameterPanel,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
										103,
										org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(37, Short.MAX_VALUE))));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_okButtonActionPerformed
		viewer.setLettersPerLine(getLettersPerLine());
		viewer.setTickInterval(getTickInterval());
		viewer.setPositionLabelMode(getPositionLabelMode());
		viewer.setFitContent(isFitContent());
		setVisible(false);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				viewer.repaint();
			}
		});

	}// GEN-LAST:event_okButtonActionPerformed

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_cancelButtonActionPerformed
		setVisible(false);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				viewer.repaint();
			}
		});
	}// GEN-LAST:event_cancelButtonActionPerformed
		// Variables declaration - do not modify//GEN-BEGIN:variables

	private javax.swing.JPanel buttonPanel;
	private javax.swing.JButton cancelButton;
	private javax.swing.JCheckBox fitContentCheckBox;
	private javax.swing.JLabel fitContentLabel;
	private javax.swing.JTextField letterPerLinTextField;
	private javax.swing.JLabel letterPerLineLabel;
	private javax.swing.JComboBox markerStyleComboBox;
	private javax.swing.JLabel markerStyleLabel;
	private javax.swing.JButton okButton;
	private javax.swing.JPanel parameterPanel;
	private javax.swing.JLabel tickIntervalLabel;
	private javax.swing.JTextField tickIntervalTextField;
	// End of variables declaration//GEN-END:variables
	private PeptideSequenceViewer viewer;
}
