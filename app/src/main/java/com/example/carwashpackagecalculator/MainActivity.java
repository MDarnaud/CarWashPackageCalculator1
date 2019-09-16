package com.example.carwashpackagecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.util.EthiopicCalendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup RG_Area;
    private TextView TV_Price;
    private EditText ET_Washes;
    private Button BT_Calculate;


    private PackageCalculator packageCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create instance
        packageCalculator = new PackageCalculator();

        RG_Area = findViewById(R.id.RadioGroupArea);
        ET_Washes = findViewById(R.id.EditText_Washes);
        TV_Price = findViewById(R.id.TextView_TotalPrice);
        BT_Calculate = findViewById((R.id.Button_Calculate));

        //click on button method
        BT_Calculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                setWashes();
                registerChangeListener();
                displayPrice();
            }
        });


    }

    private void registerChangeListener() {
        RG_Area.setOnCheckedChangeListener(AreaListener);
    }

    private RadioGroup.OnCheckedChangeListener AreaListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int radioID) {
            switch (radioID) {
                case R.id.Radio_Exterior:
                    packageCalculator.setArea(packageCalculator.Wash_Exterior);
                    break;

                case R.id.Radio_Ext_Int:
                    packageCalculator.setArea(packageCalculator.Wash_Ext_Int);
                    break;
            }
        }

    };

    private void displayPrice(){
        String PriceText = "Price: " + packageCalculator.getTotalPrice();
        TV_Price.setText(PriceText);
    }

    private void setWashes(){
        int washes = Integer.valueOf(Integer.parseInt(ET_Washes.getText().toString()));
        packageCalculator.setWashes(washes);
    }

}
