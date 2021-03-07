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
    private lateinit var value: String
    private var numberOfInputs=0


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
            buttonOne.setOnClickListener {inputNumberIntoCalculator(1) }
            buttonTwo.setOnClickListener {inputNumberIntoCalculator(2) }
            buttonThree.setOnClickListener {inputNumberIntoCalculator(3) }
            buttonFour.setOnClickListener { inputNumberIntoCalculator(4) }
            buttonFive.setOnClickListener { inputNumberIntoCalculator(5) }
            buttonSix.setOnClickListener { inputNumberIntoCalculator(6) }
            buttonSeven.setOnClickListener { inputNumberIntoCalculator(7) }
            buttonEight.setOnClickListener { inputNumberIntoCalculator(8) }
            buttonEight.setOnClickListener { inputNumberIntoCalculator(9) }
            buttonCero.setOnClickListener { inputNumberIntoCalculator(0) }

            buttonMulti.setOnClickListener {
                if(numberOfInputs==0){
                    numberOfInputs++
                }
                if (screenCalc.text == null) {
                    screenCalc.text = ""
                } else {

                    mValueOne = value.toDouble()
                    isMultiplication = true
                    screenCalc.text = null
                    operatorSign.text= "X"
                    value = 0.0.toString()
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
                operatorSign.text=""
                value=""
            }
            buttonEquals.setOnClickListener {
                value= binding.screenCalc.text.toString()
                val first = mValueOne
                mValueTwo = value.toDouble()
                if (isAddition) {
                    val value1 = mValueOne
                    val value2 = mValueTwo
                    screenResult.text = doPlusOp(mValueOne,mValueTwo)
                    isAddition = false;
                }

                if (isSubstraction) {
                    screenResult.text = doSubstractOp(mValueOne,mValueTwo)
                    isSubstraction = false;
                }

                if (isMultiplication) {
                    screenResult.text = doMultiOp(mValueOne,mValueTwo)
                    isMultiplication = false;

                }

                if (isDivision) {
                    screenResult.text = doDivisionOp(mValueOne,mValueTwo)
                    isDivision = false;
                }
            }
        }

    }

    private fun CalculatorBinding.inputNumberIntoCalculator(number:Int) {
        if (value.equals("") && numberOfInputs == 0) {
            value = "$number"
            screenCalc.text = "$number"
        } else {
            value = "${value + "$number"}"
            screenCalc.text = value
        }
    }

    private fun doSubstractOp(valueOne:Double,valueTwo:Double):String{
        return valueOne.minus(mValueTwo).toString()
    }
    private fun doPlusOp(valueOne:Double,valueTwo:Double):String{
        return valueOne.plus(mValueTwo).toString()
    }
    private fun doMultiOp(valueOne:Double,valueTwo:Double):String{
        return valueOne.times(mValueTwo).toString()
    }
    private fun doDivisionOp(valueOne:Double,valueTwo:Double):String{
        return valueOne.div(mValueTwo).toString()
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