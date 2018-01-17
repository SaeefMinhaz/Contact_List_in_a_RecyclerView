package com.example.user.contactrecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by SHOVON on 1/17/2018.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder>{

    private List<ContactModel> contactModelList;
    private Context mContext;
    public ContactsAdapter(List<ContactModel> contactModelList, Context mContext){
        this.contactModelList = contactModelList;
        this.mContext = mContext;
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.single_contact_view, null);
        ContactViewHolder contactViewHolder = new ContactViewHolder(view);
        return contactViewHolder;
    }

    @Override
    public void onBindViewHolder(ContactViewHolder holder, int position) {
        final ContactModel contactModel = contactModelList.get(position);
        holder.tvContactName.setText(contactModel.getContactName());
        holder.tvPhoneNumber.setText(contactModel.getContactNumber());

        holder.contactsRowLV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,""+ contactModel.getContactNumber(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactModelList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder{

        ImageView ivContactImage;
        TextView tvContactName;
        TextView tvPhoneNumber;
        LinearLayout contactsRowLV;

        public ContactViewHolder(View itemView) {
            super(itemView);
            ivContactImage = (ImageView) itemView.findViewById(R.id.ivContactImage);
            tvContactName = (TextView) itemView.findViewById(R.id.tvContactName);
            tvPhoneNumber = (TextView) itemView.findViewById(R.id.tvPhoneNumber);
            contactsRowLV = itemView.findViewById(R.id.contactsRowLV);
        }
    }
}
