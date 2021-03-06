/**
 * *****************************************************************************
 * Copyright C 2012, The Pistoia Alliance
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * ****************************************************************************
 */
package org.helm.editor.sample;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.helm.editor.HELMApp;
import org.helm.editor.editor.MacromoleculeEditor;
import org.helm.notation.MonomerException;
import org.helm.notation.MonomerFactory;
import org.helm.notation.NotationException;
import org.jdom.JDOMException;

/**
 *
 * @author cheny12
 */
public class EditorSample extends javax.swing.JFrame {

    /**
     * Creates new form MoleculeEditor
     *
     * @throws JDOMException
     * @throws IOException
     * @throws MonomerException
     * @throws NotationException
     */
    public EditorSample() throws MonomerException, IOException, JDOMException, NotationException {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     *
     * @throws JDOMException
     * @throws IOException
     * @throws MonomerException
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() throws MonomerException, IOException, JDOMException, NotationException {
        setTitle("Molecule Editor");

        editor = new MacromoleculeEditor();
//        ModelController.notationUpdated("RNA1{R(A)P.R(U)P.R(A)P.R(A)P.R(A)P.R(U)P.R(A)P.R(A)P}$$$$");
        editor.setNotation("RNA1{R(A)P.R(U)P.R(A)P.R(A)P.R(A)P.R(U)P.R(A)P.R(A)P}$$$$");

        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                editor.reset();
            }
        });

        setNotationButton = new JButton("Set Notation");
        setNotationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String notation = JOptionPane.showInputDialog(null, "Please enter text notation here");
                if (notation != null && notation.length() > 0) {
                    editor.reset();
//                    ModelController.notationUpdated("RNA1{R(A)P.R(U)P.R(A)P.R(A)P.R(A)P.R(U)P.R(A)P.R(A)P}$$$$");
                    editor.setNotation(notation);
                }
            }
        });

        showNotationButton = new JButton("Show Notation");
        showNotationButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println(editor.getNotation());
                JOptionPane.showMessageDialog(null, editor.getNotation());
            }
        });

        showStrucInfoButton = new JButton("Show Structure Info");
        showStrucInfoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String structureInfoXML = editor.getStructureInfoXML();
                    JOptionPane.showMessageDialog(null, "Done, see detail in System.out");
                    System.out.println(structureInfoXML);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(clearButton);
        buttonPanel.add(setNotationButton);
        buttonPanel.add(showNotationButton);
        buttonPanel.add(showStrucInfoButton);
        buttonPanel.add(Box.createHorizontalStrut(5));

        setJMenuBar(editor.getMenuBar());
        add(BorderLayout.CENTER, editor.getContentComponent());
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                try {
                    MonomerFactory.getInstance().saveMonomerCache();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });

        pack();

        setLocationRelativeTo(null);
    }
    private MacromoleculeEditor editor;
    private JButton clearButton;
    private JButton setNotationButton;
    private JButton showNotationButton;
    private JButton showStrucInfoButton;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            HELMApp.initLnF();
            EditorSample mEditor = new EditorSample();
            mEditor.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
