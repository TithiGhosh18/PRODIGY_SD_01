import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverterGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelTemp = new JLabel("Enter Temperature:");
        labelTemp.setBounds(50, 50, 150, 25);
        JTextField tempField = new JTextField();
        tempField.setBounds(200, 50, 100, 25);

        JLabel labelUnit = new JLabel("Select Unit:");
        labelUnit.setBounds(50, 100, 150, 25);
        String[] units = {"Celsius", "Fahrenheit", "Kelvin"};
        JComboBox<String> unitBox = new JComboBox<>(units);
        unitBox.setBounds(200, 100, 100, 25);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(150, 150, 100, 30);

        JTextArea resultArea = new JTextArea();
        resultArea.setBounds(50, 200, 300, 50);
        resultArea.setEditable(false);

        frame.setLayout(null);
        frame.add(labelTemp);
        frame.add(tempField);
        frame.add(labelUnit);
        frame.add(unitBox);
        frame.add(convertButton);
        frame.add(resultArea);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double temperature = Double.parseDouble(tempField.getText());
                    String selectedUnit = (String) unitBox.getSelectedItem();
                    if (selectedUnit != null) {
                        String result = "";
                        if (selectedUnit.equals("Celsius")) {
                            double fahrenheit = (temperature * 9 / 5) + 32;
                            double kelvin = temperature + 273.15;
                            result = String.format("Fahrenheit: %.2f°F\nKelvin: %.2f K", fahrenheit, kelvin);
                        } else if (selectedUnit.equals("Fahrenheit")) {
                            double celsius = (temperature - 32) * 5 / 9;
                            double kelvin = celsius + 273.15;
                            result = String.format("Celsius: %.2f°C\nKelvin: %.2f K", celsius, kelvin);
                        } else if (selectedUnit.equals("Kelvin")) {
                            double celsius = temperature - 273.15;
                            double fahrenheit = (celsius * 9 / 5) + 32;
                            result = String.format("Celsius: %.2f°C\nFahrenheit: %.2f°F", celsius, fahrenheit);
                        }
                        resultArea.setText(result);
                    }
                } catch (NumberFormatException ex) {
                    resultArea.setText("Invalid input! Please enter a numeric value.");
                }
            }
        });

        frame.setVisible(true);
    }
}
