package com.example.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    Context context;
    com.example.recyclerview.Model[] model;
    public Adapter(Context context, Model[] model)
    {
        this.model=model;
        this.context=context;
    }
    @NonNull
    @Override
    public Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recycler_adapter,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyViewHolder holder, int position) {
        holder.myText1.setText(model[position].Name);
        holder.myText2.setText(model[position].Description);
        //holder.myImage.setImageResource(model[position].img);
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity2.class);
                intent.putExtra("img", model[position].img);
                intent.putExtra("description", model[position].Description);
                intent.putExtra("name", model[position].Name);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return model.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView myText1,myText2;
        ImageView myImage;
        ConstraintLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1=itemView.findViewById(R.id.myText1);
            myText2=itemView.findViewById(R.id.myText2);
            myImage=itemView.findViewById(R.id.myImageView);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }
}
