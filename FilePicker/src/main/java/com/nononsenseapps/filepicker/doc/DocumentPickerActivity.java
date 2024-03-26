package com.nononsenseapps.filepicker.doc;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.nononsenseapps.filepicker.AbstractFilePickerActivity;
import com.nononsenseapps.filepicker.AbstractFilePickerFragment;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class DocumentPickerActivity extends AbstractFilePickerActivity<Uri> {

    @Override
    protected AbstractFilePickerFragment<Uri> getFragment(@Nullable String startPath, int mode, boolean allowMultiple, boolean allowCreateDir, boolean allowExistingFile, boolean singleClick) {
        Uri root = Uri.parse(startPath);
        getContentResolver().takePersistableUriPermission(
                root, Intent.FLAG_GRANT_READ_URI_PERMISSION);
        if (!DocumentPickerFragment.isTreeUsable(this, root)) {
            throw new UnsupportedOperationException("PATH " + startPath + "is not usable");
        }
        DocumentPickerFragment fragment = new DocumentPickerFragment(root);
        fragment.setArgs(null, mode, allowMultiple, allowCreateDir, allowExistingFile, singleClick);
        return fragment;
    }
}
