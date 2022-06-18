package Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.farming.CategoryOverview;
import com.example.farming.GetAllCartProduct;
import com.example.farming.MyOrderOverview;
import com.example.farming.ProductDetailsActivity;
import com.example.farming.R;

import java.util.List;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.viewHolder>{

    private List<MyOrderOverview> dataList;
    private Context context;

    public MyOrderAdapter(Context context, List<MyOrderOverview> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        TextView customerName, tvAddress, tvPincode, tvOrderStatus, tvTotalAmount, tvCouponApplied, couponText;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

           customerName = itemView.findViewById(R.id.customer_name);
           tvAddress = itemView.findViewById(R.id.tvAddress);
           tvPincode = itemView.findViewById(R.id.tvPincode);
           tvOrderStatus = itemView.findViewById(R.id.tvOrderStatus);
           tvTotalAmount = itemView.findViewById(R.id.tvTotalAmount);
           tvCouponApplied = itemView.findViewById(R.id.tvCouponApplied);
           couponText = itemView.findViewById(R.id.couponText);

        }
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_myorder, parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.customerName.setText(dataList.get(position).getCustomer_name());
        holder.tvAddress.setText(dataList.get(position).getCustomer_address()+ ",");
        holder.tvPincode.setText(dataList.get(position).getCustomer_pincode());
        holder.tvOrderStatus.setText(dataList.get(position).getOrder_status());
        holder.tvTotalAmount.setText(dataList.get(position).getSubtotal_amount());
        if (dataList.get(position).getCoupon_used() != null){
            holder.couponText.setVisibility(View.VISIBLE);
            holder.tvCouponApplied.setText(dataList.get(position).getCoupon_used());
        } else{
            holder.couponText.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}
