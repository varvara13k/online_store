package com.example.mobiledevproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.processNextEventInCurrentThread

class ProductsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_products)


            val productsList: RecyclerView = findViewById(R.id.productsList)
            val products = arrayListOf<Product>()

            products.add(Product(1, "cardigan", "Cardigan", "H&M cardigan, size XS, lilac", "The cardigan is made in a classic beige color, which is easily combined with various elements of the wardrobe. The model has a loose silhouette and a long sleeve, providing comfort and coziness in cool weather. The button closure adds practicality and makes it easy to put on and take off the cardigan. The composition of the cardigan includes 50% recycled polyester, 45% acrylic, and 5% wool, making it soft, warm, and pleasant to the touch.", 2399))

            products.add(Product(2, "jeans", "Jeans MOM", "Mom FEIMAILIS jeans, size 29, blue", "Women's mom jeans, narrowed to the bottom, are a basic casual classic for any girl. Fashionable stretch jeans made of soft fabric, which consists of cotton, elastane, and polyester, will fit into the wardrobe of every representative of the fair sex and will be in harmony with any style of clothing.", 3109))

            productsList.layoutManager = LinearLayoutManager(this)
            productsList.adapter = ProductsAdapter(products, this)


        }
    }
