package org.personal.hackerton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import org.personal.hackerton.Adapter.FriendAdapter;
import org.personal.hackerton.Data.FriendItem;

import java.util.ArrayList;

public class FriendListActivity extends AppCompatActivity {

    ArrayList<FriendItem> friendItemArrayList;
    FriendAdapter friendAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);

        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        friendItemArrayList=new ArrayList<>();
        friendAdapter=new FriendAdapter(friendItemArrayList,this);
        recyclerView.setAdapter(friendAdapter);

        friendItemArrayList.add(new FriendItem("강지영",getDrawable(R.drawable.profile_image1)));
        friendItemArrayList.add(new FriendItem("이가연",getDrawable(R.drawable.profile_image2)));
        friendItemArrayList.add(new FriendItem("노병학",getDrawable(R.drawable.profile_image3)));
        friendItemArrayList.add(new FriendItem("김철수",getDrawable(R.drawable.profile_image4)));
        friendItemArrayList.add(new FriendItem("박영희",getDrawable(R.drawable.profile_image5)));
        friendAdapter.notifyDataSetChanged();
    }
}