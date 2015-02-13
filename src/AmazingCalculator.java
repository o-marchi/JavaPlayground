import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AmazingCalculator implements ActionListener {

    public JFrame frame;
    public JPanel[] panels;
    public JButton[] buttons;
    public JTextArea input;
    public JTextArea inputResult;

    private String lastDigit;

    public AmazingCalculator() {}

    public JFrame SetFrame() {

        frame = new JFrame("Amazing Calculator");
        frame.setSize(new Dimension(450, 300));
        frame.setLayout(new GridLayout(6, 1));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);

        return frame;
    }

    public void CreatePanels() {

        panels = new JPanel[6];

        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel();
        }
    }

    public void CreateButtons() {

        buttons = new JButton[4 * 4];

        String[] buttonsLabels = {
                "7", "8", "9", "+",
                "4", "5", "6", "-",
                "1", "2", "3", "*",
                "C", "0", "=", "/"
        };

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setText(buttonsLabels[i]);
            buttons[i].addActionListener(this);
            panels[(i / 4) + 2].add(buttons[i]);
        }
    }

    public void CreateInputs() {

        input = new JTextArea(2, 20);
        input.setEditable(true);

        panels[0].add(input);

        inputResult = new JTextArea(2, 20);
        inputResult.setEditable(false);

        panels[1].add(inputResult);
    }

    public void Init() {

        SetFrame();
        CreatePanels();
        CreateButtons();
        CreateInputs();

        for (int i = 0; i < panels.length; i++) {
            frame.add(panels[i]);
        }

        frame.setVisible(true);
    }

    public void Reset() {

        input.setText("");
        inputResult.setText("");
    }

    public void GetResult(String valueString) {

        try {
            ScriptEngineManager mgr = new ScriptEngineManager();
            ScriptEngine engine = mgr.getEngineByName("JavaScript");
            String result = engine.eval(valueString).toString();
            inputResult.setText(result);
        } catch (ScriptException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String  label = e.getActionCommand(),
                value = input.getText();

        if (
            (label == "+" || label == "-" || label == "*" || label == "/") &&
            (lastDigit == "+" || lastDigit == "-" || lastDigit == "*" || lastDigit == "/")
        ) {
            return;
        }

        if (label == "=") {
            GetResult(value);
            return;
        }

        if (label == "C") {
            Reset();
            return;
        }

        lastDigit = label;
        input.append(label);
    }
}
