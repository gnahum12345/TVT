package com.example.gaby.tvt;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TimePicker;
import android.widget.Toast;


/**
 * Created by gaby on 1/13/16.
 */
public class Settings extends Activity {



    boolean zeroPeriod = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_student, menu);
        menu.findItem(R.id.action_settings).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        TimePickerDialog zero;

        switch(id) {
            case android.R.id.home:
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
