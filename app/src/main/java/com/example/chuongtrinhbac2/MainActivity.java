package com.example.chuongtrinhbac2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText soThuNhat, soThuhai , soThuBa;
    private TextView ketQua;
    private Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhxa();
        // Giải phương trình bậc 2: ax2 + bx + c = 0
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                float n1 = Float.parseFloat(soThuNhat.getText().toString());
                float n2 = Float.parseFloat(soThuhai.getText().toString());
                float n3 = Float.parseFloat(soThuBa.getText().toString());
                giaiPTBac2(n1, n2, n3);
            }
        });

    }

    public void anhxa() {
        soThuNhat = (EditText) findViewById(R.id.etextSoThuNhat);
        soThuhai = (EditText) findViewById(R.id.etextSoThuHai);
        soThuBa = (EditText) findViewById(R.id.etextSoThuBa);
        ketQua = (TextView) findViewById(R.id.txtKetQua);
        submit = (Button) findViewById(R.id.btnSubmit);
    }

    public void giaiPTBac2(float a, float b, float c) {
        if(a == 0) {
            if (b == 0) {
                ketQua.setText("Phương trình vô nghiệm!");
            }else {
                float x = -c/b;
                ketQua.setText(String.valueOf("x = " + x));
            }
        }
        else {
            // tính delta
            float delta = b*b - 4*a*c;
            float x1;
            float x2;
            // tính nghiệm
            if (delta > 0) {
                x1 = (float) ((-b + Math.sqrt(delta)) / (2*a));
                x2 = (float) ((-b - Math.sqrt(delta)) / (2*a));
                ketQua.setText("x1 = " + x1 + " và x2 = " + x2);
            } else if (delta == 0) {
                x1 = (-b / (2 * a));
                ketQua.setText("x1 = x2 = " + x1);
            } else {
                ketQua.setText("Phương trình vô nghiệm!");
            }
        }
    }
}