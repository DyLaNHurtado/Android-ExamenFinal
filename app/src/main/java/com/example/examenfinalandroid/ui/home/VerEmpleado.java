package com.example.examenfinalandroid.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.examenfinalandroid.Intercambio;
import com.example.examenfinalandroid.R;
import com.example.examenfinalandroid.database.RoomDatabase;
import com.example.examenfinalandroid.databinding.ActivityVerEmpleadoBinding;
import com.example.examenfinalandroid.mapper.UriMapper;
import com.example.examenfinalandroid.model.Empleado;

public class VerEmpleado extends AppCompatActivity {

    ActivityVerEmpleadoBinding binding;
    private Empleado emp = Intercambio.getInstance().getEmpleado();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_empleado);
        binding= ActivityVerEmpleadoBinding.inflate(getLayoutInflater());
        binding.fotoPreview.setImageURI(UriMapper.getInstance().fromStringToUri(emp.getImage()));
        binding.nombreTV.setText(emp.getName());
        binding.idTV.setText(emp.getId());
        binding.lugarTV.setText(emp.getLugarTrabajo());
        binding.fabDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomDatabase.getInstance(getApplicationContext()).empleadoDao().deleteEmpleadoById(emp.getId());
            }
        });
        binding.fabEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RoomDatabase.getInstance(getApplicationContext()).empleadoDao().updateEmpleado(emp);
                Toast.makeText(VerEmpleado.this, "Empleado Actualizado (Llamada basedatos bien pero no actualiza)", Toast.LENGTH_SHORT).show();
            }
        });
        setContentView(binding.getRoot());

    }
}