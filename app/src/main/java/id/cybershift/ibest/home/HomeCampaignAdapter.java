package id.cybershift.ibest.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.cybershift.ibest.R;
import id.cybershift.ibest.model.Campaign;

public class HomeCampaignAdapter extends RecyclerView.Adapter<HomeCampaignAdapter.HomeCampaignHolder> {
    ArrayList<Campaign> listCampaign;

    public HomeCampaignAdapter(ArrayList<Campaign> listCampaign) {
        this.listCampaign = listCampaign;
    }

    @NonNull
    @Override
    public HomeCampaignHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_home_campaign, viewGroup, false);
        return new HomeCampaignHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeCampaignHolder homeCampaignHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class HomeCampaignHolder extends RecyclerView.ViewHolder {
        public HomeCampaignHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
