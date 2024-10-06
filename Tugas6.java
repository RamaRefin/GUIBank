package Tugas2GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tugas6 extends JFrame {

    public Tugas6() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Nama:");
        nameLabel.setBounds(15, 40, 80, 10);

        JTextField nameField = new JTextField();
        nameField.setBounds(15, 60, 350, 30);

        JLabel phoneLabel = new JLabel("Nomor HP:");
        phoneLabel.setBounds(15, 100, 80, 10);

        JTextField phoneField = new JTextField();
        phoneField.setBounds(15, 120, 350, 30);

        JLabel genderLabel = new JLabel("Jenis Kelamin:");
        genderLabel.setBounds(15, 160, 100, 10);

        JRadioButton maleRadio = new JRadioButton("Laki-Laki");
        maleRadio.setBounds(15, 180, 150, 30);

        JRadioButton femaleRadio = new JRadioButton("Perempuan");
        femaleRadio.setBounds(15, 210, 150, 30);

        JCheckBox foreignCheckBox = new JCheckBox("Warga Negara Asing");
        foreignCheckBox.setBounds(15, 240, 200, 30);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        JButton saveButton = new JButton("Simpan");
        saveButton.setBounds(15, 280, 100, 40);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(15, 330, 350, 100);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = nameField.getText();
                String nomorHP = phoneField.getText();
                String jenisKelamin = "";
                if (maleRadio.isSelected()) {
                    jenisKelamin = "Laki-Laki";
                } else if (femaleRadio.isSelected()) {
                    jenisKelamin = "Perempuan";
                }
                String wargaNegaraAsing = foreignCheckBox.isSelected() ? "Warga Negara Asing" : "Bukan Warga Negara Asing";
                textArea.append("Nama: " + nama + "\n");
                textArea.append("Nomor HP: " + nomorHP + "\n");
                textArea.append("Jenis Kelamin: " + jenisKelamin + "\n");
                textArea.append(wargaNegaraAsing + "\n");
                nameField.setText("");
                phoneField.setText("");
                genderGroup.clearSelection();
                foreignCheckBox.setSelected(false);
            }
        });

        this.add(nameLabel);
        this.add(nameField);
        this.add(phoneLabel);
        this.add(phoneField);
        this.add(genderLabel);
        this.add(maleRadio);
        this.add(femaleRadio);
        this.add(foreignCheckBox);
        this.add(saveButton);
        this.add(textArea);

        this.setSize(400, 500);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Tugas6 form = new Tugas6();
                form.setVisible(true);
            }
        });
    }
}

