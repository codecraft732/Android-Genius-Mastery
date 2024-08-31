package com.example.stylishphotoframeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.stylishphotoframeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //how this pic shows 0 1 2 3 4 click next
    // -> 0 1 2 3 4 click prev 3 2 1 0 -> click prev 4 3 2 1 0
    lateinit var binding : ActivityMainBinding
    var currentImage = 0
   var names = arrayOf("Noor Mahal","Residential Buildings","Mosque","Eiffel Tower")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBtn1.setOnClickListener {
            val currentImageView = when (currentImage) {
                0 -> binding.pic0
                1 -> binding.pic1
                2 -> binding.pic2
                3 -> binding.pic3
                else -> null // Handle invalid index if necessary
            }
            //question? means if current image view is null without ? app is crash
            // if ? add its called null pointer exception  if null then stop next part is not working and app is not crash
            currentImageView?.alpha = 0f // Fade out the current image

            currentImage = (4 + currentImage - 1) % 4

            val nextImageView = when (currentImage) {
                0 -> binding.pic0
                1 -> binding.pic1
                2 -> binding.pic2
                3 -> binding.pic3
                else -> null // Handle invalid index if necessary
            }
            nextImageView?.alpha = 1f // Fade in the next image

            binding.tV2.text = names[currentImage]
        }



        binding.imgBtn2.setOnClickListener {
            // This code runs when imgBtn2 (likely a "Next" button) isclicked
            // Find the ImageView that's currently showing
            val currentImageView = when (currentImage) {
                0 -> binding.pic0 // Find the ImageView that's currently showing
                1 -> binding.pic1 // Find the ImageView that's currently showing
                2 -> binding.pic2
                3 -> binding.pic3
                else -> null  // If currentImage is something unexpected, don't do anything
            }
            currentImageView?.alpha = 0f // Make the current image invisible (fade out)
// Calculate the index of the next image to show
            currentImage = (currentImage + 1) % 4
            // This wraps around to 0 after 3

            // Find the ImageView for the next image
            val nextImageView = when (currentImage) {
                0 -> binding.pic0
                1 -> binding.pic1
                2 -> binding.pic2
                3 -> binding.pic3
                else -> null // Handle invalid index if necessary
            }
            nextImageView?.alpha = 1f   // Make the next image visible (fade in)

            // Update the text label to match the new image

            binding.tV2.text = names[currentImage]
        }
    }}
/*
currentImage = (currentImage + 1) % 4
explain this formula
Initial Value: currentImage starts at 0.

First Click:

currentImage = (0 + 1) % 4
currentImage = 1 % 4
Quotient: 0 (since 1 ÷ 4 = 0.25, integer part is 0)(0.25*4=1)
Remainder: 1
Result: currentImage = 1
Second Click:

currentImage = (1 + 1) % 4
currentImage = 2 % 4
Quotient: 0 (since 2 ÷ 4 = 0.5, integer part is 0)(0.5*4=2)
Remainder: 2
Result: currentImage = 2
Third Click:

currentImage = (2 + 1) % 4
currentImage = 3 % 4
Quotient: 0 (since 3 ÷ 4 = 0.75, integer part is 0)(0.75*4=3)
Remainder: 3
Result: currentImage = 3
Fourth Click:

currentImage = (3 + 1) % 4
currentImage = 4 % 4
Quotient: 1 (since 4 ÷ 4 = 1, integer part is 1)(1*4=4) there is no 4 image means 0
Remainder: 0
Result: currentImage = 0
And so on...
*/



/*explain some xml points.
when  u are using constraint layout then must doing constraint
for all four sides otherwise when u are running it places your components somewhere else.

how to constraint it for all four sides middle dot put your arrow on that and strech it from its back

how to add image button in xml add image button where
we add images scroll down search previous or next button

new attribute alpha 0 0means pic invisible or 1 means pic visible darker*/




