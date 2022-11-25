package com.joduma.prueba.activities.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.joduma.prueba.R
import com.joduma.prueba.activities.activities.client.home.ClientHomeActivity
import com.joduma.prueba.activities.activities.delivery.DeliveryHomeActivity
import com.joduma.prueba.activities.activities.restaurant.RestaurantHomeActivity
import com.joduma.prueba.activities.models.Rol
import com.joduma.prueba.activities.utils.SharedPref


class RolesAdapter(val context: Activity, val roles: ArrayList<Rol>): RecyclerView.Adapter<RolesAdapter.RolesViewHolder>()  {


    val sharedPref = SharedPref(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RolesViewHolder{

        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_roles, parent, false)

        return RolesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return roles.size
    }

    override fun onBindViewHolder(holder: RolesViewHolder, position: Int) {
        val rol = roles[position]

        holder.textViewRol.text = rol.name
        //Glide.with(context).load(rol.image).into(holder.imageViewRol)

        holder.itemView.setOnClickListener{ goToRol(rol) }
    }

    private fun goToRol(rol: Rol) {
        if (rol.name == "admin" ) {

            sharedPref.save("rol", "admin")

            val i = Intent(context, ClientHomeActivity::class.java)
            context.startActivity(i)
        }
        else if (rol.name == "supervisor" ) {

            sharedPref.save("rol", "supervisor")

            val i = Intent(context, RestaurantHomeActivity::class.java)
            context.startActivity(i)
        }
        else if (rol.name == "vendedor" ) {

            sharedPref.save("rol", "vendedor")

            val i = Intent(context, DeliveryHomeActivity::class.java)
            context.startActivity(i)
        }
    }

    class RolesViewHolder(view: View): RecyclerView.ViewHolder(view){

        val  textViewRol: TextView
        val imageViewRol : ImageView

        init {

            textViewRol = view.findViewById(R.id.textview_rol)
            imageViewRol = view.findViewById(R.id.imageview_rol)
        }
    }

}

































































