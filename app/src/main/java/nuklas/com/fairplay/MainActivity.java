package nuklas.com.fairplay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText amountToDivideInput;
    EditText firstPersonSalaryInput;
    EditText secondPersonSalaryInput;
    TextView firstPersonPart;
    TextView secondPersonPart;
    Button calculateButton;
    int amountToDivide;
    int firstPersonSalary;
    int secondPersonSalary;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amountToDivideInput = (EditText) findViewById(R.id.amount_to_divide);
        firstPersonSalaryInput = (EditText) findViewById(R.id.first_person_salary);
        secondPersonSalaryInput = (EditText) findViewById(R.id.second_person_salary);
        secondPersonPart = (TextView) findViewById(R.id.second_person_part);
        firstPersonPart = (TextView) findViewById(R.id.first_person_part);
        calculateButton = (Button) findViewById(R.id.calulate_button);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAmounts();
            }
        });

    }

    private void calculateAmounts() {
        getUserInput();
        Calculator calculator = new Calculator(firstPersonSalary, secondPersonSalary);
        Map<String, Float> result = calculator.calculate(amountToDivide);
        setOutput(result);

    }

    public void getUserInput() {
        amountToDivide = Integer.parseInt((amountToDivideInput.getText().toString()));
        firstPersonSalary = Integer.parseInt(firstPersonSalaryInput.getText().toString());
        secondPersonSalary = Integer.parseInt(secondPersonSalaryInput.getText().toString());
    }

    public void setOutput(Map<String,Float> output) {
        firstPersonPart.setText(String.valueOf(output.get("firstAmount")));
        secondPersonPart.setText(String.valueOf(output.get("secondAmount")));

    }
}
