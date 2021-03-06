package com.franco.calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.franco.calculator.databinding.CalculatorBinding
import java.util.*

class MainCalculator : AppCompatActivity() {
    private lateinit var binding: CalculatorBinding
    private var isMultiplication = false
    private var isAddition = false
    private var isSubstraction = false
    private var isDivision = false

    private var mValueOne: Double = 0.0
    private var mValueTwo: Double = 0.0
    private var value: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        value = binding.screenCalc.text.toString()
        val locale = Locale.getDefault().language
        when (locale) {
            "es" -> doNothing()
            "en" -> changeColors()
        }
        with(binding) {
            buttonOne.setOnClickListener { screenCalc.text = "1" }
            buttonTwo.setOnClickListener { screenCalc.text = "2" }
            buttonThree.setOnClickListener { screenCalc.text = "3" }
            buttonFour.setOnClickListener { screenCalc.text = "4" }
            buttonFive.setOnClickListener { screenCalc.text = "5" }
            buttonSix.setOnClickListener { screenCalc.text = "6" }
            buttonSeven.setOnClickListener { screenCalc.text = "7" }
            buttonEight.setOnClickListener { screenCalc.text = "8" }
            buttonEight.setOnClickListener { screenCalc.text = "9" }
            buttonCero.setOnClickListener { screenCalc.text = "0" }

            buttonMulti.setOnClickListener {
                if (screenCalc.text == null) {
                    screenCalc.text = ""
                } else {
                    val value = binding.screenCalc.text.toString()
                    mValueOne = value.toDouble()
                    isMultiplication = true
                    screenCalc.text = null
                }
            }
            buttonPlus.setOnClickListener {
                if (screenCalc.text == null) {
                    screenCalc.text = ""
                } else {
                    mValueOne = value.toDouble()
                    isAddition = true
                    screenCalc.text = null
                }
            }
            buttonPlusMinus.setOnClickListener {
                Toast.makeText(
                        this@MainCalculator,
                        "Action not supported",
                        Toast.LENGTH_LONG
                )
            }
            buttonMinus.setOnClickListener {
                if (binding.screenCalc.text == null) {
                    screenCalc.text = ""
                } else {
                    mValueOne = value.toDouble()
                    isSubstraction = true
                    screenCalc.text = null
                }
            }
            buttonDivision.setOnClickListener {
                if (binding.screenCalc.text == null) {
                    screenCalc.text = ""
                } else {

                    mValueOne = value.toDouble()
                    isDivision = true
                    screenCalc.text = null
                }
            }
            ButtonCanceled.setOnClickListener {
                screenResult.text = ""
                screenCalc.text = ""
            }
            buttonEquals.setOnClickListener {
                mValueTwo = value.toDouble()
                if (isAddition) {
                    val value1 = mValueOne
                    val value2 = mValueTwo
                    screenResult.text = "${mValueOne + mValueTwo} "
                    isAddition = false;
                }

                if (isSubstraction) {
                    screenResult.text = "${mValueOne - mValueTwo} "
                    isSubstraction = false;
                }

                if (isMultiplication) {
                    screenResult.text = "${mValueOne * mValueTwo} "
                    isMultiplication = false;

                }

                if (isDivision) {
                    screenResult.text = "${mValueOne / mValueTwo} "
                    isDivision = false;
                }
            }
        }

    }






    private fun changeColors() {
        val colorWhite = resources.getColor(R.color.per_white)
        with(binding) {
            buttonMinus.setBackgroundColor(resources.getColor(R.color.per_blue))
            buttonMinus.setTextColor(colorWhite)
            buttonDivision.setBackgroundColor(Color.DKGRAY)
            buttonDivision.setTextColor(Color.BLACK)
            buttonEquals.setBackgroundColor(Color.GREEN)
            buttonEquals.setTextColor(colorWhite)
            buttonPlus.setBackgroundColor(Color.YELLOW)
            buttonPlus.setTextColor(colorWhite)
            buttonMulti.setBackgroundColor(Color.RED)
            buttonMulti.setTextColor(Color.YELLOW)
        }

    }

    private fun doNothing() {


    }
}