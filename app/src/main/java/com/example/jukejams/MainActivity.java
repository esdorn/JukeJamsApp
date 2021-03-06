package com.example.jukejams;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

    private TextView mTextMessage;
    private Connector connect;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.navigation_host_or_join:
                                selectedFragment = Account.newInstance();
                                break;

                            case R.id.navigation_home:
                                selectedFragment = HostOrJoinConnector.newInstance();
                                break;
                            case R.id.navigation_mymusic:
                                selectedFragment = MyMusic.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment); //change selected to name navigation_home
                        transaction.commit();
                        return true;
                    }
                });
                //Once we have a home fragment put that in here- so that we start there
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_layout, HostOrJoinConnector.newInstance());
                transaction.commit();



        mTextMessage = (TextView) findViewById(R.id.message);
        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void Host(View view)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout,Host.newInstance());
        transaction.commit();
    }
    public void Join(View view)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout,PartyJoin.newInstance());
        transaction.commit();
    }

    public void About(View view)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout,About.newInstance());
        transaction.commit();
    }

    public void JoinParty(View v){
        String code = ((EditText)findViewById(R.id.codeInput)).getText().toString();
        connect = new Connector((TextView)findViewById(R.id.textView3),getSupportFragmentManager().beginTransaction());
        connect.execute(code);
    }

    public void HostParty(View v){
        connect = new Connector((TextView)findViewById(R.id.textView4),getSupportFragmentManager().beginTransaction());
        connect.execute();
    }

}
