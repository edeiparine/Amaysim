package com.eman.exam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.eman.exam.ui.fragment.SplashScreenFragment;
import com.eman.exam.utility.FragmentUtils;
import com.eman.exam.utility.JSONFileLoader;
import com.eman.exam.utility.KeyboardUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {

    private static final String JSON_INCLUDED = "included";
    private static final String JSON_ATTRIBUTES = "attributes";
    private static final String JSON_MSN = "msn";

    String enteredCredential;

    EditText et_credentials;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loadJSONData();
        initializeComponents();
    }

    private void initializeComponents() {

        View view = findViewById(R.id.container);
        view.setOnTouchListener(this);

        et_credentials = (EditText) findViewById(R.id.et_credentials);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    private void loadJSONData() {
        try {
            JSONObject obj = new JSONObject(JSONFileLoader.loadJSONFromAsset(this));
            JSONArray jsonArray = obj.getJSONArray(JSON_INCLUDED);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                // attributes node
                JSONObject attrib = jsonObject.getJSONObject(JSON_ATTRIBUTES);
                String msn = attrib.getString(JSON_MSN);
                Log.d("MSN", msn);
                enteredCredential = msn;
                break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        String credentials = et_credentials.getText().toString();
        if (credentials.matches(enteredCredential)) {
            et_credentials.setText("");
            Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
            KeyboardUtils.hideSoftKeyboard(this);
            FragmentUtils.addFragmentToActivity(getSupportFragmentManager(),
                    new SplashScreenFragment(), R.id.container);
        } else {
            et_credentials.setError("Please enter valid credentials");
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        KeyboardUtils.hideSoftKeyboard(this);
        return false;
    }

    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }
    }
}
