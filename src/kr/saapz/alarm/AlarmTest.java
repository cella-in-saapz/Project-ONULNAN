package kr.saapz.alarm;

import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class AlarmTest extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_test);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
				Intent intent = new Intent(AlarmTest.this, AlarmReceiver.class);
				PendingIntent sender = PendingIntent.getBroadcast(AlarmTest.this, 0, intent, 0);
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTimeInMillis(System.currentTimeMillis());
				calendar.add(Calendar.SECOND, 10);
				am.set(AlarmManager.RTC, calendar.getTimeInMillis(), sender);
				
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_alarm_test, menu);
        return true;
    }
}
