package com.example.gaby.tvt;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


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

       //.....................Test period 1........................
        changePeriods();
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
                Intent intent = new Intent(Student.this, Browser.class);
                intent.putExtra("URL", "https://13066netclass.blackbaudondemand.com/NetClassroom7/Forms/login.aspx?ReturnUrl=%2fNetClassroom7%2fForms%2fNCShell.aspx");
                intent.putExtra("Activity","NetClassroom");
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

    public void changePeriods(){
        changeperiod1(R.mipmap.bach, "GargeBand", "Mr. B","play music", "A");
        changeperiod2(R.mipmap.berkowitz, "Calc AB", "Mrs. Berkowitz", "AB RULES", "B");
        changeperiod3(R.mipmap.epstein, "AP lit", "Mr. Epstein", "This essay sucks!", "C");
        changeperiod4(R.mipmap.hays, "Digi photos", "Mr. Hays", "Good photos", "D");
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
               //TODO go to the settings activity
               intent = new Intent(Student.this, Settings.class);
               startActivity(intent);
               return true;
           case R.id.blood:
               //TODO go to activity with the blood drive consent form
               intent = new Intent(Student.this, Browser.class);
               intent.putExtra("URL","A URL"); //add the url for blood drive
               intent.putExtra("Activity","Blood Drive");
             //  intent.putExtra("ActivityID",R.id.blood);
               startActivity(intent);
               return true;
           case R.id.asbCal:
               //TODO go to activity with calendar that shows everything tab for ASB AND For MASTER CAL

               return true;
           case R.id.masterCal:
               //TODO go to the same activity as asbCal

               return true;
           case R.id.studentCouncil:
               //TODO go to the same activity as asbCal has a tab for MS
               return true;
           case R.id.USletterRot:
               //TODO go to an activity with the letter rotation.
               return true;
           case R.id.MSletterRot:
               //TODO go to an activity with the letter rotation. same as US but has a tab for MS
               return true;
           case R.id.schedule:
               //TODO go to an activity with the schedule.
               intent = new Intent(Student.this, Browser.class);
               intent.putExtra("url","a url"); //add the url for schedule
               startActivity(intent);
               return true;
           case R.id.handbook:
               //TODO go to an activity with the schedule and handbook.
               intent = new Intent(Student.this, Browser.class);
               intent.putExtra("url","a url"); //add the url for handbook
               startActivity(intent);
               break;
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
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

}
