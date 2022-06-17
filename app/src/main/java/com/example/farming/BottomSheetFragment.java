package com.example.farming;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.text.DecimalFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    ApiInterface apiInterface ;
    EditText enterCoupon;
    TextView tvFinalApply;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public BottomSheetFragment() {
        // Required empty public constructor
    }

    public static BottomSheetFragment newInstance(String param1, String param2) {
        BottomSheetFragment fragment = new BottomSheetFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bottom_sheet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);
        enterCoupon = view.findViewById(R.id.enterCoupon);
        tvFinalApply = view.findViewById(R.id.tvFinalApply);

        tvFinalApply.setOnClickListener(v -> {
            apiInterface.getApplyCoupon(enterCoupon.getText().toString().trim()).enqueue(new Callback<ResponseArrayApplyCouponOverview>() {
                @Override
                public void onResponse(Call<ResponseArrayApplyCouponOverview> call, Response<ResponseArrayApplyCouponOverview> response) {
                    if (response.body()!=null){
                        if (response.body().getStatus()== 1){
                            cartView.totalPriceText.setText(df.format(Float.parseFloat(cartView.totalPriceText.getText().toString())-(Integer.parseInt(response.body().getResponse().getDiscount_percentage())*Float.parseFloat(cartView.totalPriceText.getText().toString())/100.0)));
                            Toast.makeText(getContext(), "Coupon Applied Successfully", Toast.LENGTH_SHORT).show();
                            dismiss();
                        } else{
                            Toast.makeText(getContext(), "No Coupon Found", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseArrayApplyCouponOverview> call, Throwable t) {
                    Toast.makeText(getContext(), "Coupon Limit Exceed", Toast.LENGTH_SHORT).show();

                }
            });
        });
    }
}