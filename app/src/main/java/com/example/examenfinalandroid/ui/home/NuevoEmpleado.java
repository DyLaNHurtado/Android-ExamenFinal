package com.example.examenfinalandroid.ui.home;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.example.examenfinalandroid.R;
import com.example.examenfinalandroid.database.RoomDatabase;
import com.example.examenfinalandroid.databinding.ActivityNuevoEmpleadoBinding;
import com.example.examenfinalandroid.mapper.UriMapper;
import com.example.examenfinalandroid.model.Empleado;

public class NuevoEmpleado extends AppCompatActivity {

    ActivityNuevoEmpleadoBinding binding;
    private Uri imageUri= Uri.EMPTY;
    private SacarFotoAction sacarFotoAction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_empleado);
        binding= ActivityNuevoEmpleadoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sacarFotoAction = new SacarFotoAction(this,this,this);
        binding.fabInsertarEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Empleado nuevoEmpleado = new Empleado(
                        binding.nameET.getText().toString(),
                        UriMapper.getInstance().fromUriToString(imageUri),
                        "Departamento1",
                        getLugar()
                );
                RoomDatabase.getInstance(getApplicationContext()).empleadoDao().insertEmpleado(nuevoEmpleado);
            }
        });
        binding.fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageUri = sacarFotoAction.sacarFoto();
            }
        });

    }
    private String getLugar(){
        if(binding.rbBarcelona.isChecked()){
            return "Barcelona";
        }
        else if(binding.rbCuenca.isChecked()){
            return "Cuenca";
        }
        else if(binding.rbMadrid.isChecked()){
            return "Madrid";
        }
        else{
            return "Valencia";
        }
    }

    private boolean checkFields(){
        return !binding.nameET.getText().toString().equalsIgnoreCase("") &&
                !imageUri.equals(Uri.EMPTY);
    }

    public ActivityResultLauncher setLauncher() {
        return registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                //result.getData().getExtras(MediaStore.)
            }
        });
    }
}