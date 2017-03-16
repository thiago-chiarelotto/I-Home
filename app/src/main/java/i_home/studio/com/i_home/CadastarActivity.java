package i_home.studio.com.i_home;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import i_home.studio.com.i_home.Config.ConfiguracaoFirebase;

public class CadastarActivity extends Activity {


    private FirebaseAuth firebaseAuth;
    private Button botaoCadastrar;
    private EditText nome;
    private EditText email;
    private EditText senha;
    private Usuario usuario;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastar);

        nome = (EditText) findViewById(R.id.et_nome);
        email = (EditText) findViewById(R.id.et_email_Cadastro);
        senha = (EditText) findViewById(R.id.et_Senha_Cadastro);
        botaoCadastrar = (Button) findViewById(R.id.bt_Cadastro);


        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(nome.getText()) | TextUtils.isEmpty(senha.getText())){

                    Toast.makeText(CadastarActivity.this,"Favor informar os dados corretamente", Toast.LENGTH_LONG).show();

                }else{

                    usuario = new Usuario();
                    usuario.setNome(nome.getText().toString());
                    usuario.setEmail(email.getText().toString());
                    usuario.setSenha(senha.getText().toString());
                    cadastrarUsuario();
                }

            }
        });

    }

    private void cadastrarUsuario(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(CadastarActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    Toast.makeText(CadastarActivity.this,"Sucesso ao cadastrar usuário", Toast.LENGTH_LONG).show();

                }else{

                    Toast.makeText(CadastarActivity.this,"Erro ao cadastrar usuário", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

}
