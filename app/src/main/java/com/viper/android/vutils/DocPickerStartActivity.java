package com.viper.android.vutils;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.nononsenseapps.filepicker.doc.DocumentPickerFragment;

import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class DocPickerStartActivity extends AppCompatActivity implements DocumentPickerFragment.OnFilePickedListener {


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
            getContentResolver().takePersistableUriPermission(
                    root, Intent.FLAG_GRANT_READ_URI_PERMISSION);
            if (!DocumentPickerFragment.isTreeUsable(this, root))
                return;
            DocumentPickerFragment fragment = new DocumentPickerFragment(root);
            getSupportFragmentManager().beginTransaction().replace(android.R.id.content, fragment).commit();
        }
    }

    @Override
    public void onFilePicked(@NonNull Uri file) {

    }

    @Override
    public void onFilesPicked(@NonNull List<Uri> files) {

    }

    @Override
    public void onCancelled() {

    }
}
