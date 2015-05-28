package com.example.lorik.gootherapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.EditText;

import org.apache.http.protocol.HTTP;

import java.util.Calendar;


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

    /*public void AddCalendar (View view)
    {
        Intent calendarIntent = new Intent(Intent.ACTION_INSERT,CalendarContract.Events.CONTENT_URI);
        //Calendar beginTime = Calendar.getInstance().set(2012, 0, 19, 7, 30);
        //Calendar beginTime = CalendarContract.getInstance().set(2015,07,07);

        //Calendar endTime = Calendar.getInstance().set(201, 0, 19, 10, 30);
        //calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis());
        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,

        calendarIntent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis());
        calendarIntent.putExtra(CalendarContract.Events.TITLE, "Ninja class");
        calendarIntent.putExtra(CalendarContract.Events.EVENT_LOCATION, "Secret dojo");
    }*/

    public void callNumber(View view)
    {
        //posted_by = "111-333-222-4";
        number = editTextCallNumber.getText().toString();
        //String uri = "tel:" + posted_by.trim() ;
        String uri = "tel:" +  number.trim();
        Intent intentCall = new Intent(Intent.ACTION_DIAL);
        //intentCall.setData(Uri.parse(uri));
        intentCall.setData(Uri.parse(uri));
        startActivity(intentCall);

    }



}
