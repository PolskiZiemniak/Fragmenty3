package com.example.fragmenty3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class InputFragment extends Fragment {

    private EditText editTextDataInput;

    public InputFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_fragment, container, false);

        editTextDataInput = view.findViewById(R.id.editText);
        Button buttonSendData = view.findViewById(R.id.sendData);

        buttonSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dataToSend = editTextDataInput.getText().toString();

                if (getActivity() != null && getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).handleDataFromInputFragment(dataToSend);
                }
            }
        });
        return view;
    }
}