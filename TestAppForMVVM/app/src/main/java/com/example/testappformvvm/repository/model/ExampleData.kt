package com.example.testappformvvm.repository.model

import java.io.Serializable

data class ExampleData (
     var status: Boolean,
     var message: String,
     var list: ArrayList<DetailsOfEample>
        ): Serializable