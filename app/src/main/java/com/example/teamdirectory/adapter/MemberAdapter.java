package com.example.teamdirectory.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamdirectory.R;
import com.example.teamdirectory.model.TeamMember;

import java.util.List;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MemberViewHolder> {
    public interface OnMemberClickListener { void onMemberClick(TeamMember member); }

    private final List<TeamMember> members;
    private final OnMemberClickListener listener;

    public MemberAdapter(List<TeamMember> members, OnMemberClickListener listener) {
        this.members = members;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rvitem_layout, parent, false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberViewHolder holder, int position) {
        TeamMember member = members.get(position);
        holder.avatar.setBackgroundColor(member.getColor());
        holder.itemView.setContentDescription(member.getName());
        holder.itemView.setOnClickListener(view -> listener.onMemberClick(member));
    }

    @Override
    public int getItemCount() { return members.size(); }

    static class MemberViewHolder extends RecyclerView.ViewHolder {
        final ImageView avatar;

        MemberViewHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.headshot);
        }
    }
}
