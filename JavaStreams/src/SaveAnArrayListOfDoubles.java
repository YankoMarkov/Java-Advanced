import java.io.*;
import java.util.ArrayList;

public class SaveAnArrayListOfDoubles {

    private static ArrayList<Double> doubles;

    public static void main(String[] args) {
        doubles = new ArrayList<>();
        doubles.add(5.45);
        doubles.add(8.75);
        doubles.add(3.85);
        saveData();
        loadData();
    }

    private static void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("resources/doubles.list")))) {
            oos.writeObject(doubles);

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("resources/doubles.list")))) {
            System.out.println(ois.readObject());

        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        }
    }
}
