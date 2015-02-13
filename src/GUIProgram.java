import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIProgram implements ActionListener {

    public JFrame frame;
    public JPanel buttonsPanel;
    public JPanel inputPanel;
    public JTextArea input;

    public GUIProgram() { }

    public JFrame SetFrame() {

        frame = new JFrame("Simple Program");
        frame.setResizable(false);
        frame.setSize(new Dimension(420, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return frame;
    }

    public void CreatePanels() {

        buttonsPanel = new JPanel();
        inputPanel = new JPanel();
    }

    public void CreateButtons() {

        JButton[] buttons = new JButton[3];
        String[] buttonsLabels = { "Onelio", "Anderson", "Mauricio" };

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttons[i].setText(buttonsLabels[i]);
            buttons[i].addActionListener(this);
            buttonsPanel.add(buttons[i]);
        }
    }

    public void CreateInput() {

        input = new JTextArea(1, 20);
        inputPanel.add(input);
    }

    public void Init() {

        SetFrame();
        CreatePanels();
        CreateButtons();
        CreateInput();

        frame.setLayout(new GridLayout(3, 1));
        frame.add(inputPanel);
        frame.add(buttonsPanel);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String label = e.getActionCommand();
        input.setText(label);
    }
}
