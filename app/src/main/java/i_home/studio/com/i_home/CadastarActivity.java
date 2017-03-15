package i_home.studio.com.i_home;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CadastarActivity extends Activity {


    private Button botaoCadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastar);


        botaoCadastro = (Button) findViewById(R.id.bt_Cadastro);

        botaoCadastro.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                 DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference();
                 DatabaseReference usuáriosReferencia = databaseReferencia.child("Usuários");

                Usuario usuario = new Usuario();

                usuario.getEmail() = .getText().toString(); ;

                usuáriosReferencia.child("001").child("Nome").setValue("Bolacha");

            }
        });



    }
}
