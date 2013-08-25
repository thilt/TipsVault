package com.example.JsonClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {

    private JsonReader reader;
    private List<Def> defs;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final EditText editText = (EditText) findViewById(R.id.editText);
        final Button button = (Button) findViewById(R.id.button);
        final TextView textView = (TextView) findViewById(R.id.textView);

        reader = new JsonReader(new InputStreamReader(this.getResources().openRawResource(R.raw.test)));

        try {
            getDef();
        } catch (IOException e) {
            e.printStackTrace();
        }

        editText.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                return false;
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                textView.setText(searchDefinition(editText.getText().toString()));
            }
        });
    }


    private String retrieveInfo(String request) {
        return "Toto a dit que j'ai bien codé : " + request;
    }

    private List<Def> getDef() throws IOException {
        defs = new ArrayList<Def>();

        reader.beginArray();
        while (reader.hasNext()) {
            reader.beginObject();
            String title = null;
            String definition = null;
            while (reader.hasNext()) {
                String name = reader.nextName();
                                if ("title".equals(name)) {
                                    title = reader.nextString();
                                } else if ("definition".equals(name)) {
                                    definition = reader.nextString();
                                } else {
                                    reader.skipValue();
                                }
            }
            reader.endObject();
            Def def = new Def(title, definition);
            defs.add(def);
        }

        return defs;
    }


    private String searchDefinition(String request) {
        for (Def def : defs) {
            if (def.getTitre().equals(request)) {
                return def.getDefinition();
            }
        }

        return null;
    }
}
