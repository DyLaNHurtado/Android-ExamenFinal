package com.example.examenfinalandroid.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.examenfinalandroid.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        binding.rvEmpleado.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvEmpleado.setAdapter(new EmpleadoAdapter(getActivity()));

        binding.fab.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), NuevoEmpleado.class);
            startActivity(intent);
        });
        binding.fabSearchById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogBuscarId dialog = new DialogBuscarId();
                dialog.show(getActivity().getSupportFragmentManager(),null);
            }
        });
        return root;
    }
    @Override
    public void onResume() {
        super.onResume();
        binding.rvEmpleado.setAdapter(new EmpleadoAdapter(getActivity()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}