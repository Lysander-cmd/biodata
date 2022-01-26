package www.smktelkommalang.sch.barvolume

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import www.smktelkommalang.sch.biodata.R

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var editNama: EditText
    private lateinit var editTTL: EditText
    private lateinit var editAlamat: EditText
    private lateinit var editkelas: EditText
    private lateinit var edithobi: EditText
    private lateinit var btnsave: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editNama = findViewById(R.id.edit_nama)
        editTTL = findViewById(R.id.edit_TTL)
        editAlamat = findViewById(R.id.edit_alamat)
        editkelas = findViewById(R.id.edit_kelas)
        edithobi = findViewById(R.id.edit_hobi)
        btnsave = findViewById(R.id.btn_save)
        tvResult = findViewById(R.id.tv_result)
        btnsave.setOnClickListener(this)

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT) as String
            tvResult.text = result
        }

    }
    override fun onClick(v: View) {
        if (v.getId() === R.id.btn_save) {
            val inputNama: String = editNama.getText().toString().trim()
            val inputKelas: String = editkelas.getText().toString().trim()
            val inputALamat: String = editAlamat.getText().toString().trim()
            val inputTTL: String = editTTL.getText().toString().trim()
            val inputHobi: String = edithobi.getText().toString().trim()
            var isEmptyFields = false
            if (TextUtils.isEmpty(inputNama)) {
                isEmptyFields = true
                editNama.setError("Field ini tidak boleh kosong")
            }
            if (TextUtils.isEmpty(inputKelas)) {
                isEmptyFields = true
                editkelas.setError("Field ini tidak boleh kosong")
            }
            if (TextUtils.isEmpty(inputALamat)) {
                isEmptyFields = true
                editAlamat.setError("Field ini tidak boleh kosong")
            }
            if (TextUtils.isEmpty(inputTTL)) {
                isEmptyFields = true
                editTTL.setError("Field ini tidak boleh kosong")
            }
            if (TextUtils.isEmpty(inputHobi)) {
                isEmptyFields = true
                edithobi.setError("Field ini tidak boleh kosong")
            }
            val nama = toString(inputNama)
            val kelas = toString(inputKelas)
            val alamat = toString(inputALamat)
            val ttl = toString(inputTTL)
            val hobi = toString(inputHobi)
        }
    }

    private fun toString(inputNama: String) {

    }


    companion object {
        private const val STATE_RESULT = "state_result"
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }




}
