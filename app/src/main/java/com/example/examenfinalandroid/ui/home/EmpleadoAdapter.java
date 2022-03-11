package com.example.examenfinalandroid.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.example.examenfinalandroid.Intercambio;
import com.example.examenfinalandroid.R;
import com.example.examenfinalandroid.database.RoomDatabase;
import com.example.examenfinalandroid.mapper.UriMapper;
import com.example.examenfinalandroid.model.Empleado;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EmpleadoAdapter extends RecyclerView.Adapter<EmpleadoAdapter.ViewHolder> {

    List<Empleado> empleados;
    Context context;

    public EmpleadoAdapter(Context context){
        empleados = RoomDatabase.getInstance(context).empleadoDao().getAllEmpleados();
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.empleado_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, int i) {
        holder.imagen.setImageURI(UriMapper.getInstance().fromStringToUri(empleados.get(i).getImage()));
        holder.nombre.setText(empleados.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return empleados.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView nombre;
        ConstraintLayout layout;
        public ViewHolder(@NonNull @NotNull View v) {
            super(v);
            imagen = v.findViewById(R.id.imageEmpleado);
            nombre = v.findViewById(R.id.nombreEmpleado);
            layout = v.findViewById(R.id.layoutItem);

            onClick();
        }

        private void onClick(){
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int posicion = getAdapterPosition();
                    Intercambio.getInstance().setEmpleado(empleados.get(posicion));
                    context.startActivity(new Intent(context,VerEmpleado.class));
                }
            });
        }
    }


}