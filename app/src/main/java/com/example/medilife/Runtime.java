import java.text.SimpleDateFormat;
import java.util.*;
public class Runtime {
    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        date.toString();
        System.out.println(formatter.format(date));
    }
}
