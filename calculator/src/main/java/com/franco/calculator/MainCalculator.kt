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
            buttonNine.setOnClickListener { inputNumberIntoCalculator(9) }
            buttonCero.setOnClickListener { inputNumberIntoCalculator(0) }

            buttonMulti.setOnClickListener {
                if(numberOfInputs==0){
                    numberOfInputs++
                }
                if (screenCalc.text == null) {
                    screenCalc.text = ""
                } else {

                    mValueOne = value.toDouble()
                    value=""
                    isMultiplication = true
                    screenCalc.text = null
                    operatorSign.text= "X"

                }
            }
            buttonPlus.setOnClickListener {
                if(numberOfInputs==0){
                    numberOfInputs++
                }
                if (screenCalc.text == null) {
                    screenCalc.text = ""
                } else {

                    mValueOne = value.toDouble()
                    value=""
                    isAddition = true
                    screenCalc.text = null
                    operatorSign.text= "X"
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
                if(numberOfInputs==0){
                    numberOfInputs++
                }
                if (screenCalc.text == null) {
                    screenCalc.text = ""
                } else {

                    mValueOne = value.toDouble()
                    value=""
                    isSubstraction = true
                    screenCalc.text = null
                    operatorSign.text= "X"
                }
            }
            buttonDivision.setOnClickListener {
                if(numberOfInputs==0){
                    numberOfInputs++
                }
                if (screenCalc.text == null) {
                    screenCalc.text = ""
                } else {

                    mValueOne = value.toDouble()
                    value=""
                    isDivision = true
                    screenCalc.text = null
                    operatorSign.text= "X"
                }
            }
            ButtonCanceled.setOnClickListener {
                screenResult.text = ""
                screenCalc.text = ""
                operatorSign.text=""
                value=""
            }
            buttonEquals.setOnClickListener {

                val first = mValueOne
                mValueTwo = value.toDouble()
                if (isAddition) {

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

                numberOfInputs=0
                value=""


            }
        }

    }

    private fun CalculatorBinding.inputNumberIntoCalculator(number:Int) {
//        if (value.contains("")  ||  numberOfInputs == 0) {
//            value = "$number"
//            screenCalc.text = "$number"
//        } else {
            val string1 =value
            val string2 =number
            val concat ="$string1$string2"
            value = concat
            screenCalc.text = value
//        }
    }

    private fun doSubstractOp(valueOne:Double,valueTwo:Double):String{
        return valueOne.minus(mValueTwo).toString()
    }
    private fun doPlusOp(valueOne:Double,valueTwo:Double):String{
        return valueOne.plus(mValueTwo).toString()
    }
    private fun doMultiOp(valueOne:Double,valueTwo:Double):String{
        numberOfInputs++
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