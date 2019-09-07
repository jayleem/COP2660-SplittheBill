package com.jayleem.splitthebill;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class HomeScreen extends AppCompatActivity {

    public String[] spinnerArray = {"Excellent", "Average", "Poor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Spinner spinner = (Spinner) findViewById(R.id.mySpinner);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        spinner.setAdapter(spinnerArrayAdapter);
        spinner.setPrompt("Rate our service.");
    }

    public void calcCosts(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.mySpinner);
        TextView costLabel = (TextView) findViewById(R.id.costLabel);
        EditText billAmt = (EditText) findViewById(R.id.inputBill);
        EditText numParty = (EditText) findViewById(R.id.inputNumParty);

        if (billAmt.getText().length() > 0 && numParty.getText().length() > 0) {

            double bill = Double.valueOf(billAmt.getText().toString());
            double tipAmt = bill * 0.18;
            double total = bill + tipAmt;

            double indvShare = bill / Integer.valueOf(numParty.getText().toString());
            double indvTip = tipAmt / Integer.valueOf(numParty.getText().toString());

            DecimalFormat currency = new DecimalFormat("$###,###.##");

            costLabel.setText(
                    "Bill: " + currency.format(total) +
                    '\n' + "Tip: " + currency.format(tipAmt) +
                    '\n' + "Individual Share: " + currency.format(indvShare) +
                    '\n' + "Individual Tip: " + currency.format(indvTip)
            );
        }
    }
}