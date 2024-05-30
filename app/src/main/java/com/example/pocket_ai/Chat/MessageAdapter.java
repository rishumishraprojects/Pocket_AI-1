package com.example.pocket_ai.Chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pocket_ai.R;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder>{

    List<Message> messageList;
    public MessageAdapter(List<Message> messageList){
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chatView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_ui,null);
        MyViewHolder myViewHolder = new MyViewHolder(chatView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Message message = messageList.get(position);
        if(message.getSentBy().equals(Message.SENT_BY_ME)){
            holder.userChatView.setVisibility(View.VISIBLE);
            holder.botChatView.setVisibility(View.GONE);
            holder.userTextView.setText(message.getMessage());
        }else{
            holder.userChatView.setVisibility(View.GONE);
            holder.botChatView.setVisibility(View.VISIBLE);
            holder.botTextView.setText(message.getMessage());

        }

    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        LinearLayout userChatView,botChatView;
        TextView userTextView,botTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userChatView = itemView.findViewById(R.id.UserChatView);
            botChatView = itemView.findViewById(R.id.botChatView);
            userTextView = itemView.findViewById(R.id.UserTextView);
            botTextView = itemView.findViewById(R.id.botTextView);


        }
    }
}
