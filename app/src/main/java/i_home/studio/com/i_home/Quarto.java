package i_home.studio.com.i_home;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Quarto extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarto);

        final ImageView botao_Lampada;

        botao_Lampada = (ImageView) findViewById(R.id.bt_lampada);
        botao_Lampada.setTag("Desligado");

        botao_Lampada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (botao_Lampada.getTag()=="Ligado"){

                    botao_Lampada.setImageResource(R.drawable.icone_apagado);
                    botao_Lampada.setTag("Desligado");

                }else{

                    botao_Lampada.setImageResource(R.drawable.icone);
                    botao_Lampada.setTag("Ligado");

                }

            }
        });

    }
}
