import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TestMemento extends JFrame{
    public static void main(String[] args) {
        new TestMemento();
    }
    private JButton save, undo, redo;

    private JTextArea theReport = new JTextArea(20,50);

    // object retrieves and stores all the reports
    Caretaker caretaker = new Caretaker();

    // object sets the value for the report and gets the report stored in the current memento

    Originator originator = new Originator();

    int saveFiles = 0, currentReport = 0;


    public TestMemento(){

        this.setSize(600,650);
        this.setTitle("Order Report for Medication");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel1 = new JPanel();

        panel1.add(new JLabel("Order Report"));

        panel1.add(theReport);

        // save, undo, and redo buttons
        ButtonListener undoListener = new ButtonListener();
        ButtonListener redoListener = new ButtonListener();
        ButtonListener saveListener = new ButtonListener();

        undo = new JButton("Undo");
        undo.addActionListener(undoListener);

        redo = new JButton("Redo");
        redo.addActionListener(redoListener);

        save = new JButton("Save");
        save.addActionListener(saveListener);

        panel1.add(undo);
        panel1.add(redo);
        panel1.add(save);

        this.add(panel1);
        this.setVisible(true);
    }

    // referenced from youtube: Derek Banas
    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if(e.getSource() == save){

                String textInTextArea = theReport.getText();

                // set current memento
                originator.set(textInTextArea);

                // add new report to store in memento
                caretaker.addMemento( originator.storeInMemento() );

                saveFiles++;
                currentReport++;

                System.out.println("Save Files " + saveFiles);

                undo.setEnabled(true);

            } else

                // implement undo button
            if(e.getSource() == undo){

                if(currentReport >= 1){

                    currentReport--;

                    String textBoxString = originator.restoreFromMemento( caretaker.getMemento(currentReport) );

                    theReport.setText(textBoxString);

                    redo.setEnabled(true);

                } else {

                    undo.setEnabled(false);

                }

            } else

                // implement redo
            if(e.getSource() == redo){

                if((saveFiles - 1) > currentReport){

                    currentReport++;

                    String textBoxString = originator.restoreFromMemento( caretaker.getMemento(currentReport) );

                    theReport.setText(textBoxString);

                    undo.setEnabled(true);

                } else {

                    redo.setEnabled(false);

                }

            }

        }

    }

}