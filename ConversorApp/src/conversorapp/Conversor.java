package conversorapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Conversor extends JFrame implements ActionListener {
    private JLabel titleLabel, fromLabel, toLabel, amountLabel, resultLabel;
    private JComboBox<String> conversionTypeComboBox, fromComboBox, toComboBox;
    private JTextField amountTextField, resultTextField;
    private JButton BtnConvertir, BtnLimpiar;

    private Moneda ConvertirMoneda;
    private UnidadesMetricas ConverirUnidadesMetricas;
    private Temperatura ConvertirTemperatura;

    public Conversor() {
        setTitle("Conversor de Medidas");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(7, 2));

        titleLabel = new JLabel("Conversor de Medidas");
        fromLabel = new JLabel("De:");
        toLabel = new JLabel("A:");
        amountLabel = new JLabel("Cantidad:");
        resultLabel = new JLabel("Resultado:");

        conversionTypeComboBox = new JComboBox<>(new String[]{"Moneda", "Unidades de Medida", "Temperatura"});
        fromComboBox = new JComboBox<>();
        toComboBox = new JComboBox<>();
        amountTextField = new JTextField();
        resultTextField = new JTextField();
        resultTextField.setEditable(false);

        BtnConvertir = new JButton("Convertir");
        BtnLimpiar = new JButton("Limpiar");

        conversionTypeComboBox.addActionListener(this);
        BtnConvertir.addActionListener(this);
        BtnLimpiar.addActionListener(this);

        add(titleLabel);
        add(conversionTypeComboBox);
        add(fromLabel);
        add(fromComboBox);
        add(toLabel);
        add(toComboBox);
        add(amountLabel);
        add(amountTextField);
        add(resultLabel);
        add(resultTextField);
        add(BtnConvertir);
        add(BtnLimpiar);

        ConvertirMoneda = new Moneda();
        ConverirUnidadesMetricas = new UnidadesMetricas();
        ConvertirTemperatura = new Temperatura();
    }

    private void updateUnitComboBoxes(String conversionType) {
        if (conversionType.equals("Moneda")) {
            fromComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Peso Colombiano", "Peso Mexicano", "Peso Argentino", "Dólar", "Euro", "Libras Esterlinas"}));
            toComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Peso Colombiano", "Peso Mexicano", "Peso Argentino", "Dólar", "Euro", "Libras Esterlinas"}));
        } else if (conversionType.equals("Unidades de Medida")) {
            fromComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Milímetro", "Centímetro", "Metro", "Millas", "Kilómetros"}));
            toComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Milímetro", "Centímetro", "Metro", "Millas", "Kilómetros"}));
        } else if (conversionType.equals("Temperatura")) {
            fromComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"}));
            toComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"}));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == conversionTypeComboBox) {
            String selectedType = (String) conversionTypeComboBox.getSelectedItem();
            updateUnitComboBoxes(selectedType);
        } else if (e.getSource() == BtnConvertir) {
            String conversionType = (String) conversionTypeComboBox.getSelectedItem();
            String fromUnit = (String) fromComboBox.getSelectedItem();
            String toUnit = (String) toComboBox.getSelectedItem();
            double amount = Double.parseDouble(amountTextField.getText());
            double result = 0.0;

            if (conversionType.equals("Moneda")) {
                result = ConvertirMoneda.convert(fromUnit, toUnit, amount);
            } else if (conversionType.equals("Unidades de Medida")) {
                result = ConverirUnidadesMetricas.convert(fromUnit, toUnit, amount);
            } else if (conversionType.equals("Temperatura")) {
                result = ConvertirTemperatura.convert(amount, fromUnit, toUnit);
            }

            DecimalFormat decimalFormat = new DecimalFormat("##.##");
            resultTextField.setText(decimalFormat.format(result));
        } else if (e.getSource() == BtnLimpiar) {
            amountTextField.setText("");
            resultTextField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Conversor app = new Conversor();
            app.setVisible(true);
        });
    }
}
