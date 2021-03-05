package com.franco.calculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.franco.calculator.databinding.CalculatorBinding
import java.util.*

class MainCalculator : AppCompatActivity() {
    private lateinit var binding: CalculatorBinding
    private var currentTextViewValue = 0
    private var operationOne = 0
    private var operationTwo = 0
    private var resultOperation = 0
    private var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val locale = Locale.getDefault().language
        when (locale) {
            "es" -> doNothing()
            "en" -> changeColors()
        }
        with(binding) {
            buttonOne.setOnClickListener { Clear("1", true) }
            buttonTwo.setOnClickListener { Clear("2", true) }
            buttonThree.setOnClickListener { Clear("3", true) }
            buttonFour.setOnClickListener { Clear("4", true) }
            buttonFive.setOnClickListener { Clear("5", true) }
            buttonSix.setOnClickListener { Clear("6", true) }
            buttonSeven.setOnClickListener { Clear("7", true) }
            buttonCero.setOnClickListener { Clear("0", true) }

            buttonMulti.setOnClickListener { Clear("x", true) }
            buttonPlus.setOnClickListener { Clear("+", false) }
            buttonPlusMinus.setOnClickListener {
                Toast.makeText(
                    this@MainCalculator,
                    "Action not supported",
                    Toast.LENGTH_LONG
                )
            }
            buttonMinus.setOnClickListener { Clear("-", false) }
            buttonDivision.setOnClickListener { Clear("/", false) }
            ButtonCanceled.setOnClickListener {
                screenResult.text = ""
                screenCalc.text = ""
            }
            buttonEquals.setOnClickListener {
                val operation = binding.screenCalc.text
                val numOfCharacters = operation.length
                if (numOfCharacters.equals(3)) {
                    val first = operation.substring(0, 1)
                    val second = operation.substring(1, 2)
                    val Third = operation.substring(2, 3)

                }
            }
        }

    }


    private fun Clear(string: String, clear: Boolean) {
        if (binding.screenResult.text.isNotEmpty()) {
            binding.screenResult.text = ""
        }
        if (clear) {

            binding.screenResult.text = ""
            binding.screenCalc.append(string)
        } else {
            binding.screenCalc.append(binding.screenResult.text)
        }
    }

    private fun verifyIfItHasThree() {

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