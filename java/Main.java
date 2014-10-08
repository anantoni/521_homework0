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
                    int part1 = Integer.parseInt(parts[0]), part2 = Integer.parseInt(parts[1]);

                    if (map.containsKey(part1)) {
                        Integer seqNumber;
                        Map tempMap = map.get(part1);

                        if ((seqNumber = (map.get(part1).get(part2))) != null) {
                            int[] array = {part1, part2, seqNumber, 0};
                            output.add(array);
                        }
                        else {
                            Map temp = map.get(part1);
                            seqNumber = temp.keySet().size()+1;
                            temp.put(part2, seqNumber);
                            int[] array = {part1, part2, seqNumber, 0};
                            output.add(array);
                        }
                    }
                    else {
                        Map seqMap = new HashMap<>();
                        seqMap.put(part2, 1);
                        map.put(part1, seqMap);
                        int[] array = {part1, part2, 1, 0};
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
