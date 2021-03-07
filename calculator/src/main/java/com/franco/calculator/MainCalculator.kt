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
    private var mValueResult:Double = 0.0
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
            "en" -> doNothing()
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
                performValidationIfUserWantsToCalculateMoreUponResult()
                if(numberOfInputs==0){
                    numberOfInputs++
                }
                if (screenCalc.text == null) {
                    screenCalc.text = ""
                } else {
                        if(!value.equals("")){
                            mValueOne = value?.toDouble()
                        }
                        if(mValueResult > 0.0){
                            screenCalc.text=""
                            screenCalc.text=mValueResult.toString()
                        }
                        value = ""
                        isMultiplication = true
                    if(mValueResult == 0.0) {
                        screenCalc.text = null
                    }
                        operatorSign.text = "X"


                }
            }
            buttonPlus.setOnClickListener {
                performValidationIfUserWantsToCalculateMoreUponResult()
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
                performValidationIfUserWantsToCalculateMoreUponResult()
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
                performValidationIfUserWantsToCalculateMoreUponResult()
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
                    if(!value.equals("")) {
                        mValueTwo = value.toDouble()
                    }
                    if (isAddition) {
                        mValueResult = doPlusOp(mValueOne, mValueTwo).toDouble()
                        screenResult.text = mValueResult.toString()
                        isAddition = false;
                    }

                    if (isSubstraction) {
                        mValueResult = doSubstractOp(mValueOne, mValueTwo).toDouble()
                        screenResult.text = mValueResult.toString()
                        isSubstraction = false;
                    }

                    if (isMultiplication) {
                        mValueResult = doMultiOp(mValueOne, mValueTwo).toDouble()
                        screenResult.text = mValueResult.toString()
                        isMultiplication = false;

                    }

                    if (isDivision) {
                        mValueResult = doDivisionOp(mValueOne, mValueTwo).toDouble()
                        screenResult.text = mValueResult.toString()
                        isDivision = false;
                    }

                    numberOfInputs = 0
                    value = ""


            }

        }


    }

    private fun CalculatorBinding.performValidationIfUserWantsToCalculateMoreUponResult() {
        if (mValueResult != 0.0) {
            screenCalc.text = mValueResult.toString()
            mValueOne = mValueResult
        }
    }

    private fun CalculatorBinding.inputNumberIntoCalculator(number:Int) {

            val string1 =value
            val string2 =number
            val concat ="$string1$string2"
            value = concat
            screenCalc.text = value

    }

    private fun doSubstractOp(valueOne:Double,valueTwo:Double):String{
        return valueOne.minus(valueTwo).toString()
    }
    private fun doPlusOp(valueOne:Double,valueTwo:Double):String{
        return valueOne.plus(valueTwo).toString()
    }
    private fun doMultiOp(valueOne:Double,valueTwo:Double):String{

        return valueOne.times(valueTwo).toString()
    }
    private fun doDivisionOp(valueOne:Double,valueTwo:Double):String{
        return valueOne.div(valueTwo).toString()
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