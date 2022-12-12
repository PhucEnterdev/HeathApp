package vn.com.enterdev.heathapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private var male: Boolean = false
    private var female: Boolean = false
    private var height: Int = 0
    private var weight: Int = 0
    private var age: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (checkbox_male.isChecked){
            male = true
            female = false
        }else {
            male = false
            female = true
        }


        // nhan cac button cong tru
        onClickSubAdd()

        // Scroll seekbar
        onScrollSeekBar()

        // Click button calculate
        onClickCalculate()



    }

    private fun onClickCalculate(){
        btn_calculate.setOnClickListener {
            val intent : Intent = Intent(this, ResultActivity::class.java)
            weight = tv_weight.text.toString().toInt()
            height = tv_height.text.toString().toInt()
            age = tv_age.text.toString().toInt()
            val bundle: Bundle = Bundle()
            bundle.putBoolean(Constants.MALE, male)
            bundle.putBoolean(Constants.FEMALE, female)
            bundle.putInt(Constants.AGE, age)
            bundle.putInt(Constants.WEIGHT, weight)
            bundle.putInt(Constants.HEIGHT, height)
            intent.putExtra(Constants.BUNDLE, bundle)
            startActivity(intent)
        }
    }

    private fun onScrollSeekBar(){
        seek_bar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (progress > 0){
                    tv_height.text = progress.toString()
                    height = progress
                }else{
                    tv_height.text = 0.toString()
                    height = progress
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }

    private fun onClickSubAdd(){
        btn_sub_weight.setOnClickListener {
            if (tv_weight.text.toString().toInt() > 0){
                tv_weight.text = (tv_weight.text.toString().toInt() - 1).toString()
            }
        }

        btn_add_weight.setOnClickListener {
            if (tv_weight.text.toString().toInt() <= 200){
                tv_weight.text = (tv_weight.text.toString().toInt() + 1).toString()
            }
        }

        btn_sub_age.setOnClickListener {
            if (tv_age.text.toString().toInt() > 0){
                tv_age.text = (tv_age.text.toString().toInt() - 1).toString()
            }
        }

        btn_add_age.setOnClickListener {
            if (tv_age.text.toString().toInt() <= 200){
                tv_age.text = (tv_age.text.toString().toInt() + 1).toString()
            }
        }
    }
}