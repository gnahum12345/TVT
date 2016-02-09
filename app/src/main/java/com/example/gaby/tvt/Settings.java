package com.example.gaby.tvt;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
  //  EditText zeroLecture;
//......Teacher....................//
    EditText teacher1;
    EditText teacher2;
    EditText teacher3;
    EditText teacher4;
    EditText teacher5;
    EditText teacher6;
    EditText teacher7;
    EditText teacher8;
  //  EditText teacher0;
//......email.................//
    EditText email1;
    EditText email2;
    EditText email3;
    EditText email4;
    EditText email5;
    EditText email6;
    EditText email7;
    EditText email8;
 //   EditText email0;

  //  EditText daysOfClass;
    boolean zeroPeriod = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Log.w("Settings","Im in settings");
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
        editor.apply();
    }


    private void loadData() {
        SharedPreferences sp =
                getSharedPreferences("MyPrefs",
                        Context.MODE_PRIVATE);
        //lectures
//        zeroLecture.setText(sp.getString("Lecture0",""));
        lecture1.setText(sp.getString("Lecture1",""));
        lecture2.setText(sp.getString("Lecture2",""));
        lecture3.setText(sp.getString("Lecture3",""));
        lecture4.setText(sp.getString("Lecture4",""));
        lecture5.setText(sp.getString("Lecture5",""));
        lecture6.setText(sp.getString("Lecture6",""));
        lecture7.setText(sp.getString("Lecture7",""));
        lecture8.setText(sp.getString("Lecture8",""));
        //Teachers
 //       teacher0.setText(sp.getString("Teacher0",""));
        teacher1.setText(sp.getString("Teacher1",""));
        teacher2.setText(sp.getString("Teacher2",""));
        teacher3.setText(sp.getString("Teacher3",""));
        teacher4.setText(sp.getString("Teacher4",""));
        teacher5.setText(sp.getString("Teacher5",""));
        teacher6.setText(sp.getString("Teacher6",""));
        teacher7.setText(sp.getString("Teacher7",""));
        teacher8.setText(sp.getString("Teacher8",""));
        //Email
   //     email0.setText(sp.getString("Email0",""));
        email1.setText(sp.getString("Email1",""));
        email2.setText(sp.getString("Email2",""));
        email3.setText(sp.getString("Email3",""));
        email4.setText(sp.getString("Email4",""));
        email5.setText(sp.getString("Email5",""));
        email6.setText(sp.getString("Email6",""));
        email7.setText(sp.getString("Email7",""));
        email8.setText(sp.getString("Email8",""));

     //   zeroPeriod = sp.getBoolean("ZeroPeriod",false);

    }


    private String getEmail(int period){
        String r = "";
        switch(period){
            case 1:
                r = email1.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 2:
                r = email2.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 3:
                r = email3.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 4:
                r = email4.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 5:
                r = email5.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 6:
                r = email6.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 7:
                r = email7.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 8:
                r = email8.getText().toString();
                if(r.equals(""))
                    return "";
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
                    return "";
                else
                    return r;
            case 2:
                r = teacher2.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 3:
                r = teacher3.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 4:
                r = teacher4.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 5:
                r = teacher5.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 6:
                r = teacher6.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 7:
                r = teacher7.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 8:
                r = teacher8.getText().toString();
                if(r.equals(""))
                    return "";
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
                    return "";
                else
                    return r;
            case 2:
                r = lecture2.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 3:
                r = lecture3.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 4:
                r = lecture4.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 5:
                r = lecture5.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 6:
                r = lecture6.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 7:
                r = lecture7.getText().toString();
                if(r.equals(""))
                    return "";
                else
                    return r;
            case 8:
                r = lecture8.getText().toString();
                if(r.equals(""))
                    return "";
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
       // TimePickerDialog zero;

        switch(id) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.zeroPeriod:
                //TODO make dialog box that asks the user the time of their zero period.
                /*new AlertDialog.Builder(getApplicationContext())
                        .setTitle("Zero Period")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // continue with delete
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                            }
                        })
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();*/
                saveData();
                Intent intent = new Intent(Settings.this,Zero.class);
                startActivity(intent);
              /*  if (!zeroPeriod) {
                    Toast.makeText(getApplicationContext(), "You have zero period and will be notified earlier", Toast.LENGTH_LONG).show();
                    zeroPeriod = true;
                }else{
                    Toast.makeText(getApplicationContext(), "You will be notified about your classes at normal time", Toast.LENGTH_LONG).show();
                    zeroPeriod = false;
                }*/
                break;
            case R.id.saveData:
                saveData();
                Toast.makeText(getApplicationContext(),"Your data was saved", Toast.LENGTH_SHORT).show();


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
