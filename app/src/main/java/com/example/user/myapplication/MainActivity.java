package com.example.user.myapplication;

//great for async tasks in android!
// FROM http://stackoverflow.com/questions/7860538/android-http-post-asynctask
/*
HashMap<String, String> data = new HashMap<String, String>();
data.put("key1", "value1");
data.put("key2", "value2");
AsyncHttpPost asyncHttpPost = new AsyncHttpPost(data);
asyncHttpPost.execute("http://example.com");
*/

import android.app.Activity;
import android.app.Dialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * constructor
 */
public class MainActivity extends Activity implements View.OnClickListener {
    TextView start,end;
    EditText title,location,asignee;
    Button creattask;
    int count=0;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task);

        start=(TextView) findViewById(R.id.start);
        end=(TextView) findViewById(R.id.end);
        title=(EditText) findViewById(R.id.title);
        location=(EditText) findViewById(R.id.location);
        asignee=(EditText) findViewById(R.id.asignee);
        creattask=(Button) findViewById(R.id.task);
        start.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {


                final Dialog dialog;
                dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.alert);

                // set the custom dialog components - text, image and button



                dialog.show();
                return false;
            }
        });
        creattask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                new MyAsyncTask().execute(String.valueOf(count),start.getText().toString(),end.getText().toString(),title.getText().toString(),location.getText().toString(),asignee.getText().toString());
            }
        });
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */




    @Override
    public void onClick(View v) {

    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    private class MyAsyncTask extends AsyncTask<String, Integer, Double> {

        @Override
        protected Double doInBackground(String... params) {
            // TODO Auto-generated method stub
            postData(params);
            return null;
        }

        protected void onPostExecute(Double result) {
             Toast.makeText(getApplicationContext(), "command sent",
                    Toast.LENGTH_LONG).show();
        }

        protected void onProgressUpdate(Integer... progress) {
         }

        public void postData(String[] valueIWantToSend) {
            // Create a new HttpClient and Post Header


            try {
                // Add your data

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                Log.d("Respons",valueIWantToSend[0]);
                Log.d("Respons",valueIWantToSend[1]);
                Log.d("Respons",valueIWantToSend[2]);
                Log.d("Respons",valueIWantToSend[3]);
                Log.d("Respons",valueIWantToSend[4]);

                nameValuePairs.add(new BasicNameValuePair("id",valueIWantToSend[0]));
                nameValuePairs.add(new BasicNameValuePair("Start", valueIWantToSend[1]));
                nameValuePairs.add(new BasicNameValuePair("End",valueIWantToSend[2]));
                nameValuePairs.add(new BasicNameValuePair("Title", valueIWantToSend[3]));
                nameValuePairs.add(new BasicNameValuePair("Location",valueIWantToSend[4]));
                nameValuePairs.add(new BasicNameValuePair("asignee", valueIWantToSend[5]));
                DefaultHttpClient httpclient = new DefaultHttpClient();
                HttpPost httppost = new HttpPost(
                        "http://192.168.0.104/insert.php");
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs, HTTP.UTF_8));

                // Execute HTTP Post Request
                HttpResponse response = httpclient.execute(httppost);

                HttpEntity entity = response.getEntity();
                Log.d("Respons",response.toString());

            } catch (ClientProtocolException e) {
                // TODO Auto-generated catch block
            } catch (IOException e) {
                // TODO Auto-generated catch block
            }
        }

    }
}