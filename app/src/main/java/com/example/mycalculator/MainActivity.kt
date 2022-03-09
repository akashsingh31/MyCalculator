package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat
import javax.xml.xpath.XPathExpression

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_clear.setOnClickListener{
            input.text=""
            output.text=""
        }
        button_bracket_left.setOnClickListener{
            input.text= addToInputText("(")
        }
        button_bracket_right.setOnClickListener{
            input.text= addToInputText(")")
        }
        button_0.setOnClickListener{
            input.text= addToInputText("0")
        }
        button_1.setOnClickListener{
            input.text= addToInputText("1")
        }
        button_2.setOnClickListener{
            input.text= addToInputText("2")
        }
        button_3.setOnClickListener{
            input.text= addToInputText("3")
        }
        button_4.setOnClickListener{
            input.text= addToInputText("4")
        }
        button_5.setOnClickListener{
            input.text= addToInputText("5")
        }
        button_6.setOnClickListener{
            input.text= addToInputText("6")
        }
        button_7.setOnClickListener{
            input.text= addToInputText("7")
        }
        button_8.setOnClickListener{
            input.text= addToInputText("8")
        }
        button_9.setOnClickListener{
            input.text= addToInputText("9")
        }
        button_dot.setOnClickListener{
            input.text= addToInputText(".")
        }
        button_division.setOnClickListener{
            input.text= addToInputText("÷")
        }
        button_addition.setOnClickListener{
            input.text= addToInputText("+")
        }
        button_subtraction.setOnClickListener{
            input.text= addToInputText("−")
        }
        button_multiply.setOnClickListener{
            input.text= addToInputText("×")
        }
        button_equals.setOnClickListener{
            showResults()
        }
    }

    private fun addToInputText(buttonValue: String): String{
        return "${input.text}$buttonValue"
    }
    private fun getInputExpression():String{
        var expression=input.text.replace(Regex("÷"),"/")
        expression=expression.replace(Regex("×"),"*")
        return expression
    }

    private fun showResults(){
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if(result.isNaN()){
                //SHOW ERROR MESSAGE
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this,R.color.green))
            }
            else{
                //show results
                output.text=DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this,R.color.green))

            }
        }catch (e:Exception){
            //SHOW ERROR MESSAGE
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this,R.color.red))
        }
    }

}