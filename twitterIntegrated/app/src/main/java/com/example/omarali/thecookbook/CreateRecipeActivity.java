package com.example.omarali.thecookbook;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omarali.thecookbook.model.Recipe;
import com.example.omarali.thecookbook.util.ApiRouter;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class CreateRecipeActivity extends ActionBarActivity implements View.OnClickListener {

    private static final int SELECT_PICTURE = 0;
    private int target;
    int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);
        Intent from = getIntent();
        target = from.getExtras().getInt("target");
        userId = ((CookBook) this.getApplication()).getCurrentUser().getId();
        TextView viewTimeline = (TextView) this.findViewById(R.id.my_timeline_link);
        viewTimeline.setClickable(true);
        viewTimeline.setOnClickListener(this);
//        viewTimeline.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), TimelineActivity.class));
//            }
//        });
//
        Button onCreate = (Button) this.findViewById(R.id.create_recipe_button);
        onCreate.setClickable(true);
        onCreate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.my_timeline_link:
                startActivity(new Intent(getApplicationContext(), TimelineActivity.class));
                break;
            case R.id.create_recipe_button:
                EditText name = (EditText) findViewById(R.id.recipe_name_field);
                EditText description = (EditText) findViewById(R.id.description_field);
                EditText preparation = (EditText) findViewById(R.id.instructions_field);
                if(name.getText().toString().equals("") || description.getText().toString().equals("") || preparation.getText().equals(""))
                {
                    TextView warning = (TextView) findViewById(R.id.missing_fields_warning_text);
                    warning.setVisibility(View.VISIBLE);
                    return;

                }

//                Post justCreated = new Post(description.getText().toString(), name.getText().toString(), owner,
//                        firstIngredient.getText().toString(), secondIngredient.getText().toString(), thirdIngredient.getText().toString()
//                , recipe.getText().toString());
//                toTimeline.putExtra("Post", justCreated);
//                ((CookBook) this.getApplication()).setPosts(justCreated);
//                Log.i("Create Rec", justCreated.description);
//                Log.i("Create Rec" , justCreated.name);
                String username = ((CookBook) this.getApplication()).getCurrentUser().getUsername();
                int currId = ((CookBook) this.getApplication()).getCurrentUser().getId();
                ApiRouter.withoutToken().setPost(name.getText().toString(), description.getText().toString(), preparation.getText().toString()
                        , target, username, currId , new Callback<Recipe>() {
                    @Override
                    public void success(Recipe recipe, Response response) {
                        Toast sucess = Toast.makeText(getApplicationContext(), "Post Successfully Created!", Toast.LENGTH_SHORT);
                        sucess.show();
                        Intent toTimeline = new Intent(getApplicationContext(), TimelineActivity.class);
                        toTimeline.putExtra("userId", userId);
                        startActivity(toTimeline);
                    }

                    @Override
                    public void failure(RetrofitError error) {

                    }
                });
                break;
        }
    }
    public void picture_uploadOnClick(View v) {
//        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        Intent intent = new Intent();
        intent.setType("image/*");
             intent.setAction(Intent.ACTION_GET_CONTENT);
             startActivityForResult(Intent.createChooser(intent,
                     "Select Picture"), SELECT_PICTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
             super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case SELECT_PICTURE:
                    Bitmap bitmap = getPath(data.getData());
//                            imageView.setImageBitmap(bitmap);

            }
        }
    }


    public void createRecipeButtonOnClick(View v) {



        startActivity(new Intent(this, TimelineActivity.class));



    }


//    protected void createButtonOnClick(View v) {
//        EditText name = (EditText) findViewById(R.id.recipe_name_field);
//        EditText description = (EditText) findViewById(R.id.description_field);
//        String owner = "Omar";
//        Post justCreated = new Post(description.getText().toString(), name.getText().toString(), owner);
//        Intent toTimeline = new Intent(getApplicationContext(), TimelineActivity.class);
//        toTimeline.putExtra("Post", justCreated);
//        startActivity(toTimeline);
//    }


    private Bitmap getPath(Uri uri) {

        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        cursor.moveToFirst();
        int column_index = cursor.getColumnIndexOrThrow(projection[0]);
        String filePath = cursor.getString(column_index);
        cursor.close();
        // Convert file path into bitmap image using below line.
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);

        return bitmap;
    }

}