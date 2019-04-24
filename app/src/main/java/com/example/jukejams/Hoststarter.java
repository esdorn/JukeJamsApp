package com.example.jukejams;

import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Hoststarter extends AsyncTask<Void, String, String> {
    private TextView output;
    private boolean con;
    FragmentTransaction transaction;
    public Hoststarter(TextView t, FragmentTransaction tran)
    {
        output = t;
        transaction = tran;
    }
    @Override
    protected String doInBackground(Void... voids) {
        String message;
        try (Socket s = new Socket("10.7.20.17",6710))
        {
            Scanner in = new Scanner(s.getInputStream());
            PrintWriter out = new PrintWriter(s.getOutputStream());
            out.println("host");
            out.flush();
            message = in.next();
        }
        catch (Exception e)
        {
            message = "Cant connect to server";
            con = false;
        }
        return message;
    }
    protected void onPostExecute(String message) {
        if (con)
        {
            transaction.replace(R.id.frame_layout,PartyHost.newInstance());
            transaction.commit();
        }
        else {
            output.setText(message);
        }
    }
}
