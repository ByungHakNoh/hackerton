package org.personal.hackerton.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.personal.hackerton.Data.FriendItem;
import org.personal.hackerton.R;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.ViewHolder>{

    ArrayList<FriendItem> friendItemArrayList;
    Activity activity;

    public FriendAdapter(ArrayList<FriendItem> friendItemArrayList, Activity activity) {
        this.friendItemArrayList = friendItemArrayList;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend, null);
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nicknameTextView.setText(friendItemArrayList.get(position).getName());
        holder.profileImageView.setImageDrawable(friendItemArrayList.get(position).getProfileImage());

    }

    @Override
    public int getItemCount() {
        return friendItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nicknameTextView;
        ImageView profileImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nicknameTextView=itemView.findViewById(R.id.nickname);
            this.profileImageView=itemView.findViewById(R.id.profileImage);
        }
    }
}