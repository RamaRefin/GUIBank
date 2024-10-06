package Tugas2GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class Tugas6 extends JFrame {
    private JTextField nameField;
    private JTextField phoneField;
    private ButtonGroup genderGroup;
    private JList<String> savingsList;
    private JSpinner transactionSpinner;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JTextArea txtOutput;
    private JSpinner dateSpinner;

    public Tugas6() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 800);
        this.setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetMenuItem = new JMenuItem("Reset");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        resetMenuItem.addActionListener(e -> {
            nameField.setText("");
            phoneField.setText("");
            genderGroup.clearSelection();
            savingsList.clearSelection();
            transactionSpinner.setValue(1);
            passwordField.setText("");
            confirmPasswordField.setText("");
            txtOutput.setText("");
            dateSpinner.setValue(new java.util.Date());
        });

        exitMenuItem.addActionListener(e -> System.exit(0));

        menu.add(resetMenuItem);
        menu.add(exitMenuItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        JLabel nameLabel = new JLabel("Nama:");
        nameLabel.setBounds(15, 40, 100, 25);

        nameField = new JTextField();
        nameField.setBounds(15, 60, 350, 30);

        JLabel phoneLabel = new JLabel("Nomor HP:");
        phoneLabel.setBounds(15, 100, 100, 25);

        phoneField = new JTextField();
        phoneField.setBounds(15, 120, 350, 30);

        JLabel genderLabel = new JLabel("Jenis Kelamin:");
        genderLabel.setBounds(15, 160, 150, 25);

        JRadioButton maleRadio = new JRadioButton("Laki-Laki");
        maleRadio.setBounds(15, 180, 150, 30);

        JRadioButton femaleRadio = new JRadioButton("Perempuan");
        femaleRadio.setBounds(15, 210, 150, 30);

        JCheckBox foreignCheckBox = new JCheckBox("Warga Negara Asing");
        foreignCheckBox.setBounds(15, 240, 200, 30);

        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        JLabel savingsLabel = new JLabel("Jenis Tabungan:");
        savingsLabel.setBounds(15, 270, 150, 25);

        String[] savingsOptions = {"Silver", "Gold", "Platinum", "Deposito"};
        savingsList = new JList<>(savingsOptions);
        savingsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane savingsScrollPane = new JScrollPane(savingsList);
        savingsScrollPane.setBounds(15, 290, 350, 80);

        JLabel transactionLabel = new JLabel("Frekuensi Transaksi/Bulan:");
        transactionLabel.setBounds(15, 380, 200, 25);

        SpinnerModel transactionModel = new SpinnerNumberModel(1, 1, 100, 1);
        transactionSpinner = new JSpinner(transactionModel);
        transactionSpinner.setBounds(220, 400, 100, 30);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(15, 440, 100, 25);

        passwordField = new JPasswordField();
        passwordField.setBounds(15, 460, 350, 30);

        JLabel confirmPasswordLabel = new JLabel("Konfirmasi Password:");
        confirmPasswordLabel.setBounds(15, 500, 200, 25);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(15, 520, 350, 30);

        JLabel dobLabel = new JLabel("Tanggal Lahir:");
        dobLabel.setBounds(15, 560, 100, 25);

        SpinnerModel dateModel = new SpinnerDateModel();
        dateSpinner = new JSpinner(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
        dateSpinner.setEditor(dateEditor);
        dateSpinner.setBounds(15, 580, 350, 30);

        JButton saveButton = new JButton("Simpan");
        saveButton.setBounds(15, 620, 100, 40);

        txtOutput = new JTextArea();
        txtOutput.setBounds(400, 60, 450, 450);
        txtOutput.setEditable(false);

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

                String jenisTabungan = savingsList.getSelectedValue();
                int frekuensiTransaksi = (Integer) transactionSpinner.getValue();
                char[] password = passwordField.getPassword();
                char[] confirmPassword = confirmPasswordField.getPassword();

                boolean passwordsMatch = Arrays.equals(password, confirmPassword);

                txtOutput.setText("");
                txtOutput.append("Nama: " + nama + "\n");
                txtOutput.append("Nomor HP: " + nomorHP + "\n");
                txtOutput.append("Jenis Kelamin: " + jenisKelamin + "\n");
                txtOutput.append(wargaNegaraAsing + "\n");
                txtOutput.append("Jenis Tabungan: " + jenisTabungan + "\n");
                txtOutput.append("Frekuensi Transaksi/Bulan: " + frekuensiTransaksi + "\n");
                txtOutput.append("Password match: " + (passwordsMatch ? "Yes" : "No") + "\n");
                nameField.setText("");
                phoneField.setText("");
                genderGroup.clearSelection();
                foreignCheckBox.setSelected(false);
                savingsList.clearSelection();
                transactionSpinner.setValue(1);
                passwordField.setText("");
                confirmPasswordField.setText("");
                dateSpinner.setValue(new java.util.Date());
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
        this.add(savingsLabel);
        this.add(savingsScrollPane);
        this.add(transactionLabel);
        this.add(transactionSpinner);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(confirmPasswordLabel);
        this.add(confirmPasswordField);
        this.add(dobLabel);
        this.add(dateSpinner);
        this.add(saveButton);
        this.add(txtOutput);
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

