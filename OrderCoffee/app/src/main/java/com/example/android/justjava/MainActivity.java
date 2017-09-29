package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;
import android.content.Context;

import static android.R.id.input;
import static android.R.string.yes;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity=0;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
    }

    public String createOrderSummary(String name,int price,boolean first,boolean second)
    {
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd Whipped Cream? " + first;
        priceMessage += "\nAdd Chocolate? " + second;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: Rs " + price;
        priceMessage += "\nThank You!";
        return priceMessage;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText input = (EditText)findViewById(R.id.name);
        String name = input.getText().toString();

        CheckBox whippedCreamBox = (CheckBox)findViewById(R.id.whipcream);
        boolean hasWhippedCream = whippedCreamBox.isChecked();

        CheckBox chocolate = (CheckBox)findViewById(R.id.chocolate);
        boolean hasChocolate = chocolate.isChecked();

        int price = calcprice(hasWhippedCream,hasChocolate);
        String priceMessage = createOrderSummary(name,price,hasWhippedCream,hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT,"Just Java order app for " + name);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

    private int calcprice(boolean first,boolean second)
    {
        int basePrice = 0, finalPrice = 0;

        if (first == false && second == false)
            basePrice = 5;
        else if ((first == true && second == false) || (first == false && second == true)) {
            if (first == true)
                basePrice = 6;
            else
                basePrice = 7;
        } else {
            basePrice = 8;
        }

        finalPrice = basePrice * quantity;
        return finalPrice;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void increment(View view)
    {
        if(quantity <=99)
            display(++quantity);
        else
            Toast.makeText(context,"Only 100 cups of coffee can be ordered!", Toast.LENGTH_LONG).show();

    }

    public void decrement(View view) {
        if (quantity >0)
            display(--quantity);
        else
            Toast.makeText(context, "Zero is the minimum limit!", Toast.LENGTH_LONG).show();
    }
}
