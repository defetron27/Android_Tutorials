package com.max.def.tutorials;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PagerSettingsActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_settings);

        createRadioButtons();
    }

    private void createRadioButtons()
    {
        RadioGroup radioGroup = findViewById(R.id.radio_groupd_list_button);

        String[] transformers = getResources().getStringArray(R.array.transformers_list);

        for(final String transformer : transformers)
        {
            RadioButton radioButton = new RadioButton(this);

            radioButton.setText(transformer);

            radioButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(PagerSettingsActivity.this, "You Clicked " + transformer, Toast.LENGTH_SHORT).show();

                    saveTransformer(transformer);
                }
            });

            radioGroup.addView(radioButton);

            if (transformer.equals(getTransformer(this)))
            {
                radioButton.setChecked(true);
            }
        }
    }

    private void saveTransformer(String transformer)
    {
        SharedPreferences preferences = this.getSharedPreferences("Transformers",MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("transformer",transformer);
        editor.apply();

    }

    protected static String getTransformer(Context context)
    {
        SharedPreferences preferences = context.getSharedPreferences("Transformers",MODE_PRIVATE);

        return preferences.getString("transformer","DefaultTransformer");
    }
}
