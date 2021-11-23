/*
* Copyright (C) 2021 The Android Open Source Project.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.example.dogglers.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dogglers.R
import com.example.dogglers.const.Layout
import com.example.dogglers.databinding.ActivityGridListBinding.inflate
import com.example.dogglers.model.Dog

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int,
    val dogs: List<Dog>
) : RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // TODO: Initialize the data using the List found in data/DataSource

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img = view.findViewById<ImageView>(R.id.imgDog)
        val name = view.findViewById<TextView>(R.id.txtDogName)
        val age = view.findViewById<TextView>(R.id.txtDogAge)
        val hobbies = view.findViewById<TextView>(R.id.txtDogHobbies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        return DogCardViewHolder(
            when (layout) {
                Layout.VERTICAL, Layout.HORIZONTAL -> {
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.vertical_horizontal_list_item, parent, false)
                }
                else -> {
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.grid_list_item, parent, false)
                }
            }
        )
    }

    override fun getItemCount(): Int = dogs.size

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        val dogVal = dogs[position]
        holder.img.setImageResource(dogVal.imageResourceId)
        holder.name.text = dogVal.name
        holder.age.text = "Age: ${dogVal.age}"
        holder.hobbies.text = "Hobbies: ${dogVal.hobbies}"
        /*val resources = context?.resources
        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)*/
    }
}
