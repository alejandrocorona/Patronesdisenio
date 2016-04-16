package mx.edu.utng.acp.patronesdisenio;

import android.app.Activity;
import android.os.Bundle;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    ImageView foto;
    TextView tv;
    int[] fotoId = {R.drawable.foto1, R.drawable.foto2, R.drawable.foto3, R.drawable.foto4};
    String[] textos = {"Flor", "Enrredadera", "Perico", "Panda"};
    int i = 0;
    int total;
    private Imagen imagen;
    private Imagen imgClonar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Acerca de:");
        builder.setMessage("Este es un visor de imagenes con iterator,null object, prototype, builder");

        builder.setPositiveButton("OK", null);
        builder.create();
        builder.show();
        Button anterior = (Button) findViewById(R.id.button1);
        Button siguiente = (Button) findViewById(R.id.button2);
        Button nada = (Button) findViewById(R.id.button3);
        Button clonar = (Button) findViewById(R.id.btnClonar);
        Button crear = (Button) findViewById(R.id.btnCrear);
        //escuchadores
        anterior.setOnClickListener(this);
        siguiente.setOnClickListener(this);
        nada.setOnClickListener(this);
        clonar.setOnClickListener(this);
        crear.setOnClickListener(this);

        tv = (TextView) findViewById(R.id.textView1);
        foto = (ImageView) findViewById(R.id.imageView1);
        total = fotoId.length;
    }

    //Lo siguiente es la function del onCLick que realiza function de la iteracion para poder
    // recorrer las imagenes e ir visualizandolas.
    @Override
    public void onClick(View view) {

        int id = view.getId();
        if (id == R.id.button2) {
            i++;
            if (i == total) {
                i = 0;
            }
        }

        if (id == R.id.button1) {
            i--;
            if (i == -1) {
                i = total - 1;
            }
        }
        if (id == R.id.btnCrear) {
            if (imagen != tv.getText()) {
                imagen = Imagen.getImagen();
                Toast.makeText(getApplicationContext(), "Se ha iniciado la clonacion de la imagen con el nombre: " + tv.getText() + "\n" +
                        " de Tamanio: " + imagen.getTamanio(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "ya se selecciono iniciar clonacion" +
                        ", no puedes iniciar de nuevo. ", Toast.LENGTH_SHORT).show();
            }

        }
        if (id == R.id.btnClonar) {
            if (imagen == null) {
                Toast.makeText(getApplicationContext(), "Necesitas iniciar la clonacion ", Toast.LENGTH_SHORT).show();
            } else {
                imgClonar = imagen;

                Toast.makeText(getApplicationContext(), "Se ha clonado una imagen: " +  tv.getText() + "\n" +
                        " Con el tamanio: " + imgClonar.getTamanio(), Toast.LENGTH_SHORT).show();

            }
        }
        foto.setImageResource(fotoId[i]);
        tv.setText(textos[i]);

        if (id == R.id.button3) {
            //Clonar null, se muestra la imagen por defecto
            foto.setImageResource(R.drawable.nofoto);
            NullObject nula = new NullObject();
            nula.sinImagen();
            Toast.makeText(getApplicationContext(), "''Null Object'' No hay imagen", Toast.LENGTH_SHORT).show();

        }



    }


}

