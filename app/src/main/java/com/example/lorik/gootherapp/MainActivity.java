package com.example.lorik.gootherapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.EditText;
import java.util.Calendar;

import org.apache.http.protocol.HTTP;



public class MainActivity extends Activity {

    public String email;
    public String subject;
    public String yourText;
    public EditText editTextSendTo;
    public EditText editTextSubject;
    public EditText editTextTypeHere;
    public EditText editTextCallNumber;
    public String posted_by;
    public String number;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //LOCALS
        editTextSendTo = (EditText) findViewById(R.id.editTextSendTo);
        editTextSubject = (EditText) findViewById(R.id.editTextSubject);
        editTextTypeHere = (EditText) findViewById(R.id.editTextTypeHere);
        editTextCallNumber = (EditText) findViewById(R.id.editTextCallNumber);
    }

    public void SendEmail(View view)
    {
        email = editTextSendTo.getText().toString();
        subject = editTextSubject.getText().toString();
        yourText = editTextTypeHere.getText().toString();
        //INTENT
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
// The intent does not have a URI, so declare the "text/plain" MIME type
        emailIntent.setType(HTTP.PLAIN_TEXT_TYPE);
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {email}); // recipients
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, yourText);
        //emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
// You can also attach multiple items by passing an ArrayList of Uris
        startActivity(emailIntent);
    }

    public void addCalendar (View view)
    {
        Intent calendarIntent = new Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI);
        Calendar beginTime = Calendar.getInstance();
        beginTime.set(2015,7,7);
        Calendar endTime = Calendar.getInstance();
        endTime.set(2015,7,8);
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
        calendarIntent.putExtra(CalendarContract.Events.TITLE, "Ninja class");
        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo");
        startActivity(calendarIntent);
    }

    public void callNumber(View view)
    {
        number = editTextCallNumber.getText().toString();
        String uri = "tel:" +  number.trim();
        Intent intentCall = new Intent(Intent.ACTION_DIAL);
        intentCall.setData(Uri.parse(uri));
        startActivity(intentCall);

    }



}
