package com.viper.android.vutils;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.nononsenseapps.filepicker.doc.DocumentPickerActivity;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class DocPickerStartActivity extends AppCompatActivity {

    private static final String TAG = "DocPickerStartActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Uri root = data.getData();
            Intent intent = new Intent(this, DocumentPickerActivity.class);
            intent.putExtra(DocumentPickerActivity.EXTRA_START_PATH, root.toString());
            intent.putExtra(DocumentPickerActivity.EXTRA_MODE, DocumentPickerActivity.MODE_NEW_FILE);
            startActivityForResult(intent, 2);
        } else if (requestCode == 2 && resultCode == RESULT_OK) {
            Log.i(TAG, data.toString());
        }
    }
}
