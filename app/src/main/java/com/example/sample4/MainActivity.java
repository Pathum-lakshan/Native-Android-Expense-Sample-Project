package com.example.sample4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sample4.bo.BOFactory;
import com.example.sample4.bo.custom.MainActivityBO;
import com.example.sample4.db.DBHandler;
import com.example.sample4.dto.ExpenseDTO;
import com.example.sample4.entity.Expense;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    TextView date,time;
    EditText txtTravelExpanse,txtFuelExpanse,txtHighwayChargeExpanse,txtParkingExpanse,txtLunchExpanse,txtVehicleServiceExpanse,txtNightOutExpanse;

    Button saveExpense;

    ImageView travelCam,fuelCam,highwayChargeCam,parkingCam,lunchCam,vehicleServiceCam,nightOutCam;

    Bitmap travelImageBitMap,fuelImageBitMap,highwayChargeImageBitMap,parkingImageBitMap,lunchImageBitMap,vehicleServiceImageBitMap,nightOutImageBitMap;

    ActivityResultLauncher<Intent> activityResultLauncher;

    private final MainActivityBO mainActivityBO = (MainActivityBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.MAIN_ACTIVITY_BO);


    private static final int CAMERA_PERMISSION_CODE=112;
    private static final int STORAGE_PERMISSION_CODE=113;
    JSONObject jsonObject ;
    String whatCam;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        setTimeAndDate();


        jsonObject = new JSONObject();



        travelCam =findViewById(R.id.imgTravelCam);
        fuelCam =findViewById(R.id.imgFuelCam);
        highwayChargeCam =findViewById(R.id.imgHighWayChargeCam);
        parkingCam =findViewById(R.id.imgParkingCam);
        lunchCam =findViewById(R.id.imgLunchCam);
        vehicleServiceCam =findViewById(R.id.imgVehicleServiceCam);
        nightOutCam =findViewById(R.id.imgNightOutCam);

                txtTravelExpanse = findViewById(R.id.txtTravelExpense);
                txtFuelExpanse = findViewById(R.id.txtFuelExpense);
                txtHighwayChargeExpanse = findViewById(R.id.txtHighwayChargeExpense);
                txtParkingExpanse = findViewById(R.id.txtParkingExpense);
                txtLunchExpanse = findViewById(R.id.txtLuncgExpense);
                txtVehicleServiceExpanse = findViewById(R.id.txtVehicleServiceExpense);
                txtNightOutExpanse = findViewById(R.id.txtNightOutExpense);

                        saveExpense = findViewById(R.id.btnSave);
        checkPermission(Manifest.permission.CAMERA,CAMERA_PERMISSION_CODE);
        checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE,STORAGE_PERMISSION_CODE);

        saveExpense.setOnClickListener(view -> {
            saveExpense();
        });


        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

                if (result.getResultCode() == RESULT_OK && result.getData() != null){
                    Bundle bundle = result.getData().getExtras();
                    switch (whatCam){
                        case "travelCam" :

                            travelImageBitMap = (Bitmap) bundle.get("data");
                            break;

                        case "fuelCam"  :

                            fuelImageBitMap = (Bitmap) bundle.get("data");
                            break;

                        case "highwayChargeCam"   :

                            highwayChargeImageBitMap = (Bitmap) bundle.get("data");
                            break;

                        case "parkingCam"   :

                            parkingImageBitMap = (Bitmap) bundle.get("data");
                            break;

                        case "lunchCam"   :

                            lunchImageBitMap = (Bitmap) bundle.get("data");
                            break;

                        case "vehicleServiceCam"   :

                            vehicleServiceImageBitMap = (Bitmap) bundle.get("data");
                            break;

                        case "nightOutCam"   :

                            nightOutImageBitMap = (Bitmap) bundle.get("data");
                            break;

                    }
                }
            }
        });



        travelCam.setOnClickListener(view -> {
            takeImage();

            whatCam="travelCam";
        });

        fuelCam.setOnClickListener(view -> {
            takeImage();

            whatCam="fuelCam";
        });

        highwayChargeCam.setOnClickListener(view -> {
            takeImage();

            whatCam="highwayChargeCam";
        });

        parkingCam.setOnClickListener(view -> {
            takeImage();

            whatCam="parkingCam";
        });

        lunchCam.setOnClickListener(view -> {
            takeImage();

            whatCam="lunchCam";
        });

        vehicleServiceCam.setOnClickListener(view -> {
            takeImage();

            whatCam="vehicleServiceCam";
        });

        nightOutCam.setOnClickListener(view -> {
            takeImage();

            whatCam="nightOutCam";
        });
    }

    private void takeImage() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

            activityResultLauncher.launch(takePictureIntent);

    }


    private void setTimeAndDate() {
        date = findViewById(R.id.date);
        time = findViewById(R.id.time);

        setDateAndTime();
    }

    @SuppressLint("NewApi")
    private void setDateAndTime() {

        Calendar calendar = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format1 = new SimpleDateFormat(" aa");

        date.setText(String.valueOf(LocalDate.now()));
        LocalTime now = LocalTime.now();


        time.setText(String.valueOf(now.getHour()+" : "+now.getMinute()+"  "+format1.format(calendar.getTime()) ));
    }
    public void checkPermission (String permission,int requestCode){

        if (ContextCompat.checkSelfPermission(MainActivity.this,permission) == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{permission},requestCode);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode==CAMERA_PERMISSION_CODE){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this,"camera permission granted",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this,"camera permission denied",Toast.LENGTH_SHORT).show();
            }
        }else if(requestCode==STORAGE_PERMISSION_CODE){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(MainActivity.this,"storage permission granted",Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(MainActivity.this,"storage permission denied",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void saveExpense(){


            LocalDate localDate=null;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                localDate= LocalDate.now();
            }



            if (  mainActivityBO.saveExpense(new ExpenseDTO(Double.parseDouble(String.valueOf(txtTravelExpanse.getText())),travelImageBitMap,Double.parseDouble(String.valueOf(txtFuelExpanse.getText())),fuelImageBitMap,Double.parseDouble(String.valueOf(txtHighwayChargeExpanse.getText())),highwayChargeImageBitMap,
                            Double.parseDouble(String.valueOf(txtParkingExpanse.getText())),parkingImageBitMap,Double.parseDouble(String.valueOf(txtVehicleServiceExpanse.getText())),vehicleServiceImageBitMap,
                            Double.parseDouble(String.valueOf(txtNightOutExpanse.getText())),nightOutImageBitMap,Double.parseDouble(String.valueOf(txtLunchExpanse.getText())),lunchImageBitMap,localDate
                    )
                    ,this
            )){
                Toast.makeText(MainActivity.this,"EXPENSES SAVED TO SQLITE",Toast.LENGTH_SHORT).show();

                try {
                    jsonObject.put("result",true);
                }catch (Exception e){}
                callApi();
            }else
            {
                Toast.makeText(MainActivity.this,"EXPENSES CAN'T SAVED TO SQLITE",Toast.LENGTH_SHORT).show();

                try {
                    jsonObject.put("result",false);
                }catch (Exception e){}
                callApi();
            }

    }

    private void callApi() {
        String URL ="https://app.ceylonlinux.lk/jsonFileWrite/testapi.php";
        RequestQueue requestQueue = Volley.newRequestQueue(this);


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, URL, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Toast.makeText(MainActivity.this,"EXPENSES RESULT SAVED TO API",Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this,"EXPENSES RESULT CAN'T SAVED TO API",Toast.LENGTH_SHORT).show();
            }

        });

        requestQueue.add(jsonObjectRequest);
    }


}