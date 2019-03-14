package com.example.jukejams;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.TextView;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Connector extends AsyncTask<String, String, String> {
    private TextView output;
    private boolean con;
    private Context context;
    public Connector(TextView t, Context context1)
    {
        output = t;
        context = context1;
    }

    protected String doInBackground(String... code)
    {
        String code1;
        try (Socket s = new Socket("10.7.22.6",6709))
        {
            Scanner in = new Scanner(s.getInputStream());
            PrintWriter out = new PrintWriter(s.getOutputStream());
            out.println(code[0]);
            out.flush();
            if (in.hasNext())
            {
                code1 = in.next();
                con = true;
            }
            else
            {
                code1 = "Party does not exist";
                con = false;
            }
        }
        catch (Exception e)
        {
            code1 = "Cant connect to server";
            con = false;
        }
        return code1;
    }

    protected void onPostExecute(String message) {
        if (con)
        {
            //Intent i = new Intent(context, JoinedRoom.class);
            //i.putExtra("ip",message);
            //context.startActivity(i);
        }
        else {
            output.setText(message);
        }
    }
}
