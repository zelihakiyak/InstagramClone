package com.zelihakiyak.instagramclone.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.zelihakiyak.instagramclone.databinding.RecyclerRowBinding;
import com.zelihakiyak.instagramclone.model.Post;

import java.util.ArrayList;

public class PostAdapter extends  RecyclerView.Adapter<PostAdapter.PostHolder> {

    private ArrayList<Post> postArrayList;

    public PostAdapter(ArrayList<Post> postArrayList) {
        this.postArrayList = postArrayList;
    }


    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new PostHolder(recyclerRowBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

        holder.recyclerRowBinding.recyclerviewRowUseremailText.setText(postArrayList.get(position).email);
        holder.recyclerRowBinding.recyclerviewRowCaptionText.setText(postArrayList.get(position).caption);
        Picasso.get().load(postArrayList.get(position).downloadUrl).into(holder.recyclerRowBinding.recyclerviewRowImageview);
    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    static class PostHolder extends RecyclerView.ViewHolder {
        RecyclerRowBinding recyclerRowBinding;
        

        public PostHolder(@NonNull RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;

        }
    }
}