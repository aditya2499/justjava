/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
   int noofcoffee=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Bhavuk's App");
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        EditText name= (EditText)findViewById(R.id.name_field);
        String nam= name.getText().toString();
        CheckBox whippedcream= findViewById(R.id.whipped_cream);
        boolean has= whippedcream.isChecked();
        display(noofcoffee);
        displayPrice(noofcoffee,has);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number,boolean has) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        String a="total:"+ number;
        a=a + "\n" +
                "thank you";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "just java");
        intent.putExtra(Intent.EXTRA_TEXT,a);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);}
       // priceTextView.setText(a);
       // priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
       // priceTextView.setText("thank you!");
    }
    public void increment(View view)
    {
        noofcoffee++;
        display(noofcoffee);
    }
    public void decrement(View view){
        noofcoffee--;
        display(noofcoffee);

    }
}