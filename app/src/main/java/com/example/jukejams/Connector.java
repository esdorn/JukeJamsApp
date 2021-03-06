package com.example.jukejams;

import android.os.AsyncTask;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connector extends AsyncTask<String, String, String> {
    private TextView output;
    private boolean con;
    FragmentTransaction transaction;
    public Connector(TextView t, FragmentTransaction tran)
    {
        output = t;
        transaction = tran;
    }

    protected String doInBackground(String... code)
    {
        String message;
        try (Socket s = new Socket("10.7.20.17",6710))
        {
            Scanner in = new Scanner(s.getInputStream());
            PrintWriter out = new PrintWriter(s.getOutputStream());
            out.println(code[0]);
            out.flush();
            if (in.hasNext())
            {
                message = in.next();
                con = true;
            }
            else
            {
                message = "Party does not exist";
                con = false;
            }
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
            transaction.replace(R.id.frame_layout,PartyJoin.newInstance());
            transaction.commit();
        }
        else {
            output.setText(message);
        }
    }
}
