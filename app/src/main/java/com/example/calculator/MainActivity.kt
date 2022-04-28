package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.math.sqrt


class MainActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityMainBinding


    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.btn0.setOnClickListener{
            setTextFields("0")
        }
        bindingClass.btn1.setOnClickListener{
            setTextFields("1")
        }
        bindingClass.btn2.setOnClickListener{
            setTextFields("2")
        }
        bindingClass.btn3.setOnClickListener{
            setTextFields("3")
        }
        bindingClass.btn4.setOnClickListener{
            setTextFields("4")
        }
        bindingClass.btn5.setOnClickListener{
            setTextFields("5")
        }
        bindingClass.btn6.setOnClickListener{
            setTextFields("6")
        }
        bindingClass.btn7.setOnClickListener{
            setTextFields("7")
        }
        bindingClass.btn8.setOnClickListener{
            setTextFields("8")
        }
        bindingClass.btn9.setOnClickListener{
            setTextFields("9")
        }

        bindingClass.btnMinus.setOnClickListener{
            setTextFields("-")
        }
        bindingClass.btnPsul.setOnClickListener{
            setTextFields("+")
        }
        bindingClass.btnUmn.setOnClickListener{
            setTextFields("*")
        }
        bindingClass.btnDel.setOnClickListener{
            setTextFields("/")
        }



        bindingClass.btnObnul.setOnClickListener{
            bindingClass.operationMath.text=""
            bindingClass.resultText.text=""
        }
        bindingClass.btnSquare.setOnClickListener{
            try{
                val x=bindingClass.operationMath.text.toString()
                val ex = ExpressionBuilder(bindingClass.operationMath.text.toString()).build()
                val result = ex.evaluate()*ex.evaluate()
                bindingClass.operationMath.text="${ex.evaluate()}"+"*"+"${ex.evaluate()}"

                val longRes = result.toLong()
                if (result == longRes.toDouble()){
                    bindingClass.resultText.text= longRes.toString()

                }
                else{
                    bindingClass.resultText.text= result.toString()


                }
            } catch(e:Exception){
                Log.d("Ошибка", "сообщение ${e.message}")
            }
        }
        bindingClass.btnKoren.setOnClickListener{
            try{
               val x=bindingClass.operationMath.text.toString()
                val ex = ExpressionBuilder(bindingClass.operationMath.text.toString()).build()
                val result = sqrt(ex.evaluate())
                bindingClass.operationMath.text="sqr("+"${ex.evaluate()}"+")"

                val longRes = result.toLong()

                if (result == longRes.toDouble()){
                    bindingClass.resultText.text= longRes.toString()}

                else{
                    bindingClass.resultText.text= result.toString()


                }
            } catch(e:Exception){
                Log.d("Ошибка", "сообщение ${e.message}")
            }
        }


        bindingClass.btnDelete.setOnClickListener{
            val str= bindingClass.operationMath.text.toString()
            if(str.isNotEmpty()){
                bindingClass.operationMath.text=str.substring(0, str.length-1)
            }
            bindingClass.resultText.text=""
        }

bindingClass.btnRavno.setOnClickListener{
    try{
val ex = ExpressionBuilder(bindingClass.operationMath.text.toString()).build()
        val result = ex.evaluate()

        val longRes = result.toLong()

        if (result == longRes.toDouble()){
            bindingClass.resultText.text= longRes.toString()}
            else{
                bindingClass.resultText.text= result.toString()

        }
    } catch(e:Exception){
        Log.d("Ошибка", "сообщение ${e.message}")
    }
}

    }




    fun setTextFields(str:String){
        if(bindingClass.resultText.text !=""){
            bindingClass.operationMath.text=bindingClass.resultText.text
            bindingClass.resultText.text=""
        }
bindingClass.operationMath.append(str)
    }

}