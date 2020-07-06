package com.example.gstcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

import static android.graphics.Color.rgb;

public class HomeActivity extends AppCompatActivity {

    private float gst = 5;
    private Float netAmt, gstAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final Button btn5 = findViewById(R.id.button5);
        final Button btn12 = findViewById(R.id.button12);
        final Button btn18 = findViewById(R.id.button18);
        final Button btn28 = findViewById(R.id.button28);
        Button add = findViewById(R.id.add);
        Button sub = findViewById(R.id.sub);
        final TextView netAmount = findViewById(R.id.net_amount);
        final EditText initAmt = findViewById(R.id.initial_amount);
        final EditText gstAmt = findViewById(R.id.gst_amount);
        final EditText sgstCgst = findViewById(R.id.sgst_cgst);

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gst = 5;
                btn5.setBackground(getDrawable(R.drawable.buttonactive));
                btn12.setBackground(getDrawable(R.drawable.button));
                btn18.setBackground(getDrawable(R.drawable.button));
                btn28.setBackground(getDrawable(R.drawable.button));
                btn5.setTextColor(rgb(210, 243, 247));
                btn12.setTextColor(rgb(61, 8, 234));
                btn18.setTextColor(rgb(61, 8, 234));
                btn28.setTextColor(rgb(61, 8, 234));
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gst = 12;
                btn5.setBackground(getDrawable(R.drawable.button));
                btn12.setBackground(getDrawable(R.drawable.buttonactive));
                btn18.setBackground(getDrawable(R.drawable.button));
                btn28.setBackground(getDrawable(R.drawable.button));
                btn12.setTextColor(rgb(210, 243, 247));
                btn5.setTextColor(rgb(61, 8, 234));
                btn18.setTextColor(rgb(61, 8, 234));
                btn28.setTextColor(rgb(61, 8, 234));
            }
        });
        btn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gst = 18;
                btn5.setBackground(getDrawable(R.drawable.button));
                btn12.setBackground(getDrawable(R.drawable.button));
                btn18.setBackground(getDrawable(R.drawable.buttonactive));
                btn28.setBackground(getDrawable(R.drawable.button));
                btn18.setTextColor(rgb(210, 243, 247));
                btn12.setTextColor(rgb(61, 8, 234));
                btn5.setTextColor(rgb(61, 8, 234));
                btn28.setTextColor(rgb(61, 8, 234));
            }
        });
        btn28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gst = 28;
                btn5.setBackground(getDrawable(R.drawable.button));
                btn12.setBackground(getDrawable(R.drawable.button));
                btn18.setBackground(getDrawable(R.drawable.button));
                btn28.setBackground(getDrawable(R.drawable.buttonactive));
                btn28.setTextColor(rgb(210, 243, 247));
                btn12.setTextColor(rgb(61, 8, 234));
                btn18.setTextColor(rgb(61, 8, 234));
                btn5.setTextColor(rgb(61, 8, 234));
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAmt.getText().toString();
                if (TextUtils.isEmpty(initAmt.getText().toString())) {
                    netAmt = 0f;
                    gstAmount = 0f;
                    initAmt.setError("Please enter valid amount");
                } else {
                    netAmt = (Float.parseFloat(initAmt.getText().toString()) + Float.parseFloat(initAmt.getText().toString()) * (gst / 100));
                    gstAmount = (Float.parseFloat(initAmt.getText().toString()) * (gst / 100));
                }
                netAmount.setText("₹" + new DecimalFormat("##.##").format(netAmt));
                gstAmt.setText("₹" + new DecimalFormat("##.##").format(gstAmount));
                sgstCgst.setText("₹" + new DecimalFormat("##.##").format((gstAmount / 2)));
                gstAmt.setTextColor(rgb(0, 0, 0));
                sgstCgst.setTextColor(rgb(0, 0, 0));
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(initAmt.getText().toString())) {
                    netAmt = 0f;
                    gstAmount = 0f;
                    initAmt.setError("Please enter valid amount");
                } else {
                    netAmt = (Float.parseFloat(initAmt.getText().toString()) - Float.parseFloat(initAmt.getText().toString()) * (gst / 100));
                    gstAmount = (Float.parseFloat(initAmt.getText().toString()) * (gst / 100));
                }
                netAmount.setText("₹" + new DecimalFormat("##.##").format(netAmt));
                gstAmt.setText("₹" + new DecimalFormat("##.##").format(gstAmount));
                sgstCgst.setText("₹" + new DecimalFormat("##.##").format((gstAmount / 2)));
                gstAmt.setTextColor(rgb(0, 0, 0));
                sgstCgst.setTextColor(rgb(0, 0, 0));
            }
        });
    }
}
