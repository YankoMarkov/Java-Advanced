import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class RoyalNonStop {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Integer[] dimensions = Arrays.stream(read.readLine().split("\\s+")).map(Integer::valueOf).toArray(Integer[]::new);
        Integer maxRow = dimensions[0];
        Integer maxColumn = dimensions[1];
        Double[] productPrices = Arrays.stream(read.readLine().split("\\s+")).map(Double::valueOf).toArray(Double[]::new);

        BigDecimal totalMoney = BigDecimal.ZERO;
        Integer totalCustomers = 0;

        String inputLine = null;
        while(!(inputLine = read.readLine()).equals("Royal Close")) {

            String[] customerArguments = inputLine.split(" ");
            Integer initialRow = Integer.valueOf(customerArguments[0]);
            Integer initialColumn = Integer.valueOf(customerArguments[1]);
            BigDecimal currentSum = BigDecimal.ZERO;

            if(initialRow >= initialColumn) {
                //FIRST GO LEFT
                for (Integer currentColumn = initialColumn; currentColumn >= 0; currentColumn--) {
                    BigDecimal rowValue = new BigDecimal(initialRow + 1);
                    BigDecimal colValue = new BigDecimal(currentColumn + 1);
                    BigDecimal productPrice = new BigDecimal(productPrices[initialRow % 2]);
                    BigDecimal productSum = rowValue.multiply(colValue).multiply(productPrice);
                    currentSum = currentSum.add(productSum);
                }
                //THEN WE GO UP
                for (Integer currentRow = initialRow - 1; currentRow > 0; currentRow--) {
                    BigDecimal rowValue = new BigDecimal(currentRow + 1);
                    BigDecimal productPrice = new BigDecimal(productPrices[currentRow % 2]);
                    BigDecimal productSum = rowValue.multiply(productPrice);
                    currentSum = currentSum.add(productSum);
                }
            }
            else {
                //FIRST WE GO UP
                for (Integer currentRow = initialRow; currentRow >= 0; currentRow--) {
                    BigDecimal rowValue = new BigDecimal(currentRow + 1);
                    BigDecimal colValue = new BigDecimal(initialColumn + 1);
                    BigDecimal productPrice = new BigDecimal(productPrices[currentRow % 2]);
                    BigDecimal productSum = rowValue.multiply(colValue).multiply(productPrice);
                    currentSum = currentSum.add(productSum);
                }
                //THEN WE GO LEFT
                for (Integer currentColumn = initialColumn - 1; currentColumn > 0; currentColumn--) {
                    BigDecimal colValue = new BigDecimal(currentColumn + 1);
                    BigDecimal productPrice = new BigDecimal(productPrices[0]);
                    BigDecimal productSum = colValue.multiply(productPrice);
                    currentSum = currentSum.add(productSum);
                }
            }
            totalMoney = totalMoney.add(currentSum);
            totalCustomers++;
        }
        System.out.println(totalMoney.setScale(6, RoundingMode.HALF_EVEN));
        System.out.println(totalCustomers);
    }
}
