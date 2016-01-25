package com.example.gaby.tvt;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;


/**
 * Created by gaby on 1/13/16.
 */
public class Settings extends Activity {
//.........Lecture...................//
    EditText lecture1;
    EditText lecture2;
    EditText lecture3;
    EditText lecture4;
    EditText lecture5;
    EditText lecture6;
    EditText lecture7;
    EditText lecture8;

//......Teacher....................//
    EditText teacher1;
    EditText teacher2;
    EditText teacher3;
    EditText teacher4;
    EditText teacher5;
    EditText teacher6;
    EditText teacher7;
    EditText teacher8;

//......email.................//
    EditText email1;
    EditText email2;
    EditText email3;
    EditText email4;
    EditText email5;
    EditText email6;
    EditText email7;
    EditText email8;

    boolean zeroPeriod = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        //..Period1..//
        lecture1 = (EditText) findViewById(R.id.lecture1);
        teacher1 = (EditText) findViewById(R.id.teacher1);
        email1 = (EditText) findViewById(R.id.email1);

        //..Period2..//
        lecture2 = (EditText) findViewById(R.id.lecture2);
        teacher2 = (EditText) findViewById(R.id.teacher2);
        email2 = (EditText) findViewById(R.id.email2);

        //..Period3..//
        lecture3 = (EditText) findViewById(R.id.lecture3);
        teacher3 = (EditText) findViewById(R.id.teacher3);
        email3 = (EditText) findViewById(R.id.email3);

        //..Period4..//
        lecture4 = (EditText) findViewById(R.id.lecture4);
        teacher4 = (EditText) findViewById(R.id.teacher4);
        email4 = (EditText) findViewById(R.id.email4);

        //..Period5..//
        lecture5 = (EditText) findViewById(R.id.lecture5);
        teacher5 = (EditText) findViewById(R.id.teacher5);
        email5 = (EditText) findViewById(R.id.email5);

        //..Period6..//
        lecture6 = (EditText) findViewById(R.id.lecture6);
        teacher6 = (EditText) findViewById(R.id.teacher6);
        email6 = (EditText) findViewById(R.id.email6);

        //..Period7..//
        lecture7 = (EditText) findViewById(R.id.lecture7);
        teacher7 = (EditText) findViewById(R.id.teacher7);
        email7 = (EditText) findViewById(R.id.email7);

        //..Period8..//
        lecture8 = (EditText) findViewById(R.id.lecture8);
        teacher8 = (EditText) findViewById(R.id.teacher8);
        email8 = (EditText) findViewById(R.id.email8);

        saveData();
    }

    private void saveData(){
        SharedPreferences sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        //Period 1
        editor.putString("Lecture1",getLecture(1));
        editor.putString("Teacher1",getTeacher(1));
        editor.putString("Email1",getEmail(1));
        //Period 2
        editor.putString("Lecture2",getLecture(2));
        editor.putString("Teacher2",getTeacher(2));
        editor.putString("Email2",getEmail(2));
        //Period 3
        editor.putString("Lecture3",getLecture(3));
        editor.putString("Teacher3",getTeacher(3));
        editor.putString("Email3",getEmail(3));
        //Period 4
        editor.putString("Lecture4",getLecture(4));
        editor.putString("Teacher4",getTeacher(4));
        editor.putString("Email4",getEmail(4));
        //Period 5
        editor.putString("Lecture5",getLecture(5));
        editor.putString("Teacher5",getTeacher(5));
        editor.putString("Email5",getEmail(5));
        //Period 6
        editor.putString("Lecture6",getLecture(6));
        editor.putString("Teacher6", getTeacher(6));
        editor.putString("Email6",getEmail(6));
        //Period 7
        editor.putString("Lecture7",getLecture(7));
        editor.putString("Teacher7",getTeacher(7));
        editor.putString("Email7",getEmail(7));
        //Period 8
        editor.putString("Lecture8",getLecture(8));
        editor.putString("Teacher8", getTeacher(8));
        editor.putString("Email8", getEmail(8));
        //Zero Period
        editor.putBoolean("ZeroPeriod",zeroPeriod);
        //TODO put in time
        editor.commit();
    }


    private void loadData() {
        SharedPreferences sp =
                getSharedPreferences("MyPrefs",
                        Context.MODE_PRIVATE);
        //lectures
        lecture1.setText(sp.getString("Lecture1",""));
        lecture2.setText(sp.getString("Lecture2",""));
        lecture3.setText(sp.getString("Lecture3",""));
        lecture4.setText(sp.getString("Lecture4",""));
        lecture5.setText(sp.getString("Lecture5",""));
        lecture6.setText(sp.getString("Lecture6",""));
        lecture7.setText(sp.getString("Lecture7",""));
        lecture8.setText(sp.getString("Lecture8",""));
        //Teachers
        teacher1.setText(sp.getString("Teacher1",""));
        teacher2.setText(sp.getString("Teacher2",""));
        teacher3.setText(sp.getString("Teacher3",""));
        teacher4.setText(sp.getString("Teacher4",""));
        teacher5.setText(sp.getString("Teacher5",""));
        teacher6.setText(sp.getString("Teacher6",""));
        teacher7.setText(sp.getString("Teacher7",""));
        teacher8.setText(sp.getString("Teacher8",""));
        //Email
        email1.setText(sp.getString("Email1",""));
        email2.setText(sp.getString("Email2",""));
        email3.setText(sp.getString("Email3",""));
        email4.setText(sp.getString("Email4",""));
        email5.setText(sp.getString("Email5",""));
        email6.setText(sp.getString("Email6",""));
        email7.setText(sp.getString("Email7",""));
        email8.setText(sp.getString("Email8",""));

        zeroPeriod = sp.getBoolean("ZeroPeriod",false);

    }


    private String getEmail(int period){
        String r = "";
        switch(period){
            case 1:
                r = email1.getText().toString();
                if(r.equals(""))
                    return "Email1";
                else
                    return r;
            case 2:
                r = email2.getText().toString();
                if(r.equals(""))
                    return "Email2";
                else
                    return r;
            case 3:
                r = email3.getText().toString();
                if(r.equals(""))
                    return "Email3";
                else
                    return r;
            case 4:
                r = email4.getText().toString();
                if(r.equals(""))
                    return "Email4";
                else
                    return r;
            case 5:
                r = email5.getText().toString();
                if(r.equals(""))
                    return "Email5";
                else
                    return r;
            case 6:
                r = email6.getText().toString();
                if(r.equals(""))
                    return "Email6";
                else
                    return r;
            case 7:
                r = email7.getText().toString();
                if(r.equals(""))
                    return "Email7";
                else
                    return r;
            case 8:
                r = email8.getText().toString();
                if(r.equals(""))
                    return "Email8";
                else
                    return r;
        }
        return r;
    }

    private String getTeacher(int period){
        String r = "";
        switch(period){
            case 1:
                r = teacher1.getText().toString();
                if(r.equals(""))
                    return "Teacher1";
                else
                    return r;
            case 2:
                r = teacher2.getText().toString();
                if(r.equals(""))
                    return "Teacher2";
                else
                    return r;
            case 3:
                r = teacher3.getText().toString();
                if(r.equals(""))
                    return "Teacher3";
                else
                    return r;
            case 4:
                r = teacher4.getText().toString();
                if(r.equals(""))
                    return "Teacher4";
                else
                    return r;
            case 5:
                r = teacher5.getText().toString();
                if(r.equals(""))
                    return "Teacher5";
                else
                    return r;
            case 6:
                r = teacher6.getText().toString();
                if(r.equals(""))
                    return "Teacher6";
                else
                    return r;
            case 7:
                r = teacher7.getText().toString();
                if(r.equals(""))
                    return "Teacher7";
                else
                    return r;
            case 8:
                r = teacher8.getText().toString();
                if(r.equals(""))
                    return "Teacher8";
                else
                    return r;
        }
        return r;
    }

    private String getLecture(int period){
        String r = "";
        switch(period){
            case 1:
                r = lecture1.getText().toString();
                if(r.equals(""))
                    return "A";
                else
                    return r;
            case 2:
                r = lecture2.getText().toString();
                if(r.equals(""))
                    return "B";
                else
                    return r;
            case 3:
                r = lecture3.getText().toString();
                if(r.equals(""))
                    return "C";
                else
                    return r;
            case 4:
                r = lecture4.getText().toString();
                if(r.equals(""))
                    return "D";
                else
                    return r;
            case 5:
                r = lecture5.getText().toString();
                if(r.equals(""))
                    return "E";
                else
                    return r;
            case 6:
                r = lecture6.getText().toString();
                if(r.equals(""))
                    return "F";
                else
                    return r;
            case 7:
                r = lecture7.getText().toString();
                if(r.equals(""))
                    return "G";
                else
                    return r;
            case 8:
                r = lecture8.getText().toString();
                if(r.equals(""))
                    return "H";
                else
                    return r;
        }
        return r;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_student, menu);
        menu.findItem(R.id.action_settings).setVisible(false);
        menu.setGroupVisible(R.id.oldTVT,false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TimePickerDialog zero;

        switch(id) {
            case android.R.id.home:
                saveData();
                finish();
                return true;
            case R.id.maps:
                //TODO go to maps activity and direct from current location to 5 federation way
                return true;
            case R.id.blood:
                //TODO go to activity with the blood drive consent form
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
                return true;
            case R.id.handbook:
                //TODO go to an activity with the schedule and handbook.
                break;
            case R.id.zeroPeriod:
                //TODO make dialog box that asks the user the time of their zero period.
                if (!zeroPeriod) {
                    Toast.makeText(getApplicationContext(), "You have zero period and will be notified earlier", Toast.LENGTH_LONG).show();
                    zeroPeriod = true;
                }else{
                    Toast.makeText(getApplicationContext(), "You will be notified about your classes at normal time", Toast.LENGTH_LONG).show();
                    zeroPeriod = false;
                }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause(){
        super.onPause();
        saveData();
    }
    @Override
    protected void onResume(){
        super.onResume();
        loadData();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
    }




}
