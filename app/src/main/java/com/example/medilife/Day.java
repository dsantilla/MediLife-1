import java.util.*;

public class Day {
    ArrayList<String> reminders = new ArrayList<>();
    public Day() {

    }

    public void addReminder(ArrayList reminders, int index) {
        int size = this.reminders.size();
        this.reminders.add(index,"New reminder");
    }

    public void removeReminder(ArrayList reminders, int index) {
        this.reminders.remove(index);
    }
}
