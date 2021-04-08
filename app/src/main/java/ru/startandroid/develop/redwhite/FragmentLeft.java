package ru.startandroid.develop.redwhite;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentLeft extends Fragment {
    private FragmentLeftCallBack fragmentLeftCallback;
    LinearLayout linearLayout;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentLeftCallback = (FragmentLeftCallBack) context;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_left, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayout = view.findViewById(R.id.left_fragment);
        linearLayout.setOnClickListener(v -> {
            if(isMyColorRed()) {
                fragmentLeftCallback.onFragmentClicked();
            }else {
                fragmentLeftCallback.onWhiteFragmentClick();
            }
        });
    }

    public boolean isMyColorRed() {
        int redColorIdFromLinearLayout = ((ColorDrawable) linearLayout.getBackground()).getColor();
        int redColorResourceId = R.color.redId;
        int redColorId = getResources().getColor(redColorResourceId);
        return redColorIdFromLinearLayout == redColorId;
    }

    public void changeMyColor() {
        if (isMyColorRed()) {
            linearLayout.setBackgroundResource(R.color.whiteId);
        } else {
            linearLayout.setBackgroundResource(R.color.redId);
        }
    }
}
