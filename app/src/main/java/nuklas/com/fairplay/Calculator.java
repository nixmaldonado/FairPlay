package nuklas.com.fairplay;
import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final float firstIncome;

    private final float secondIncome;

    public Calculator(float firstIncome, float secondIncome) {
        if ((firstIncome + secondIncome) <= 0) throw new IllegalArgumentException();

        this.firstIncome = firstIncome;
        this.secondIncome = secondIncome;
    }

    public Map<String, Float> calculate(float expenseAmount) {
        float percentage = expenseAmount * 100 / (this.firstIncome + this.secondIncome);

        Map<String, Float> result = new HashMap<>();

        result.put("firstAmount", this.firstIncome * percentage / 100);
        result.put("secondAmount", this.secondIncome * percentage / 100);

        return result;
    }

}
