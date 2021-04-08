package ru.startandroid.develop.redwhite;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentRight extends Fragment {
    private FragmentLeftCallBack fragmentRightCallback;
    private LinearLayout linearLayout;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentRightCallback = (FragmentLeftCallBack) context;

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_right, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        linearLayout = view.findViewById(R.id.right_fragment);
        linearLayout.setOnClickListener(v -> {
            if(isMyColorRed()) {
                fragmentRightCallback.onFragmentClicked();
            }else{
                fragmentRightCallback.onWhiteFragmentClick();
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
