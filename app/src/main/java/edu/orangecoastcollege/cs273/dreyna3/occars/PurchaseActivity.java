package edu.orangecoastcollege.cs273.dreyna3.occars;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class PurchaseActivity extends AppCompatActivity {

    // Connections to View
    private EditText mPriceEditText;
    private EditText mDownPaymentEditText;
    private RadioButton mThreeYearRadioButton;
    private RadioButton mFourYearRadioButton;
    private RadioButton mFiveYearRadioButton;

    // Connections to Model
    private CarLoan mCarLoan = new CarLoan();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase);

        mPriceEditText = (EditText) findViewById(R.id.carPriceEditText);
        mDownPaymentEditText = (EditText) findViewById(R.id.downPaymentEditText);
        mThreeYearRadioButton = (RadioButton) findViewById(R.id.threeYearsRadioButton);
        mFourYearRadioButton = (RadioButton) findViewById(R.id.fourYearsRadioButton);
        mFiveYearRadioButton = (RadioButton) findViewById(R.id.fiveYearsRadioButton);
    }

    private void collectCarLoanData(){
        mCarLoan.setPrice(Double.parseDouble(mPriceEditText.getText().toString()));
        mCarLoan.setDownPayment(Double.parseDouble(mDownPaymentEditText.getText().toString()));

        if (mThreeYearRadioButton.isChecked())
            mCarLoan.setTerm(3);
        else if (mFourYearRadioButton.isChecked())
            mCarLoan.setTerm(4);
        else
            mCarLoan.setTerm(5);
    }

    protected void reportSummary(View v){
        collectCarLoanData();
        String report = "Monthly Payment: $" + mCarLoan.monthlyPayment();
        //keep going, more report needed

        // Intents start new actitvities and share data with them
        Intent launchLoanSummary = new Intent(this, LoanSummaryActivity.class);
        // Put data into the intent for loan summary to receive
        launchLoanSummary.putExtra("loanReport", report);
        // Start the 2nd activity
        startActivity(launchLoanSummary);
    }
}
