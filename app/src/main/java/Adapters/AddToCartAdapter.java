package Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.farming.GetAllCartProduct;
import com.example.farming.GetAllCartProduct;
import com.example.farming.R;

import java.util.List;

public class AddToCartAdapter extends RecyclerView.Adapter<AddToCartAdapter.viewHolder> {

    private List<GetAllCartProduct> dataList;
    private Context context;

    public AddToCartAdapter(Context context, List<GetAllCartProduct> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    public class viewHolder extends RecyclerView.ViewHolder{

        TextView productName, ProductSP;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            productName = itemView.findViewById(R.id.product_name);
            ProductSP = itemView.findViewById(R.id.product_sp);
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

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
