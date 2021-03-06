package com.example.gaby.tvt;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;


public class Student extends Activity {

    //First period
    ImageView teacherpic1;
    TextView class1;
    TextView teacher1;
    TextView google1;
    TextView period1;

    //second period
    ImageView teacherpic2;
    TextView class2;
    TextView teacher2;
    TextView google2;
    TextView period2;

    //Third period
    ImageView teacherpic3;
    TextView class3;
    TextView teacher3;
    TextView google3;
    TextView period3;
    //Fourth
    ImageView teacherpic4;
    TextView class4;
    TextView teacher4;
    TextView google4;
    TextView period4;


    //........................After Periods...................
    ImageButton netClass;
    ImageButton classes;
    ImageButton questions;
    ImageButton sports;

    //..................Twitter feed..........................
    TextView studentTwitterfeed;
    //..................Parasha...............................
    TextView parasha;
    TextView freeOrSale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        //first period
        teacherpic1 = (ImageView) findViewById(R.id.teacherpic1);
        class1 = (TextView) findViewById(R.id.class1);
        teacher1 = (TextView) findViewById(R.id.teacher1);
        google1 = (TextView) findViewById(R.id.twitter1);
        period1 = (TextView) findViewById(R.id.period1);
        //second period
        teacherpic2 = (ImageView) findViewById(R.id.teacherpic2);
        class2 = (TextView) findViewById(R.id.class2);
        teacher2 = (TextView) findViewById(R.id.teacher2);
        google2 = (TextView) findViewById(R.id.twitter2);
        period2 = (TextView) findViewById(R.id.period2);
        //third period
        teacherpic3 = (ImageView) findViewById(R.id.teacherpic3);
        class3 = (TextView) findViewById(R.id.class3);
        teacher3 = (TextView) findViewById(R.id.teacher3);
        google3 = (TextView) findViewById(R.id.twitter3);
        period3 = (TextView) findViewById(R.id.period3);
        //fourth period
        teacherpic4 = (ImageView) findViewById(R.id.teacherpic4);
        class4 = (TextView) findViewById(R.id.class4);
        teacher4 = (TextView) findViewById(R.id.teacher4);
        google4 = (TextView) findViewById(R.id.twitter4);
        period4 = (TextView) findViewById(R.id.period4);
        //.....................linearlayouts........................//
        LinearLayout linearLayoutPeriod1 = (LinearLayout) findViewById(R.id.LinearLayoutPeriod1);
        LinearLayout linearLayoutPeriod2 = (LinearLayout) findViewById(R.id.LinearLayoutPeriod2);
        LinearLayout linearLayoutPeriod3 = (LinearLayout) findViewById(R.id.LinearLayoutPeriod3);
        LinearLayout linearLayoutPeriod4 = (LinearLayout) findViewById(R.id.LinearLayoutPeriod4);
        //........................parasha............................//
        parasha = (TextView) findViewById(R.id.Parasha);
        freeOrSale = (TextView) findViewById(R.id.freeorsale);

        parasha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.chabad.org/parshah/default.asp?tdate=";
                String date = findDate();
                url +=date;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);


            }
        });

        freeOrSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Go to an activity",Toast.LENGTH_SHORT).show();
            }
        });

        //.....................Test period 1........................//


        changePeriods();
        setPeriods();

        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student.this,Classes.class);
                startActivity(intent);
            }
        };

        linearLayoutPeriod1.setOnClickListener(click);
        linearLayoutPeriod2.setOnClickListener(click);
        linearLayoutPeriod3.setOnClickListener(click);
        linearLayoutPeriod4.setOnClickListener(click);
       //.....................end of test.........................

        //After periods
        netClass = (ImageButton) findViewById(R.id.netClass);
        classes = (ImageButton) findViewById(R.id.classes);
        questions = (ImageButton) findViewById(R.id.suggestions);
        sports = (ImageButton) findViewById(R.id.Sports);
        parasha = (TextView) findViewById(R.id.Parasha);
        studentTwitterfeed = (TextView) findViewById(R.id.google);

        netClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent(Student.this, Browser.class);
               // intent.putExtra("URL", "https://13066netclass.blackbaudondemand.com/NetClassroom7/Forms/login.aspx?ReturnUrl=%2fNetClassroom7%2fForms%2fNCShell.aspx");
               // intent.putExtra("Activity","NetClassroom");
                String url = "https://13066netclass.blackbaudondemand.com/NetClassroom7/Forms/login.aspx?ReturnUrl=%2fNetClassroom7%2fForms%2fNCShell.aspx";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student.this,Sports.class);
                startActivity(intent);
            }
        });
        questions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student.this, Questions.class);
                startActivity(intent);
            }
        });
        classes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Student.this, Classes.class);
                startActivity(intent);
            }
        });

    }
    private static String findDate(){
        Date d = new Date();
        int month = findMonth(d.toString());
        String mo;
        if(month < 10){
            mo = "0"+month;
        }else{
            mo = "" + month;
        }
        String day = findDay(d.toString());
        String year = findYear(d.toString());
        return (mo + "/" + day + "/" + year);
    }
    private static String findYear(String date){
        date = date.trim();
        //System.out.println(date.length());
        date = date.substring(date.length() - 4);
        return date;
    }
    private static String findDay(String date){
        date = date.trim();
        date = date.substring(8,10);
        // System.out.println(date);
        return date;
    }
    private static int findMonth(String date){
       String [] months = {
               "Jan","Feb","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"
       };
        for(int i = 0; i<months.length; i++){
            if(date.contains(months[i])){
                return i+1;
            }
        }
        return 0;

    }
    /*
    private String findClass(String aClass) {
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String lecture1 = sp.getString("Lecture1", "");
        String lecture2 = sp.getString("Lecture2", "");
        String lecture3 = sp.getString("Lecture3", "");
        String lecture4 = sp.getString("Lecture4", "");
        String lecture5 = sp.getString("Lecture5", "");
        String lecture6 = sp.getString("Lecture6", "");
        String lecture7 = sp.getString("Lecture7", "");
        String lecture8 = sp.getString("Lecture8","");
        switch(aClass){
            case lecture1:

                return lecture1;
            case lecture2:

                return lecture2;
            case lecture3:

                return lecture3;
            case lecture4:

                return lecture4;
            case lecture5:

                return lecture5;
            case lecture6:

                return lecture6;
            case lecture7:

                return lecture7;
            case lecture8:

                return lecture8;
            default:
                return " ";

        }


    }
*/
    public void changePeriods(){
        changeperiod1(R.mipmap.bach, "GargeBand", "Mr. B","play music", "A");
        changeperiod2(R.mipmap.berkowitz, "Calc AB", "Mrs. Berkowitz", "AB RULES", "B");
        changeperiod3(R.mipmap.epstein, "AP lit", "Mr. Epstein", "This essay sucks!", "C");
        changeperiod4(R.mipmap.hays, "Digi photos", "Mr. Hays", "Good photos", "D");
    }

    public void setPeriods(){
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        changeBlock1(sp.getString("Lecture1", ""), sp.getString("Teacher1", ""), "A");
        changeBlock2(sp.getString("Lecture2", ""), sp.getString("Teacher2", ""), "B");
        changeBlock3(sp.getString("Lecture3", ""), sp.getString("Teacher3", ""), "C");
        changeBlock4(sp.getString("Lecture4", ""), sp.getString("Teacher4", ""), "D");
    }

    private void changeBlock1(String lecture,String teacher, String period){
        class1.setText(lecture);
        teacher1.setText(teacher);
        period1.setText(period.toUpperCase());
    }
    private void changeBlock2(String lecture,String teacher, String period){
        class2.setText(lecture);
        teacher2.setText(teacher);
        period2.setText(period.toUpperCase());

    }
    private void changeBlock3(String lecture, String teacher, String period){
        class3.setText(lecture);
        teacher3.setText(teacher);
        period3.setText(period.toUpperCase());
    }
    private void changeBlock4(String lecture, String teacher, String period){
        class4.setText(lecture);
        teacher4.setText(teacher);
        period4.setText(period.toUpperCase());
    }


    private void changeperiod1(int teacherID, String lecture, String teacherName,
                              String twitterfeed, String periodLetter){
        teacherpic1.setImageResource(teacherID);
        class1.setText(lecture);
        teacher1.setText(teacherName);
        google1.setText(twitterfeed);
        period1.setText(periodLetter.toUpperCase());


    }
    private void changeperiod2(int teacherID, String lecture, String teacherName,
                               String twitterfeed, String periodLetter){
        teacherpic2.setImageResource(teacherID);
        class2.setText(lecture);
        teacher2.setText(teacherName);
        google2.setText(twitterfeed);
        period2.setText(periodLetter.toUpperCase());

    }
    private void changeperiod3(int teacherID, String lecture, String teacherName,
                               String twitterfeed, String periodLetter){
        teacherpic3.setImageResource(teacherID);
        class3.setText(lecture);
        teacher3.setText(teacherName);
        google3.setText(twitterfeed);
        period3.setText(periodLetter.toUpperCase());


    }

    private void changeperiod4(int teacherID, String lecture, String teacherName,
                               String twitterfeed, String periodLetter){
        teacherpic4.setImageResource(teacherID);
        class4.setText(lecture);
        teacher4.setText(teacherName);
        google4.setText(twitterfeed);
        period4.setText(periodLetter.toUpperCase());


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_student, menu);
        menu.findItem(R.id.zeroPeriod).setVisible(false);
        menu.findItem(R.id.saveData).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent intent;

        //noinspection SimplifiableIfStatement
       switch(id){
           case R.id.maps:
               //TODO go to maps activity and direct from current location to 5 federation way
               return true;
           case R.id.action_settings:
               intent = new Intent(Student.this, Settings.class);
               startActivity(intent);
               return true;
           case R.id.blood:
               //TODO go to pdf activity with blood drive consent form.
             //  intent = new Intent(Student.this, Browser.class);
               intent = new Intent(Student.this,PDF.class);
               intent.putExtra("URL","A URL"); //add the url for blood drive
               intent.putExtra("Activity","Blood Drive");
             //  intent.putExtra("ActivityID",R.id.blood);
               startActivity(intent);
               return true;
           case R.id.asbCal:
               intent = new Intent(Student.this, Calendar.class);
               intent.putExtra("Info","Check yes or no if you want the ASB's Calendar to be synced with your Google Calendar");
               intent.putExtra("ActivityName","ASB's Calendar");
               startActivity(intent);
               return true;
           case R.id.masterCal:
               intent = new Intent(Student.this,Calendar.class);
               intent.putExtra("Info","Check yes or no if you want TVT's Master Calendar to be synced with your Google Calendar");
               intent.putExtra("ActivityName","TVT Master Calendar");
               startActivity(intent);
               return true;
           case R.id.studentCouncil:
               intent = new Intent(Student.this,Calendar.class);
               intent.putExtra("Info","Check yes or no if you want the Student Council's calendar to be synced with your Google Calendar");
               intent.putExtra("ActivityName","Student Council's Calendar");
               startActivity(intent);
               return true;
           case R.id.USletterRot:
               //TODO go to an activity with the letter rotation.
               intent = new Intent(Student.this,PDF.class);
               intent.putExtra("URL","a url"); //add the url for schedule
               startActivity(intent);
               return true;
           case R.id.MSletterRot:
               //TODO go to an activity with the letter rotation. same as US but has a tab for MS
               intent = new Intent(Student.this,PDF.class);
               intent.putExtra("URL","a url"); //add the url for schedule
               startActivity(intent);
               return true;
           case R.id.schedule:
               //TODO go to a pdf activity with the schedule.
               intent = new Intent(Student.this,PDF.class);
               intent.putExtra("URL","a url"); //add the url for schedule
               startActivity(intent);
               return true;
           case R.id.handbook:
               // intent = new Intent(Student.this, PDF.class);
              // intent.putExtra("URL","http://my.tarbut.com/document.doc?id=112"); //add the url for handbook
             //  intent.putExtra("Activity","Student Handbook");
               String url = "http://my.tarbut.com/document.doc?id=112";
               intent = new Intent(Intent.ACTION_VIEW);
               intent.setData(Uri.parse(url));
               startActivity(intent);
               return true;
       }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause(){
        super.onPause();
    }
    @Override
    protected void onResume(){
        super.onResume();
        setPeriods();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
