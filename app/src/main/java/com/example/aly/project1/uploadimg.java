package com.example.aly.project1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

/**
 * Created by aly on 11/19/16.
 */

public class uploadimg extends Activity implements View.OnClickListener {
    private static final int RESULT_LOAD_IMAGE = 0;
    ImageView imageToUpload, downloadedImage;
    Button bUploadImage, bDownloadImage;
    EditText uploadedImageName, downloadImageName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imgupload);

        imageToUpload = (ImageView) findViewById(R.id.imageToUpload);

        bUploadImage= (Button) findViewById(R.id.bUploadImage);


        imageToUpload.setOnClickListener(this);
        bUploadImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.bUploadImage:
                Intent galleryIntent = new Intent (Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
                break;
            case R.id.etUploadName:

                break;




        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data !=null)
        {
            Uri selectedImage = data.getData();
            imageToUpload.setImageURI(selectedImage);
            DatabaseHelper helper = new DatabaseHelper(this);
            helper.Setprofilepicurl(selectedImage);



        }
    }
}
