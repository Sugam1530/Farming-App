package Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farming.ApiInterface;
import com.example.farming.GetAllCartProduct;
import com.example.farming.GetAllCartProduct;
import com.example.farming.R;
import com.example.farming.RemoveCartItem;
import com.example.farming.RetrofitInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddToCartAdapter extends RecyclerView.Adapter<AddToCartAdapter.viewHolder> {

    private List<GetAllCartProduct> dataList;
    private Context context;

    public AddToCartAdapter(Context context, List<GetAllCartProduct> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView productName, ProductSP, removeCartItem;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.product_name);
            ProductSP = itemView.findViewById(R.id.product_sp);
            removeCartItem = itemView.findViewById(R.id.removeCartItem);
        }
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sample_addtocart_item, parent,false);
        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.productName.setText(dataList.get(position).getProduct_name());
        holder.ProductSP.setText(dataList.get(position).getSp());

        holder.removeCartItem.setOnClickListener(view -> {
            ApiInterface apiInterface;
            apiInterface = RetrofitInstance.getRetrofit().create(ApiInterface.class);

            apiInterface.getRemoveSingleCartItem(Integer.parseInt(dataList.get(position).getCart_id())).enqueue(new Callback<RemoveCartItem>() {
                @Override
                public void onResponse(Call<RemoveCartItem> call, Response<RemoveCartItem> response) {
                    Toast.makeText(context, "Product has removed from cart, please refresh", Toast.LENGTH_SHORT).show();

                }

                @Override
                public void onFailure(Call<RemoveCartItem> call, Throwable t) {
                    Toast.makeText(context, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        });


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
