package com.rogmax.amirjaber.taskrogmax2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.Bind;

public class CreatePet extends AppCompatActivity {

    @Bind(R.id.et_petName)
    EditText petName;
    Spinner spinnerSub;
    Spinner spinnerType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pet);
        spinnerType = (Spinner) findViewById(R.id.id_spinner);
        spinnerSub = (Spinner) findViewById(R.id.id_spinner1);
        spinnerSub.setEnabled(false);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.type_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(adapter);
        spinnerType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String type = (String) parent.getItemAtPosition(position);

                if ("".equals(type)){
                    spinnerSub.setEnabled(false);
                }

                if ("Cat".equals(type)) {
                    spinnerSub.setEnabled(true);
                    populateCat();
                }
                if ("Dog".matches(type)) {
                    spinnerSub.setEnabled(true);
                    populateDog();
                }
                if ("Snake".equals(type)) {
                    spinnerSub.setEnabled(true);
                    populateSnake();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    void populateCat() {
        String[] cat = {"black","orange","white"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cat);
        spinnerSub.setAdapter(adapter);

    }
    void populateDog() {
        String[] dog = {"poodle","husky","pit"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, dog);
        spinnerSub.setAdapter(adapter);
    }
    void populateSnake() {
        String[] snake = {"long","short"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, snake);
        spinnerSub.setAdapter(adapter);
    }
}
