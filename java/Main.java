import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
                Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
                String line;
                ArrayList<int[]> output = new ArrayList<>();

                while ((line = br.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    int[] intParts = {Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};

                    if (map.containsKey(intParts[0])) {
                        Integer seqNumber;
                        Map tempMap = map.get(intParts[0]);

                        if ((seqNumber = (map.get(intParts[0]).get(intParts[1]))) != null) {
                            int[] array = {intParts[0], intParts[1], seqNumber, 0};
                            output.add(array);
                        }
                        else {
                            Map temp = map.get(intParts[0]);
                            seqNumber = temp.keySet().size()+1;
                            temp.put(intParts[1], seqNumber);
                            int[] array = {intParts[0], intParts[1], seqNumber, 0};
                            output.add(array);
                        }
                    }
                    else {
                        //System.out.println("map.put(" + intParts[0] + ", new HashMap<>().put(" + intParts[1] + ", 1)");
                        Map seqMap = new HashMap<>();
                        seqMap.put(intParts[1], 1);
                        map.put(intParts[0], seqMap);
                        int[] array = {intParts[0], intParts[1], 1, 0};
                        output.add(array);
                    }
                }
                for (int[] array: output)
                    System.out.println(array[0] + "|" + array[1] + "[" + array[2] + " of " + map.get(array[0]).keySet().size() + "]");
            }
        catch (IOException ex) {
            System.out.println(ex.toString());
            System.exit(-1);
        }
    }
}
