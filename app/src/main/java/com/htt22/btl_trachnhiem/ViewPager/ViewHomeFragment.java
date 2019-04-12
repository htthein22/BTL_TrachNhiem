package com.htt22.btl_trachnhiem.ViewPager;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.htt22.btl_trachnhiem.CauHoi.CauHoi;
import com.htt22.btl_trachnhiem.MainActivity;
import com.htt22.btl_trachnhiem.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewHomeFragment extends Fragment {
    ArrayList<CauHoi> cauHoiArrayList;
    public static final String SO_TRANG="trang";
    private int vitri;

    TextView tvNum,tvcauhoi,cau;
    RadioGroup radioGroup;
    RadioButton rbA,rbB,rbC,rbD;

    public ViewHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_view_home, container, false);
        tvNum=(TextView)rootView.findViewById(R.id.tvNum);
        tvcauhoi=(TextView)rootView.findViewById(R.id.tvQuestion);
        rbA=(RadioButton) rootView.findViewById(R.id.radA);
        rbB=(RadioButton) rootView.findViewById(R.id.radB);
        rbC=(RadioButton) rootView.findViewById(R.id.radC);
        rbD=(RadioButton) rootView.findViewById(R.id.radD);
        radioGroup=(RadioGroup)rootView.findViewById(R.id.radGroup);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //lay data tu ben activity
        cauHoiArrayList = new ArrayList<CauHoi>();
        ViewHome viewHome = (ViewHome) getActivity();
        cauHoiArrayList= viewHome.getData();

        //lay vi tri
        vitri = getArguments().getInt(SO_TRANG);
    }

    public static ViewHomeFragment create(int pageNumber){
        ViewHomeFragment viewHomeFragment = new ViewHomeFragment();
        Bundle args = new Bundle();
        args.putInt(SO_TRANG,pageNumber);
        viewHomeFragment.setArguments(args);
        return viewHomeFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvNum.setText(" Câu " + (vitri+1)+"/20");
        tvcauhoi.setText(cauHoiArrayList.get(vitri).getCauhoi());
        rbA.setText(cauHoiArrayList.get(vitri).getA());
        rbB.setText(cauHoiArrayList.get(vitri).getB());
        rbC.setText(cauHoiArrayList.get(vitri).getC());
        rbD.setText(cauHoiArrayList.get(vitri).getD());
    }
}
