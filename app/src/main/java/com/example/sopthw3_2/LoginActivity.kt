package com.example.sopthw3_2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.sopthw3_2.data.RequestLogin
import com.example.sopthw3_2.data.ResponseLogin
import com.example.sopthw3_2.network.RequestToServer

import kotlinx.android.synthetic.main.login_activity.*
import kotlinx.android.synthetic.main.login_activity.button
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity :AppCompatActivity() {

    val requestToServer = RequestToServer //싱글톤 그대로 가져옴.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        //로그인 버튼을 눌렀을 때
        button.setOnClickListener {
            if(editText_email.text.isNullOrBlank()||editText_pw.text.isNullOrBlank()) {
                showToast("아이디와 비밀번호를 확인하세요")
            } else {
                //로그인 요청
                requestToServer.service.requestLogin(
                    RequestLogin(
                        id = editText_email.text.toString(),
                        password = editText_pw.text.toString()
                    ) //로그인 정보를 전달
                ).enqueue(object :Callback<ResponseLogin>{
                    override fun onFailure(call: Call<ResponseLogin>, t: Throwable) { //Callback 등록. Retrofit의 import를 해줘야 함!
                        //통신 실패
                    }

                    override fun onResponse(
                        call: Call<ResponseLogin>,
                        response: Response<ResponseLogin>
                    ) {
                        //통신 성공
                        if(response.isSuccessful) { //statusCode가 200-300 사이일 때. 응답 body 이용 가능
                            if(response.body()!!.success) { //ResponseLogin의 success가 true인 경우
                                val nextIntent = Intent(this@LoginActivity, PageActivity::class.java)

                                showToast("로그인 성공.")

//                                editText_email.setText(nextIntent.getStringExtra("email"))
//                                editText_pw.setText(nextIntent.getStringExtra("password"))

                                startActivity(nextIntent)
                                finish()
                            } else {
                                showToast("아이디/비밀번호가 일치하지 않습니다.")
                            }
                        }
                    }

                })
            }
        }

        //회원가입 버튼을 눌렀을 때
        textView3.setOnClickListener{ //회원가입하기 텍스트뷰 누르면 회원가입으로 넘어간다.
            val nextIntent = Intent(this@LoginActivity, RegisterActivity::class.java)

            showToast("회원가입화면으로 이동합니다.")

            startActivityForResult(nextIntent, 100)
        }
    }

    // todo RegisterActivity를 종료하면서 LoginActivity를 불러오고 intent로 정보 넘겨주기

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        var email = data!!.getStringExtra("email").toString()
        var password = data!!.getStringExtra("password").toString()

        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100) {
            when (requestCode) {
                100 -> {
//                    showToast("확인")
//                    editText_email = data!!.getStringExtra("email").toString()
//                    editText_pw = data!!.getStringExtra("password").toString()
                    //todo 토스트로 email 데이터 띄어보기
                    //todo email데이터를 email 변수에 저장하기 var email = ~~~
                    //todo editText에 email을 넣기

//                    Toast.makeText(this, email, Toast.LENGTH_SHORT).show()


                    val ed_mail = findViewById<EditText>(R.id.editText_email)
                    val ed_pw = findViewById<EditText>(R.id.editText_pw)

                    ed_mail.setText(email)
                    ed_pw.setText(password)
//                    email = editText_email
//                    email = editText_email.text.toString()

                }
            }
        }
    }



}