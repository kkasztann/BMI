package pl.slowik.kasztan.daniel.bmi;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivityBMI extends AppCompatActivity implements View.OnClickListener {

    public Button bPrzelicz;
    public EditText etMasa;
    public EditText etWzrost;
    public EditText etBMI;
    public TextView tvOcena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_bmi);

        bPrzelicz =  (Button) findViewById(R.id.buttonPrzelicz);
        bPrzelicz.setOnClickListener(this);
        etMasa = (EditText)findViewById(R.id.etMasa);
        etWzrost = (EditText) findViewById(R.id.etWzrost);
        etBMI = (EditText) findViewById(R.id.etBMI);
        etBMI.setEnabled(false);

        tvOcena = (TextView) findViewById(R.id.tvOcena);
        tvOcena.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
    }

    public void onClick(View v){
        String sMasa = etMasa.getText().toString().trim();
        String sWzrost = etWzrost.getText().toString().trim();

        double masa = Double.parseDouble(sMasa);
        double wzrost =  Double.parseDouble(sWzrost);

        double wzrostWMetrach = wzrost/100;

        double bmi = masa/(wzrostWMetrach*wzrostWMetrach);
        bmi*=100;
        bmi = Math.round(bmi);
        bmi/=100;

        String sBmi = String.valueOf(bmi);

        etBMI.setText(sBmi);

        if (bmi<18.5){
            tvOcena.setText("Niedowaga");
            tvOcena.setBackgroundColor(Color.RED);
            tvOcena.setTextColor(Color.BLACK);
            etBMI.setTextColor(Color.RED);
        }
        else if (bmi>25.0){
            tvOcena.setText("Nadwaga");
            tvOcena.setBackgroundColor(Color.RED);
            tvOcena.setTextColor(Color.BLACK);
            etBMI.setTextColor(Color.RED);
        }
        else {
            tvOcena.setText("BMI w normie");
            tvOcena.setBackgroundColor(Color.GREEN);
            tvOcena.setTextColor(Color.BLACK);
            etBMI.setTextColor(Color.GREEN);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
