import java.util.ArrayList;

public class Memento {

    private String report;
    // Save order report to memento
    public Memento(String reportSave) {
        report = reportSave; }

    public String getSavedReport() { return report; }
}

class Originator{

    private String report;

    public void set(String newReport) {
        System.out.println("From Originator: Current version of order report\n"+ newReport+ "\n");
        this.report = newReport;
    }

    // Create a new memento for new report
    public Memento storeInMemento() {
        System.out.println("From Originator: Saving to Memento");
        return new Memento(report);
    }

    public String restoreFromMemento(Memento memento) {

        // call current saved report from the memento
        report = memento.getSavedReport();

        System.out.println("From Originator: Last Saved Report in Memento\n"+ report + "\n");

        return report;
    }
}
class Caretaker {
    // create array list for the saved reports in the memento
    ArrayList<Memento> savedReports = new ArrayList<Memento>();

    public void addMemento(Memento m) { savedReports.add(m); }

    public Memento getMemento(int index) { return savedReports.get(index); }
}